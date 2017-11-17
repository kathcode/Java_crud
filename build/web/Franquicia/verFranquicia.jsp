<%@page import="Model.ModelFranquicias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Franquicia</title>
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
                        <h1>Información de la Franquicia</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            
                        <div class="ver-info">
                            <% ModelFranquicias franquicia = (ModelFranquicias) request.getAttribute("oldFranquicia"); %>
                            <div> 
                                <span>Código de franquicia: </span>
                                <% out.print(franquicia.getCodigo_Franquicia()); %>  
                            </div>
                            <div> 
                                <span>Nombre: </span>
                                <% out.print(franquicia.getNombre_Franquicia()); %>  
                            </div>
                            
                            <div> 
                                <span>Acrónimo: </span>
                                <% out.print(franquicia.getAcronimo_Franquicia()); %>  
                            </div>
                            
                            <div> 
                                <span>Rango Mínimo: </span>
                                <% out.print(franquicia.getRangoPingMin_Franquicia()); %>  
                            </div>
                            
                            <div> 
                                <span>Rango máximo: </span>
                                <% out.print(franquicia.getRangoPingMax_Franquicia()); %>  
                            </div>
                            
                            <div> 
                                <span>Fecha de creación: </span>
                                <% out.print(franquicia.getFecha_Creacion()); %>  
                            </div>
                        </div>
                        
                        <br/>
                        <a href="Franquicia/listarFranquicia.jsp" class="btn btn-primary">Regresar</a>
                                
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
