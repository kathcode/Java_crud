<%@page import="Model.ModelPagoCuota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
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
                        <h1>Realizar pago</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body text-center">
                            <div class="ver-info">
                                <% ModelPagoCuota pago = (ModelPagoCuota) request.getAttribute("pago_cuota"); %>
                                <form action=<% out.print("../Pago?opcion=realizarPago&idPago=" + pago.getId_pago() + "&valor_pago=" + pago.getValor_a_pagar()); %> method="post">
                                    <div> 
                                        <span>Valor a pagar: </span>
                                        <% out.print(pago.getValor_a_pagar()); %>  
                                    </div>
                                    <div>
                                        <button class="btn btn-primary" type="submit" name="pagar">Pagar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>Información de pago

            </div>
        </div>
    </body>


    <script src="Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="Js/custom.min.js" type="text/javascript"></script>


</html>
