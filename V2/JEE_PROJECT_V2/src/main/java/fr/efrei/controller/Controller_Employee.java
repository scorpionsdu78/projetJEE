/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.AdressApi;
import fr.efrei.API.EmployeeApi;
import static fr.efrei.jeeproject.Constants.*;
import fr.efrei.jpa.SB_Adress;
import fr.efrei.jpa.SB_Employee;
import fr.efrei.jpa.delete;

import java.io.IOException;
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
@WebServlet(name = "Controller_Employee")
public class Controller_Employee extends HttpServlet
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
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {        
        if(request.getParameter("radio_employees_v1") == null)
        {
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
            return;
        }
        
        if(request.getParameter("button").equals("Delete"))
        {
                System.out.println("1HERE");

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

                System.out.println(Integer.valueOf(request.getParameter("radio_employees_v1")));
                EmployeeApi employee = sB_Employee.Get(Integer.valueOf(request.getParameter("radio_employees_v1")));
                
                for(AdressApi adress : employee.getAdresses()){
                    sB_Employee.Delete(adress.getId());
                }
                
                sB_Employee.Delete(Integer.valueOf(request.getParameter("radio_employees_v1")));
                System.out.println("2HERE");
            }
            catch(Exception e)
            {
                System.out.println("1.IN CATCH : " + e.getClass());
                System.out.println(e.getMessage());
                request.setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
            }
            response.sendRedirect("employees");
            return;
        }
        if(request.getParameter("button").equals("Details"))
        {
            try{
                //call the api to get the employee here
                EmployeeApi employee = sB_Employee.Get(Integer.valueOf(request.getParameter("radio_employees_v1")));
                
                request.setAttribute("employee", employee);
            }catch(Exception e){
                System.out.println(e.getMessage());
                request.setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
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
