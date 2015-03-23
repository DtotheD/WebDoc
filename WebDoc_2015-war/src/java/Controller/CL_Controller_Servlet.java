/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;
import model.CL_Symptom;
import controller.CL_Krankheit_Akt_Wert;
import controller.CL_Symptom_Bean;
import controller.CL_Create_DB_Data_Bean;
import controller.CL_Hole_Krankheiten_Bean;

/**
 *
 * @author DEKREDAV
 * Datum: CREDAT
 * Controller-Servlet Reagiert auf Push- und Pull-Anfragen gleich.
 * Verarbeitet Anfragen je nach Anfrageparametern und leitet die Anfrage dann an
 * die Template-JSP weiter, wobei deren jeweiliger Inhalt im context, in Form
 * des Namens des JSP-Includes, mitgegeben wird.
 *
 * Genutzte Context-Attribute:
 * context_alle_symptome: 
 *  Hier sind alle Symptome gespeichert, damit die combo-box der Symptomauswahl
 *  nicht bei jeder Eingabe erneut auf die Datenbank zugreifen muss. 
 *   Durch das Speichern in der Session,muss nur einmal auf die Datenbank
 *  zugegriffen werden.
 * context_patient_symptome:
 *  Hier sind die Symptome, die vom Anwender ausgewählt wurden gespeichert Diese
 *  werden zur Auswahl der Krankheiten benötigt
 * context_inhalt:
 *  Hier ist der Name der JSP-Seite gespeichert, die im Template angezeigt werden 
 *  soll.
 * context_krankheiten:
 *  Hier sind die zu den Symptomen passenden Krankheiten mit
 *  ihrer aktuellen Wahrscheinlichkeit gespeichert. Sie sind nach ihrer
 *  Wahrscheinlichkeit absteigend geordnet
 * context_genauere_krankheit:
 *  Hier ist die vom Nutzer für genauere informationen ausgewählte Krankheit
 *  gespeichert. Über diese wird auf Namen, Beschreibung und Empfehlung zugegriffen
 *
 * Abgefragte Anfrage-Parameter:
 * p_step:
 *  Gibt an wohin navigiert werden soll (Welchen Inhalt das Template haben soll).
 * p_action:
 *  Gibt an welche Aktion ausgeführt werden soll.
 * p_del_symptom:
 *  Bei User-Action, die ein Symptom aus der Liste nehmen soll,
 *  steht hier der Name des Symptoms
 * p_krankheit:
 *  Bei Auswahl einer Krankheit für genauere Informationen, steht hier der Name der
 *  Krankheit, die näher betrachtet werden soll
 *
 * Abgefragte Input-Felder:
 * input_symptom:
 * Input-Feld für den Name des gewählten Symptoms
 *
 */
@WebServlet(name = "CL_Controller_Servlet", urlPatterns = {"/main"})
public class CL_Controller_Servlet extends HttpServlet {

    /**
     * Beans-Deklaration für den Datenbankzugriff
     */
    @EJB
    private CL_Symptom_Bean io_symptom_bean;
    @EJB
    private CL_Create_DB_Data_Bean io_create_db_data_bean;
    @EJB
    private CL_Hole_Krankheiten_Bean io_hole_krankheiten_bean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param po_request HTTP-Request der Anfrage
     * @param po_response HTTP-Antwort
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * Abarbeitung von Anfragen besteht zur Strukturierung aus 3 Schritten
     * 1. Anfrage-Parameter auslesen, Eingabefelder auslesen,
     *    Sessioncontext-Attribute auslesen und lokale Varaiblen deklarieren und
     *    instanzieren.
     * 2. Je nach Anfrageparameter Aktion durchführen
     * 3. Sessioncontext-Attribute setzten und Anfrage weiterleiten
     */
    protected void im_processRequest(HttpServletRequest po_request, HttpServletResponse po_response)
            throws ServletException, IOException {

        //--------------------------------------------------------------------------- 
        //Alle Contextattribute, Eingabefelder und Parameter auslesen und Voreinstellungen vornehmen
        
        // Zeichensatz für Anfragedaten und empfangene Formulardaten festlegen
        po_request.setCharacterEncoding("utf-8");
        po_response.setContentType("utf-8");
        po_response.setContentType("text/html;charset=utf-8");

        //Session auslesen zur Speicherung der Context-Attribute
        HttpSession lo_session = po_request.getSession(true);

        //Template Auswahl - Wenn diese Variable gesetzt ist, wurde bereits Aktion durchgeführt
        String lv_inhalt = "";

        //Standardmeldung Meldung festlegen
        String lv_message = "";

        //Liste aller Symptome auslesen
        List<CL_Symptom> lo_symptome = (List<CL_Symptom>) lo_session.getAttribute("context_alle_symptome");
        //Falls sie sich noch nicht im Context befindet, wird sie neu erzeugt
        if (lo_symptome == null || lo_symptome.size() < 1) {
            //Über Bean alle Symptome aus der Datenbank auslesen
            //! DTB-Zugriff
            lo_symptome = io_symptom_bean.im_getAllSymptoms();
        }

        //Liste der gewählten Symptome auslesen
        ArrayList<CL_Symptom> lo_patient_symptome = (ArrayList<CL_Symptom>) lo_session.getAttribute("context_patient_symptome");
        //Falls sie sich nich nicht im Context befindet, wird neue leere Liste erzeugt
        if (lo_patient_symptome == null) {
            lo_patient_symptome = new ArrayList<>();
        }

        //Aktueller Template-Inhalt auslesen
        String lv_bisheriger_inhalt = (String) lo_session.getAttribute("context_inhalt");

        //Krankheitsliste auslesen
        ArrayList<CL_Krankheit_Akt_Wert> lo_krankheiten = (ArrayList<CL_Krankheit_Akt_Wert>) lo_session.getAttribute("context_krankheiten");

        //Genauer zu betrachtende Krankheit auslesen
        CL_Krankheit_Akt_Wert lo_genauere_krankheit = (CL_Krankheit_Akt_Wert) lo_session.getAttribute("context_genauere_krankheit");

        // URL-Parameter auslesen
        String step = po_request.getParameter("p_step");
        String action = po_request.getParameter("p_action");
        String lv_geloeschtes_symptom_name = po_request.getParameter("p_del_symptom");
        String iv_gewaehlte_kranheit_name = po_request.getParameter("p_krankheit");

        //Inputfelder
        String lv_gewaehlte_symptom_name = po_request.getParameter("input_symptom");

        //--------------------------------------------------------------------------- 
        //Useractionen bearbeiten
        //DTB anlegen action = "create_dtb":
        if (action != null && action.equalsIgnoreCase("create_dtb")) {
            //Datenbank anlegen
            //! DTB-Zugriff
            io_create_db_data_bean.im_create_db();
            //Alle Symptome auslesen
            //! DTB-Zugriff
            lo_symptome = io_symptom_bean.im_getAllSymptoms();
            //Template auswählen
            lv_inhalt = im_setze_templateinhalt(lv_bisheriger_inhalt, lv_inhalt);
        }
        //Symptom hinzufügen 
        else if (action != null && action.equalsIgnoreCase("add_symptom")) {
            // Symptom über Symptomname suchen
            CL_Symptom lo_neues_Symptom = im_suche_symptom_ueber_name(lv_gewaehlte_symptom_name, lo_symptome);
            //prüfen, ob Symptom gefunden wurde
            if (lo_neues_Symptom != null) {
                //prüfen ob Symptom bereits gewählt wurde
                if (!lo_patient_symptome.contains(lo_neues_Symptom)) {
                    //prüfen ob nicht mehr als 10 Symptome gewählt wurden
                    if (lo_patient_symptome.size() < 10) {
                        //Symptom hinzufügen
                        lo_patient_symptome.add(lo_neues_Symptom);
                        //Meldung
                        lv_message = "Symptom hinzugefügt";
                    } else
                    {
                        //Meldung
                        lv_message = "Nicht mehr als 10 Symptome wählen";
                    }
                } else
                {
                    //Meldung
                    lv_message = "Symptom bereits gewählt";
                }
            } else
            {
                //Meldung
                lv_message = "Element ist nicht vorhanden";
            }
            //Template auswählen
            lv_inhalt = im_setze_templateinhalt("Inc_symptome.jsp", lv_inhalt);
        }
        //Symptom löschen
        else if (action != null && action.equalsIgnoreCase("del_symptom")) {   
            //Symptom über Symptomname suchen
            CL_Symptom lo_del_Symptom = im_suche_symptom_ueber_name(lv_geloeschtes_symptom_name, lo_patient_symptome); 
            //prüfen ob Symptom gefunden wurde
            if (lo_del_Symptom != null) {
                //Symptom aus der Liste entfernen
                lo_patient_symptome.remove(lo_del_Symptom);
                //Meldung
                lv_message = "Symptom gelöscht";
            } else {
                //Meldung
                lv_message = "Fehler!";
            }
            //Template auswählen
            lv_inhalt = lv_bisheriger_inhalt;
        }
        //Aus Symptomen Krankheiten finden
        else if (action != null && action.equalsIgnoreCase("suche_krankheiten")) {
            //Suche startet nur falls Symptome ausgewählt wurden
            if (lo_patient_symptome.size() > 0) {
                //Krankheiten mit den zu den Symptomen passenden Wahrscheinlichkeiten geben lassen
                //! DTB-Zugriff
                lo_krankheiten = im_get_krankheiten(lo_patient_symptome);
                //Template auf Krankheiten-Übersicht schalten
                lv_inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", lv_inhalt);
            } else {
                //Kein Template-Wechsel, da keine Symptome ausgewählt wurden
                lv_inhalt = im_setze_templateinhalt("Inc_symptome.jsp", lv_inhalt);
                //Meldung
                lv_message = "Wählen sie Symptom aus, bevor sie weiter navigieren";
            }
        }
        //Kranheit genauer betrachten
        else if (action != null && action.equalsIgnoreCase("read_more")) {
            //Suche der Krankheiten über den als Parameter übergebenen Namen
            CL_Krankheit_Akt_Wert lo_gewaehlte_Krankheit = im_krankheit_ueber_name(iv_gewaehlte_kranheit_name, lo_krankheiten);
            //Prüfe ob Krankheit gefunden wurde
            if (lo_gewaehlte_Krankheit != null) {
                lo_genauere_krankheit = lo_gewaehlte_Krankheit;
            } else {
                //Meldung - Fehler der nur bei manueller URL-Eingabe auftreten kann
                lv_message = "Fehler!";
            }
            lv_inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", lv_inhalt);
        } //Navigations-Links
        else if (step == null || step.equalsIgnoreCase("p_step_symptome")) {
            lv_inhalt = im_setze_templateinhalt("Inc_symptome.jsp", lv_inhalt);
            lo_genauere_krankheit = null;
        } else if (step.equalsIgnoreCase("p_step_krankheiten")) {
            if (lo_patient_symptome.size() > 0) {
                lv_inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", lv_inhalt);
            } else {
                lv_inhalt = im_setze_templateinhalt("Inc_symptome.jsp", lv_inhalt);
                lv_message = "Wählen sie Symptom aus, bevor sie weiter navigieren";
            }
            //Fehlerhafter Step
        } else if (lv_inhalt.equalsIgnoreCase("")) {
            lv_message = "fehlerhfate URL-Parameter";
            lv_inhalt = im_setze_templateinhalt("Inc_symptome.jsp", lv_inhalt);
        }

        //--------------------------------------------------------------------------- 
        //Session-Attribute setzen und weiterleiten
        //Template-Inhalt
        lo_session.setAttribute("context_inhalt", lv_inhalt);
        //Symptom-Liste
        lo_session.setAttribute("context_patient_symptome", lo_patient_symptome);
        // Message
        lo_session.setAttribute("context_message", lv_message);
        //Alle Symptome
        lo_session.setAttribute("context_alle_symptome", lo_symptome);
        //Kranheiten
        lo_session.setAttribute("context_krankheiten", lo_krankheiten);
        //genauere Krankheit
        lo_session.setAttribute("context_genauere_krankheit", lo_genauere_krankheit);

        //Weiterleitung
        RequestDispatcher dispatcher = po_request.getRequestDispatcher("Head.jsp");
        dispatcher.forward(po_request, po_response);

    }

    /**
     *
     * @param pv_symptom_name
     * @param po_symptome
     * @return Methode die ein Symptom über dessen Name sucht Genutzt um bei
     * Button(Del-Symptom), der ein Symptomname mitgibt, diese aus der Liste der
     * gewählten Symptome zu entfernen Genutzt um bei Button(add), bei dem ein
     * Symptomname ausgelesen wird, diesen der Liste der gewählten Symptome
     * hinzuzufügen
     */
    protected CL_Symptom im_suche_symptom_ueber_name(String pv_symptom_name, List<CL_Symptom> po_symptome) {

        for (CL_Symptom lo_symptom : po_symptome) {
            if (lo_symptom.getIv_name().equalsIgnoreCase(pv_symptom_name)) {
                return lo_symptom;
            }
        }
        return null;
    }

    /**
     *
     * @param pv_krankheit_name
     * @param po_krankheitsliste
     * @return Methode, die eine Krankheit über deren Name sucht Genutzt um bei
     * Butto(Read-More), der den Krankheitsnamen mitgibt, die gewählte Krankheit
     * zu suchen
     */
    protected CL_Krankheit_Akt_Wert im_krankheit_ueber_name(String pv_krankheit_name, List<CL_Krankheit_Akt_Wert> po_krankheitsliste) {

        for (CL_Krankheit_Akt_Wert lo_krankheit : po_krankheitsliste) {
            if (lo_krankheit.getIo_krankheit().getIv_name().equalsIgnoreCase(pv_krankheit_name)) {
                return lo_krankheit;
            }
        }
        return null;
    }

    /**
     *
     * @param pv_wunsch_inhalt
     * @param pv_inhalt
     * @return
     */
    protected String im_setze_templateinhalt(String pv_wunsch_inhalt, String pv_inhalt) {
        if (pv_inhalt == null || pv_inhalt.equalsIgnoreCase("")) {
            return pv_wunsch_inhalt;
        }
        return pv_inhalt;
    }

    /**
     *
     * @param po_gewaehlte_Symptome
     * @return
     */
    protected ArrayList<CL_Krankheit_Akt_Wert> im_get_krankheiten(ArrayList<CL_Symptom> po_gewaehlte_Symptome) {

        return new ArrayList<>(io_hole_krankheiten_bean.im_get_passende_Krankheiten(po_gewaehlte_Symptome));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        im_processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        im_processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
