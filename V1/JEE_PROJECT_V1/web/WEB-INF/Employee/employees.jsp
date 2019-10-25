<%-- 
    Document   : employees
    Created on : 15 oct. 2019, 11:23:24
    Author     : Eddy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fr.efrei.jeeproject.Employee"%>
<% String JSP_TEMPLATE_TITLE = "Employee list"; %>
<% boolean JSP_TEMPLATE_SECURITY = false; %>

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
                            <%
                              
                                ArrayList<Employee> employees = (ArrayList<Employee>)request.getAttribute("employees");
                                for(Employee employee : employees){
                                    out.println("                            <tr>");
                                    out.println("                                <td scope=\"row\"><input type=\"radio\" name=\"radio_employees_v1\" form=\"employee\" value=\"" + employee.getId() + "\"></td>");
                                    out.println("                                <td>" + employee.getLast_name() + "</td>");
                                    out.println("                                <td>" + employee.getFirst_name()+ "</td>");
                                    out.println("                                <td>" + employee.getHome_phone()+ "</td>");
                                    out.println("                                <td>" + employee.getCell_phone()+ "</td>");
                                    out.println("                                <td>" + employee.getWork_phone()+ "</td>");
                                    out.println("                                <td>" + employee.getAdresses().get(0).getRue() + "</td>");
                                    out.println("                                <td>" + employee.getAdresses().get(0).getVille() + "</td>");
                                    out.println("                                <td>" + employee.getAdresses().get(0).getCodePostal() + "</td>");
                                    out.println("                                <td>" + employee.getEmail()+ "</td>");
                                    out.println("                            </tr>");
                                }

                            %>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="row">
                <div class="col">
                    
                    <hr/>
                    
                    <div>
                        
                        <form class="d-inline" action="employee" id="employee">
                            <input type="radio" name="radio_employees_v1" hidden required>
                            <input type="submit" class="btn btn-primary" name="button" value="Delete">
                            <input type="submit" class="btn btn-primary" name="button" value="Details">
                        </form>

                        <a class="btn btn-primary" href="employee">Add</a>
                        
                    </div>
                    
                    <hr/>
                    
                </div>
            </div>
            
            <iframe width="100%" height="400px" src="https://www.watchisup.fr/compte-a-rebours/embed/frozen-2-2019-11-20-10-30?backgroundcolor=&color=" frameborder="0" allowfullscreen></iframe>
            
        </div>
<%@include file="../includes/template_bot.jsp" %>
