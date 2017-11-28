<%-- 
    Document   : Crear
    Created on : Oct 17, 2017, 7:04:30 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Compra</title>
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
                        <h1>Crear usuario</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            
                            <% 
                                String error = (String) request.getAttribute("errorMessage"); 
                                String idCliente = (String) request.getAttribute("idCliente");
                                ModelCompra modelCompra = (ModelCompra) request.getAttribute("modelCompra");
                            %>
                            
                            
                            <% 
                                if(error != null){ 
                                    out.print("<div class='alert alert-danger' role='alert'>"+ error +"</div>"); 
                                }
                            %>
                            
                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>
                            
                            
                            <form action="${pageContext.request.contextPath}/Compra" onsubmit="return validacionCompra()" method="post">
                                
                                
                                <div class="form-group">
                                    <label for="formUsuario">Identificación del cliente*</label>
                                    
                                    <% 
                                        if(idCliente != null){
                                            out.print("<input type='text' class='form-control' id='IdClient' name='IdClient' value='" + idCliente + "' placeholder='Identificación'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='IdClient' name='IdClient' placeholder='Identificación'>");
                                        }
                                    
                                    %>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label for="formUsuario">Número Tarjeta*</label>
                                    
                                    <% 
                                        if(idCliente != null){
                                            out.print("<input type='text' class='form-control' id='NoTarjeta' name='NoTarjeta' onkeypress='return isNumberKey(event)' value='" + modelCompra.getNumero_TarjetaXCliente() + "' placeholder='Número Tarjeta'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='NoTarjeta' name='NoTarjeta' placeholder='Número Tarjeta' onkeypress='return isNumberKey(event)'>");
                                        }
                                    
                                    %>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label for="formUsuario">Descripción compra*</label>
                                    
                                    <% 
                                        if(idCliente != null){
                                            out.print("<input type='text' class='form-control' id='Descripcion' name='Descripcion' value='" + modelCompra.getDescripcion_Compra()+ "' placeholder='Descripción'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='Descripcion' name='Descripcion' placeholder='Descripción'>");
                                        }
                                    
                                    %>

                                </div>
                                
                                
                                <div class="form-group">
                                    <label for="formUsuario">Valor de la compra*</label>
                                    
                                    <% 
                                        if(idCliente != null){
                                            out.print("<input type='text' class='form-control' id='VCompra' name='VCompra' onkeypress='return isNumberKey(event)' value='" + modelCompra.getDeudaActual_Compra() + "' placeholder='Valor compra'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='VCompra' name='VCompra' onkeypress='return isNumberKey(event)' placeholder='Valor compra'>");
                                        }
                                    
                                    %>
            
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Número de cuotas*</label>
                                    
                                    <% 
                                        if(idCliente != null){
                                            out.print("<input type='text' class='form-control' id='NCuotas' name='NCuotas' onkeypress='return isNumberKey(event)' value='" + modelCompra.getNumeroCuotas_Compra() + "' placeholder='Número Cuotas'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='NCuotas' name='NCuotas' onkeypress='return isNumberKey(event)' placeholder='Número Cuotas'>");
                                        }
                                    
                                    %>

                                </div>
                                    
                                    
                                <div id="text-error" class="text-error"></div>
                                
                                <div class="ctn-btn-form">
                                    <a href="Listar.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" name="create" class="btn btn-primary">Crear compra</button>
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
