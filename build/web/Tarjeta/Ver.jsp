<%-- 
    Document   : newjspVer
    Created on : 7/11/2017, 08:45:43 PM
    Author     : Asus
--%>

<%@page import="Model.ModelTipoTarjeta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Tarjetas</title>
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
                        <h1>Info Tarjeta</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">


                            <div class="ver-info">
                                <% ModelTipoTarjeta tarjeta = (ModelTipoTarjeta) request.getAttribute("oldTarjeta"); %>
                                <div>
                                    <span>codigo tipo tarjeta </span>
                                    <% out.print(tarjeta.getCodigo_TipoTarjeta());%>  
                                </div>
                                <div>
                                    <span>Nombre tarjeta </span>
                                    <% out.print(tarjeta.getNombre_TipoTarjeta());%>  
                                </div>
                                <div>
                                    <span>Acronimo tarjeta </span>
                                    <% out.print(tarjeta.getAcronimo_TipoTarjeta()); %>  
                                </div>
                                <div> 
                                    <span>interes tarjeta </span>
                                    <% out.print(tarjeta.getInteres_TipoTarjeta()); %>  
                                </div>
                                <div> 
                                    <span>Plazo Maximo Tarjeta </span>
                                    <% out.print(tarjeta.getPlazoMax_TipoTarjeta()); %>  
                                </div>
                                <div> 
                                    <span>Cupo Maximo Tarjeta: </span>
                                    <% out.print(tarjeta.getCupoMax_TipoTarjeta()); %>  
                                </div>
                                <div> 
                                    <span>Multa Tarjeta: </span>
                                    <% out.print(tarjeta.getMulta_TipoTarjeta()); %>  
                                </div>
                                <div> 
                                    <span>Codigo Franquicia: </span>
                                    <% out.print(tarjeta.getCodigo_Franquicia());%>  
                                </div>
                              
                            </div>

                            <br/>
                            <a href="Usuario/Lista.jsp" class="btn btn-primary">Regresar</a>

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
