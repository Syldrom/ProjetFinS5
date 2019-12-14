package model;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class DAO {

        public static void main(String[] args) throws SQLException{
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            try {
                //System.out.println(dao.allProductsByCategory(Integer.parseInt("1")));
                dao.updateClient("ALFKI", "ALFKI", "Alfreds Futterkiste", "Maria Anders",
                        "Représentant(e)", "Obere Str. 57", "Berlintoz", "test",
                        "12209", "Allemagne", "030-0074321", "030-0076545");
                out.println("ok");
                //System.out.println(dao.allCategory());
            } catch (Exception ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table PRODUIT
        * 
        * @throws java.sql.SQLException
	*/
        
        public void updateClient(String user,String code,String societe,String contact,String fonction,String adresse,String ville,String region,String code_postal,String pays,String telephone,String fax) throws SQLException{
            String sql = "UPDATE CLIENT SET CODE=?, SOCIETE=?, CONTACT=?, FONCTION=?,"
                    +" ADRESSE=?, VILLE=?, REGION=?, CODE_POSTAL=?, PAYS=?, TELEPHONE=?,FAX=?"
                    + " WHERE CONTACT=?";
            try (Connection connection = myDataSource.getConnection(); 
		    PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, code);
                    stmt.setString(2, societe);
                    stmt.setString(3, contact);
                    stmt.setString(4, fonction);
                    stmt.setString(5, adresse);
                    stmt.setString(6, ville);
                    stmt.setString(7, region);
                    stmt.setString(8, code_postal);
                    stmt.setString(9, pays);
                    stmt.setString(10, telephone);
                    stmt.setString(11, fax);
                    stmt.setString(12, user);
                    
                    stmt.executeUpdate();
                   
                    stmt.close();

            }catch(SQLException e){
                throw new SQLException("Erreur : "+e.getMessage());
            }
            
            
        }
        
        public Client getClientInfos(String login,String mdp) throws SQLException{
            
            Client client = new Client(); 
            
            String sql = "SELECT * FROM CLIENT WHERE CODE=? AND CONTACT =?";
		try (Connection connection = myDataSource.getConnection(); 
		    PreparedStatement stmt = connection.prepareStatement(sql)) {

                        stmt.setString(1,mdp);
                        stmt.setString(2,login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
                                client.setCode(rs.getString("CODE"));
                                client.setSociete(rs.getString("SOCIETE"));
                                client.setContact(rs.getString("CONTACT"));
                                client.setFonction(rs.getString("FONCTION"));
                                client.setAdresse(rs.getString("ADRESSE"));
                                client.setVille(rs.getString("VILLE"));
                                client.setRegion(rs.getString("REGION"));
                                client.setCode_postal(rs.getString("CODE_POSTAL"));
                                client.setPays(rs.getString("PAYS"));
                                client.setTelephone(rs.getString("TELEPHONE"));
                                client.setFax(rs.getString("FAX"));
			}
		}
		return client;
            
        }
        
	public List<Product> allProducts() throws SQLException {

		List<Product> result = new LinkedList<>();

		String sql = "SELECT * FROM PRODUIT ORDER BY CATEGORIE,REFERENCE";
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
        public List<Product> allProductsByCategory(Integer categorie) throws SQLException {

		List<Product> result = new LinkedList<>();

		String sql = "SELECT * FROM PRODUIT WHERE CATEGORIE=? ORDER BY CATEGORIE,REFERENCE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, categorie);
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
                                int unavailable = rs.getInt("INDISPONIBLE");
                                
                                Product p = new Product(ref,name,four,cate,quantity,price,stock,sales,restock,unavailable);
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
        public List<Order> clientOrders(String cli) throws SQLException {
                List<Order> result = new ArrayList<Order>();
                
                String sql = "SELECT * FROM COMMANDE WHERE CLIENT=?";
                try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, cli);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            
                                int numero = rs.getInt("NUMERO");
                                String client = rs.getString("CLIENT");
                                Date saisie = rs.getDate("SAISIE_LE"); 
                                Date envoi = rs.getDate("ENVOYEE_LE");
                                float port = rs.getFloat("PORT");
                                String destinataire = rs.getString("DESTINATAIRE");
                                String addresse_livraison = rs.getString("ADRESSE_LIVRAISON");
                                String ville_livraison = rs.getString("VILLE_LIVRAISON");
                                String region_livraison = rs.getString("REGION_LIVRAISON");
                                String code_postal_livraison = rs.getString("CODE_POSTAL_LIVRAIS");
                                String pays_livraison = rs.getString("PAYS_LIVRAISON");
                                float remise = rs.getFloat("REMISE");
                                
                                Order o = new Order(numero, client, saisie, envoi, port, destinataire, addresse_livraison, ville_livraison, region_livraison, code_postal_livraison, pays_livraison, remise);
				result.add(o);
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
                                String pc = rs.getString("CODE_POSTAL_LIVRAIS");
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

