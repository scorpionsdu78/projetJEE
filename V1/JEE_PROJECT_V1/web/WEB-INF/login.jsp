<%-- 
    Document   : login
    Created on : 15 oct. 2019, 10:04:51
    Author     : Eddy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="fr.efrei.dbcontroller.DBaction"%>

<% String JSP_TEMPLATE_TITLE = "Login"; %>
<% boolean JSP_TEMPLATE_SECURITY = true; %>
<%@include file="includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
     
            <div class="row">
                
                <div class="col-lg-5 col-md-8 col-sm-12" style="margin: auto;">
                                
                    <%-- Displaying the Error Message if there is one --%>
                    <div style="color:red; text-align: center">
                        <label>
                            <small>
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
                            </small>
                        </label>
                    </div>
            
                    <div class="card">
                        <div class="card-header">
                            Login
                        </div>
                        <div class="card-body">

                            <form action="login" method="post">
                              <div class="form-group">
                                  <input type="text" class="form-control" name="Login_v1" placeholder="Login" required>
                              </div>
                              <div class="form-group">
                                  <input type="password" class="form-control" name="Password_v1" placeholder="Password" required>
                              </div>
                              <button type="submit" class="btn btn-primary">Login</button>
                            </form>

                        </div>            
                    </div>
            
                </div>
            </div>
        </div>
<%@include file="includes/template_bot.jsp" %>