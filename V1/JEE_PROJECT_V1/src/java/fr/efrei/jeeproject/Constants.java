package fr.efrei.jeeproject;


/** This Class stores all kind of Constants to use throughout the project
 * @author Hugues
 */
public class Constants
{
    // Error Messages
    public static final String ERR_MESSAGE_INVALID = "Connection failed ! Verify your login / password and try again !";


    // Form Fields' names
    public static final String FORM_FIELD_LOGIN = "Login_v1";
    public static final String FORM_FIELD_PWD = "Password_v1";
    
    // Form Employee from
    public static final String FORM_EMPLOYEE_LAST_NAME = "Employee_nom";
    public static final String FORM_EMPLOYEE_FIRST_NAME = "Employee_prenom";
    public static final String FORM_EMPLOYEE_HOME_PHO = "Employee_tel_dom";
    public static final String FORM_EMPLOYEE_MOB_PHO = "Employee_tel_mob";
    public static final String FORM_EMPLOYEE_PRO_PHO = "Employee_tel_pro";
    
    
    // JSP File's location
    public static final String JSP_PAGE_LOGIN = "WEB-INF/login.jsp";
    public static final String JSP_PAGE_LOGOUT = "WEB-INF/logout.jsp";
    public static final String JSP_PAGE_EMPLOYEE_SINGLE = "WEB-INF/Employee/employee.jsp";
    public static final String JSP_PAGE_EMPLOYEE_ALL = "WEB-INF/Employee/employees.jsp";
}