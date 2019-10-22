/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import fr.efrei.dbcontroller.DBaction;
import fr.efrei.jeeproject.Employee;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
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
        DBaction dba = new DBaction();
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        ResultSet rs = dba.getResultSet("SELECT * FROM EMPLOYEE");

        // TESTING the getProperty method (the display is done within the method itself)
        String pleaseDeleteMe = this.getProperty("ADMIN_LOGIN");

        while(rs.next()){
            Employee emp = new Employee();
            emp.setFirst_name(rs.getString("fisrt_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setHome_phone(rs.getString("home_phone"));
            emp.setCell_phone("cell_phone");
            emp.setWork_phone(rs.getString("work_phone"));
            emp.setEmail("e_mail");
            employees.add(emp);
            
        }

        request.setAttribute("empList", employees);
<<<<<<< Updated upstream
        request.getRequestDispatcher("Employee/employees.jsp").forward(request, response);
        
        
        
=======
        request.getRequestDispatcher("employees.jsp");
>>>>>>> Stashed changes
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

    
    
    /** Gets a property stored in the constant.properties file with a given index
     * 
     * @param propertyName Name of the property to return
     * @return Returns a property from the constants.properties
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String getProperty(String propertyName) throws ServletException, IOException
    {   
        String PROP_FILE_PATH = "/WEB-INF/db.properties";
        InputStream input = getServletContext().getResourceAsStream(PROP_FILE_PATH);
        
        
        Properties prop = new Properties();
        prop.load(input);
        
        // DELETE ME WHEN THE METHOD IS WORKING
        System.out.println(propertyName);
        System.out.println(prop.getProperty(propertyName));
        
        
        return prop.getProperty( propertyName );
    }
}