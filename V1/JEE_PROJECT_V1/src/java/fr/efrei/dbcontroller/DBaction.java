package fr.efrei.dbcontroller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author francois
 */
public class DBaction
{    
    Connection conn;
    Statement stmt;
    ResultSet rs;

    
    /** Default constructor of the DBaction Class
     * 
     */
    public DBaction()
    {    
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projet","projet","projet");
            System.out.println("connection reussit");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /** Try to create a Statement from the database
     * 
     * @return The Statement created from the database
     */
    public Statement getStatement()
    {
        try
        {
            stmt = conn.createStatement();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        return stmt;
    }
    
    
    /** Returns a ResultSet from the database of a given SQL query
     * 
     * @param SQL_QUERY Syntax of the SQL query
     * @return The ResultSet corresponding to the SQL query
     */
    public ResultSet getResultSet(String SQL_QUERY)
    {
        stmt = getStatement();
        try
        {
            rs = stmt.executeQuery(SQL_QUERY);
            System.out.println("query execute success");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
        return rs;
    }
}