package fr.efrei.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static fr.efrei.jeeproject.Constants.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eddy
 */
@WebServlet(urlPatterns = {"/Login_controller"})
public class Login_controller extends HttpServlet {

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
        
            //Data entered by the user
        String inputLogin = request.getParameter(FORM_FIELD_LOGIN);
        String inputPwd = request.getParameter(FORM_FIELD_PWD);
        
       
        
        // We verify that the user filled both form's fields
        if( inputLogin.length() == 0 || inputPwd.length()==0)
        {
            request.setAttribute("errKey", ERR_MESSAGE_EMPTY_FIELDS);
            request.getRequestDispatcher(JSP_PAGE_LOGIN).forward(request, response);
        }
        
        
        // Checking if the inputs correspond to the ADMIN credentials
        String adminLogin = getServletContext().getInitParameter("Admin_Login");
        String adminPwd = getServletContext().getInitParameter("Admin_Pwd");
        
        //Créer une session admin
        if(adminLogin.equals(inputLogin) && adminPwd.equals(inputPwd))
        {
            request.setAttribute("errKey", "I am the Admin !");
            request.getRequestDispatcher(JSP_PAGE_LOGIN).forward(request, response);
        }
        
        
        
        // Checking if the inputs correspond to the EMPLOYEE credentials
        String EmployeeLogin = getServletContext().getInitParameter("Employee_Login");
        String EmployeePwd = getServletContext().getInitParameter("Employee_Pwd");
        
        //Créer une session employee
        if(EmployeeLogin.equals(inputLogin) && EmployeePwd.equals(inputPwd))
        {
            request.setAttribute("errKey", "I am the Employee !");
            request.getRequestDispatcher(JSP_PAGE_LOGIN).forward(request, response);
        }        

        
        //si une session existe, envoyer vers employees.jsp
        
        
        //sinon
        // Since no match was found, 
        request.setAttribute("errKey", ERR_MESSAGE_INVALID);
        request.getRequestDispatcher(JSP_PAGE_LOGIN).forward(request, response);
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
