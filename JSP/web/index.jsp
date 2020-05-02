<%@page session="true"%>
<%@page import="vistas.LoginOperaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

    <form id="login" action="servletLogin" method="POST">
        <div class="form-group">
            <label for="exampleInputEmail1">Usuario</label>
            <input type="text" name="txtUser" class="form-control" placeholder="Usuario">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Contraseña</label>
            <input type="password" name="txtContra" class="form-control" placeholder="Contraseña">
        </div>
        <button type="submit" name="btnIngresar" class="btn btn-primary">Ingresar</button>
        <button type="submit" name="btnOlvide" class="btn btn-primary">Olvide Mis Datos</button>
    </form>

<%@ include file="WEB-INF/footer.jsp" %> 