<%-- 
    Document   : SideBar
    Created on : Oct 11, 2017, 10:20:16 PM
    Author     : esneiderserna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-bold"></i> <span>BATO</span></a>
        </div>

        <div class="clearfix"></div>

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-user"></i>Usuario<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/PPI-Proyecto-Bato/Usuario/Crear.jsp">Nuevo usuario</a></li>
                            <li><a href="/PPI-Proyecto-Bato/Usuario/Lista.jsp">Lista clientes</a></li>
                        </ul>
                    </li>
                    
                    <li><a><i class="fa fa-credit-card-alt"></i>Tarjetas clientes<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">Nuevo cliente</a></li>
                            <li><a href="index2.html">Lista clientes</a></li>
                        </ul>
                    </li>
                    
                    <li><a><i class="fa fa-shopping-bag"></i>Compras<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">Nuevo compra</a></li>
                            <li><a href="index2.html">Lista compras</a></li>                            
                            <li><a href="index2.html">Generar proyección</a></li>

                        </ul>
                    </li>
                    
                    <li><a><i class="fa fa-money"></i>Pagos<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">Nuevo pago</a></li>
                            <li><a href="index2.html">Lista pagos</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
            <div class="menu_section">
                <h3>Administrador</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-building"></i> Franquicias <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/PPI-Proyecto-Bato/Franquicia/crearFranquicia.jsp">Nueva franquicia</a></li>
                            <li><a href="/PPI-Proyecto-Bato/Franquicia/listarFranquicia.jsp">Lista franquicias</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-credit-card-alt"></i>Tipo tarjeta <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">Nuevo tipo tarjeta</a></li>
                            <li><a href="index2.html">Lista tipo tarjetas</a></li>
                        </ul>
                    </li>
                    
                    <!--
                    <li><a><i class="fa fa-sitemap"></i> Usuarios <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">Nuevo Usuario</a></li>
                            <li><a href="index2.html">Lista Usuarios</a></li>
                        </ul>
                    </li>  
                    -->                

                </ul>
            </div>

        </div>
        <!-- /sidebar menu -->

    </div>
</div>

