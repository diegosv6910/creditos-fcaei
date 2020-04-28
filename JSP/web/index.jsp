<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

    <form id="login">
        <div class="form-group">
            <label for="exampleInputEmail1">Usuario</label>
            <input type="text" class="form-control" placeholder="Usuario">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Contraseña</label>
            <input type="password" class="form-control" placeholder="Contraseña">
        </div>
        <button type="submit" class="btn btn-primary">Ingresar</button>
        <button type="submit" class="btn btn-primary">Olvide Mis Datos</button>
    </form>

<%@ include file="WEB-INF/footer.jsp" %> 