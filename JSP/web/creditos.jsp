<%@page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="vistas.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="vistas.Creditos"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CreditosDAO"%>
<%@ include file="WEB-INF/header2.jsp" %>  
<link rel="stylesheet" type="text/css" href="css/styles.css"/>

<form id="tabla_eventos" style="width: 30rem">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID Credito</th>
                <th scope="col">Matricula</th>
                <th scope="col">ID_Evento</th>
                <th scope="col">ID_Log_Evidencia</th>
                <th scope="col">Tipo_Evento</th>
            </tr>
        </thead>
        <%
            CreditosDAO dao = new CreditosDAO();
            Creditos cred = new Creditos();
            List<Creditos> list = dao.listar_creditos(cred);
            Iterator<Creditos> iter = list.iterator();
            Creditos cre = null;
            while (iter.hasNext()) {
                cre = iter.next();
        %>
        <tbody>
            <tr>
                <td> <%= cre.getID_Creditos()%> </td>
                <td> <%= cre.getMatricula()%> </td>
                <td> <%= cre.getID_Evento()%> </td>
                <td> <%= cre.getID_Log_Evidencia()%> </td>
                <td> <%= cre.getTipo_Credito()%> </td>
                
                <form>
                </form>   
                <% } %>
    </tr>
        </tbody>
    </table>
</form>
<form id="Enviar" action="buscarCreditos" method="POST" style="position: absolute; top: 6.2rem; right: 15rem; width: 10rem;">
    <div class="form-group">
        <input type="text" name="Matricula" class="form-control" placeholder="Matricula">
    </div>
    <button type="submit" class="btn btn-primary">Buscar Mis Creditos</button>
</form>

<%@ include file="WEB-INF/footer.jsp" %> 