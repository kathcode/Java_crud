<%@page import="Model.ModelgetDuesPaid"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de pagos realizados</title>
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
                        <h1>Lista de pagos realizados</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Id de pago</th> 
                                        <th>Fecha de pago</th> 
                                        <th>Id de compra</th> 
                                        <th>Valor cuota</th> 
                                        <th>Fecha de pago realizado</th>
                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <jsp:include page="../Compra?opcion=listPays" />


                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        List<ModelgetDuesPaid> listPays = (List<ModelgetDuesPaid>) request.getAttribute("listShoppings");
                                        for (ModelgetDuesPaid c : listPays) {
                                            out.println("<tr>");
                                            out.println("<td>" + c.getId_pago() + "</td>");
                                            out.println("<td>" + c.getFecha_pago() + "</td>");
                                            out.println("<td>" + c.getId_compra() + "</td>");
                                            out.println("<td>" + c.getValor_cuota() + "</td>");
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