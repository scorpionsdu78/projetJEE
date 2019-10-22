package fr.efrei.jeeproject;


/** This Class stores all kind of Constants to use throughout the project
 * @author Hugues
 */
public class Constants
{
    // Error Messages
    public static final String ERR_MESSAGE_EMPTY_FIELDS = "You must enter values in both fields !";
    public static final String ERR_MESSAGE_INVALID = "Connection failed ! Verify your login / password and try again !";


    // Form Fields' names
    public static final String FORM_FIELD_LOGIN = "Login_v1";
    public static final String FORM_FIELD_PWD = "Password_v1";
    
    
    // JSP File's location
    public static final String JSP_PAGE_LOGIN = "WEB-INF/login.jsp";
    public static final String JSP_PAGE_EMPLOYEE_SINGLE = "WEB-INF/Employee/employee.jsp";
    public static final String JSP_PAGE_EMPLOYEE_ALL = "WEB-INF/Employee/employees.jsp";
}