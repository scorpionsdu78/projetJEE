<%-- 
    Document   : employee
    Created on : 21 oct. 2019, 16:43:20
    Author     : Eddy
--%>

<%@page import="fr.efrei.jeeproject.Adress"%>
<%@page import="fr.efrei.jeeproject.Employee"%>
<% String JSP_TEMPLATE_TITLE = "Employee"; %>
<% boolean JSP_TEMPLATE_SECURITY = true; %>

<%@include file="../includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">
                <div class="col">
                    
                    <h1>Details of employee :</h1>
                    
                    <hr/>
                    
                    <%
                        Employee emp = null;
                        Adress add = null;
                        
                        
                        if(request.getAttribute("employee") != null)
                        {
                            emp = (Employee)request.getAttribute("employee");
                            
                            if(emp != null && !emp.getAdresses().isEmpty())
                            {
                                add = emp.getAdresses().get(0);
                            }
                        }
                    %>
                    
                    <%
                        if(emp == null)
                        {
                            out.print(" <form action=\"Controller_POST_Employee\" method=\"POST\">");
                        }
                        else
                        {
                            out.print( "<form action=\"Controller_Employee_put\" method=\"POST\">");
                        }
                        
                    
                     %>  
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_nom" class="col-sm-2 col-form-label" style="text-align: right;">Nom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_nom" id="Employee_nom" placeholder="Nom" <%
                                    
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getLast_name() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }

                                %> required pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_prenom" class="col-sm-2 col-form-label" style="text-align: right;">Prénom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_prenom" placeholder="Prénom"<%
                                    
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getFirst_name() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="\w(\w| \w)*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_dom" class="col-sm-2 col-form-label" style="text-align: right;">Tél dom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_dom" id="Employee_tel_dom" placeholder="Tél dom"<%
                                    
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getHome_phone() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_mob" class="col-sm-2 col-form-label" style="text-align: right;">Tél mob</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_mob" id="Employee_tel_mob" placeholder="Tél mob"<%
                                    
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getCell_phone() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_tel_pro" class="col-sm-2 col-form-label" style="text-align: right;">Tél pro</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_tel_pro" id="Employee_tel_pro" placeholder="Tél pro"<%
                                    
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getWork_phone() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="(0[0-9]( [0-9]{2}){4}|\+[0-9]{2} [0-9]( [0-9]{2}){4})">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_adresse" class="col-sm-2 col-form-label" style="text-align: right;">Adresse</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_street" id="Employee_adresse" placeholder="Adresse"<%
                                    
                                    if(add!=null){
                                        out.print(" value=\"" + add.getRue() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="[\w0-9]([\w0-9]| [\w0-9]|-[\w0-9])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <div class="col-sm-1"></div>
                            <label for="Employee_ville" class="col-sm-2 col-form-label" style="text-align: right;">Ville</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_ville" id="Employee_ville" placeholder="Ville"<%
                                    
                                    if(add!=null){
                                        out.print(" value=\"" + add.getVille() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="[\w]([\w]| [\w]|-[\w])*">
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            
                            <div class="col-sm-1"></div>
                            <label for="Employee_code_postal" class="col-sm-2 col-form-label" style="text-align: right;">Code postal</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="Employee_code_postal" id="Employee_code_postal" placeholder="Code postal" <%
                                    
                                    if(add!=null){
                                        out.print(" value=\"" + add.getCodePostal() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required pattern="[0-9]{5}">
                            </div>
                            
                            <label for="Employee_email" class="col-sm-2 col-form-label" style="text-align: right;">Adresse e-mail</label>
                            
                            <div class="col-sm-3">
                                <input type="email" class="form-control" name="Employee_email" id="Employee_email" placeholder="Adresse e-mail"<%
                                
                                    if(emp!=null){
                                        out.print(" value=\"" + emp.getEmail() + "\"");
                                    }

                                    if(session.getAttribute("role") != null && !session.getAttribute("role").equals( "admin")){
                                        out.print(" disabled");
                                    }
                                    
                                %> required>
                            </div>
                        </div>
                        
                        <%if(emp!=null){
                            out.print("<input type=\"hidden\" id=\"empID\" name=\"empID\" value="+emp.getId()+">" );
                        }%> 
                        
                        <%if(add!=null){
                            out.print("<input type=\"hidden\" id=\"addID\" name=\"addID\" value="+add.getId()+">" );
                        }%> 
                            
                        <hr/>
                        <%
                            
                            // If the user is an ADMIN, he can access the BUTTONS
                            if( session.getAttribute("role") != null && session.getAttribute("role").equals( "admin") )
                            {
                                out.println("<div class=\"col-sm-11\">");
                                out.println("   <div class=\"float-right\">");
                                out.println("       <input type=\"submit\" class=\"btn btn-primary\" value=\"Save\">");
                                out.println("       <a class=\"btn btn-danger\" href=\"employees\">Cancel</a>");
                                out.println("   </div>");
                                out.println("</div>");
                            }
                        %>
                        
                    </form>
                    
                </div>
            </div>
        </div>
<%@include file="../includes/template_bot.jsp" %>
