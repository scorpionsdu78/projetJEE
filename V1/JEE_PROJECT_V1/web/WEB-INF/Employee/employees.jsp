<%-- 
    Document   : employees
    Created on : 15 oct. 2019, 11:23:24
    Author     : Eddy
--%>

<% String JSP_TEMPLATE_TITLE = "Employee list"; %>
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
                            <tr>
                                <td scope="row"><input type="radio" name="radio_employees_v1" form="employee" value="1"></td>
                                <td>NAME</td>
                                <td>FIRST NAME</td>
                                <td>HOME PHONE</td>
                                <td>MOBILE PHONE</td>
                                <td>WORK PHONE</td>
                                <td>ADRESS</td>
                                <td>POSTAL CODE</td>
                                <td>CITY</td>
                                <td>EMAIL</td>
                            </tr>
                            <tr>
                                <td scope="row"><input type="radio" name="radio_employees_v1" form="employee" value="2"></td>
                                <td>NAME</td>
                                <td>FIRST NAME</td>
                                <td>HOME PHONE</td>
                                <td>MOBILE PHONE</td>
                                <td>WORK PHONE</td>
                                <td>ADRESS</td>
                                <td>POSTAL CODE</td>
                                <td>CITY</td>
                                <td>EMAIL</td>
                            </tr>
                            <tr>
                                <td scope="row"><input type="radio" name="radio_employees_v1" form="employee" value="3"></td>
                                <td>NAME</td>
                                <td>FIRST NAME</td>
                                <td>HOME PHONE</td>
                                <td>MOBILE PHONE</td>
                                <td>WORK PHONE</td>
                                <td>ADRESS</td>
                                <td>POSTAL CODE</td>
                                <td>CITY</td>
                                <td>EMAIL</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="row">
                <div class="col">
                    
                    <hr/>
                    
                    <div>
                        
                        <form class="d-inline" action="employee_controller.jsp" id="employee">
                            <input type="radio" name="radio_employees_v1" hidden required>
                            <input type="submit" class="btn btn-primary" name="test" value="Delete">
                            <input type="submit" class="btn btn-primary" name="test2" value="Details">
                        </form>

                        <a class="btn btn-primary" href="employee.jsp">Add</a>
                        
                    </div>
                    
                    <hr/>
                    
                </div>
            </div>
        </div>
<%@include file="../includes/template_bot.jsp" %>
