/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import model.DAO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.After;
import org.hsqldb.cmdline.SqlFile
import org.hsqldb.cmdline.SqlToolError;
/**
 *
 * @author Axel
 */
public class CheckingLoginTest {
    
    private DAO dao; // L'objet à tester
    private DataSource myDataSource; // La source de données à utiliser
    private static Connection myConnection ;
    private String code; //Le code client qu'on utilise dans les jeux de tests
	

    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        myDataSource = getDataSource();
	myConnection = myDataSource.getConnection();
	// On initialise la base avec le contenu d'un fichier de test
	String sqlFilePath = CheckingLoginTest.class.getResource("comptoirs_data.sql").getFile();
	SqlFile sqlFile = new SqlFile(new File(sqlFilePath));
	sqlFile.setConnection(myConnection);
	sqlFile.execute();
	sqlFile.closeReader();	
	// On crée l'objet à tester
	dao = new DAO(myDataSource);
        code = "ALFKI";
    }
    
    @After
    public void tearDown() throws SQLException {
        myConnection.close();		
        dao = null; // Pas vraiment utile
    }
    
        
    /**
     * Teste la méthode loginExiste
     * @throws SQLException 
     */
    @Test
    public void existingClientTest() throws SQLException{
        String username = "Maria Anders";
        String password = "ALFKI";
        
        //on teste un utlisateur
        assertTrue(dao.connexionClient(username,"ANATR"));
        
        //on teste un utilisateur incorrect
        assertFalse(dao.connexionClient(username, "ANATR"));

    }
    
    
    public static DataSource getDataSource() throws SQLException {
		org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
		ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
		ds.setUser("sa");
		ds.setPassword("sa");
		return ds;
	}
}