/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Client;
import model.DAO;
import model.DataSourceFactory;
import model.Product;

/**
 *
 * @author pedago
 */
@WebServlet(name = "EditionController", urlPatterns = {"/EditionController"})
public class EditionController extends HttpServlet {

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
        throws ServletException, IOException, SQLException {
		// Quelle action a servi à appeler la servlet ? (Ajouter, Supprimer ou aucune = afficher)
		//String action = request.getParameter("action");
		//action = (action == null) ? "" : action; // Pour le switch qui n'aime pas les null
		DAO dao = new DAO(DataSourceFactory.getDataSource());
                HttpSession session = request.getSession();
                Object l = session.getAttribute("login");
                Object p = session.getAttribute("password");
		try {
                        if(null==l & null==p){
                            p="Maria Anders";
                            l="ALFKI";
                        }
                        Client client;
                        client = dao.getClientInfos(l.toString(),p.toString());
                        request.setAttribute("client", client);
                        request.getRequestDispatcher("Edition.jsp").forward(request, response);
                        
                } catch (Exception ex) {
			Logger.getLogger("EditionController.jsp").log(Level.SEVERE, "Action en erreur", ex);
			request.setAttribute("message", ex.getMessage());
		} 
		/*try (PrintWriter out = response.getWriter()){
                    Properties res = new Properties();
                    res.put("records", listProducts);
                    response.setContentType("application/json;charset=UTF-8");
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String gson_data = gson.toJson(res);
                    out.println(gson_data);
                    
                }*/
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                HttpSession session=request.getSession();
                String password = null;
                String login = null;
                
                String jspView="Edition.jsp";
                String user = request.getParameter("code");
                String code =request.getParameter("code");
                String societe = request.getParameter("societe");
                String contact = request.getParameter("contact");
                String fonction = request.getParameter("fonction");
                String adresse = request.getParameter("adresse");
                String ville = request.getParameter("ville");
                String region = request.getParameter("region");
                String code_postal = request.getParameter("code_postal");
                String pays = request.getParameter("pays");
                String telephone = request.getParameter("telephone");
                String fax = request.getParameter("fax");
                
                DAO dao = new DAO(DataSourceFactory.getDataSource());
        try {
            
            dao.updateClient(user,code,societe,contact,fonction,adresse,ville,region,code_postal,pays,telephone,fax);
            
            jspView="Edition.jsp";
            processRequest(request, response);
            
            
        
            //request.getRequestDispatcher(jspView).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
