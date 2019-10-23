<%-- 
    Document   : template_sticky_top
    Created on : 22 oct. 2019, 14:30:35
    Author     : Eddy
--%>

<%@page import="fr.efrei.jeeproject.Constants"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/JEE_PROJECT_V1">Employees Management</a>
    <div class="collapse navbar-collapse" id="navbarText">
        
        <ul class="navbar-nav mr-auto">
            <li class="nav-item" style="width: 10vh">
            </li>
            <li class="nav-item active">
                <span class="navbar-text">             
                        <%
    if(session.getAttribute("role") != null){
        out.println("Hello " + session.getAttribute("role") + " ! Your session is active");
    }
                        %>
                </span>
            </li>
        </ul>
                 
        <%
    if(session.getAttribute("role") != null){
        out.println("        <ul class=\"navbar-nav\">");
        out.println("            <li class=\"nav-item\">");
        out.println("                <a class=\"btn btn-light\" href=\"Controller_Logout\" style=\"color: black; font-size: 8px; font-size: 1.2vw;\">");
        out.println("                    Log out");
        out.println("                    <span style=\"");
        out.println("                        background-image: url('https://c7.uihere.com/icons/826/332/883/operating-log-off-860f8851a94474056cfa47ff8435ddc1.png');");
        out.println("                        background-size: cover;");
        out.println("                        background-repeat: no-repeat;");
        out.println("                        background-position: 50% 50%;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>");
        out.println("                </a>");
        out.println("            </li>");
        out.println("        </ul>");
    }
        %>
    </div>
</nav>