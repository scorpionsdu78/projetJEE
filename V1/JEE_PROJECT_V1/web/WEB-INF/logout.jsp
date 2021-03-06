<%-- 
    Document   : logout
    Created on : 22 oct. 2019, 18:24:21
    Author     : Hugues
--%>

<%@page import="java.sql.ResultSet"%>

<% String JSP_TEMPLATE_TITLE = "Logout"; %>
<% boolean JSP_TEMPLATE_SECURITY = false; %>
<%@include file="includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">             
                <div class="col-lg-5 col-md-8 col-sm-12" style="margin: auto;">
                                    
                    <div class="card">
                        
                        <%-- A farewell message --%>
                        <div class="card-header">
                            You got logged out. See you soon.
                        </div>
                        
                        <%-- A "funny" picture to say goodbye --%>
                        <div class="card-body">
                            <img src="https://i.gyazo.com/f0e3a206546e2952fd088d3954e0c132.png" style="width: 100%;" />
                        </div>      
                        
                    </div>
                    
                </div>
            </div>
        </div>

<%@include file="includes/template_bot.jsp" %>