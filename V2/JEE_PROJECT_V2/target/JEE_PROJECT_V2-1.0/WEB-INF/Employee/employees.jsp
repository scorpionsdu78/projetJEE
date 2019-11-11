<%-- 
    Document   : employees
    Created on : 15 oct. 2019, 11:23:24
    Author     : Eddy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="fr.efrei.jeeproject.Adress"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.efrei.jeeproject.Employee"%>

<c:set var="JSP_TEMPLATE_TITLE" value="Employees list" scope="page" />
<c:set var="JSP_TEMPLATE_SECURITY" value="true" scope="page" />

<%@include file="../includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">
                <div class="col">
                    
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Sél</th>
                                <th scope="col">NAME</th>
                                <th scope="col">FIRST NAME</th>
                                <th scope="col">HOME PHONE</th>
                                <th scope="col">MOBILE PHONE</th>
                                <th scope="col">WORK PHONE</th>
                                <th scope="col">ADRESS</th>
                                <th scope="col">POSTAL CODE</th>
                                <th scope="col">CITY</th>
                                <th scope="col">EMAIL</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty employees}">
                                
                                <c:forEach var="employee" items="${employees}">
                                    
                            <tr style="cursor: pointer;<c:if test="${highlight_ID == employee.id}"> border-left: 4px solid CornflowerBlue ; border-right: 2px solid CornflowerBlue;</c:if>">
                                <td scope="row"><input type="radio" name="radio_employees_v1" form="employee" value="${employee.id}"></td>
                                <td> ${employee.last_name} </td>
                                <td> ${employee.first_name} </td>
                                <td> ${employee.home_phone} </td>
                                <td> ${employee.cell_phone} </td>
                                <td> ${employee.work_phone} </td>
                                    
                                    
                                    <c:set var="adress" value="${employee.adresses[0]}" scope="page" />
                                    
                                    <c:choose>

                                        <c:when test="${not empty adress}">

                                <td> ${adress.rue} </td>
                                <td> ${adress.codePostal} </td>
                                <td> ${adress.ville} </td>
                                    
                                        </c:when>

                                        <c:otherwise>

                                <td>NA</td>
                                <td>NA</td>
                                <td>NA</td>

                                        </c:otherwise>

                                    </c:choose>

                                <td> ${employee.email} </td>
                            </tr>
                            
                                </c:forEach>
                                
                            </c:if>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="row">
                <div class="col">
                    
                    <hr/>
                    
                    <div>
                        <form class="d-inline" action="employee" method="GET" id="employee">
                            <input type="radio" name="radio_employees_v1" hidden required>
                            <%
                                // If the user is an ADMIN, he can access the DELETE BUTTON
                                if( session.getAttribute("role").equals( "admin") )
                                        out.println("<input type=\"submit\" class=\"btn btn-primary\" name=\"button\" value=\"Delete\">");
                            %>
                            <input type="submit" class="btn btn-primary" name="button" value="Details">
                        </form>
                            
                            
                        <%
                            // If the user is an ADMIN, he can access the ADD BUTTON
                            
                            if( session.getAttribute("role").equals( "admin") )
                                    out.println("<a class=\"btn btn-primary\" href=\"employee\">Add</a>");
                        %>
                        
                    </div>
                    
                    <hr/>
                    
                </div>
            </div>
                        
            <%@include file="../Misc/frozen_2.jsp" %>
            
            <script>
                
                $('table tbody tr').click(function()
                {
                    $(this).find('input[type=radio]').prop('checked', true);
                });
              
            </script>
                                    
        </div>
<%@include file="../includes/template_bot.jsp" %>
