/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CL_Symptom;
import controller.BeanFactory;
import controller.CL_Symptom_Bean;
import controller.IN_Symptom_Bean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

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
        session.setAttribute("context_message", "es läuft noch alles!");
        
        //Liste aller Symptome auslesen, falls diese noch nicht dort gespeicehrt ist
        List<CL_Symptom> lo_symptome = (List<CL_Symptom>) session.getAttribute("context_alle_symptome");
        if (lo_symptome == null || lo_symptome.size() < 1) {
            IN_Symptom_Bean lo_symptom_bean = BeanFactory.sm_getSymptomBean();
            session.setAttribute("context_alle_symptome", lo_symptom_bean.im_getAllSymptoms());
        }

        //Patientenobjekt auslesen und erstellen, falls dieses noch nicht vorhanden ist
        ArrayList<CL_Symptom> lo_patient_symptome = (ArrayList<CL_Symptom>) session.getAttribute("context_patient_symptome");
        if (lo_patient_symptome == null) {
            lo_patient_symptome = new ArrayList<CL_Symptom>();
        }
        
        //Aktuelles Template auslesen
        String lv_bisheriger_inhalt = (String) session.getAttribute("context_inhalt");
        
        // URL-Parameter auslesen
        String step = request.getParameter("step");
        String from = request.getParameter("from");
        String action = request.getParameter("action");
        
        
      //--------------------------------------------------------------------------- 
      //Useractionen bearbeiten
        
        //DTB anlegen action = create_dtb
        if (action != null && action.equalsIgnoreCase("create_dtb")) {
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
            inhalt = lv_bisheriger_inhalt;
        }
        
        //Symptom hinzufügen 
        else if (action != null && action.equalsIgnoreCase("add_symptom")) {
            // gewählten Symptomname auslesen
            String lv_gewaehltee_symptom_name = (String) request.getParameter("input_symptom");
            // 
            CL_Symptom lo_neues_Symptom = im_suche_symptom_ueber_name(lv_gewaehltee_symptom_name, (List<CL_Symptom>) session.getAttribute("context_alle_symptome"));

            if (lo_neues_Symptom != null) {
                if(!lo_patient_symptome.contains(lo_neues_Symptom)){
                    if(lo_patient_symptome.size() < 10){
                        lo_patient_symptome.add(lo_neues_Symptom);
                        session.setAttribute("context_message", "Symptom hinzugefügt");
                    }
                    session.setAttribute("context_message", "Symptom hinzugefügt");
                }
                else
                    session.setAttribute("context_message", "Bereits 10 Symptome ausgewählt");
            }
            else
                session.setAttribute("context_message", "Element ist nicht vorhanden");
            session.setAttribute("context_patient_symptome", lo_patient_symptome);

           inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        }

        if (step == null || step.equalsIgnoreCase("p_step_symptome")) {
           inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        } else if (step.equalsIgnoreCase("p_step_krankheiten")) {
           inhalt = im_setze_templateinhalt("Inc_krankheiten.jsp", inhalt);
        } else if (inhalt.equalsIgnoreCase("")) {
           request.setAttribute("message", "fehlerhfate URL-Parameter");
           inhalt = im_setze_templateinhalt("Inc_symptome.jsp", inhalt);
        }

        session.setAttribute("context_inhalt", inhalt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Head.jsp");
        dispatcher.forward(request, response);

    }

    protected CL_Symptom im_suche_symptom_ueber_name(String pv_symptom_name, List<CL_Symptom> po_symptome) {

        for (CL_Symptom lv_symptom : po_symptome) {
            if (lv_symptom.getIv_name().equalsIgnoreCase(pv_symptom_name)) {
                return lv_symptom;
            }
        }
        return null;
    }

    protected String im_setze_templateinhalt(String pv_wunsch_inhalt, String pv_inhalt) {
        if (pv_inhalt == null || pv_inhalt == "") {
            return pv_wunsch_inhalt;
        }
        return pv_inhalt;
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
