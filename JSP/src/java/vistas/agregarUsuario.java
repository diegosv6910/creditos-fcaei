package vistas;

import DAO.CreditosDAO;
import DAO.EventosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "agregarUsuario", urlPatterns = {"/agregarUsuario"})
public class agregarUsuario extends HttpServlet{
    String listar="/eventos.jsp";
    String listar_creditos="WEB-INF/creditos.jsp";
    String editar="/editar.jsp";
    Eventos eve = new Eventos();
    EventosDAO dao = new EventosDAO();
    int pagina=0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("lista")){
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("eventos.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("ID_Evento", request.getParameter("ID_Evento"));
            acceso=editar;
        }else if(action.equalsIgnoreCase("actualizar")){
            System.out.println(request.getParameter("Nombre_Evento"));
            int id_e = Integer.parseInt(request.getParameter("ID_Evento"));
            System.out.println(request.getParameter("ID_Evento"));
            int id_i = Integer.parseInt(request.getParameter("ID_Institucion"));
            String N_E = request.getParameter("Nombre_Evento");
            String F_I = request.getParameter("Fecha_Inicio");
            String F_F = request.getParameter("Fecha_Fin");
            eve.setID_Evento(id_e);
            eve.setID_Institucion(id_i);
            eve.setNombre_Evento(N_E);
            eve.setFecha_Inicio(F_I);
            eve.setFecha_Final(F_F);
            dao.editar(eve);
            request.getRequestDispatcher("eventos.jsp").forward(request, response);
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String ID_Evento = request.getParameter("ID_Evento");
            String ID_Institucion = request.getParameter("ID_Institucion");
            String Nombre_Evento = request.getParameter("Nombre_Evento");
            String Fecha_Inicio = request.getParameter("Fecha_Inicio");
            String Fecha_Fin = request.getParameter("Fecha_Fin");
            Almacenar a = new Almacenar();
            a.Recibir(ID_Evento,ID_Institucion,Nombre_Evento,Fecha_Inicio,Fecha_Fin);
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("eventos.jsp").forward(request, response);
  
            
            
    }

}
