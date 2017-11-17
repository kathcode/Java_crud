<%@page import="java.util.List"%>
<%@page import="Model.ModelFranquicias"%>
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
                        <h1>Lista de franquicias</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form action="../Franquicia" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="IdFranquicia" placeholder="Id Franquicia">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" name="search">Buscar</button>
                                        </span>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <a href="crearFranquicia.jsp" class="btn btn-primary pull-right">Crear nueva franquicia</a>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-hover"> 
                                <thead> 
                                    <tr> 
                                        <th>Código de franquicia</th> 
                                        <th>Nombre</th> 
                                        <th>Acrónimo</th> 
                                        <th>Rango Máximo</th> 
                                        <th>Rango Mínimo</th>
                                        <th>Fecha creación</th>
                                        <th>Acciones</th>
                                    </tr> 
                                </thead> 
                                <tbody> 
                
                                    <jsp:include page="../Franquicia?opcion=listarFranquicia"/>

                                    <%
                                        // Se recupera la variable de session listaUsuario
                                        List<ModelFranquicias> listaFranquicias = (List<ModelFranquicias>) request.getAttribute("listarFranquicia");
                                        for (ModelFranquicias u : listaFranquicias) {
                                            out.println("<tr>");
                                            out.println("<td>" + u.getCodigo_Franquicia()+ "</td>");
                                            out.println("<td>" + u.getNombre_Franquicia() + "</td>");
                                            out.println("<td>" + u.getAcronimo_Franquicia() + "</td>");
                                            out.println("<td>" + u.getRangoPingMax_Franquicia() + "</td>");
                                            out.println("<td>" + u.getRangoPingMin_Franquicia() + "</td>");
                                            out.println("<td>" + u.getFecha_Creacion() + "</td>");
                                            out.println("<td><a href= '../Franquicia?opcion=editarFranquicia&idfranquicia=" + u.getCodigo_Franquicia()+ "'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> Editar </a> "
                                                    + "<a href= '../Franquicia?opcion=verFranquicia&idfranquicia=" + u.getCodigo_Franquicia() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span> Ver </a>"
                                                    + "<a href= '../Franquicia?opcion=eliminarFranquicia&idfranquicia=" + u.getCodigo_Franquicia() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span> Eliminar </a></td>");
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