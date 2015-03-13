/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.CL_Patient;
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
        response.setContentType("text/html;charset=UTF-8");
        
        
        String inhalt = "";
        // Session auslesen
        HttpSession session = request.getSession(true);
        //Aktuelle Meldung setuen
        session.setAttribute("message", "es läuft noch alles!");
        
        //Liste aller Symptome in die Session setzen, falls diese noch nicht dort gespeicehrt ist
        List<CL_Symptom> lo_symptome = (List<CL_Symptom>) session.getAttribute("context_alle_symptome");
        if (lo_symptome == null || lo_symptome.size() < 1){
            IN_Symptom_Bean lo_symptom_bean = BeanFactory.sm_getSymptomBean();
            session.setAttribute("context_alle_symptome", lo_symptom_bean.im_getAllSymptoms());  
        } 
        
        //Patientenobjekt erstellen, falls dieses noch nicht vorhanden ist
        CL_Patient patient = (CL_Patient) session.getAttribute("Patient");
        if (patient == null) {
            patient = new CL_Patient(100, 100, 100, 1);
        }
        String step = request.getParameter("step");
        String from = request.getParameter("from");

        //DTB anlegen
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("create_dtb")) {
            IN_Symptom_Bean symp_bean = BeanFactory.sm_getSymptomBean();
            CL_Symptom symp = symp_bean.im_create_Symptom("Symp1");
            symp = symp_bean.im_create_Symptom("Symp2");
            symp = symp_bean.im_create_Symptom("Symp3");
        }

        if (step == null || step.equalsIgnoreCase("pers_data")) {
            inhalt = "Inc_pers_data.jsp";
        } else if (step.equalsIgnoreCase("krankheiten")) {
            inhalt = "Inc_krankheiten.jsp";
        } else if (step.equalsIgnoreCase("symptome")) {
            inhalt = "Inc_symptome.jsp";
        } else {
            request.setAttribute("message", "fehlerhfate URL-Parameter");
            inhalt = "Inc_pers_data.jsp";
        }

        request.setAttribute("inhalt", inhalt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Head.jsp");
        dispatcher.forward(request, response);

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
