<%-- 
    Document   : Crear
    Created on : 7/11/2017, 06:55:54 PM
    Author     : Asus
--%>
<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Tarjeta</title>
        <link href="../Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/main.css" rel="stylesheet" type="text/css"/>
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
                            <form action="../TipoTarjeta" method="post">
                                
                                
                                <div class="form-group">
                                    <jsp:include page="../Franquicia?opcion=listarFranquicia" />
                                    <label for="formUsuario">Codigo Franquicia*</label>
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
                                    <input type="number" class="form-control" id="Codigo_TipoTarjeta" name="Codigo_TipoTarjeta" placeholder="Codigo Tarjeta">
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Nombre tarjeta</label>
                                    <input type="text" class="form-control" id="Nombre_TipoTarjeta" name="Nombre_TipoTarjeta" placeholder="Nombre Tarjeta">
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Acronimo tarjeta</label>
                                    <input type="text" class="form-control" id="Acronimo_TipoTarjeta" name="Acronimo_TipoTarjeta" placeholder="Acronimo Tarjeta">
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Interes tarjeta</label>
                                    <input type="number" class="form-control" id="Interes_TipoTarjeta" name="Interes_TipoTarjeta" placeholder="Interes tarjeta" step="0.01" min="0.05" max="0.1">
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Plazo maximo tarjeta</label>
                                    <input type="number" class="form-control" id="PlazoMax_TipoTarjeta" name="PlazoMax_TipoTarjeta" placeholder="Plazo maximo Tarjeta" min="1" max="60">
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Cupo maximo tarjeta</label>
                                    <input type="number" class="form-control" id="CupoMax_TipoTarjeta" name="CupoMax_TipoTarjeta" placeholder="Cupo maximo tarjeta" min="100000" max="9999999999" >
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta" >Multa por mora Tarjeta</label>
                                    <input type="number" class="form-control" id="Multa_TipoTarjeta" name="Multa_TipoTarjeta" placeholder="Multa por Mora" min="100" max="10000000">
                                </div>

                                

                                <a href="Lista.jsp" class="btn btn-default">Cancelar</a>
                                <button type="submit" id="CrearTarjeta" name="create" class="btn btn-primary">Crear Tarjeta</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <script src="../Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="../Js/custom.min.js" type="text/javascript"></script>

</html>
