package vistas;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        LoginOperaciones log = new LoginOperaciones();
        if(request.getParameter("btnIngresar")!=null){
            System.out.println("Hola");
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtContra");
            
            switch(log.loguear(user, pass)){
                case 1:
                    sesion.setAttribute("usuario", user);
                    sesion.setAttribute("nivel", "1");
                    response.sendRedirect("eventosEstudiantes.jsp");
                    break;
                case 2:
                    sesion.setAttribute("usuario", user);
                    sesion.setAttribute("nivel", "2");
                    response.sendRedirect("eventos.jsp");
                    break;
                case 3:
                    sesion.setAttribute("usuario", user);
                    sesion.setAttribute("nivel", "3");
                    response.sendRedirect("creditos.jsp");
                    break;                   
                default:
                    out.print("No existe");
            }
        }else{
            out.print("No mandaste ningun dato");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
