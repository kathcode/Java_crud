<%-- 
    Document   : Crear
    Created on : 5/10/2017, 09:12:05 AM
    Author     : esneider.serna
--%>

<%@page import="Model.ModelTipousuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <% String error = (String) request.getAttribute("errorMessage"); %>

                <%@include  file="../Shared/SideBar.jsp" %>
                <%@include  file="../Shared/TopBar.jsp" %>

                <div class="right_col" role="main">

                    <div class="page-header">
                        <h1>Crear usuario</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            <%
                                if (error != null) {
                                    out.print("<div class='alert alert-danger' role='alert'>" + error + "</div>");
                                }
                            %>

                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>

                            <form action="../Usuario" onsubmit="return validacionUsuario()" method="post">

                                <div class="form-group">
                                    <jsp:include page="../TipoUsuario?opcion=listarTipoUsuarios" />
                                    <label for="formUsuario">Tipo usuario*</label>
                                    <select class="form-control" id="TipoUsuario" name="TipoUsuario" >
                                        <option value="">Seleccionar</option>

                                        <%
                                            List<ModelTipousuario> listTU = (List<ModelTipousuario>) request.getAttribute("ListTypeUser");
                                            for (ModelTipousuario tUsuario : listTU) {
                                                out.println("<option value='" + tUsuario.getId_TipoUsuario() + "' >" + tUsuario.getNombre_TipoUsuario() + "</option>");
                                            }

                                        %>            
                                    </select>
                                </div> 

                                <div class="form-group">
                                    <label for="formUsuario">Identificación*</label>
                                    <input type="text" class="form-control" id="Identificacion" name="Identificacion" placeholder="Identificación">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Nombre*</label>
                                    <input type="text" class="form-control" id="Nombre" name="Nombre" placeholder="Nombre">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Apellidos*</label>
                                    <input type="text" class="form-control" id="Apellidos" name="Apellidos" placeholder="Apellidos">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Teléfono*</label>
                                    <input type="text" class="form-control" id="Telefono" name="Telefono" placeholder="Teléfono" onkeypress="return isNumberKey(event)">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Dirección*</label>
                                    <input type="text" class="form-control" id="Direccion" name="Direccion" placeholder="Direccion">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Email*</label>
                                    <input type="text" class="form-control" id="Email" name="Email" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Genero*</label>
                                    <select class="form-control" id="Genero" name="Genero" >
                                        <option value="">Seleccionar</option>
                                        <option value="Femenino">Femenino</option>
                                        <option value="Masculino">Masculino</option>
                                        <option value="Otro">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario" >Nombre de usuario*</label>
                                    <input type="text" class="form-control" id="Usuario" name="Usuario" placeholder="Usuario">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Password*</label>
                                    <input type="password" class="form-control" id="Password" name="Password" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Password*</label>
                                    <input type="password" class="form-control" id="CPassword" name="CPassword" placeholder="Password">
                                </div>

                                <div id="text-error" class="text-error"></div>

                                <div class="ctn-btn-form">
                                    <a href="Lista.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" name="create" class="btn btn-primary">Crear usuario</button>
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
