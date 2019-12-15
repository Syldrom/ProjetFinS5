/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.DataSourceFactory;
//import model.PurchaseEntity;

/**
 *
 * @author Nicolas
 */
@WebServlet(name = "ConnectionController", urlPatterns = {"/ConnectionController"})
public class ConnectionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try (PrintWriter out = response.getWriter()) {
            String jspView ="/";

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session=request.getSession();  
                String jspView="Produits.jsp";
                String password = null;
                String login = null;
                DAO dao = new DAO(DataSourceFactory.getDataSource());
        try {
            String loginAdmin = getInitParameter("loginAdmin");             
            String passwordAdmin = getInitParameter("passwordAdmin");       
            login = request.getParameter("login");
            password = request.getParameter("password");
            
            if(dao.connexionClient(login, password) ){
                session.setAttribute("login",login);
                session.setAttribute("password",password);
                
                request.getRequestDispatcher(jspView).forward(request, response);
                               
            }
            else if (login.equals(loginAdmin)&&password.equals(passwordAdmin)) {
                session.setAttribute("login",loginAdmin);
                session.setAttribute("password",passwordAdmin);
                
                request.getRequestDispatcher(jspView).forward(request, response);
            }
            else{
                jspView="Connexion.jsp";
                session.setAttribute("login",null);
                session.setAttribute("password",password);
                String error = "Connexion échouée : nom ou mot de passe érroné !";
                request.setAttribute("message",error);             
                request.getRequestDispatcher(jspView).forward(request, response);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session=request.getSession();  
                session.removeAttribute("login");
                session.removeAttribute("password");
                            
                response.sendRedirect("Connexion.jsp");
        
    }
}
