<%-- 
    Document   : Proyeccion
    Created on : Oct 17, 2017, 7:04:56 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelListProyeccion"%>
<%@page import="Model.ModelInfoProyeccion"%>
<%@page import="java.util.List"%>
<%@page import="Model.ModelCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Usuario</title>
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
                        <h1>Proyección compra</h1>
                    </div>
                    
                    
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="ver-info">
                            <% 
                                ModelListProyeccion proyec = (ModelListProyeccion) request.getAttribute("proyec"); 
                                ModelCompra compra = (ModelCompra) proyec.getInfoCompra();
                                List<ModelInfoProyeccion> infoProyec = (List<ModelInfoProyeccion>) proyec.getInfoProyeccion();
                            %>
                            
                            
                            <div>
                                <span>Descripción Compra: </span>
                                <% out.print(compra.getDescripcion_Compra()); %>  
                            </div>
                            
                            <div>
                                <span>Fecha compra: </span>
                                <% out.print(compra.getFecha_Compra()); %>  
                            </div>
                            <div>
                                <span>Valor compra: </span>
                                <% out.print(compra.getDeudaInicial_Compra()); %>  
                            </div>
                            <div> 
                                <span>Número de cuotas: </span>
                                <% out.print(compra.getNumeroCuotas_Compra()); %>  
                            </div>
                            <div> 
                                <span>Interes: </span>
                                <% out.print(compra.getInteres_Compra()); %>  
                            </div>
                            <div> 
                                <span>Cuota Mensual: </span>
                                <% out.print(proyec.getCuota_Mensual()); %> 
                            </div>
    
                        </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>No. cuota</th> 
                                        <th>Fecha</th> 
                                        <th>Valor Saldo</th> 
                                        <th>Abono Capital</th> 
                                        <th>Valor Interes</th> 
                                        <th>Valor Cuota</th> 
                                        <th>Nuevo Saldo</th>                                                                             
                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        for (ModelInfoProyeccion c : infoProyec) {
                                            out.println("<tr>");
                                            out.println("<td>" + c.getNumero_Couta() + "</td>");
                                            out.println("<td>" + c.getFecha() + "</td>");
                                            out.println("<td>" + c.getValor_Saldo() + "</td>");
                                            out.println("<td>" + c.getAbono_Capital() + "</td>");
                                            out.println("<td>" + c.getValor_Interes()  + "</td>");
                                            out.println("<td>" + c.getValor_Cuota()  + "</td>");
                                            out.println("<td>" + c.getNuevo_Saldo() + "</td>");
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
    </body>


    <script src="Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="Js/custom.min.js" type="text/javascript"></script>


</html>
