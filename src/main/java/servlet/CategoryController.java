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
import model.Category;
import model.DAO;
import model.DataSourceFactory;
import model.Product;

/**
 *
 * @author pedago
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

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
                List<Product> listProducts = null;
		try {
                        String selectedCategory = request.getParameter("categories");
                        if(null==selectedCategory){
                            selectedCategory="1";
                        }
                        List<Category> listCategories = dao.allCategory();
                        listProducts = dao.allProductsByCategory(Integer.parseInt(selectedCategory));
                        request.setAttribute("categorie",selectedCategory);
                        request.setAttribute("listCategories", listCategories);
                        request.setAttribute("listProducts",listProducts);
                        request.getRequestDispatcher("Categories.jsp").forward(request, response);
                        
                } catch (Exception ex) {
			Logger.getLogger("CategoryController.jsp").log(Level.SEVERE, "Action en erreur", ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
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
