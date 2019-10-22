<%-- 
    Document   : employee
    Created on : 21 oct. 2019, 16:43:20
    Author     : Eddy
--%>

<% String JSP_TEMPLATE_TITLE = "Employee"; %>
<%@include file="../includes/template_top.jsp" %>

        <div class="container" style="padding-top: 4vh">
            <div class="row">
                <div class="col">
                    
                    <h1>Details of employee :</h1>
                    
                    <hr/>
                    
                    <form>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_nom" class="col-sm-2 col-form-label">Nom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_nom" id="Employee_nom" placeholder="Nom">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_prenom" class="col-sm-2 col-form-label">Prénom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_prenom" placeholder="Prénom">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_tel_dom" class="col-sm-2 col-form-label">Tél dom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_tel_dom" placeholder="Tél dom">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_tel_mob" class="col-sm-2 col-form-label">Tél mob</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_tel_mob" placeholder="Tél mob">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_tel_pro" class="col-sm-2 col-form-label">Tél pro</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_tel_pro" placeholder="Tél pro">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_adresse" class="col-sm-2 col-form-label">Adresse</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_adresse" placeholder="Adresse">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_code_postal" class="col-sm-2 col-form-label">Code postal</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_code_postal" placeholder="Code postal">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <label for="Employee_ville" class="col-sm-2 col-form-label">Ville</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="Employee_prenom" id="Employee_ville" placeholder="Ville">
                            </div>
                            <label for="Employee_email" class="col-sm-2 col-form-label">Adresse e-mail</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="Employee_email" id="Employee_ville" placeholder="Adresse e-mail">
                            </div>
                        </div>
                        
                        <hr/>
                    
                    </form>
                    
                </div>
            </div>
        </div>
<%@include file="../includes/template_bot.jsp" %>
