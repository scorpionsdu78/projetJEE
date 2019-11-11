<%-- 
    Document   : logout
    Created on : 22 oct. 2019, 18:24:21
    Author     : Hugues
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.sql.ResultSet"%>

<c:set var="JSP_TEMPLATE_TITLE" value="Logout" scope="page" />
<c:set var="JSP_TEMPLATE_SECURITY" value="false" scope="page" />
<%@include file="includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">             
                <div class="col-lg-5 col-md-8 col-sm-12" style="margin: auto;">
                                    
                    <div class="card">
                        <div class="card-header">
                            You got log out. See you soon.
                        </div>
                        <div class="card-body">
                            <img src="https://i.gyazo.com/f0e3a206546e2952fd088d3954e0c132.png" style="width: 100%;" />
                        </div>            
                    </div>
                    
                </div>
            </div>
        </div>

<%@include file="includes/template_bot.jsp" %>