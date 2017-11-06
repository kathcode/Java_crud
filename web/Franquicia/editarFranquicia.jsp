<%@page import="java.util.List"%>
<%@page import="Model.ModelFranquicias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Franquicia</title>
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
                        <h1>Editar franquicia</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            <form action="../PPI-Proyecto-Bato/Franquicia?opcion=actualizarFranquicias" method="post">
                                <% ModelFranquicias franquicia = (ModelFranquicias) request.getAttribute("oldFranquicia"); %>
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='nombre' name='nombre' value='" + franquicia.getNombre_Franquicia()+ "' placeholder='Identificación'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label>Acronimo</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='acronimo' name='acronimo' value='" + franquicia.getAcronimo_Franquicia()+ "' placeholder='Identificación'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label>Min</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='min' name='min' value='" + franquicia.getRangoPingMin_Franquicia() + "' placeholder='Identificación'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label>Max</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='max' name='max' value='" + franquicia.getRangoPingMax_Franquicia() + "' placeholder='Identificación'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                </div>
                            </form>
                            </form>
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
