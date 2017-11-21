<%-- 
    Document   : Crear
    Created on : 7/11/2017, 06:55:54 PM
    Author     : Asus
--%>
<%@page import="Model.ModelTipoTarjeta"%>
<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Tarjeta</title>
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1>Crear Tarjeta</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
        
                            
                            <% 
                                ModelTipoTarjeta model = (ModelTipoTarjeta) request.getAttribute("newTarjeta");
                                String error = (String) request.getAttribute("errorMessage"); 
                                if(error != null){ 
                                    out.print("<div class='alert alert-danger' role='alert'>"+ error +"</div>"); 
                                }
                            %>
                            
                            
                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>
                            
                            <form action="${pageContext.request.contextPath}/TipoTarjeta" onsubmit="return validationTypeT()" method="post">
                                
                                
                                <div class="form-group">
                                    <jsp:include page="../Franquicia?opcion=listarFranquicia" />
                                    <label for="formUsuario">Código Franquicia*</label>
                                    <select class="form-control" id="Codigo_Franquicia" name="Codigo_Franquicia" >
                                        <option value="">Seleccionar</option>

                                        <%
                                            List<ModelFranquicias> listFran = (List<ModelFranquicias>) request.getAttribute("listarFranquicia");
                                            for (ModelFranquicias fran : listFran) {
                                                out.println("<option value='" + fran.getCodigo_Franquicia() + "' >" + fran.getNombre_Franquicia() + "</option>");
                                            }

                                        %>            
                                    </select>
                                </div> 
                                
                                <div class="form-group">
                                    <label for="formTarjeta">Código tarjeta</label>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='number' class='form-control' id='Codigo_TipoTarjeta' name='Codigo_TipoTarjeta' value='" + model.getCodigo_TipoTarjeta()+ "' placeholder='Código Tarjeta'>");
                                        }else{
                                            out.print("<input type='number' class='form-control' id='Codigo_TipoTarjeta' name='Codigo_TipoTarjeta' placeholder='Código Tarjeta'>");
                                        }
                                    
                                    %>
                                    
                    
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Nombre tarjeta</label>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='Nombre_TipoTarjeta' name='Nombre_TipoTarjeta' value='" + model.getNombre_TipoTarjeta()+ "' placeholder='Nombre Tarjeta'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='Nombre_TipoTarjeta' name='Nombre_TipoTarjeta' placeholder='Nombre Tarjeta'>");
                                        }
                                    
                                    %>
                                    

                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Acronimo tarjeta</label>

                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='Acronimo_TipoTarjeta' name='Acronimo_TipoTarjeta' value='" + model.getAcronimo_TipoTarjeta()+ "' placeholder='Acronimo Tarjeta'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='Acronimo_TipoTarjeta' name='Acronimo_TipoTarjeta' placeholder='Acronimo Tarjeta'>");
                                        }
                                    
                                    %>
                                
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Interes tarjeta</label>
                 
                                    <% 
                                        if(model != null){
                                            out.print("<input type='number' class='form-control' id='Interes_TipoTarjeta' name='Interes_TipoTarjeta' value='" + model.getInteres_TipoTarjeta()+ "' placeholder='Interes tarjeta' step='0.01' min='0.01' max='0.1'>");
                                        }else{
                                            out.print("<input type='number' class='form-control' id='Interes_TipoTarjeta' name='Interes_TipoTarjeta' placeholder='Interes tarjeta' step='0.01' min='0.01' max='0.1'>");
                                        }
                                    
                                    %>
                                
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Plazo máximo tarjeta</label>

                                    <% 
                                        if(model != null){
                                            out.print("<input type='number' class='form-control' id='PlazoMax_TipoTarjeta' name='PlazoMax_TipoTarjeta' value='" + model.getPlazoMax_TipoTarjeta()+ "' placeholder='Plazo máximo Tarjeta' onkeypress='return isNumberKey(event)' min='1' max='60'>");
                                        }else{
                                            out.print("<input type='number' class='form-control' id='PlazoMax_TipoTarjeta' name='PlazoMax_TipoTarjeta' placeholder='Plazo máximo Tarjeta' onkeypress='return isNumberKey(event)' min='1' max='60'>");
                                        }
                                    
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Cupo máxmo tarjeta</label>
                                    
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='number' class='form-control' id='CupoMax_TipoTarjeta' name='CupoMax_TipoTarjeta' value='" + model.getCupoMax_TipoTarjeta() + "' placeholder='Cupo máximo tarjeta' onkeypress='return isNumberKey(event)' min='100000' max='9999999999'>");
                                        }else{
                                            out.print("<input type='number' class='form-control' id='CupoMax_TipoTarjeta' name='CupoMax_TipoTarjeta' placeholder='Cupo máximo tarjeta' onkeypress='return isNumberKey(event)' min='100000' max='9999999999'>");
                                        }
                                    
                                    %>
                                    
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta" >Multa por mora Tarjeta</label>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='number' class='form-control' id='Multa_TipoTarjeta' name='Multa_TipoTarjeta' value='" + model.getMulta_TipoTarjeta()+ "' placeholder='Multa por Mora' onkeypress='return isNumberKey(event)' min='100' max='10000000'>");
                                        }else{
                                            out.print("<input type='number' class='form-control' id='Multa_TipoTarjeta' name='Multa_TipoTarjeta' placeholder='Multa por Mora' onkeypress='return isNumberKey(event)' min='100' max='10000000'>");
                                        }
                                    
                                    %>
                                </div>

                                <div id="text-error" class="text-error"></div>
                                <div class="ctn-btn-form">
                                    <a href="${pageContext.request.contextPath}/Tarjeta/Lista.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" id="CrearTarjeta" name="create" class="btn btn-primary">Crear Tarjeta</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <script src="${pageContext.request.contextPath}/Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="${pageContext.request.contextPath}/Js/custom.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/Js/validaciones.js" type="text/javascript"></script>

</html>
