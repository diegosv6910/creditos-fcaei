<%@page import="vistas.Eventos"%>
<%@page import="DAO.EventosDAO"%>
<%@ include file="WEB-INF/header.jsp" %>  

<%

    EventosDAO dao = new EventosDAO();
    int ID_E = Integer.parseInt((String)request.getAttribute("ID_Evento"));
    Eventos eve = (Eventos)dao.listar(ID_E);
    
    
%>




    <form action="agregarUsuario" style="position: absolute; top: 6.25rem; right: 35rem; width: 18rem">
        <div class="form-group">
        <input type="hidden" name="ID_Evento" class="form-control" placeholder="ID Evento" value="<%= eve.getID_Evento() %>">
        <input type="number" name="ID_Institucion" class="form-control" placeholder="ID Institucion" value="<%= eve.getID_Institucion() %>">
        <input type="text" name="Nombre_Evento" class="form-control" placeholder="Nombre del Evento" value="<%= eve.getNombre_Evento() %>">
        <input type="text" name="Fecha_Inicio" class="form-control" placeholder="Fecha Inicio" value="<%= eve.getFecha_Inicio()  %>">
        <input type="text" name="Fecha_Fin" class="form-control" placeholder="Fecha Final" value="<%= eve.getFecha_Final() %>">
        <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
        </div>
        <a href="agregarUsuario?accion=lista"></a>
    </form>




<%@ include file="WEB-INF/footer.jsp" %> 
