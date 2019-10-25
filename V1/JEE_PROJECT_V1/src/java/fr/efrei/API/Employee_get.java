/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import fr.efrei.dbcontroller.DBaction;
import fr.efrei.jeeproject.Adress;
import static fr.efrei.jeeproject.Constants.*;
import fr.efrei.jeeproject.Employee;
import java.io.IOException;
import java.sql.PreparedStatement;
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
        
        PreparedStatement psmt = dba.getPreparedStatement("SELECT * FROM EMPLOYEE");

        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        ResultSet rs = psmt.executeQuery();
        ResultSet rs_adress; 
        

        while(rs.next())
        {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("fisrt_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setHome_phone(rs.getString("home_phone"));
            emp.setCell_phone(rs.getString("cell_phone"));
            emp.setWork_phone(rs.getString("work_phone"));
            emp.setEmail(rs.getString("e_mail"));
            employees.add(emp);

            //??
            psmt = dba.getPreparedStatement("SELECT * FROM ADRESS WHERE \"id_employee\" = 1");
            rs_adress = psmt.executeQuery();
            
            ArrayList<Adress> adresses = new ArrayList<Adress>();
            
            while(rs_adress.next()){
                Adress addr = new Adress();
                addr.setId(rs_adress.getInt("id"));
                addr.setRue(rs_adress.getString("rue"));
                addr.setVille(rs_adress.getString("ville"));
                addr.setComplement(rs_adress.getString("complement"));
                addr.setBatiment(rs_adress.getString("batiment"));
                adresses.add(addr);
            }
            
            emp.setAdresses(adresses);
            

        }

        request.setAttribute("empList", employees);
        request.getRequestDispatcher("WEB-INF/Employee/employee.jsp").forward(request, response);
        
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
            String value = request.getParameter(FORM_EMPLOYEES_EMPLOYEE);
            System.out.println(value);
            int id = Integer.valueOf(value) ;
            
            
            Employee emp = Employee_API.get_employee_byID(id);
            
            request.setAttribute("emp",emp);
            request.getRequestDispatcher(JSP_PAGE_EMPLOYEE_SINGLE).forward(request, response);
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
        String email = request.getParameter(FORM_EMPLOYEE_EMAIL);
        String street = request.getParameter(FORM_EMPLOYEE_STREET);
        String postal = request.getParameter(FORM_EMPLOYEE_POSTAL);
        String city = request.getParameter(FORM_EMPLOYEE_CITY);
        
        System.out.println(Last_name + First_name + home_tel + mob_tel + pro_tel + street + postal + city);
        try {
            DBaction dba = new DBaction();
            dba.postData(First_name, Last_name, home_tel, mob_tel, pro_tel, email, street, postal, city);
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