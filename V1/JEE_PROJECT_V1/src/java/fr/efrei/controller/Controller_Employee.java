/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.Employee_API;
import static fr.efrei.jeeproject.Constants.JSP_PAGE_EMPLOYEE_SINGLE;
import fr.efrei.jeeproject.Employee;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eddy
 */
@WebServlet(name = "Controller_Employee", urlPatterns = {"/Controller_Employee"})
public class Controller_Employee extends HttpServlet
{
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
        // The user is not supposed to be here
        if(request.getParameter("radio_employees_v1") == null)
        {
            // The user is an ADMIN : he will add a new employee
            if(request.getSession().getAttribute("role").equals("admin"))
                request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
            
            
            // The user is an EMPLOYEE : he will go back to employees.jsp
            else
                response.sendRedirect("employees");
            
            
            return;
        }
        
        
        
        if(request.getParameter("button").equals("Delete"))
        {
            try
            {
                // if the user is an employee and not an admin
                // REDIRECT to the main page
                String role = (String)request.getSession().getAttribute("role");
                if( role.equals( "employee" ) )
                {
                    response.sendRedirect("employees");
                    return;
                }
                    
                //call the api to delete here
                Employee_API.DELETE(Integer.valueOf(request.getParameter("radio_employees_v1")));
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            response.sendRedirect("employees");
            return;
        }
        
        
        if(request.getParameter("button").equals("Details"))
        {
            try
            {
                // Call the api to Get the employee here
                Employee employee = Employee_API.Get((Integer.valueOf(request.getParameter("radio_employees_v1"))));
                
                
                // If the return employee is null :
                // - I'm an Admin : this is normal, you'll Get to the ADD page
                // - I'm an Employee : this is NOT normal, you go back to the main page
                if(employee == null && request.getSession().getAttribute("role").equals("employee"))
                {
                    response.sendRedirect("employees");
                    return;
                }
                
                
                request.setAttribute("employee", employee);
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
            return;
        }
        
        request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
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
