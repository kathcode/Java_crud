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
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/login.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        
        <% String error = (String) request.getAttribute("errorMessage"); %>

        <div class="col-xs-12 col-sm-6 col-sm-offset-3 col-lg-4 col-lg-offset-4 box-login">

            <div class="logo-login">
                <a href="index.html" class="site_title"><i class="fa fa-bold"></i> <span>BATO</span></a>
            </div>

            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="title-login">
                        <h1>Bienvenido</h1>
                        <span>Ingresa usuario y contraseña para continuar</span>
                    </div>

                    <div class="col-xs-12 col-sm-10 col-sm-offset-1">

                        <form action="Login" onsubmit="return validacionLogin()" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Usuario*</label>
                                <input class="form-control" type="text" name="usuario" id="usuario" /> 
                                <span id="text-errorUser" class="text-error">Ingrese un nombre de usuario.</span>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Contraseña*</label>
                                <input class="form-control" type="password" name="password" id="password" />
                                <span id="text-errorPass" class="text-error">Ingrese una contraseña.</span>
                            </div>
                            
                            <% 
                                if(error != null){ 
                                    out.print("<div class='alert alert-danger' role='alert'>"+ error +"</div>"); 
                                }
                            %>

                            <div class="form-group ctn-btn-login">
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                            </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>


    </body>

    <script src="${pageContext.request.contextPath}/Js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>    
    <script src="${pageContext.request.contextPath}/Js/validaciones.js" type="text/javascript"></script>

</html>