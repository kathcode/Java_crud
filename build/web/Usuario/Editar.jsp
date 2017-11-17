<%-- 
    Document   : Editar.jsp
    Created on : Oct 8, 2017, 10:55:42 PM
    Author     : esneiderserna
--%>


<%@page import="Model.ModelTipousuario"%>
<%@page import="java.util.List"%>
<%@page import="Model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
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
                        <h1>Editar usuario</h1>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">

                            <form action="Usuario" method="post">

                                <% ModelUsuario user = (ModelUsuario) request.getAttribute("oldUser"); %>

                                <div class="form-group">
                                    <jsp:include page="../TipoUsuario?opcion=listarTipoUsuarios" />
                                    <label for="formUsuario">Tipo usuario</label>
                                    <select class="form-control" id="TipoUsuario" name="TipoUsuario" >
                                        <option>Seleccionar</option>
                                        <% 
                                            
                                            List<ModelTipousuario> listTU = (List<ModelTipousuario>) request.getAttribute("ListTypeUser");
                                            for(ModelTipousuario tUsuario : listTU)
                                            {
                                                if(tUsuario.getId_TipoUsuario() != user.getId_TipoUsuario())
                                                {
                                                    out.println("<option value='" + tUsuario.getId_TipoUsuario() + "' >" + tUsuario.getNombre_TipoUsuario() + "</option>");
                                                }
                                                else
                                                {
                                                    out.println("<option value='" + tUsuario.getId_TipoUsuario() + "' selected >" + tUsuario.getNombre_TipoUsuario() + "</option>");
                                                }
                                            }
                                        
                                        %>            
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="formUsuario">Identificación</label>                           
                                    <%
                                        out.println("<input type='text' class='form-control' id='Identificacion' name='Identificacion' value='" + user.getId_Usuario() + "' placeholder='Identificación'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Nombre</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='Nombre' name='Nombre' value='" + user.getNombre_Usuario() + "' placeholder='Nombre'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Apellidos</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='Apellidos' name='Apellidos' value='" + user.getApellidos_Usuario() + "' placeholder='Apellidos'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Teléfono</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='Telefono' name='Telefono' value='" + user.getTelefono_Usuario() + "' placeholder='Telefono'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Dirección</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='Direccion' name='Direccion' value='" + user.getDireccion_Usuario() + "' placeholder='Direccion'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Email</label>
                                    <%
                                        out.println("<input type='email' class='form-control' id='Email' name='Email' value='" + user.getEmail_Usuario() + "' placeholder='Email'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Genero</label>
                                    <select class='form-control' id='Genero' name='Genero' >

                                        <option>Seleccionar</option>
                                        <option value="Femenino" <%= (user.getGenero_Usuario().equals("Femenino")) ? "selected" : ""%> >Femenino</option>
                                        <option value="Masculino" <%= (user.getGenero_Usuario().equals("Masculino")) ? "selected" : ""%> >Masculino</option>
                                        <option value="Otro" <%= (user.getGenero_Usuario().equals("Otro")) ? "selected" : ""%> >Otro</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario" >Nombre de usuario</label>
                                    <%
                                        out.println("<input type='text' class='form-control' id='Usuario' name='Usuario' value='" + user.getUsuario_Usuario() + "' placeholder='Usuario'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Password</label>
                                    <%
                                        out.println("<input type='password' class='form-control' id='Password' name='Password' value='" + user.getPassword_Usuario() + "' placeholder='Password'>");
                                    %>
                                </div>
                                <div class="form-group">
                                    <label for="formUsuario">Password</label>
                                    <%
                                        out.println("<input type='password' class='form-control' id='CPassword' name='CPassword' value='" + user.getPassword_Usuario() + "' placeholder='CPassword'>");
                                    %>
                                </div>

                                <a href="Usuario/Lista.jsp" class="btn btn-default">Cancelar</a>
                                <button type="submit" name="update" class="btn btn-primary">Guardar usuario</button>
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
