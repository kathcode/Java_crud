<%-- 
    Document   : Listar
    Created on : Oct 17, 2017, 7:04:42 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelCompra"%>
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
                        <h1>Lista de compras por tarjeta</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Descripción</th> 
                                        <th>Fecha</th> 
                                        <th>Valor Compra</th> 
                                        <th>Valor Actual</th> 
                                        <th>Interes</th>                                         
                                        <th colspan="2">Pagos</th>
                                    </tr> 
                                </thead> 
                                <tbody> 


                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        
                                        List<ModelCompra> listShoppings = (List<ModelCompra>) request.getAttribute("listShoppings");
                                        
                                        if(listShoppings.size() > 0){
                                        
                                            for (ModelCompra c : listShoppings) {
                                                out.println("<tr>");
                                                out.println("<td>" + c.getDescripcion_Compra() + "</td>");
                                                out.println("<td>" + c.getFecha_Compra() + "</td>");
                                                out.println("<td>" + c.getDeudaInicial_Compra() + "</td>");
                                                out.println("<td>" + c.getDeudaActual_Compra() + "</td>");
                                                out.println("<td>" + c.getInteres_Compra()  + "</td>");
                                                out.println("<td><a href= 'Pago?opcion=pagoCuota&idCompra=" + c.getId_Compra()  + "'> <span class='glyphicon glyphicon-credit-card' aria-hidden='true'></span> Pagar cuota </a>   </td>");
                                                out.println("<td><a href= 'Pago?opcion=pagoTotal&idCompra=" + c.getId_Compra()  + "'> <span class='glyphicon glyphicon-credit-card' aria-hidden='true'></span> Pago total </a>   </td>");
                                                out.println("</tr>");
                                            }
                                       
                                        }else{
                                            out.println("<tr><td colspan ='7'> <div class='text-no-pagos'>¡No tienes compras pendientes con esta tarjeta!</div>  </td></tr>");
                                        }
                                        

                                    %>

                                </tbody> 
                            </table>
                                    
                                    
                            <div class="ctn-btn-form">
                                <a href="${pageContext.request.contextPath}/Pago/Crear.jsp" class="btn btn-default">Regresar</a>
                            </div>
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