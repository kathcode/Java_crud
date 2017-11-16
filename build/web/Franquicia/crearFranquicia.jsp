
<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Franquicia</title>
        <link href="../Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/main.css" rel="stylesheet" type="text/css"/>
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
                            <form action="../Franquicia?opcion=crearFranquicia" method="post">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input class="form-control" type="text" name="nombre" id="nombre" /> 
                                </div>
                                <div class="form-group">
                                    <label>Acronimo</label>
                                    <input class="form-control" type="text" name="acronimo" id="acronimo" />
                                </div>
                                <div class="form-group">
                                    <label>Min</label>
                                    <input class="form-control" type="number" name="min" id="min" />
                                </div>
                                <div class="form-group">
                                    <label>Max</label>
                                    <input class="form-control" type="number" name="max" id="max" />
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Crear</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
