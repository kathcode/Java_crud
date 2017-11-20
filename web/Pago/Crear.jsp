<%@page import="java.util.List"%>
<%@page import="Model.ModelPago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagos</title>
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>

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
                            
                            <%
                                String error = (String) request.getAttribute("errorMessage");
                                if (error != null) {
                                    out.print("<div class='alert alert-danger' role='alert'>" + error + "</div>");
                                }
                            %>
                            
                            <form action="${pageContext.request.contextPath}/Pago?opcion=buscarPago" onsubmit="return validacionBuscarPago()" method="post">
                                    
                                <div class="text-required">
                                    Los campos marcados con * son obligatorios
                                </div>
                                    
                                    <div class="form-group">
                                        <label for="formUsuario">Número de tarjeta*</label>
                                        
                                        <% 
                                            String num = (String) request.getAttribute("numero_tarjeta");
                                            if(num != null){
                                                out.print("<input type='text' class='form-control' id='numero_tarjeta' name='numero_tarjeta' placeholder='Número de tarjeta' value='"+ num +"' onkeypress='return isNumberKey(event)'>");
                                            }else{
                                                out.print("<input type='text' class='form-control' id='numero_tarjeta' name='numero_tarjeta' placeholder='Número de tarjeta' onkeypress='return isNumberKey(event)'>");
                                            }
                                        %>

                                    
                                    </div>
                                
                                    <div id="text-error" class="text-error"></div>
                                    
                                    <div class="ctn-btn-form">
                                        <button class="btn btn-primary" type="submit" name="search">Buscar tarjeta a pagar</button>
                                    </div>
                                </form>
                            
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
    <script src="${pageContext.request.contextPath}/Js/validaciones.js" type="text/javascript"></script>
</html>
