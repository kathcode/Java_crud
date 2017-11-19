<%-- 
    Document   : Editar
    Created on : 7/11/2017, 08:45:03 PM
    Author     : Asus
--%>

<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page import="Model.ModelTipoTarjeta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tipo Tarjeta</title>
        <link href="Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="Css/main.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1>Editar Tipo Tarjeta</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            <form action="TipoTarjeta" method="post">

                                <% ModelTipoTarjeta Tarjeta = (ModelTipoTarjeta) request.getAttribute("oldTarjeta"); %>

                                <div class="form-group">
                                    
                                    <div class="form-group">
                                        <label for="formTarjeta">Tipo Tarjeta*</label>                           
                                        <%
                                            out.println("<input type='text' class='form-control' id='' name='' value='" + Tarjeta.getAcronimo_Franquicia() + "' placeholder=''readonly >");
                                        %>
                                        
                                        <%
                                            out.println("<input type='hidden' class='form-control' id='Codigo_Franquicia' name='Codigo_Franquicia' value='" + Tarjeta.getCodigo_Franquicia()+ "' placeholder='Codigo Tipo Tarjeta'readonly >");
                                        %>
                                    </div>
                         
                                </div>

                                <div class="form-group">
                                    <label for="formTarjeta">Codigo Tarjeta</label>                           
                                    <%
                                        out.println("<input type='number' class='form-control' id='Codigo_TipoTarjeta' name='Codigo_TipoTarjeta' value='" + Tarjeta.getCodigo_TipoTarjeta() + "' placeholder='Codigo Tipo Tarjeta'readonly >");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Nombre Tarjeta</label>                           
                                    <%
                                        out.println("<input type='text' class='form-control' id='Nombre_TipoTarjeta' name='Nombre_TipoTarjeta' value='" + Tarjeta.getNombre_TipoTarjeta() + "' placeholder='Nombre Tipo Tarjeta'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Acronimo Tarjeta</label>                           
                                    <%
                                        out.println("<input type='text' class='form-control' id='Acronimo_TipoTarjeta' name='Acronimo_TipoTarjeta' value='" + Tarjeta.getAcronimo_TipoTarjeta() + "' placeholder='Acronimo Tipo Tarjeta'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Interes Tarjeta</label>                           
                                    <%
                                        out.println("<input type='number' class='form-control' id='Interes_TipoTarjeta' name='Interes_TipoTarjeta' value='" + Tarjeta.getInteres_TipoTarjeta() + "' placeholder='Interes Tipo Tarjeta'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Plazo maximo</label>                           
                                    <%
                                        out.println("<input type='number' class='form-control' id='PlazoMax_TipoTarjeta' name='PlazoMax_TipoTarjeta' value='" + Tarjeta.getPlazoMax_TipoTarjeta() + "' placeholder='Plazo Maximo TipoTarjeta'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Cupo tarjeta</label>                           
                                    <%
                                        out.println("<input type='number' class='form-control' id='CupoMax_TipoTarjeta' name='CupoMax_TipoTarjeta' value='" + String.format("%.0f", Tarjeta.getCupoMax_TipoTarjeta()) + "' placeholder='Cupo Maximo Tipo Tarjeta'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formTarjeta">Multa Tarjeta</label>                           
                                    <%
                                        out.println("<input type='number' class='form-control' id='Multa_TipoTarjeta' name='Multa_TipoTarjeta' value='" + Tarjeta.getMulta_TipoTarjeta() + "' placeholder='Multa Tipo Tarjeta'>");
                                    %>
                                </div>

                                <a href="Tarjeta/Lista.jsp" class="btn btn-default">Cancelar</a>
                                <button type="submit" name="update" class="btn btn-primary">Guardar Tarjeta</button>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>


    <script src="Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="Js/custom.min.js" type="text/javascript"></script>


</html>
