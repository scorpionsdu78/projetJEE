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
                    
                    <table class="table table-striped">
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
                                <td scope="row"><input type="radio" name="radio_employees_v1"></td>
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
                                <td scope="row"><input type="radio" name="radio_employees_v1"></td>
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
                                <td scope="row"><input type="radio" name="radio_employees_v1"></td>
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
                    
                <button type="submit" class="btn btn-primary">Delete</button>
                <button type="submit" class="btn btn-primary">Details</button>
                <button type="submit" class="btn btn-primary">Add</button>
                    
                </div>
            </div>
        </div>
<%@include file="../includes/template_bot.jsp" %>
