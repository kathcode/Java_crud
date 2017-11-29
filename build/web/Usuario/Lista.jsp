<%-- 
    Document   : Lista
    Created on : 11/10/2017, 02:25:08 PM
    Author     : esneider.serna
--%>

<%@page import="Model.ModelUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
        <link href="../Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/custom.min.css" rel="stylesheet" type="text/css"/>        
        <link href="../Css/main.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1 id="listado_clientes">Lista de clientes</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../Usuario" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="IdUsuario" placeholder="Id Usuario">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <a href="Crear.jsp" class="btn btn-primary pull-right">Crear nuevo usuario</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Identificación</th> 
                                        <th>Nombre completo</th> 
                                        <th>Teléfono</th> 
                                        <th>Correo eléctronico</th> 
                                        <th>Usuario</th>                                         
                                        <th>Tipo usuario</th> 
                                        <th>Acciones</th>    

                                    </tr> 
                                </thead> 
                                <tbody> 

                                    <jsp:include page="../Usuario?opcion=listarUsuarios" />


                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        List<ModelUsuario> listaUsuario = (List<ModelUsuario>) request.getAttribute("listUsers");
                                        for (ModelUsuario u : listaUsuario) {
                                            out.println("<tr>");
                                            out.println("<td>" + u.getId_Usuario() + "</td>");
                                            out.println("<td>" + u.getNombre_Usuario() + " " + u.getApellidos_Usuario() + "</td>");
                                            out.println("<td>" + u.getTelefono_Usuario() + "</td>");
                                            out.println("<td>" + u.getEmail_Usuario() + "</td>");
                                            out.println("<td>" + u.getUsuario_Usuario() + "</td>");
                                            out.println("<td>" + u.getNombre_TipoUsuario()+ "</td>");
                                            out.println("<td><a href= '../Usuario?opcion=info&idUsuario=" + u.getId_Usuario() + "'> <span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span> Ver </a> "
                                                    + "<a href= '../Usuario?opcion=edit&idUsuario=" + u.getId_Usuario() + "'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> Editar </a> "
                                                    + "<a href= '../Usuario?opcion=delete&idUsuario=" + u.getId_Usuario() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span> Eliminar </a></td>");
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

<script src="../Js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="../Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
<script src="../Js/custom.min.js" type="text/javascript"></script>


</html>
