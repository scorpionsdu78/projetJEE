/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.AdressApi;
import fr.efrei.API.EmployeeApi;
import fr.efrei.API.Employee_API;
import static fr.efrei.jeeproject.Constants.*;
import fr.efrei.jpa.SB_Adress;
import fr.efrei.jpa.SB_Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eddy
 */
@WebServlet(name = "Controller_Employee_POST")
public class Controller_Employee_POST extends HttpServlet
{

    @EJB
    private SB_Employee sB_Employee;

    @EJB
    private SB_Adress sB_Adress;

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
        //Admin privilege is required
        if(request.getSession().getAttribute("role") != null && !request.getSession().getAttribute("role").equals("admin")){
            request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", "You don't have the permission to be here !");
            response.sendRedirect("employees");
            return;
        }
        
        try{
            String last_name = request.getParameter(FORM_EMPLOYEE_LAST_NAME);
            String first_name = request.getParameter(FORM_EMPLOYEE_FIRST_NAME);
            String home_tel = request.getParameter(FORM_EMPLOYEE_HOME_PHO);
            String mob_tel = request.getParameter(FORM_EMPLOYEE_MOB_PHO);
            String pro_tel = request.getParameter(FORM_EMPLOYEE_PRO_PHO);
            String email = request.getParameter(FORM_EMPLOYEE_EMAIL);
            String street = request.getParameter(FORM_EMPLOYEE_STREET);
            String postal = request.getParameter(FORM_EMPLOYEE_POSTAL);
            String city = request.getParameter(FORM_EMPLOYEE_CITY);
            
            
            System.out.println(first_name + ", " + last_name + ", " + home_tel + ", " + mob_tel + ", " + pro_tel + ", " + email);
            int employee_id = sB_Employee.Post(first_name, last_name, home_tel, mob_tel, pro_tel, email);
            //int employee_id = 15;
            System.out.println("HERE");
            System.out.println(street + ", " + postal + ", " + city + ", " + employee_id);
            int adress_id = sB_Adress.Post(street, postal, city, employee_id);
            
            request.getSession().setAttribute("highlight_ID", employee_id);
            response.sendRedirect("employees");
            System.out.println("Succed");
            return;
        }catch(Exception e){
            System.out.println("CATCH : " + e.getClass());
            System.out.println(e.getMessage());
            request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
            response.sendRedirect("employees");
            return;
        }
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
