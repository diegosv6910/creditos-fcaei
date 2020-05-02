<%@page session="true"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="vistas.Eventos"%>
<%@page import="DAO.EventosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

<%

    HttpSession sesion = request.getSession();
    String user;
    String nivel;
    
    if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null){
        user=sesion.getAttribute("usuario").toString();
        nivel=sesion.getAttribute("nivel").toString();
        if(nivel=="1"){
            response.sendRedirect("eventosEstudiantes.jsp");
        }
    }

%>

<form id="tabla_eventos">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID Evento</th>
                <th scope="col">Insitucion</th>
                <th scope="col">Nombre_Evento</th>
                <th scope="col">Fecha Inicial</th>
                <th scope="col">Fecha Final</th>
                <th scope="col">Descripcion Del Evento</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <%
            EventosDAO dao = new EventosDAO();
            List<Eventos>list=dao.listar();
            Iterator<Eventos>iter=list.iterator();
            Eventos eve=null;
            while(iter.hasNext()){
                eve=iter.next();
        %>
        <tbody>
            <tr>
                <td> <%= eve.getID_Evento() %> </td>
                <td> <%= eve.getNom_Inst() %> </td>
                <td> <%= eve.getNombre_Evento() %> </td>
                <td> <%= eve.getFecha_Inicio() %> </td>
                <td> <%= eve.getFecha_Final() %> </td>
                <td> <%= eve.getDescripcion()%> </td>
                <td>
                    <a href="agregarUsuario?accion=editar&ID_Evento=<%= eve.getID_Evento() %>">Editar</a>
                    <a href="agregarUsuario?accion=eliminar&ID_Evento=<%= eve.getID_Evento() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</form>

<form action="agregarUsuario" method="POST" style="position: absolute; top: 6.25rem; right: 15rem; width: 18rem;"
    <div class="form-group">
        <input type="text" name="ID_Institucion" class="form-control" placeholder="ID Institucion">
        <input type="text" name="Nombre_Evento" class="form-control" placeholder="Nombre del Evento">
        <input type="text" name="Fecha_Inicio" class="form-control" placeholder="Fecha Inicio">
        <input type="text" name="Fecha_Fin" class="form-control" placeholder="Fecha Final">
        <input type="text" name="Descripcion" class="form-control" placeholder="Introduce Una Descripcion">
    </div>
    <button type="submit" class="btn btn-primary">Registrar Evento</button>
</form>
<%@ include file="WEB-INF/footer.jsp" %> 