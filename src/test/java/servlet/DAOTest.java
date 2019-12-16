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
import model.Client;
import model.DAO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.After;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import static servlet.CheckingLoginTest.getDataSource;
/**
 *
 * 
 */
public class DAOTest {
    
    private DAO dao; // L'objet à tester
    private DataSource myDataSource; // La source de données à utiliser
    private static Connection myConnection ;
    private String code; //Le code client qu'on utilise dans les jeux de tests
	

    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        myDataSource = getDataSource();
	myConnection = myDataSource.getConnection();
	// On initialise la base avec le contenu d'un fichier de test
	String sqlFilePath = DAOTest.class.getResource("comptoirs_test.sql").getFile();
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
        dao = null;
    }
    
    @Test
    public void nomCategorieTest() throws SQLException {
        int code = 1;
        assertEquals( dao.nomCategorie(code) , "Boissons" );

      
    }
    
    @Test
    public void connexionClientTest() throws SQLException {
        String contact = "Maria Anders";
        String code = "ALFKI";
        assertEquals( dao.connexionClient(contact,code) , true );
    }
    @Test
    public void updateClientTest() throws SQLException {
        String contact = "Maria Anders";
        String code = "ALFKI";
        
        String région ="Brandebourg";
        String telephone ="030-0909090";

        

        dao.updateClient(contact,"ALFKI","Alfreds Futterkiste","Maria Anders","Représentant(e)","Obere Str. 57","Berlin",région,"12209","Allemagne",telephone,"030-0076545");
        Client client = dao.getClientInfos(contact,code);
        assertEquals(client.getRegion(),région);
        assertEquals(client.getTelephone(),telephone);
    }
   
}