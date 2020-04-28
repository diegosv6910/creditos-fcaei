package vistas;

import DAO.CreditosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
public class buscarCreditos extends HttpServlet {

    String listar_creditos="WEB-INF/creditos.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("creditos.jsp"); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                Creditos cre = new Creditos();
                cre.setM_Busqueda(request.getParameter("Matricula"));
                System.out.println("Servlet "+cre.getM_Busqueda());
                response.sendRedirect("creditos.jsp"); 
        }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
