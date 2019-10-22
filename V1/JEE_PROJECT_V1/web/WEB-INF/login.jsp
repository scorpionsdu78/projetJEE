<%-- 
    Document   : login
    Created on : 15 oct. 2019, 10:04:51
    Author     : Eddy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="fr.efrei.dbcontroller.DBaction"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String JSP_TEMPLATE_TITLE = "Login"; %>
<%@include file="includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
     
            <div class="row">
                
                <div class="col-lg-5 col-md-8 col-sm-12" style="margin: auto;">
                                
                    <%-- Displaying the Error Message if there is one --%>
                    <div style="color:red; text-align: center">
                        <%
                            if(request.getAttribute("errKey") != null)
                            {
                                out.println( request.getAttribute("errKey") );
                            }
                            else
                            {
                                out.println( " " );
                            }
                        %>
                    </div>
            
                    <div class="card">
                        <div class="card-header">
                            Login
                        </div>
                        <div class="card-body">

                            <form action="Employee_get">
                              <div class="form-group">
                                  <input type="text" class="form-control" name="Login_v1" placeholder="Login">
                              </div>
                              <div class="form-group">
                                  <input type="password" class="form-control" name="Password_v1" placeholder="Password">
                              </div>
                              <button type="submit" class="btn btn-primary">Login</button>
                            </form>

                        </div>            
                    </div>
            
                </div>
            </div>
        </div>
<%@include file="includes/template_bot.jsp" %>