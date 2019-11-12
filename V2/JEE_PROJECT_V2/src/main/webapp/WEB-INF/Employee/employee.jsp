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
                            <label for="<%=Constants.FORM_EMPLOYEE_LAST_NAME%>" class="col-sm-2 col-form-label" style="text-align: right;">Nom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_LAST_NAME%>" id="<%=Constants.FORM_EMPLOYEE_LAST_NAME%>" placeholder="Nom" 
                                       <c:if test="${not empty employee}">
                                    value="${employee.last_name}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_FIRST_NAME%>" class="col-sm-2 col-form-label" style="text-align: right;">Prénom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_FIRST_NAME%>" id="<%=Constants.FORM_EMPLOYEE_FIRST_NAME%>" placeholder="Prénom"
                                       <c:if test="${not empty employee}">
                                    value="${employee.first_name}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    requiredrequired pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_HOME_PHO%>" class="col-sm-2 col-form-label" style="text-align: right;">Tél dom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_HOME_PHO%>" id="<%=Constants.FORM_EMPLOYEE_HOME_PHO%>" placeholder="Tél dom"
                                       <c:if test="${not empty employee}">
                                    value="${employee.home_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_MOB_PHO%>" class="col-sm-2 col-form-label" style="text-align: right;">Tél mob</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_MOB_PHO%>" id="<%=Constants.FORM_EMPLOYEE_MOB_PHO%>" placeholder="Tél mob"
                                       <c:if test="${not empty employee}">
                                    value="${employee.cell_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_PRO_PHO%>" class="col-sm-2 col-form-label" style="text-align: right;">Tél pro</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_PRO_PHO%>" id="<%=Constants.FORM_EMPLOYEE_PRO_PHO%>" placeholder="Tél pro"
                                       <c:if test="${not empty employee}">
                                    value="${employee.work_phone}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_STREET%>" class="col-sm-2 col-form-label" style="text-align: right;">Adresse</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_STREET%>" id="<%=Constants.FORM_EMPLOYEE_STREET%>" placeholder="Adresse"
                                       <c:if test="${not empty adress}">
                                    value="${adress.rue}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[\w0-9]([\w0-9]| [\w0-9]|-[\w0-9])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_CITY%>" class="col-sm-2 col-form-label" style="text-align: right;">Ville</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_CITY%>" id="<%=Constants.FORM_EMPLOYEE_CITY%>" placeholder="Ville"
                                       <c:if test="${not empty adress}">
                                    value="${adress.ville}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[\w]([\w]| [\w]|-[\w])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            
                            <div class="col-sm-1"></div>
                            <label for="<%=Constants.FORM_EMPLOYEE_POSTAL%>" class="col-sm-2 col-form-label" style="text-align: right;">Code postal</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="<%=Constants.FORM_EMPLOYEE_POSTAL%>" id="<%=Constants.FORM_EMPLOYEE_POSTAL%>" placeholder="Code postal"
                                       <c:if test="${not empty adress}">
                                    value="${adress.codePostal}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required pattern="[0-9]{5}">
                            </div>
                            
                            <label for="<%=Constants.FORM_EMPLOYEE_EMAIL%>" class="col-sm-2 col-form-label" style="text-align: right;">Adresse e-mail</label>
                            
                            <div class="col-sm-3">
                                <input type="email" class="form-control" name="<%=Constants.FORM_EMPLOYEE_EMAIL%>" id="<%=Constants.FORM_EMPLOYEE_EMAIL%>" placeholder="Adresse e-mail"
                                       <c:if test="${not empty employee}">
                                    value="${employee.email}"
                                       </c:if>
                                       <c:if test="${role != 'admin'}">
                                    disabled
                                       </c:if>
                                    required>
                            </div>
                        </div>
                        
                        <c:if test="${not empty employee}">
                        <input type="hidden" id="<%=Constants.FORM_EMPLOYEE_ID%>" name="<%=Constants.FORM_EMPLOYEE_ID%>" value="${employee.id}">
                        </c:if>
                            
                        <c:if test="${not empty adress}">
                        <input type="hidden" id="<%=Constants.FORM_EMPLOYEE_AID%>" name="<%=Constants.FORM_EMPLOYEE_AID%>" value="${adress.id}">
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
