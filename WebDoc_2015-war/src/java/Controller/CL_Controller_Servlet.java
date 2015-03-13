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
        HttpSession session = request.getSession(true);
        request.setAttribute("message","es läuft noch alles!");
        
        CL_Patient patient = (CL_Patient) session.getAttribute("Patient");
        if (patient == null){
            patient = new CL_Patient(100,100,100,1);
        }     
        String step = request.getParameter("step");
        String from = request.getParameter("from");
        
        //DTB anlegen
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("create_dtb"))
            im_create_dtb();
        
        if (step == null || step.equalsIgnoreCase("pers_data")){
            inhalt = "Inc_pers_data.jsp";
        }
        else if (step.equalsIgnoreCase("krankheiten")){
            inhalt = "Inc_krankheiten.jsp";
        }
        else if (step.equalsIgnoreCase("symptome")){
            
            inhalt = "Inc_symptome.jsp";
        }
        else{
            request.setAttribute("message", "fehlerhfate URL-Parameter");
            inhalt = "Inc_pers_data.jsp";
        }
        
        request.setAttribute("inhalt",inhalt);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Head.jsp");
        dispatcher.forward(request, response);

    }
    
    protected void im_create_dtb() throws ServletException, IOException {
        
        CL_Symptom symptom = CL_Symptom_Bean.im_create_Symptom("Symptom1");
        symptom = CL_Symptom_Bean.im_create_Symptom("Symptom2");
        symptom = CL_Symptom_Bean.im_create_Symptom("Symptom3");
        symptom = CL_Symptom_Bean.im_create_Symptom("Symptom4");
        
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
