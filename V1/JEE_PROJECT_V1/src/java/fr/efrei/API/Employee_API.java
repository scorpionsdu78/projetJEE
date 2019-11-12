/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import fr.efrei.dbcontroller.DBaction;
import fr.efrei.jeeproject.Adress;
import fr.efrei.jeeproject.Constants;
import static fr.efrei.jeeproject.Constants.DELETE_ADRESS;
import static fr.efrei.jeeproject.Constants.DELETE_EMPLOYEE;
import fr.efrei.jeeproject.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eddy
 */
public class Employee_API
{
    /** Returns all the {@link Employee} from the Database
     * 
     * @return All the {@link Employee} from the Database
     * @throws SQLException 
     */
    static public ArrayList<Employee> Get()
            throws SQLException
    {
        DBaction db = new DBaction();
        
        ArrayList<Employee> employees = new ArrayList<Employee>(); 

        PreparedStatement psmt = db.getPreparedStatement("SELECT * FROM EMPLOYEE");

        // We Get all the employees
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
        
            // We Get all the adress of the given employee (we verify the ID)
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
    
    
    
    /** Returns a given  {@link Employee} from the database
     * 
     * @param id ID of the  {@link Employee} we search
     * @return  A given {@link Employee} from the database
     * @throws SQLException 
     */
    static public Employee Get(int id)
            throws SQLException
    {
        DBaction dba = new DBaction();
        
        PreparedStatement psmt = dba.getPreparedStatement("SELECT * FROM EMPLOYEE WHERE \"id\" = ?");
        psmt.setInt(1, id);
        ResultSet rs = psmt.executeQuery();
        ResultSet rsAdress; 
            
        
        Employee emp = null;
        if( rs.next() )
        {
            emp = new Employee();
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

            while(rsAdress.next())
            {
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
        }

          
        return emp;
    }
    
    
    
    /** Creates a new  {@link Employee} in the Database
     * 
     * @param last_name Its last name
     * @param first_name Its first name
     * @param home_pho Its home phone number
     * @param mob_pho Its mobile phone number
     * @param work_pho Its work phone number
     * @param email Its email adress
     * @param street Its street
     * @param postal Its home postal code
     * @param city Its city
     * @return the ID of the new {@link Employee}
     * @throws SQLException 
     */
    static public int Post(String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, String street, String postal, String city)
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
    
    
    
    
    /** Modify a {@link Employee} in the database
     * 
     * @param id ID of the {@link Employee} to modify
     * @param last_name New last name
     * @param first_name New first name
     * @param home_pho New home phone number
     * @param mob_pho New mobile phone number
     * @param work_pho New work phone number
     * @param email New email adress
     * @param street New street
     * @param postal New home postal code
     * @param city New city
     * @throws SQLException 
     */
    static public void Put(int id, String last_name, String first_name, String home_pho, String mob_pho, String work_pho, String email, String street, String postal, String city, int idadd)
        throws SQLException
    {
        
        DBaction db = new DBaction();
        PreparedStatement psmt = db.getPreparedStatement(Constants.UPDATE_EMPLOYEE);
        PreparedStatement psmt2 = db.getPreparedStatement(Constants.UPDATE_ADRESS);

        psmt.setString(1, last_name);
        psmt.setString(2, first_name);
        psmt.setString(3, home_pho);
        psmt.setString(4, mob_pho);
        psmt.setString(5, work_pho);
        psmt.setString(6, email);

        psmt.setInt(7, id);

        psmt.executeUpdate();

        psmt2.setString(1, street);
        psmt2.setString(2, postal);
        psmt2.setString(3, city);

        psmt2.setInt(4, idadd);

        psmt2.executeUpdate();
    }
    
    
    
    /** Deletes an {@link Employee} from the database
     * 
     * @param id ID of the {@link Employee} to delete
     * @throws SQLException 
     */
    static public void DELETE(int id)
        throws SQLException
    {
        DBaction dba = new DBaction();
        PreparedStatement delete_adress = dba.getPreparedStatement(DELETE_ADRESS);
        PreparedStatement delete_employee = dba.getPreparedStatement(DELETE_EMPLOYEE);

        ResultSet rsAdress; 
        rsAdress = dba.getPreparedStatement("SELECT * FROM ADRESS WHERE \"id_employee\" = "+id).executeQuery();

        while(rsAdress.next()){
            delete_adress.setInt(1,rsAdress.getInt(1));
            delete_adress.executeUpdate();
        }

        delete_employee.setInt(1, id);
        delete_employee.executeUpdate();
    }
}
