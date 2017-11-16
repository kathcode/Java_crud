<%-- 
    Document   : Ver.jsp
    Created on : Oct 8, 2017, 10:56:00 PM
    Author     : esneiderserna
--%>

<%@page import="Model.ModelUsuario"%>
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
                        <h1>Info usuario</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            
                        <div class="ver-info">
                            <% ModelUsuario user = (ModelUsuario) request.getAttribute("oldUser"); %>

                            <div>
                                <span>Nombre: </span>
                                <% out.print(user.getNombre_Usuario() + " " + user.getApellidos_Usuario() ); %>  
                            </div>
                            <div>
                                <span>Identificación: </span>
                                <% out.print(user.getId_Usuario()); %>  
                            </div>
                            <div> 
                                <span>Correo electrónico: </span>
                                <% out.print(user.getEmail_Usuario()); %>  
                            </div>
                            <div> 
                                <span>Nombre Teléfono: </span>
                                <% out.print(user.getTelefono_Usuario()); %>  
                            </div>
                            <div> 
                                <span>Dirección: </span>
                                <% out.print(user.getDireccion_Usuario()); %>  
                            </div>
                            <div> 
                                <span>Usuario: </span>
                                <% out.print(user.getNombre_Usuario()); %>  
                            </div>
                            <div> 
                                <span>genero: </span>
                                <% out.print(user.getGenero_Usuario()); %>  
                            </div>
                        </div>
                        
                        <br/>
                        
                        <div class="ctn-btn-form">
                            <a href="Usuario/Lista.jsp" class="btn btn-primary">Regresar</a>
                        </div>
                                
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
