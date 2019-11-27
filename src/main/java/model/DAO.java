package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
                                int code = rs.getInt("Code");
                                String description = rs.getString("Description");                                   
                                Category c = new Category(code,description);
				result.add(c);
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
    
}

