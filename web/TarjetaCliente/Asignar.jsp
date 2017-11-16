<%-- 
    Document   : AsignarTarjeta
    Created on : 15/11/2017, 01:34:32 PM
    Author     : esneider.serna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignar tarjeta</title>
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
                        <h1>Asignar tarjeta</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            
                          
                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>
                            
                            
                            <form action="${pageContext.request.contextPath}/TarjetaXCliente"  method="post">
                                
                                
                                
                                    
                                    
                                <div id="text-error" class="text-error"></div>
                                
                                <div class="ctn-btn-form">
                                    <a href="Lista.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" name="create" class="btn btn-primary">Asignar tarjeta</button>
                                </div>
                            </form>
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