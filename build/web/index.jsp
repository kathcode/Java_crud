<%-- 
    Document   : index
    Created on : 11/10/2017, 02:04:38 PM
    Author     : esneider.serna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="Css/main.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        
        <div class="col-md-6 col-lg-offset-3 box-login">
            
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2>Ingresar</h2>
                    <form action="Login" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Usuario</label>
                            <input class="form-control" type="text" name="usuario" id="usuario" /> 
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Contraseña</label>
                            <input class="form-control" type="password" name="password" id="password" />
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Ingresar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        
        
        <!--
            <div>

                <ul>
                    <li>
                        <span>Usuarios</span>
                        <ul>
                            <li>
                                <a href="Usuario/Crear.jsp">Crear Usuario</a>  
                            </li>
                            <li>
                                <a href="Usuario/Lista.jsp">Lista Usuario</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div> 
        -->

    </body>

    <script src="Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
</html>