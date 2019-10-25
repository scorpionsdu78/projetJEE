/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import fr.efrei.dbcontroller.DBaction;
import fr.efrei.jeeproject.Adress;
import fr.efrei.jeeproject.Constants;
import fr.efrei.jeeproject.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eddy
 */
public class Employee_API
{
    static public ArrayList<Employee> get_employees()
            throws SQLException
    {
        DBaction db = new DBaction();
        
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        PreparedStatement psmt = db.getPreparedStatement("SELECT * FROM EMPLOYEE");

        // We get all the employees
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            // Creating an employee
            Employee emp = new Employee();
            
            // Adding all the basic employee's data
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("first_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setHome_phone(rs.getString("home_phone"));
            emp.setCell_phone(rs.getString("cell_phone"));
            emp.setWork_phone(rs.getString("work_phone"));
            emp.setEmail(rs.getString("e_mail"));
            ArrayList<Adress> adresses = new ArrayList<Adress>();
            
            
            psmt = db.getPreparedStatement("SELECT * FROM ADRESS WHERE \"id_employee\" = ?");
            psmt.setInt(1, emp.getId());
        
            // We get all the adress of the given employee (we verify the ID)
            ResultSet rs_adress = psmt.executeQuery();
            while( rs_adress.next() )
            {
                Adress addr = new Adress();
                addr.setId(rs_adress.getInt("id"));
                addr.setRue(rs_adress.getString("rue"));
                addr.setVille(rs_adress.getString("ville"));
                addr.setCodePostal(rs_adress.getString("code_postal"));
                addr.setComplement(rs_adress.getString("complement"));
                addr.setBatiment(rs_adress.getString("batiment"));
                
                // We add the current adress to the list of Adresses
                adresses.add(addr);
            }        
            
            // We add the Adresses to the current Employee
            emp.setAdresses(adresses);
            
            // We add the current Employee to the list
            employees.add(emp);
        }
        
        return employees;
    }
    
    
    static public Employee get_employee_byID(int id)
            throws SQLException
    {
        
        DBaction dba = new DBaction();
        
        PreparedStatement psmt = dba.getPreparedStatement("SELECT * FROM EMPLOYEE WHERE \"id\" = ?");
        psmt.setInt(1, id);
        ResultSet rs = psmt.executeQuery();
        ResultSet rsAdress; 
            
        rs.next();
            
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setFirst_name(rs.getString("first_name"));
        emp.setLast_name(rs.getString("last_name"));
        emp.setHome_phone(rs.getString("home_phone"));
        emp.setCell_phone(rs.getString("cell_phone"));
        emp.setWork_phone(rs.getString("work_phone"));
        emp.setEmail(rs.getString("e_mail"));
            
        psmt = dba.getPreparedStatement("SELECT * FROM ADRESS WHERE \"id_employee\" = ?");
        psmt.setInt(1, id);
        rsAdress = psmt.executeQuery();
            
        ArrayList<Adress> adresses = new ArrayList<Adress>();
            
        while(rsAdress.next()){
            Adress addr = new Adress();
            addr.setId(rsAdress.getInt("id"));
            addr.setRue(rsAdress.getString("rue"));
            addr.setCodePostal(rsAdress.getString("code_postal"));
            addr.setVille(rsAdress.getString("ville"));
            addr.setComplement(rsAdress.getString("complement"));
            addr.setBatiment(rsAdress.getString("batiment"));
            adresses.add(addr);
        }

        emp.setAdresses(adresses);
        return emp;
    }
    
    
    static public int post_employee(String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, String street, String postal, String city)
            throws SQLException
    {
        DBaction db = new DBaction();
        
        PreparedStatement psmt = db.getPreparedStatement(Constants.INSERT_EMPLOYEE);
        
        psmt.setString(1, last_name);
        psmt.setString(2, first_name);
        psmt.setString(3, home_pho);
        psmt.setString(4, mob_pho);
        psmt.setString(5, work_pho);
        psmt.setString(6, email);
        
        int i = psmt.executeUpdate();
        
        if(i != 0){
            ResultSet rs = psmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            
            psmt = db.getPreparedStatement(Constants.INSERT_ADRESS);
            psmt.setString(1, street);
            psmt.setString(2, postal);
            psmt.setString(3, city);
            psmt.setInt(4, id);
            
            psmt.executeUpdate();
            
            return id;
        }
        
        
        return 0;
    }
    
    static public int putEmployee(int id, String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, String street, String postal, String city){
        
        DBaction db;
        try {
            db = new DBaction();
            PreparedStatement psmt = db.getPreparedStatement(Constants.UPDATE_EMPLOYEE);
            
            psmt.setString(1, last_name);
            psmt.setString(2, first_name);
            psmt.setString(3, home_pho);
            psmt.setString(4, mob_pho);
            psmt.setString(5, work_pho);
            psmt.setString(6, email);
            
            psmt.setInt(7, id);
            
            psmt.executeUpdate();
            
            return 0;
                    
        } catch (SQLException ex) {
            Logger.getLogger(Employee_API.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
