package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class DAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table PRODUTI
	 * @return Liste des produits
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Product> allProducts() throws SQLException {

		List<Product> result = new LinkedList<>();

		String sql = "SELECT * FROM PRODUIT ORDER BY REFERENCE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                                int ref = rs.getInt("REFERENCE");
                                String name = rs.getString("NOM");
                                int four = rs.getInt("FOURNISSEUR");
                                int cate = rs.getInt("CATEGORIE");                                
                                String quantity = rs.getString("QUANTITE_PAR_UNITE");
                                float price = rs.getFloat("PRIX_UNITAIRE");
                                int stock = rs.getInt("UNITES_EN_STOCK");
                                int sales = rs.getInt("UNITES_COMMANDEES");
                                int restock = rs.getInt("NIVEAU_DE_REAPPRO");
                                int unvailable = rs.getInt("INDISPONIBLE");
                                
                                Product p = new Product(ref,name,four,cate,quantity,price,stock,sales,restock,unvailable);
				result.add(p);
			}
		}
		return result;
	}
        public List<Category> allCategory() throws SQLException {
                List<Category> result = new LinkedList<>();
                
                String sql = "SELECT * FROM CATEGORIE";
                try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                                int code = rs.getInt("CODE");
                                String name = rs.getString("LIBELLE");
                                String description = rs.getString("DESCRIPTION");                                   
                                Category c = new Category(code,name,description);
				result.add(c);
			}
                    return result;
		}
        }
        public List<Line> allLines() throws SQLException {
                List<Line> result = new LinkedList<>();
                
                String sql = "SELECT * FROM LIGNE";
                try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                                int command = rs.getInt("COMMANDE");
                                int product = rs.getInt("PRODUIT");
                                int quantity = rs.getInt("QUANTITE");                                   
                                Line l = new Line(command,product,quantity);
				result.add(l);
			}
                    return result;
		}
        }
        public List<Order> allOrders() throws SQLException {
                List<Order> result = new LinkedList<>();
                
                String sql = "SELECT * FROM COMMANDE";
                try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                                int number = rs.getInt("NUMERO");
                                String client = rs.getString("CLIENT");
                                Date writing_date = rs.getDate("SAISIE_LE"); 
                                Date sending_date = rs.getDate("ENVOYEE_LE");
                                float port = rs.getFloat("PORT");
                                String target = rs.getString("DESTINATAIRE");
                                String address = rs.getString("ADRESSE_LIVRAISON");
                                String city = rs.getString("VILLE_LIVRAISON");
                                String district = rs.getString("REGION_LIVRAISON");
                                String pc = rs.getString("CODE_POSTAL_LIVRAISON");
                                String country = rs.getString("PAYS_LIVRAISON");
                                float discount = rs.getFloat("REMISE");
                                
                                Order o = new Order(number,client,writing_date,sending_date,port,target,address,city
                                ,district,pc,country,discount);
				result.add(o);
			}
                    return result;
		}
        }

        public List<Integer> numCommandes() throws SQLException {

		List<Integer> result = new LinkedList<>();

		String sql = "SELECT * FROM COMMANDE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("NUMERO");					
				result.add(id);
			}
		}
		return result;
	}
        
        //CONTROLES DE CONNEXION
        

        
         public boolean connexionClient(String contact,String code) throws SQLException {
            boolean verif = false;
            String sql = "SELECT CODE FROM CLIENT WHERE EXISTS (SELECT CONTACT,CODE FROM CLIENT WHERE CONTACT=? AND CODE = ?)";
            //String sql1 = "SELECT COUNT(*) AS Nombre FROM CLIENT WHERE CONTACT=? AND CODE=? ";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)){
                    
                    stmt.setString(1,contact);
                    stmt.setString(2,code);
                    
                    try(ResultSet rs = stmt.executeQuery()){
                        if(rs.next()){
                            verif = true;
                        }
                    }catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
            }
            return verif;
            }
         }
         
         public String nomCategorie( int ID ) throws SQLException {
            String sql = "SELECT libelle FROM CATEGORIE , PRODUIT WHERE categorie.code = produit.categorie and categorie.code = ? ";
            //String sql1 = "SELECT COUNT(*) AS Nombre FROM CLIENT WHERE CONTACT=? AND CODE=? ";
            String result = null;
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)){
                    
                    stmt.setInt(1,ID);
                    
                    
                    try(ResultSet rs = stmt.executeQuery()){
                        if(rs.next()){
                            result = rs.getString("libelle");
                        }
                    }catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
            }
            return result;
            }
         }
    }

