/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.dbcontroller;
import fr.efrei.jeeproject.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author francois
 */
public class DBaction {
    
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ArrayList<Employee> employees;

    public DBaction() {
        
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/project","root","root");
            System.out.println("connection reussit");
        } catch (SQLException ex) {
            Logger.getLogger(DBaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stmt;

    }
    
    public ResultSet getResultSet(String SQL_QUERY) {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(SQL_QUERY);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return rs;

    }
    
}
