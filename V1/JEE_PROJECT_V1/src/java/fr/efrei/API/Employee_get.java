/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import fr.efrei.dbcontroller.DBaction;
import fr.efrei.jeeproject.Adress;
import static fr.efrei.jeeproject.Constants.*;
import fr.efrei.jeeproject.Employee;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francois
 */
public class Employee_get extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
          
        // Francois's Code
        
        DBaction dba = new DBaction();
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        ResultSet rs = dba.getResultSet("SELECT * FROM EMPLOYEE");
        ResultSet rs_adress; 
        

        while(rs.next())
        {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("fisrt_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setHome_phone(rs.getString("home_phone"));
            emp.setCell_phone("cell_phone");
            emp.setWork_phone(rs.getString("work_phone"));
            emp.setEmail("e_mail");
            employees.add(emp);

            
            rs_adress = dba.getResultSet("SELECT * FROM ADRESS WHERE \"id_employee\" = 1");
            
            ArrayList<Adress> adresses = new ArrayList<Adress>();
            
            while(rs_adress.next()){
                Adress addr = new Adress();
                addr.setId(rs_adress.getInt("id"));
                addr.setRue(rs_adress.getString("rue"));
                addr.setVille("ville");
                addr.setComplement(rs_adress.getString("complement"));
                addr.setBatiment(rs_adress.getString("batiment"));
                adresses.add(addr);
            }
            
            emp.setAdresses(adresses);
            

        }

        request.setAttribute("empList", employees);
        request.getRequestDispatcher("employees").forward(request, response);
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Employee_get.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        String Last_name = request.getParameter(FORM_EMPLOYEE_LAST_NAME);
        String First_name = request.getParameter(FORM_EMPLOYEE_FIRST_NAME);
        String home_tel = request.getParameter(FORM_EMPLOYEE_HOME_PHO);
        String mob_tel = request.getParameter(FORM_EMPLOYEE_MOB_PHO);
        String pro_tel = request.getParameter(FORM_EMPLOYEE_PRO_PHO);
        
        System.out.println(Last_name + First_name + home_tel + mob_tel + pro_tel);
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Employee_get.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "is this magic? yes it is ";
    }// </editor-fold>
}