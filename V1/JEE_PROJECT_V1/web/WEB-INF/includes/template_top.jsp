<%-- 
    Document   : template_top
    Created on : 15 oct. 2019, 10:10:54
    Author     : Eddy
--%>

<%
    boolean sessionActive = (session.getAttribute("role") != null);
    boolean isSecured = JSP_TEMPLATE_SECURITY;
    
    // rediriger vers le Login
    if( !sessionActive && !isSecured )
    {
        response.sendRedirect("login");
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title><%
            try
            {
                out.print(JSP_TEMPLATE_TITLE);
            }
            catch(NullPointerException e)
            {
                out.print("Default");
            }
        %></title>
    </head>
    <body>
        
<%@include file="navbar.jsp" %>
