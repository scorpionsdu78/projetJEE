package fr.efrei.dbcontroller;


import static fr.efrei.jeeproject.Constants.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author francois
 */
public class DBaction
{    
    private final Connection conn;

    
    /** Default constructor of the DBaction Class
     * 
     */
    public DBaction() throws SQLException
    {    
        this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projet","projet","projet");
        System.out.println("connection réussie");
    }
    
    
    
    
    /** Try to prepare a Statement from the database
     * 
     * @param query SQL query to execute
     * @return The Statement created from the database
     */
    public PreparedStatement getPreparedStatement(String query)
            throws SQLException
    {
        return conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }
    
    
    
    
    /** Post data
     * 
     * @param first_name First Name to enter
     * @param last_name Last Name to enter
     * @param home_phone Home Phone to enter
     * @param cell_phone Cell Phone to enter
     * @param work_phone Work Phone to enter
     * @param email Email to enter
     * @param street Street to enter
     * @param postal Postal Code to enter
     * @param town Town to enter
     * @throws SQLException 
     */
    public void postData(String first_name, String last_name, String home_phone, String cell_phone, String work_phone, String email, String street, String postal, String town)
        throws SQLException
    {
        PreparedStatement pstmt = conn.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, first_name);
        pstmt.setString(2, last_name);
        pstmt.setString(3, home_phone);
        pstmt.setString(4, cell_phone);
        pstmt.setString(5, work_phone);
        pstmt.setString(6, email);
        pstmt.executeUpdate();

        ResultSet local_rs = pstmt.getGeneratedKeys();

        if(local_rs != null)
        {
            local_rs.next();
            int a = local_rs.getInt(1);
            
            PreparedStatement pstmt2 = conn.prepareStatement(INSERT_ADRESS);
            pstmt2.setString(1, street);
            pstmt2.setString(2, postal);
            pstmt2.setString(3, town);
            pstmt2.setInt(4, a);
            
            pstmt2.executeUpdate();
        }
    }
}