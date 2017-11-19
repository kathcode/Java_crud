<%-- 
    Document   : Listar
    Created on : Oct 17, 2017, 7:04:42 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelPago"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
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
                        <h1>Lista de pagos</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../Usuario" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="IdUsuario" placeholder="Compra">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <a href="Crear.jsp" class="btn btn-primary pull-right">Crear pago</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Id pago</th>;
                                        <th>Fecha de pago</th>
                                        <th>Valor saldo</th>
                                        <th>Abono capital</th>
                                        <th>Valor interes</th>
                                        <th>Valor cuota</th>
                                        <th>Nuevo saldo</th>
                                        <th>Estado de pago</th>
                                        <th>Id de compra</th>
                                        <th>Fecha de pago realizado</th>
                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <jsp:include page="../Pago?opcion=listarPagos" />


                                    <%
                                        List<ModelPago> listShoppings = (List<ModelPago>) request.getAttribute("listPays");
                                        for (ModelPago p : listShoppings) {
                                            out.println("<tr>");
                                            out.println("<td>" + p.getId_Pago() + "</td>");
                                            out.print("<td>" + p.getFecha_de_Pago() + "</td>");
                                            out.print("<td>" + p.getValor_Saldo() + "</td>");
                                            out.print("<td>" + p.getAbono_Capital() + "</td>");
                                            out.print("<td>" + p.getValor_Interes() + "</td>");
                                            out.print("<td>" + p.getValor_Cuota() + "</td>");
                                            out.print("<td>" + p.getNuevo_Saldo() + "</td>");
                                            out.print("<td>" + p.isEstado_Pago() + "</td>");
                                            out.print("<td>" + p.getId_Compra() + "</td>");
                                            out.print("<td>" + p.getFecha_Realizado() + "</td>");
                                            out.println("<td><a href= 'Pago?opcion=pagoCuota&idCompra=" + p.getId_Pago()  + "'> <span class='glyphicon glyphicon-credit-card' aria-hidden='true'></span> Pagar cuota </a>   </td>");
                                            out.println("<td><a href= 'Pago?opcion=pagoTotal&idCompra=" + p.getId_Pago()  + "'> <span class='glyphicon glyphicon-credit-card' aria-hidden='true'></span> Pago total </a>   </td>");
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