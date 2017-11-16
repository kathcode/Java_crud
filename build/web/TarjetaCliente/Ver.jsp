<%-- 
    Document   : Ver
    Created on : Nov 16, 2017, 12:04:48 AM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelTarjetaXCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información tarjeta cliente</title>
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
                        <h1>Información tarjeta cliente</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            
                        <div class="ver-info">
                            <% ModelTarjetaXCliente txc = (ModelTarjetaXCliente) request.getAttribute("oldModel"); %>

                            
                            <div>
                                <span>Número tarjeta </span>
                                <% out.print(txc.getNumero_TarjetaXCliente()); %>  
                            </div>
                            <div> 
                                <span>Tipo tarjeta: </span>
                                <% out.print(txc.getNombre_TipoTarjeta()); %>  
                            </div>
                            <div>
                                <span>Identificación cliente: </span>
                                <% out.print(txc.getId_Usuario()); %>  
                            </div>
                            <div>
                                <span>Nombre cliente: </span>
                                <% out.print(txc.getNombre_Cliente()); %>  
                            </div>

                            <div> 
                                <span>Cupo total: </span>
                                <% out.print(String.format("%.0f", txc.getCupo_TarjetaXCliente())); %>  
                            </div>
                            <div> 
                                <span>Cupo disponible: </span>
                                <% out.print(String.format("%.0f", txc.getCupoDisp_TarjetaXCliente())); %>  
                            </div>
                            <div> 
                                <span>Interes tarjeta: </span>
                                <% out.print(txc.getInteres_TipoTarjeta()); %> 
                            </div>
                            <div> 
                                <span>Fecha de asignación: </span>
                                <% out.print(txc.getFecha_Creacion()); %>  
                            </div>
                            
                        </div>
                        
                        <br/>
                        
                        <div class="ctn-btn-form">
                            <a href="TarjetaCliente/Lista.jsp" class="btn btn-primary">Regresar</a>
                        </div>
                                
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
