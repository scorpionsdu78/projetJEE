package fr.efrei.jeeproject;


/** This Class stores all kind of Constants to use throughout the project
 * @author Hugues
 */
public class Constants
{
    //Theme constants
    public static final String THEME_COLOR = "indianred";
    
    // Error Messages
    public static final String ERR_MESSAGE_INVALID = "Connection failed ! Verify your login / password and try again !";


    // Form Login fields's names
    public static final String FORM_LOGIN_USERNAME = "Username_v1";
    public static final String FORM_LOGIN_PASSWORD = "Password_v1";
    
    // Form Employee fields's names
    public static final String FORM_EMPLOYEE_LAST_NAME = "Employee_nom";
    public static final String FORM_EMPLOYEE_FIRST_NAME = "Employee_prenom";
    public static final String FORM_EMPLOYEE_HOME_PHO = "Employee_tel_dom";
    public static final String FORM_EMPLOYEE_MOB_PHO = "Employee_tel_mob";
    public static final String FORM_EMPLOYEE_PRO_PHO = "Employee_tel_pro";
    public static final String FORM_EMPLOYEE_EMAIL = "Employee_email";
    public static final String FORM_EMPLOYEE_STREET = "Employee_street";
    public static final String FORM_EMPLOYEE_POSTAL = "Employee_code_postal";
    public static final String FORM_EMPLOYEE_CITY = "Employee_ville";
    public static final String FORM_EMPLOYEE_ID = "empID";
    public static final String FORM_EMPLOYEE_AID = "addID";
    
    // Form employess 
    public static final String FORM_EMPLOYEES_EMPLOYEE = "radio_employees_v1";
    
    // QUERY SQL
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEE";
    public static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM EMPLOYEE WHERE id = ?";
    public static final String GET_ADRESSES_BY_EMPLOYEE_ID = "SELECT * FROM ADRESS WHERE id_employee = ?";
    
    public static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE(last_name, first_name, home_phone, cell_phone, work_phone, e_mail) VALUES(?,?,?,?,?,?)";
    public static final String INSERT_ADRESS = "INSERT INTO ADRESS(rue, code_postal, ville, id_employee) VALUES(?,?,?,?)";

    public static final String UPDATE_EMPLOYEE ="UPDATE EMPLOYEE SET last_name=?, first_name=?, home_phone=?, cell_phone=?, work_phone=?, e_mail=? where id=?";
    public static final String UPDATE_ADRESS = "UPDATE ADRESS SET rue=?, code_postal=?, ville=? where id=?";
    
    public static final String DELETE_ADRESS = "DELETE FROM ADRESS WHERE id=?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE id=?";
    
    // JSP File's location
    public static final String JSP_PAGE_LOGIN = "WEB-INF/login.jsp";
    public static final String JSP_PAGE_LOGOUT = "WEB-INF/logout.jsp";
    public static final String JSP_PAGE_EMPLOYEE_SINGLE = "WEB-INF/Employee/employee.jsp";
    public static final String JSP_PAGE_EMPLOYEE_ALL = "WEB-INF/Employee/employees.jsp";
}