/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.controller;

import fr.efrei.API.EmployeeApi;
import static fr.efrei.jeeproject.Constants.*;
import fr.efrei.jpa.SB_Employee;
import fr.efrei.jpa.delete;

import java.io.IOException;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {        
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
        if(request.getParameter("radio_employees_v1") == null)
        {
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
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
                sB_Employee.Delete(Integer.valueOf(request.getParameter("radio_employees_v1")));
            }
            catch(Exception e)
            {
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
        
        //Admin privilege is required
        if(request.getSession().getAttribute("role") != null && !request.getSession().getAttribute("role").equals("admin")){
            request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", "You don't have the permission to be here !");
            response.sendRedirect("employees");
            return;
        }
        
        if(request.getParameter("method").equals("POST"))
        {

            try
            {
                String last_name = request.getParameter(FORM_EMPLOYEE_LAST_NAME);
                String first_name = request.getParameter(FORM_EMPLOYEE_FIRST_NAME);
                String home_tel = request.getParameter(FORM_EMPLOYEE_HOME_PHO);
                String mob_tel = request.getParameter(FORM_EMPLOYEE_MOB_PHO);
                String pro_tel = request.getParameter(FORM_EMPLOYEE_PRO_PHO);
                String email = request.getParameter(FORM_EMPLOYEE_EMAIL);
                String street = request.getParameter(FORM_EMPLOYEE_STREET);
                String postal = request.getParameter(FORM_EMPLOYEE_POSTAL);
                String city = request.getParameter(FORM_EMPLOYEE_CITY);

                int employee_id = sB_Employee.Post(first_name, last_name, home_tel, mob_tel, pro_tel, email, street, postal, city);


                request.getSession().setAttribute("highlight_ID", employee_id);

                response.sendRedirect("employees");
                return;
            }
            catch(Exception e)
            {
                System.out.println("CATCH");
                System.out.println(e.getMessage());
                request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());

                response.sendRedirect("employees");
                return;
            }
            
        }
        if(request.getParameter("method").equals("PUT"))
        {
            
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
            try
            {
                id = Integer.valueOf(request.getParameter(FORM_EMPLOYEE_ID));
            }
            catch(NumberFormatException e)
            {
                System.out.printf(e.getMessage());

                response.sendRedirect("employees");
                return;
            }


            try
            {
                System.out.println(id + " " + first_name + " " + last_name + " " + home_tel + " " + mob_tel + " " + pro_tel + " " + email);
                sB_Employee.Put(id, first_name, last_name, home_tel, mob_tel, pro_tel, email, street, postal, city);

                request.getSession().setAttribute("highlight_ID", id);

                response.sendRedirect("employees");
                return;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                request.getSession().setAttribute("JSP_TEMPLATE_SQL_ERROR", e.getMessage());
                response.sendRedirect("employees");
                return;
            }
        }
        
        response.sendRedirect(JSP_PAGE_EMPLOYEE_SINGLE);
        return;
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
