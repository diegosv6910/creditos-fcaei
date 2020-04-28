<%@page import="vistas.Evidencias"%>
<%@page import="DAO.EvidenciasDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="vistas.Eventos"%>
<%@page import="DAO.EventosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

<form id="tabla_eventos">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID_EVIDENCIA</th>
                <th scope="col">URL_Evidencia</th>
            </tr>
        </thead>
        <%
            EvidenciasDAO dao = new EvidenciasDAO();
            List<Evidencias>list=dao.listar();
            Iterator<Evidencias>iter=list.iterator();
            Evidencias evi=null;
            while(iter.hasNext()){
                evi=iter.next();
        %>       
        
        <tbody>
           <tr>
                <td> <%= evi.getId_e() %> </td>
                <td> <%= evi.getUrl() %> </td>
                <td>
                    <a href="agregarUsuario?accion=editar&ID_Evento=<%= evi.getId_e() %>">Validar</a>
                    <a href="agregarUsuario?accion=eliminar&ID_Evento=<%= evi.getId_e() %>">Rechazar</a>
                </td>
            </tr>
            <% } %>       
     
        </tbody>
    </table>
</form>

<form action="EvidenciasServlet" method="POST" style="position: absolute; top: 6.25rem; right: 15rem; width: 18rem;"
    <div class="form-group">
        <input type="text" name="URL_EVIDENCIA" class="form-control" placeholder="URL_EVIDENCIA">
    </div>
    <button type="submit" class="btn btn-primary">Registrar Evidencia</button>
</form>
<%@ include file="WEB-INF/footer.jsp" %> 