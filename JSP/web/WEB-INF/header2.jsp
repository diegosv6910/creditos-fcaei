<%@page import="java.io.PrintWriter"%>
<%@page session="true"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    HttpSession sesion1 = request.getSession();
        String user1;
        String nivel1=null;
        
        if(sesion1.getAttribute("usuario")!=null && sesion1.getAttribute("nivel")!=null){
        user1=sesion1.getAttribute("usuario").toString();
        nivel1=sesion1.getAttribute("nivel").toString();
        }else{
            user1="invitado";
        }

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MODULO CREDITOS</title>
    <link rel="stylesheet" href="https://bootswatch.com/4/yeti/bootstrap.min.css">

</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="index.jsp">Creditos FCAEI.</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
  
            <li class="nav-item">
                <%
                    if(nivel1=="1"){
                        out.print("<a class='nav-link' href='eventosEstudiantes.jsp'>Eventos.</a>");
                    }else if(nivel1!="1"){
                        out.print("<a class='nav-link' href='eventos.jsp'>Eventos.</a>");
                    }
                
                %>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="creditos.jsp">Creditos.</a> 
            </li>
            <li class="nav-item">
                <a class="nav-link" href="evidencias.jsp">Evidencias.</a>
              </li>
            <li class="nav-item">
              <a class="nav-link" href="editar.jsp">Contacto.</a>
            </li>
            <li class="nav-item">
              <form action="servletLogin" method="POST">
                <a class="nav-link" href="servletLogin?cerrar=true">Cerrar Sesion: <%=user1%>.</a>
            </form>
            </li>
          </ul>
        </div>
        <form class="form-inline">
          <input class="form-control mr-sm-2" type="search" placeholder="" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
        </form>
      </nav>
