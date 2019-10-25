package fr.efrei.dbcontroller;


import static fr.efrei.jeeproject.Constants.INSERT_ADRESS;
import static fr.efrei.jeeproject.Constants.INSERT_EMPLOYEE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    PreparedStatement pstmt;
    ResultSet rs;

    
    /** Default constructor of the DBaction Class
     * 
     */
    public DBaction()
    {    
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projet","projet","projet");
            System.out.println("connection réussie");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /** Try to prepare a Statement from the database
     * 
     * @return The Statement created from the database
     */
    public Statement getPreparedStatement(String query)
    {
        try
        {
            this.pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        return this.pstmt;
    }
    
    
    /** Try to prepare a Statement from the database
     * 
     * @return The Statement created from the database
     */
    public void setString(int index, String value)
    {
        try
        {
            this.pstmt.setString(index, value);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
    }
    
    
    /** Try to prepare a Statement from the database
     * 
     * @return The Statement created from the database
     */
    public void setInt(int index, int value)
    {
        try
        {
            this.pstmt.setInt(index, value);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
    }
    
    
    /** Try to prepare a Statement from the database
     * 
     * @return The Statement created from the database
     */
    public ResultSet executeUpdate()
    {
        ResultSet rs = null;
        try
        {
            int bool = this.pstmt.executeUpdate();
            
            if(bool == 1){
                rs = this.pstmt.getGeneratedKeys();
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
        
        return rs;
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
    public ResultSet executeQuery(String SQL_QUERY)
    {
        try
        {
            stmt = getStatement();
            rs = stmt.executeQuery(SQL_QUERY);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
        return rs;
    }
    
    public void postData(String first_name, String last_name, String home_phone, String cell_phone, String work_phone, String email, String rue, String code_postal, String ville){
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, home_phone);
            pstmt.setString(4, cell_phone);
            pstmt.setString(5, work_phone);
            pstmt.setString(6, email);
            pstmt.executeUpdate();
            
            ResultSet local_rs = pstmt.getGeneratedKeys();

            if(local_rs != null){
                local_rs.next();
                int a = local_rs.getInt(1);
                System.out.println("entrer IF");
                PreparedStatement pstmt2 = conn.prepareStatement(INSERT_ADRESS);
                pstmt2.setString(1, rue);
                pstmt2.setString(2, code_postal);
                pstmt2.setString(3, ville);
                pstmt2.setInt(4, a);
                System.out.println("update ready");
                pstmt2.executeUpdate();
                System.out.println("updated?");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}