<%-- 
    Document   : Listar
    Created on : 7/11/2017, 08:45:14 PM
    Author     : Asus
--%>

<%@page import="Model.ModelTipoTarjeta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de tarjetas</title>
        <link href="../Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/custom.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Css/main.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1>Lista de Tarjetas</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../TipoTarjeta" method="post">
                                    <div class="input-group">
                                        <input type="number" class="form-control" name="Codigo_TipoTarjeta"  id="Codigo_TipoTarjeta2" placeholder="Codigo Tipo Tarjeta">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit"  id="search" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <a href="Crear.jsp" class="btn btn-primary pull-right">Crear nueva tarjeta</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Código tarjeta</th> 
                                        <th>Nombre tarjeta</th> 
                                        <th>Acronimo tarjeta</th> 
                                        <th>Interes tarjeta</th>                                         
                                        <th>Cupo tarjeta</th>                                        
                                        <th>Acrónimo Franquicia</th>
                                        <th>Acciones</th>    

                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <jsp:include page="../TipoTarjeta?opcion=listarTipoTarjeta" />


                                    <%
                                        // Se recupera la variable de session ListaTarjeta
                                        List<ModelTipoTarjeta> listaTarjeta = (List<ModelTipoTarjeta>) request.getAttribute("listTipoTarjeta");
                                        for (ModelTipoTarjeta u : listaTarjeta) {
                                            out.println("<tr>");
                                            out.println("<td>" + u.getCodigo_TipoTarjeta() + "</td>");
                                            out.println("<td>" + u.getNombre_TipoTarjeta() + "</td>");
                                            out.println("<td>" + u.getAcronimo_TipoTarjeta() + "</td>");
                                            out.println("<td>" + u.getInteres_TipoTarjeta() + "</td>");
                                            out.println("<td>" + String.format("%.0f", u.getCupoMax_TipoTarjeta()) + "</td>");
                                            out.println("<td>" + u.getAcronimo_Franquicia() + "</td>");
                                            out.println("<td><a href= '../TipoTarjeta?opcion=info&Codigo_TipoTarjeta=" + u.getCodigo_TipoTarjeta() + "'> <span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span> Ver </a> "
                                                    + "<a href= '../TipoTarjeta?opcion=edit&Codigo_TipoTarjeta=" + u.getCodigo_TipoTarjeta() + "'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> Editar </a> "
                                                    + "<a href= '../TipoTarjeta?opcion=delete&Codigo_TipoTarjeta=" + u.getCodigo_TipoTarjeta() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span> Eliminar </a></td>");
                                            out.println("</tr>");
                                        }
                                    %>

                                </tbody> 
                            </table>
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
