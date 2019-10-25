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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eddy
 */
public class Employee_API {
    
    
    
    static public ArrayList<Employee> get_employees() throws SQLException{
        // Francois's Code
        
        DBaction db = new DBaction();
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        ResultSet rs = db.executeQuery("SELECT * FROM EMPLOYEE");
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

            
            rs_adress = db.executeQuery("SELECT * FROM ADRESS WHERE \"id_employee\" = 1");
            
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
        
        return employees;
    }
    
    
    static public Employee get_employee_byID(int ID) throws SQLException{
        return null;
    }
    
    
    static public int post_employee(String last_name, String first_name, String home_pho, String mob_pho, String email, String street, String postal, String city) throws SQLException{
        DBaction db = new DBaction();
        db.getPreparedStatement(Constants.INSERT_EMPLOYEE);
        
        db.setString(1, last_name);
        db.setString(2, first_name);
        db.setString(3, home_pho);
        db.setString(4, mob_pho);
        db.setString(5, email);
        
        ResultSet rs = db.executeUpdate();
        
        if(rs != null){
            rs.next();
            int a = rs.getInt(1);
            
            
            return a;
        }
        
        
        return 0;
    }
}
