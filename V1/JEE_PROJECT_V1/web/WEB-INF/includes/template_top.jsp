<%-- 
    Document   : template_top
    Created on : 15 oct. 2019, 10:10:54
    Author     : Eddy
--%>

<%
    boolean sessionActive = (session.getAttribute("role") != null);
    
    
    // If we have no session and we are in a secured page 
    // REDIRECTION --> LOGIN
    if( !sessionActive && JSP_TEMPLATE_SECURITY )
    {
        response.sendRedirect("login");
    }    
    
    // If we have a session and we want to access the Login 
    // REDIRECTION --> EMPLOYEES
    if( sessionActive && request.getRequestURI().equals("/JEE_PROJECT_V1/WEB-INF/login.jsp"))
    {
        response.sendRedirect("employees");
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <%
            
        if(request.getAttribute("JSP_TEMPLATE_SQL_ERROR") != null){
            out.print("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
        }
            
        %>
        
        
        <script src="jquery-3.4.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        
        <title><%
            if(JSP_TEMPLATE_TITLE != null)
            {
                out.print(JSP_TEMPLATE_TITLE);
            }
            else
            {
                out.print("Default");
            }
        %></title>
    </head>
    <body>
        
        <%

        if(request.getAttribute("JSP_TEMPLATE_SQL_ERROR") != null){
            out.println("");
            out.println("       <!-- Modal -->");
            out.println("		<script>");
            out.println("");
            out.println("			$(document).ready(function(){");
            out.println("				$(\"#myModal\").modal();");
            out.println("			});");
            out.println("");
            out.println("		</script>");
            out.println("");
            out.println("       <!-- Modal -->");
            out.println("		<div class=\"modal fade\" id=\"myModal\" role=\"dialog\">");
            out.println("		  <div class=\"modal-dialog\">");
            out.println("		  ");
            out.println("			<!-- Modal content-->");
            out.println("			<div class=\"modal-content\">");
            out.println("			  <div class=\"modal-header\">");
            out.println("				<h4 class=\"modal-title\">Erreur !</h4>");
            out.println("				<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>");
            out.println("			  </div>");
            out.println("			  <div class=\"modal-body\">");
            out.println("				<p>");
            out.println("					" + request.getAttribute("JSP_TEMPLATE_SQL_ERROR"));
            out.println("				</p>");
            out.println("			  </div>");
            out.println("			  <div class=\"modal-footer\">");
            out.println("				<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Fermer</button>");
            out.println("			  </div>");
            out.println("			</div>");
            out.println("");
            out.println("		  </div>");
            out.println("		</div>");
            out.println("");
        }

        %>
        
<%@include file="navbar.jsp" %>
