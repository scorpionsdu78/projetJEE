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
import java.util.ArrayList;

/**
 *
 * @author Eddy
 */
public class Employee_API
{
    static public ArrayList<Employee> get_employees() throws SQLException
    {
        DBaction db = new DBaction();
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        

        // We get all the employees
        ResultSet rs = db.executeQuery("SELECT * FROM EMPLOYEE");
        while(rs.next())
        {
            // Creating an employee
            Employee emp = new Employee();
            
            // Adding all the basic employee's data
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("fisrt_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setHome_phone(rs.getString("home_phone"));
            emp.setCell_phone(rs.getString("cell_phone"));
            emp.setWork_phone(rs.getString("work_phone"));
            emp.setEmail(rs.getString("e_mail"));
            ArrayList<Adress> adresses = new ArrayList<Adress>();
            
            
            // We get all the adress of the given employee (we verify the ID)
            ResultSet rs_adress = db.executeQuery("SELECT * FROM ADRESS WHERE \"id_employee\" = " + emp.getId());
            while( rs_adress.next() )
            {
                Adress addr = new Adress();
                addr.setId(rs_adress.getInt("id"));
                addr.setRue(rs_adress.getString("rue"));
                addr.setVille(rs_adress.getString("ville"));
                addr.setCodePostal(rs_adress.getString("code_postal"));
                addr.setComplement(rs_adress.getString("complement"));
                addr.setBatiment(rs_adress.getString("batiment"));
                adresses.add(addr);
            }        
            
            // We add the Addresses to the current Employee
            emp.setAdresses(adresses);
            
            // We add the current Employee to the list
            employees.add(emp);
        }
        
        return employees;
    }
    
    
    static public Employee get_employee_byID(int id) throws SQLException
    {
        
        DBaction dba = new DBaction();
        ResultSet rs = dba.executeQuery("SELECT * FROM EMPLOYEE WHERE \"id\"="+id);
        ResultSet rsAdress; 
            
        rs.next();
            
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setFirst_name(rs.getString("fisrt_name"));
        emp.setLast_name(rs.getString("last_name"));
        emp.setHome_phone(rs.getString("home_phone"));
        emp.setCell_phone(rs.getString("cell_phone"));
        emp.setWork_phone(rs.getString("work_phone"));
        emp.setEmail(rs.getString("e_mail"));
            
        rsAdress = dba.executeQuery("SELECT * FROM ADRESS WHERE \"id_employee\"="+id);
            
        ArrayList<Adress> adresses = new ArrayList<Adress>();
            
        while(rsAdress.next()){
            Adress addr = new Adress();
            addr.setId(rsAdress.getInt("id"));
            addr.setRue(rsAdress.getString("rue"));
            addr.setVille(rsAdress.getString("ville"));
            addr.setComplement(rsAdress.getString("complement"));
            addr.setBatiment(rsAdress.getString("batiment"));
            adresses.add(addr);
        }

        emp.setAdresses(adresses);
        return emp;
    }
    
    
    static public int post_employee(String last_name, String first_name, String home_pho, String mob_pho, String email, String street, String postal, String city) throws SQLException
    {
        DBaction db = new DBaction();
        db.getPreparedStatement(Constants.INSERT_EMPLOYEE);
        
        db.setString(1, last_name);
        db.setString(2, first_name);
        db.setString(3, home_pho);
        db.setString(4, mob_pho);
        db.setString(5, email);
        
        ResultSet rs = db.executeUpdate();
        
        if(rs != null)
        {
            rs.next();
            int a = rs.getInt(1);
            
            db.getPreparedStatement(Constants.INSERT_ADRESS);
            db.setString(1, street);
            db.setString(2, postal);
            db.setString(3, city);
            db.setInt(4, a);
            System.out.println("update ready");
            db.executeUpdate();
            System.out.println("updated?");
            
            return a;
        }
        
        
        return 0;
    }
}
