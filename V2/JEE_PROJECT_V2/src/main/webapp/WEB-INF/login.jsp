<%-- 
    Document   : login
    Created on : 15 oct. 2019, 10:04:51
    Author     : Eddy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="fr.efrei.dbcontroller.DBaction"%>

<c:set var="JSP_TEMPLATE_TITLE" value="Login" scope="page" />
<c:set var="JSP_TEMPLATE_SECURITY" value="false" scope="page" />
<%@include file="includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
     
            <div class="row">
                
                <div class="col-lg-5 col-md-8 col-sm-12" style="margin: auto;">
                                
                    <%-- Displaying the Error Message if there is one --%>
                    <c:if test="${not empty errKey}">
                    <div style="color:red; text-align: center">
                        <label>
                            <small>
                                ${errKey}
                            </small>
                        </label>
                    </div>
                    </c:if>     
            
                    <div class="card">
                        <div class="card-header">
                            Login
                        </div>
                        <div class="card-body">

                            <form action="login" method="post">
                              <div class="form-group">
                                  <input type="text" class="form-control" name="<%=Constants.FORM_LOGIN_USERNAME%>" placeholder="Login" required>
                              </div>
                              <div class="form-group">
                                  <input type="password" class="form-control" name="<%=Constants.FORM_LOGIN_PASSWORD%>" placeholder="Password" required>
                              </div>
                              <button type="submit" class="btn btn-primary">Login</button>
                            </form>

                        </div>            
                    </div>
            
                </div>
            </div>
        </div>
<%@include file="includes/template_bot.jsp" %>