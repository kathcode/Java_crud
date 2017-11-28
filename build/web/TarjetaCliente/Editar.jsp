<%-- 
    Document   : Editar
    Created on : Nov 19, 2017, 11:02:05 AM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelTipoTarjeta"%>
<%@page import="java.util.List"%>
<%@page import="Model.ModelTarjetaXCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar tarjeta de cliente</title>
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
                        <h1>Editar tarjeta de cliente</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            
                            <% 
                                String error = (String) request.getAttribute("errorMessage"); 
                                ModelTarjetaXCliente model = (ModelTarjetaXCliente) request.getAttribute("model");
                            %>
                            
                            <% 
                                if(error != null){ 
                                    out.print("<div class='alert alert-danger' role='alert'>"+ error +"</div>"); 
                                }
                            %>


                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>


                            <form action="${pageContext.request.contextPath}/TarjetaXCliente"  method="post">


                                <div class="form-group">
                                    <label for="formUsuario">Identificación del cliente*</label>
                                    
                                    <% 
                                        out.print("<input type='text' class='form-control' id='IdClient' name='IdClient' placeholder='Identificación'>");                                   
                                    %>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label for="formUsuario">Tipo tarjeta*</label>
                                    
                                    <jsp:include page="../TipoTarjeta?opcion=listarTipoTarjeta" />

                                        <%
                                            List<ModelTipoTarjeta> listTipo = (List<ModelTipoTarjeta>) request.getAttribute("listTipoTarjeta");
                                            for (ModelTipoTarjeta tipo : listTipo) {
                                                
                                                if(tipo.getCodigo_TipoTarjeta() == model.getCodigo_TipoTarjeta()){
                                                    out.print("<input type='text' class='form-control' id='' name='' placeholder='Tipo tarjeta'>"); 
                                                    out.print("<input type='text' class='form-control' id='TipoTarjeta' name=''TipoTarjeta value='" + tipo.getCodigo_TipoTarjeta() + "'>"); 
                                                }
                                              
                                            }

                                        %>            
                                </div>

                                
                                <div class="form-group">
                                    <label for="formUsuario">Cupo de la tarjeta*</label>
                                    
                                    <% 
                                        out.print("<input type='text' class='form-control' id='CTarjeta' name='CTarjeta' value='" + String.format("%.0f", model.getCupo_TarjetaXCliente()) + "' placeholder='Cupo de la tarjeta'>");
                                    %>

                                </div>


                                <div id="text-error" class="text-error"></div>

                                <div class="ctn-btn-form">
                                    <a href="Lista.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" name="create" class="btn btn-primary">Asignar tarjeta</button>
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
