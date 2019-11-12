/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.EmployeeApi;
import fr.efrei.API.Employee_API;
import fr.efrei.jeeproject.Adress;
import fr.efrei.jeeproject.Employee;
import static fr.efrei.jeeproject.Constants.JSP_PAGE_EMPLOYEE_ALL;
import fr.efrei.jpa.SB_Employee;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Controller_Employees")
public class Controller_Employees extends HttpServlet
{

    @EJB
    private SB_Employee sB_Employee;
    
    
    
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
            throws ServletException, IOException
    {
        if(request.getSession().getAttribute("JSP_TEMPLATE_SQL_ERROR") != null){
            request.setAttribute("JSP_TEMPLATE_SQL_ERROR", request.getSession().getAttribute("JSP_TEMPLATE_SQL_ERROR"));
            request.getSession().removeAttribute("JSP_TEMPLATE_SQL_ERROR");
        }
        
        if(request.getSession().getAttribute("highlight_ID") != null){
            request.setAttribute("highlight_ID", request.getSession().getAttribute("highlight_ID"));
            request.getSession().removeAttribute("highlight_ID");
        }
        
        try
        {
            
            ArrayList<EmployeeApi> employees = new ArrayList(sB_Employee.Get());
            
            request.setAttribute("employees", employees);
            
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_ALL).forward(request, response);
            return;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            request.setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_ALL).forward(request, response);
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
