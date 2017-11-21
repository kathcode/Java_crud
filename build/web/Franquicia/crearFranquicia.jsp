
<%@page import="Model.ModelFranquicias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Franquicia</title>
        <link href="${pageContext.request.contextPath}/Lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>        
        <link href="${pageContext.request.contextPath}/Lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/custom.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Css/main.css" rel="stylesheet" type="text/css"/>
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
                            
                            <%
                                
                                String error = (String) request.getAttribute("errorMessage");
                                if (error != null) {
                                    out.print("<div class='alert alert-danger' role='alert'>" + error + "</div>");
                                }
                                
                                ModelFranquicias model = (ModelFranquicias) request.getAttribute("franquicia");
                            %>
                            
                            <div class="text-required">
                                Los campos marcados con * son obligatorios
                            </div>
                            <form action="${pageContext.request.contextPath}/Franquicia?opcion=crearFranquicia" onsubmit="return validacionFranquicia()" method="post">
                                <div class="form-group">
                                    <label>Nombre*</label>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='nombre' name='nombre' placeholder='Nombre' value='"+ model.getNombre_Franquicia() +"'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='nombre' name='nombre' placeholder='Nombre'>");
                                        }
                                    %>
                                    
                                
                                </div>
                                <div class="form-group">
                                    <label>Acrónimo*</label>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='acronimo' name='acronimo' placeholder='Nombre' value='"+ model.getAcronimo_Franquicia()+"'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='acronimo' name='acronimo' placeholder='Acrónimo'>");
                                        }
                                    %>

                                </div>
                                <div class="form-group">
                                    <label>Rango de pin Mínimo*</label>
                                    <div class="text-required">
                                        Debe ser de 4 cifras
                                    </div>
                                    
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='min' name='min' placeholder='Rango mínimo' value='"+ model.getRangoPingMin_Franquicia() +"' onkeypress='return isNumberKey(event)'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='min' name='min' placeholder='Rango mínimo' onkeypress='return isNumberKey(event)'>");
                                        }
                                    %>

                                </div>
                                <div class="form-group">
                                    <label>Rango de pin Máximo*</label>
                                    <div class="text-required">
                                        Debe ser de 4 cifras
                                    </div>
                                    
                                    <% 
                                        if(model != null){
                                            out.print("<input type='text' class='form-control' id='max' name='max' placeholder='Ranfo máximo' value='"+ model.getRangoPingMax_Franquicia() +"' onkeypress='return isNumberKey(event)'>");
                                        }else{
                                            out.print("<input type='text' class='form-control' id='max' name='max' placeholder='Ranfo máximo' onkeypress='return isNumberKey(event)'>");
                                        }
                                    %>
                                </div>
                                
                                <div id="text-error" class="text-error"></div>
                                
                                <div class="ctn-btn-form">
                                    <a href="${pageContext.request.contextPath}/Franquicia/listarFranquicia.jsp" class="btn btn-default">Cancelar</a>
                                    <button type="submit" class="btn btn-primary">Crear franquicia</button>
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
