<%-- 
    Document   : employee
    Created on : 21 oct. 2019, 16:43:20
    Author     : Eddy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="fr.efrei.jeeproject.Adress"%>
<%@page import="fr.efrei.jeeproject.Employee"%>

<c:set var="JSP_TEMPLATE_TITLE" value="Employee" scope="page" />
<c:set var="JSP_TEMPLATE_SECURITY" value="true" scope="page" />

<%@include file="../includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">
                <div class="col">
                    
                    <h1>Details of employee :</h1>
                    
                    <hr/>
                        
                    <c:choose>
                        
                        <c:when test="${empty employee}">
                    <form action="Controller_Employee_POST" method="POST">
                        </c:when>
                                
                        <c:otherwise>
                            <c:set var="adress" value="${employee.adresses[0]}" scope="page" />
                    <form action="Controller_Employee_PUT" method="POST">                            
                        </c:otherwise>
                                
                    </c:choose>
                                
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_nom" class="col-sm-2 col-form-label" style="text-align: right;">Nom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_nom" id="Employee_nom" placeholder="Nom" 
                                       <c:if test="${not empty employee}">
                                    value="${employee.Last_name}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_prenom" class="col-sm-2 col-form-label" style="text-align: right;">Prénom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_prenom" placeholder="Prénom"
                                       <c:if test="${not empty employee}">
                                    value="${employee.FirstName}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    requiredrequired pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_dom" class="col-sm-2 col-form-label" style="text-align: right;">Tél dom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_dom" id="Employee_tel_dom" placeholder="Tél dom"
                                       <c:if test="${not empty employee}">
                                    value="${employee.Home_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_mob" class="col-sm-2 col-form-label" style="text-align: right;">Tél mob</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_mob" id="Employee_tel_mob" placeholder="Tél mob"
                                       <c:if test="${not empty employee}">
                                    value="${employee.Cell_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_pro" class="col-sm-2 col-form-label" style="text-align: right;">Tél pro</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_pro" id="Employee_tel_pro" placeholder="Tél pro"
                                       <c:if test="${not empty employee}">
                                    value="${employee.Work_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_adresse" class="col-sm-2 col-form-label" style="text-align: right;">Adresse</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_street" id="Employee_adresse" placeholder="Adresse"
                                       <c:if test="${not empty adress}">
                                    value="${adress.Rue}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[\w0-9]([\w0-9]| [\w0-9]|-[\w0-9])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_ville" class="col-sm-2 col-form-label" style="text-align: right;">Ville</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_ville" id="Employee_ville" placeholder="Ville"
                                       <c:if test="${not empty adress}">
                                    value="${adress.Ville}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[\w]([\w]| [\w]|-[\w])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            
                            <div class="col-sm-1"></div>
                            <label for="Employee_code_postal" class="col-sm-2 col-form-label" style="text-align: right;">Code postal</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="Employee_code_postal" id="Employee_code_postal" placeholder="Code postal"
                                       <c:if test="${not empty adress}">
                                    value="${adress.CodePostal}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[0-9]{5}">
                            </div>
                            
                            <label for="Employee_email" class="col-sm-2 col-form-label" style="text-align: right;">Adresse e-mail</label>
                            
                            <div class="col-sm-3">
                                <input type="email" class="form-control" name="Employee_email" id="Employee_email" placeholder="Adresse e-mail"
                                       <c:if test="${not empty employee}">
                                    value="${employee.Email}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required>
                            </div>
                        </div>
                        
                        <c:if test="${not empty employee}">
                        <input type="hidden" id="empID" name="empID" value="${employee.Id}">
                        </c:if>
                            
                        <c:if test="${not empty adress}">
                        <input type="hidden" id="addID" name="addID" value="${address.Id}">
                        </c:if>
                            
                        <hr/>
                        
                        <c:if test="${role == 'admin'}">
                        <div class="col-sm-11">
                            <div class="float-right">
                                <input type="submit" class="btn btn-primary" value="Save">
                                <a class="btn btn-danger" href="employees">Cancel</a>
                             </div>
                         </div>   
                        </c:if>
                        
                    </form>
                    
                </div>
            </div>
        </div>
<%@include file="../includes/template_bot.jsp" %>
