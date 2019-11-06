<%-- 
    Document   : employees
    Created on : 15 oct. 2019, 11:23:24
    Author     : Eddy
--%>

<%@page import="fr.efrei.jeeproject.Adress"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.efrei.jeeproject.Employee"%>

<% String JSP_TEMPLATE_TITLE = "Employees list"; %>
<% boolean JSP_TEMPLATE_SECURITY = true; %>

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
                                if(request.getAttribute("employees") != null)
                                {
                                    ArrayList<Employee> employees = (ArrayList<Employee>)request.getAttribute("employees");
                                    for(Employee employee : employees)
                                    {
                                        out.println("                            <tr style=\"cursor: pointer;");
                                        try
                                        {
                                            if(request.getAttribute("highlight_ID").equals(employee.getId()))
                                                out.println(" border-left: 2px solid red; border-right: 2px solid red;");
                                        }
                                        catch(NullPointerException e)
                                        {
                                        }
                                        out.println("\">");

                                        out.println("                                <td scope=\"row\"><input type=\"radio\" name=\"radio_employees_v1\" form=\"employee\" value=\"" + employee.getId() + "\"></td>");
                                        out.println("                                <td>" + employee.getLast_name() + "</td>");
                                        out.println("                                <td>" + employee.getFirst_name()+ "</td>");
                                        out.println("                                <td>" + employee.getHome_phone()+ "</td>");
                                        out.println("                                <td>" + employee.getCell_phone()+ "</td>");
                                        out.println("                                <td>" + employee.getWork_phone()+ "</td>");


                                        if(  !employee.getAdresses().isEmpty() )
                                        {
                                           Adress add = employee.getAdresses().get(0);

                                            out.println("                                <td>" + add.getRue() + "</td>");
                                            out.println("                                <td>" + add.getCodePostal() +  "</td>");
                                            out.println("                                <td>" + add.getVille() +  "</td>");
                                        }
                                        else
                                        {
                                            out.println("                                <td>NA</td>");
                                            out.println("                                <td>NA</td>");
                                            out.println("                                <td>NA</td>");                                      
                                        }

                                        out.println("                                <td>" + employee.getEmail()+ "</td>");
                                        out.println("                            </tr>");
                                    }
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
