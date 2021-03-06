/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.Employee_API;
import static fr.efrei.jeeproject.Constants.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francois
 */
public class Controller_Employee_PUT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>Get</code> and <code>Post</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Admin privilege is required
        if(request.getSession().getAttribute("role") != null && !request.getSession().getAttribute("role").equals("admin")){
            request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", "You don't have the permission to be here !");
            response.sendRedirect("employees");
            return;
        }
        
        /* TODO output your page here. You may use following sample code. */
        String last_name = request.getParameter(FORM_EMPLOYEE_LAST_NAME);
        String first_name = request.getParameter(FORM_EMPLOYEE_FIRST_NAME);
        String home_tel = request.getParameter(FORM_EMPLOYEE_HOME_PHO);
        String mob_tel = request.getParameter(FORM_EMPLOYEE_MOB_PHO);
        String pro_tel = request.getParameter(FORM_EMPLOYEE_PRO_PHO);
        String email = request.getParameter(FORM_EMPLOYEE_EMAIL);
        String street = request.getParameter(FORM_EMPLOYEE_STREET);
        String postal = request.getParameter(FORM_EMPLOYEE_POSTAL);
        String city = request.getParameter(FORM_EMPLOYEE_CITY);
        int id = 0;
        int idadd = 0;
        try{
            id = Integer.valueOf(request.getParameter(FORM_EMPLOYEE_ID));
            idadd = Integer.valueOf(request.getParameter(FORM_EMPLOYEE_AID));
        }catch(NumberFormatException e){
            System.out.printf(e.getMessage());
            
            response.sendRedirect("employees");
            return;
        }
        
        
        try{
            Employee_API.Put(id,last_name,first_name, home_tel,  mob_tel,  pro_tel,  email, street,  postal,  city, idadd);

            request.getSession().setAttribute("highlight_ID", id);
            response.sendRedirect("employees");
            return;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
            response.sendRedirect("employees");
            return;
        }

        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>Get</code> method.
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
     * Handles the HTTP <code>Post</code> method.
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
