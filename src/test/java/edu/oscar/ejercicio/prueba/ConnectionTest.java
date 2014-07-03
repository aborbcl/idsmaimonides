package edu.oscar.ejercicio.prueba;



import java.sql.Connection;
import java.sql.SQLException;

import edu.oscar.ejercicio.prueba.ConnectionURL;
import junit.framework.TestCase;


public class ConnectionTest extends TestCase {
	public ConnectionTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    public void testCreateConn() throws Exception {
        System.out.println("createConn");
        String URL = "jdbc:hsqldb:mem:db";
        ConnectionURL instance = new ConnectionURL();
        Connection expResult = null;
        Connection result = instance.connect(URL);
        assertTrue(! result.isClosed());
    }
    
        public void testCreateConnFail() throws Exception {
        System.out.println("createConn");
        String URL = "jdbc:hsqldb:file:/usuarios";
        ConnectionURL instance = new ConnectionURL();
        Connection expResult = null;
        try{
            Connection result = instance.connect(URL);
            fail();
        }catch(SQLException ee){
            ee.printStackTrace();
        }
   }

}
