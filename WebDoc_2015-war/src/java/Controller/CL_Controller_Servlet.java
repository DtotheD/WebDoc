/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CL_Symptom;
import controller.BeanFactory;
import controller.IN_Symptom_Bean;
import java.util.ArrayList;
import java.util.List;
import model.CL_Bewertetes_Symptom;
import model.CL_Empfehlung;
import model.CL_Krankheit;
import controller.CL_Krankheit_Akt_Wert;

/**
 *
 * @author DEKREDAV
 */
@WebServlet(name = "CL_Controller_Servlet", urlPatterns = {"/main"})
public class CL_Controller_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Zeichensatz für Anfragedaten und empfangene Formulardaten festlegen
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //--------------------------------------------------------------------------- 
        //Alle Contextattribute und Parameter auslesen und Voreinstellungen vornehmen
        //Template Auswahl - Wenn diese Variable gesetzt ist wird wurde bereits Aktion durchgeführt
        String inhalt = "";
        //Session auslesen
        HttpSession session = request.getSession(true);
        //Standardmeldung Meldung setzen
        String lv_message = "es_läuft_noch_alles";

        //Liste aller Symptome auslesen, falls diese noch nicht dort gespeicehrt ist
        List<CL_Symptom> lo_symptome = (List<CL_Symptom>) session.getAttribute("context_alle_symptome");
        if (lo_symptome == null || lo_symptome.size() < 1) {
            IN_Symptom_Bean lo_symptom_bean = BeanFactory.sm_getSymptomBean();
            lo_symptome = lo_symptom_bean.im_getAllSymptoms();
        }

        //gewählte Symptome auslesen und erstellen, falls dieses noch nicht vorhanden ist
        ArrayList<CL_Symptom> lo_patient_symptome = (ArrayList<CL_Symptom>) session.getAttribute("context_patient_symptome");
        if (lo_patient_symptome == null) {
            lo_patient_symptome = new ArrayList<>();
        }

        //Aktuelles Template auslesen
        String lv_bisheriger_inhalt = (String) session.getAttribute("context_inhalt");

        //Krankheitsliste
        ArrayList<CL_Krankheit_Akt_Wert> lo_krankheiten = (ArrayList<CL_Krankheit_Akt_Wert>) session.getAttribute("context_krankheiten");
        if (lo_krankheiten == null) {
            lo_krankheiten = im_mock_get_krankheiten(lo_patient_symptome);
        }
        
        //genauere Krankheit
        CL_Krankheit_Akt_Wert lo_genauere_krankheit = (CL_Krankheit_Akt_Wert) session.getAttribute("context_genauere_krankheit");

        // URL-Parameter auslesen
        String step = request.getParameter("step");
        String action = request.getParameter("action");
        String lv_geloeschtes_symptom_name = request.getParameter("del_symptom");
        String iv_gewaehltee_kranheit_name = request.getParameter("krankheit");

        //Inputfelder
        String lv_gewaehlte_symptom_name = (String) request.getParameter("input_symptom");

        //--------------------------------------------------------------------------- 
        //Useractionen bearbeiten
        //DTB anlegen action = create_dtb
        if (action != null && action.equalsIgnoreCase("create_dtb")) {
            //Datenbank anlegen
            im_create_dtb();
            //Alle Symptome auslesen
            IN_Symptom_Bean lo_symptom_bean = BeanFactory.sm_getSymptomBean();
            lo_symptome = lo_symptom_bean.im_getAllSymptoms();
            //Template auswählen
            inhalt = im_setze_templateinhalt(lv_bisheriger_inhalt, inhalt);
        } //Symptom hinzufügen 
        else if (action != null && action.equalsIgnoreCase("add_symptom")) {
            // prüfen ob Symptomname auch in Datenbank vorliegt
            CL_Symptom lo_neues_Symptom = im_suche_symptom_ueber_name(lv_gewaehlte_symptom_name, lo_symptome);
            //falls Symptom gefunden wurde
            if (lo_neues_Symptom != null) {
                //prüfen ob Symptom vorhanden ist
                if (!lo_patient_symptome.contains(lo_neues_Symptom)) {
                    //prüfen ob nicht emhr als 10 Symptome vorhanden sind
                    if (lo_patient_symptome.size() < 10) {
                        //Symptom hinzufügen
                        lo_patient_symptome.add(lo_neues_Symptom);
                        //Meldung
                        lv_message = "Symptom hinzugefügt";
                    } else //Meldung
                    {
                        lv_message = "Nicht mehr als 10 Symptome wählen";
                    }
                } else //Meldung
                {
                    lv_message = "Symptom bereits gewählt";
                }
            } else //Meldung
            {
                lv_message = "Element ist nicht vorhanden";
            }
            //Template auswählen
            inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        }
        //Symptom löschen
        else if (action != null && action.equalsIgnoreCase("del_symptom")) {

            CL_Symptom lo_del_Symptom = im_suche_symptom_ueber_name(lv_geloeschtes_symptom_name, lo_patient_symptome);

            if (lo_del_Symptom != null) {
                lo_patient_symptome.remove(lo_del_Symptom);
                lv_message = "Symptom gelöscht";
            } else {
                lv_message = "Fehler!";
            }

            inhalt = lv_bisheriger_inhalt;
        }
        //Kranheit genauer getrachten
        else if (action != null && action.equalsIgnoreCase("read_more")){
            CL_Krankheit_Akt_Wert lo_gewaehlte_Krankheit = im_krankheit_ueber_name(iv_gewaehltee_kranheit_name, lo_krankheiten);
            if (lo_gewaehlte_Krankheit != null){
                lo_genauere_krankheit = lo_gewaehlte_Krankheit;
            }
            else
                lv_message = "Fehler!";
            inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", inhalt);
        }
        //Navigations-Links
        else if (step == null || step.equalsIgnoreCase("p_step_symptome")) {
            inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        } else if (step.equalsIgnoreCase("p_step_krankheiten")) {
            if (lo_patient_symptome.size() > 0) {
                inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", inhalt);
            } else {
                inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
                lv_message = "Wählen sie Symptom aus, bevor sie weiter navigieren";
            }
            //Fehlerhafter Step
        } else if (inhalt.equalsIgnoreCase("")) {
            lv_message = "fehlerhfate URL-Parameter";
            inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        }

        //--------------------------------------------------------------------------- 
        //Session-Attribute setzen und weiterleiten
        //Template-Inhalt
        session.setAttribute("context_inhalt", inhalt);
        //Symptom-Liste
        session.setAttribute("context_patient_symptome", lo_patient_symptome);
        // Message
        session.setAttribute("context_message", lv_message);
        //Alle Symptome
        session.setAttribute("context_alle_symptome", lo_symptome);
        //Kranheiten
        session.setAttribute("context_krankheiten", lo_krankheiten);
        //genauere Krankheit
        session.setAttribute("context_genauere_krankheit", lo_genauere_krankheit);

        //Weiterleitung
        RequestDispatcher dispatcher = request.getRequestDispatcher("Head.jsp");
        dispatcher.forward(request, response);

    }

    protected CL_Symptom im_suche_symptom_ueber_name(String pv_symptom_name, List<CL_Symptom> po_symptome) {

        for (CL_Symptom lo_symptom : po_symptome) {
            if (lo_symptom.getIv_name().equalsIgnoreCase(pv_symptom_name)) {
                return lo_symptom;
            }
        }
        return null;
    }
    
    protected CL_Krankheit_Akt_Wert im_krankheit_ueber_name (String pv_krankheit_name, List<CL_Krankheit_Akt_Wert> po_krankheitsliste){
        
        for (CL_Krankheit_Akt_Wert lo_krankheit : po_krankheitsliste) {
            if (lo_krankheit.getIo_krankheit().getName().equalsIgnoreCase(pv_krankheit_name))
                return lo_krankheit;
        }
        return null;
    }

    protected String im_setze_templateinhalt(String pv_wunsch_inhalt, String pv_inhalt) {
        if (pv_inhalt == null || pv_inhalt == "") {
            return pv_wunsch_inhalt;
        }
        return pv_inhalt;
    }

    protected ArrayList<CL_Krankheit_Akt_Wert> im_mock_get_krankheiten(List<CL_Symptom> po_gewaehlte_Symptome) {
        ArrayList<CL_Bewertetes_Symptom> bewertete_Symptome = new ArrayList<>();

        bewertete_Symptome.add(new CL_Bewertetes_Symptom(new CL_Symptom("Symp1"), 1));
        bewertete_Symptome.add(new CL_Bewertetes_Symptom(new CL_Symptom("Symp2"), 2));

        ArrayList<CL_Krankheit_Akt_Wert> back = new ArrayList<>();
        back.add(0, new CL_Krankheit_Akt_Wert(po_gewaehlte_Symptome, new CL_Krankheit("Krankheit0", 3, new CL_Empfehlung("tue 0"), bewertete_Symptome, "Beschreibungstext 0"), 1));
        back.add(1, new CL_Krankheit_Akt_Wert(po_gewaehlte_Symptome, new CL_Krankheit("Krankheit1", 3, new CL_Empfehlung("tue 1"), bewertete_Symptome, "Beschreibungstext 1"), 2));

        return back;
    }

    protected void im_create_dtb() {
        IN_Symptom_Bean symp_bean = BeanFactory.sm_getSymptomBean();
        CL_Symptom symp = symp_bean.im_create_Symptom("Symp1");
        symp = symp_bean.im_create_Symptom("Symp2");
        symp = symp_bean.im_create_Symptom("Symp3");
        symp = symp_bean.im_create_Symptom("Symp4");
        symp = symp_bean.im_create_Symptom("Symp5");
        symp = symp_bean.im_create_Symptom("Symp6");
        symp = symp_bean.im_create_Symptom("Symp7");
        symp = symp_bean.im_create_Symptom("Symp8");
        symp = symp_bean.im_create_Symptom("Symp9");
        symp = symp_bean.im_create_Symptom("Symp10");
        symp = symp_bean.im_create_Symptom("Symp11");

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
        processRequest(request, response);
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
        processRequest(request, response);
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
