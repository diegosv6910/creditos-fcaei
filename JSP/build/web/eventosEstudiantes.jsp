<%@page session="true"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="vistas.Eventos"%>
<%@page import="DAO.EventosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header2.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

<%

    HttpSession sesion = request.getSession();
    String user;
    String nivel;
        
        if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null){
        user=sesion.getAttribute("usuario").toString();
        nivel=sesion.getAttribute("nivel").toString();
        if(nivel!="1"){
            response.sendRedirect("eventos.jsp"); 
        }
        }else{
            response.sendRedirect("index.jsp"); 
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
                <td>
                    <a href="agregarUsuario?accion=evidencia&ID_Evento=<%= eve.getID_Evento() %>">Evidencia</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</form>