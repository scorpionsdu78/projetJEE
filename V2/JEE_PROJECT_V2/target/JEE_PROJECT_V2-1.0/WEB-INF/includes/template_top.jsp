<%-- 
    Document   : template_top
    Created on : 15 oct. 2019, 10:10:54
    Author     : Eddy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    
    <c:when test="${empty role && JSP_TEMPLATE_SECURITY}">
        <c:redirect url="login" />   
    </c:when>

    <c:when test="${not empty role && pageContext.request.requestURI == '/JEE_PROJECT_V2/WEB-INF/login.jsp'}" >
        <c:redirect url="employees" />
    </c:when>
    
</c:choose>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        
        <title><c:out value="${JSP_TEMPLATE_TITLE}" default="default" /></title>
    </head>
    <body>
        
        <c:if test="${not empty JSP_TEMPLATE_SQL_ERROR}">
            
        <!-- Modal -->
        <script>

            $(document).ready(function(){
                $("#myModal").modal();
            });

        </script>
        

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
             <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Erreur !</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                      </div>
                     <div class="modal-body">
                        <p>
                            ${JSP_TEMPLATE_SQL_ERROR}
                        </p>
                      </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                     </div>
                </div>

            </div>
         </div>
            
        </c:if>
        
        
<%@include file="navbar.jsp" %>
