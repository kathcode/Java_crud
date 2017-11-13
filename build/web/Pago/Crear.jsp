<%@page import="java.util.List"%>
<%@page import="Model.ModelPago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagos</title>
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
                        <h1>Realizar pago</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../Pago?opcion=buscarPago" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="numero_tarjeta" placeholder="Numero de tarjeta">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar tarjeta a pagar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>
                        </div>
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
