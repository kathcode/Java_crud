<%@page import="java.util.List"%>
<%@page import="Model.ModelPago"%>
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
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Id pago</th>
                                        <th>Fecha de pago</th>
                                        <th>Valor saldo</th>
                                        <th>Abono capital</th>
                                        <th>Valor interes</th>                                        
                                        <th>Valor Mora</th>
                                        <th>Valor cuota</th>
                                        <th>Nuevo saldo</th>
                                        
                                    </tr> 
                                </thead> 
                                <tbody> 


                                    <%
                                        List<ModelPago> listCuotas = (List<ModelPago>) request.getAttribute("listCuotas");
                                        
                                        
                                        if(listCuotas.size() > 0){
                                            
                                            for (ModelPago cuota : listCuotas) {
                                            
                                                out.println("<tr>");
                                                out.println("<td>" + cuota.getId_Pago()+ "</td>");
                                                out.print("<td>" + cuota.getFecha_de_Pago() + "</td>");
                                                out.print("<td>" + cuota.getValor_Saldo() + "</td>");
                                                out.print("<td>" + cuota.getAbono_Capital() + "</td>");
                                                out.print("<td>" + cuota.getValor_Interes() + "</td>");
                                                out.print("<td>" + cuota.getMulta_Mora() + "</td>");
                                                out.print("<td>" + cuota.getValor_Cuota()+ "</td>");
                                                out.print("<td>" + cuota.getNuevo_Saldo() + "</td>");
                                                out.println("</tr>");

                                            }
                                        
                                        }else{
                                            out.println("<tr><td colspan ='8'> <div class='text-no-pagos'>¡No tienes pagos pendientes a esta compra!</div>  </td></tr>");
                                        }
                                        
                                        
                                        
                                        
                                    %>

                                </tbody> 
                            </table>
                                    
                            <div class="pago-total">

                                <% 
                                    if(listCuotas.size() > 0){
                                    
                                        double pagoTotal = 0;

                                        for (ModelPago cuota : listCuotas) {
                                            pagoTotal += cuota.getValor_Cuota();
                                        }
                                        
                                        out.print("<span> Pago total: " + pagoTotal + "</span>");
                                    }
                                %>
                            </div>
                            
                            
                        </div>
                    </div>            
                                
                    <div class="ctn-btn-form">
                        <a href="Pago/Crear.jsp" class="btn btn-default">Cancelar</a>
                        <%
                            if(listCuotas.size() > 0){
                                boolean isTotal = false;
                            
                                if(listCuotas.size() > 1){
                                    isTotal = true;
                                }
                            
                                out.println("<a href= 'Pago?opcion=realizarPago&idPago=" + listCuotas.get(0).getId_Pago() + "&pagoTotal=" + isTotal + "' class='btn btn-primary'>Pagar cuota</a>");
                            }
                        %>
                    </div>
                                    
                </div>

            </div>
        </div>
    </body>


    <script src="Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="Js/custom.min.js" type="text/javascript"></script>


</html>
