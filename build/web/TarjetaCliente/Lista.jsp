<%-- 
    Document   : ListaTarjetaCliente
    Created on : 15/11/2017, 01:35:25 PM
    Author     : esneider.serna
--%>

<%@page import="Model.ModelTarjetaXCliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista tarjetas por cliente</title>
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1>Lista tarjetas por cliente</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../Usuario" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="IdUsuario" placeholder="Id Usuario">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <a href="Asignar.jsp" class="btn btn-primary pull-right">Asignar nueva tarjeta</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Número tarjeta</th>
                                        <th>Tipo tarjeta</th>
                                        <th>Identificación cliente</th>
                                        <th>Nombre cliente</th> 
                                        <th>Cupo total</th> 
                                        <th>Cupo disponible</th> 
                                        <th>Acciones</th> 

                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <jsp:include page="../TarjetaXCliente?opcion=listarTarjetasCliente" />


                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        List<ModelTarjetaXCliente> listCards = (List<ModelTarjetaXCliente>) request.getAttribute("listCards");
                                        for (ModelTarjetaXCliente c : listCards) {
                                            out.println("<tr>");
                                            out.println("<td>" + c.getNumero_TarjetaXCliente()+ "</td>");
                                            out.println("<td>" + c.getNombre_TipoTarjeta()+ "</td>");
                                            out.println("<td>" + c.getId_Usuario()+ "</td>");
                                            out.println("<td>" + c.getNombre_Cliente() + "</td>");
                                            out.println("<td>" + String.format("%.0f", c.getCupo_TarjetaXCliente()) + "</td>");
                                            out.println("<td>" + String.format("%.0f", c.getCupoDisp_TarjetaXCliente()) + "</td>");
                                            out.println("<td><a href= '../TarjetaXCliente?opcion=info&noTarjeta=" + c.getNumero_TarjetaXCliente() + "'> <span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span> Ver </a> "
                                                    + "<a href= '../TarjetaXCliente?opcion=edit&noTarjeta=" + c.getNumero_TarjetaXCliente()  + "'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> Editar </a>   </td>");
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

<script src="${pageContext.request.contextPath}/Js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
<script src="${pageContext.request.contextPath}/Js/custom.min.js" type="text/javascript"></script>


</html>