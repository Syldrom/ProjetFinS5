/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.DAO;
import model.DataSourceFactory;
import model.Order;
import model.Product;

/**
 *
 * @author Sylvain
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        HttpSession session = request.getSession();
        List<Order> listOrders ; 
        Object login = null;
        Object password = null;
		try {
                        login = request.getParameter("login");
                        password = request.getParameter("password");
                        out.println("PASSWORD ICI : "+password);
                        out.println("PASSWORD DE SESSION : "+session.getAttribute("password"));
                        if(null==password){
                            password="ALFKI";
                        }
                        listOrders = dao.clientOrders(password.toString());
                        out.println("CHECK ICI");
                        out.println(listOrders.get(0).getAdresse_livraison());
                        request.setAttribute("listOrders",listOrders);
                        request.getRequestDispatcher("Commandes.jsp").forward(request, response);
                        
                } catch (Exception ex) {
                    out.println("Password:"+request.getParameter("password"));
			Logger.getLogger("Commandes.jsp").log(Level.SEVERE, "Action en erreur", ex);
			request.setAttribute("message", ex.getMessage());
		} 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
