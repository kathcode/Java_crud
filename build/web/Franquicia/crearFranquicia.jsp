
<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Franquicia</title>
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
                        <h1>Crear franquicia</h1>
                    </div>
                    
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>
                            <form action="../Franquicia?opcion=crearFranquicia" onsubmit="return validacionFranquicia()" method="post">
                                <div class="form-group">
                                    <label>Nombre*</label>
                                    <input class="form-control" id="nombre" type="text" placeholder="Nombre" name="nombre" id="nombre" /> 
                                </div>
                                <div class="form-group">
                                    <label>Acrónimo*</label>
                                    <input class="form-control" id="acronimo" type="text" placeholder="Acrónimo" name="acronimo" id="acronimo" />
                                </div>
                                <div class="form-group">
                                    <label>Rango de pin Mínimo*</label>
                                    <div class="text-required">
                                        Debe ser de 4 cifras
                                    </div>
                                    <input class="form-control" id="min" type="number" placeholder="Rango mínimo" name="min" id="min" />
                                </div>
                                <div class="form-group">
                                    <label>Rango de pin Máximo*</label>
                                    <div class="text-required">
                                        Debe ser de 4 cifras
                                    </div>
                                    <input class="form-control" id="max" type="number" placeholder="Ranfo máximo" name="max" id="max" />
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Crear</button>
                                </div>
                            </form>
                            <div id="text-error" class="text-error"></div>
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
