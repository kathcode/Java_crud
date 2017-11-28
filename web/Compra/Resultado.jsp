<%-- 
    Document   : Resultado
    Created on : Nov 28, 2017, 1:38:21 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelCompra"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de compras por usuario</title>
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
                        <h1>Compras por usuario</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-sm-12">
                                <label>Buscar compras de un cliente</label>
                            </div>
                            <div class="col-lg-6">
                                <form action="${pageContext.request.contextPath}/Compra" method="post">
                                    <div class="input-group">
                                        
                                        <input type="text" class="form-control" name="IdUsuario" placeholder="Cédula cliente">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6 pull-right">
                                <a href="Crear.jsp" class="btn btn-primary pull-right">Crear compra</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr>
                                        <th>Id cliente</th>
                                        <th>Nombre cliente</th>
                                        <th>Descripción</th> 
                                        <th>Fecha</th> 
                                        <th>Valor Compra</th> 
                                        <th>Valor Actual</th> 
                                        <th>Interes</th>                                         
                                        <th>Acciones</th>
                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        List<ModelCompra> listShoppings = (List<ModelCompra>) request.getAttribute("listShoppings");
                                        for (ModelCompra c : listShoppings) {
                                            out.println("<tr>");
                                            out.println("<td>" + c.getId_Usuario()+ "</td>");
                                            out.println("<td>" + c.getNombre_Cliente() + "</td>");
                                            out.println("<td>" + c.getDescripcion_Compra() + "</td>");
                                            out.println("<td>" + c.getFecha_Compra() + "</td>");
                                            out.println("<td>" + c.getDeudaInicial_Compra() + "</td>");
                                            out.println("<td>" + c.getDeudaActual_Compra() + "</td>");
                                            out.println("<td>" + c.getInteres_Compra()  + "</td>");
                                            out.println("<td><a href= 'Compra?opcion=proyeccion&idCompra=" + c.getId_Compra()  + "'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> Proyección </a>   </td>");
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
