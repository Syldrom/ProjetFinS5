/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                String jspView="/";
                String login = request.getParameter("login");
                String password = request.getParameter("password");		
                DAO dao = new DAO(DataSourceFactory.getDataSource());
        try {
            if(dao.connexionClient(login, password)){
                jspView="GraphiqueParCetogrie.jsp";
                response.sendRedirect(jspView);
                
            }
            
            //request.getRequestDispatcher(jspView).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
/*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
*/
/*
    private void checkLogin(HttpServletRequest request) throws SQLException {
        System.out.print("checkingLogin");
        DAO dao = new DAO(DataSourceFactory.getDataSource());

        // Les paramètres transmis dans la requête
        String login = request.getParameter("login");
        String password = request.getParameter("password");

*/        /*Le login/password défini dans web.xml*/
/*        String loginAd = getInitParameter("loginAdmin");
        String passwordAd = getInitParameter("passwordAdmin");
        String userName = getInitParameter("ID");

        if (loginAd.equals(login) && passwordAd.equals(password)) {
            HttpSession session = request.getSession(true); // démarre la session
            session.setAttribute("userAdmin", userName);
            System.out.println("Admin");
        } else if (dao.connexionClient(login, password)) {
            // On a trouvé la combinaison login / password
            // On stocke l'information dans la session
            HttpSession session = request.getSession(true); // démarre la session
            //Nom du client (Non admin)
            String name = login;
            session.setAttribute("userName", name);
            session.setAttribute("id", password);
            System.out.println("User");
        } else { // On positionne un message d'erreur pour l'afficher dans la JSP
            request.setAttribute("errorMessage", "Login/Password incorrect");
            System.out.println("Fail");
        }
    }

    private void doLogout(HttpServletRequest request) {
        // On termine la session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }

    private String findAdminInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userAdmin");
    }

    /*private void AjouterCommande(HttpServletRequest request) throws SQLException {
        DAO dao = new DAO(DataSourceFactory.getDataSource());

        int quantite = Integer.parseInt(request.getParameter("quantite"));
        int id = Integer.parseInt(request.getParameter("id"));
        float fraisport = Float.parseFloat(request.getParameter("fraisport"));
        String dateAchat = request.getParameter("dateAchat");
        String dateLivraison = request.getParameter("dateLivraison");
        String description = request.getParameter("produit");

        PurchaseEntity commande = new PurchaseEntity(1, id, quantite, 30, fraisport, dateAchat, dateLivraison, description);

        dao.ajoutCommande(commande);

    }*/

}
