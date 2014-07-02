package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;

public class ConnectionFactoryTest extends TestCase {
	public ConnectionFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of createConn method, of class ConnectionFactory.
     * @throws java.lang.Exception
     */
    public void testCreateConn() throws Exception {
        System.out.println("createConn");
        String URL = "jdbc:hsqldb:mem:mymemdb";
        ConnectionFactory instance = new ConnectionFactory();
        Connection expResult = null;
        Connection result = instance.createConn(URL);
        assertTrue(! result.isClosed());
    }
    
        public void testCreateConnFail() throws Exception {
        System.out.println("createConn");
        String URL = "jdbasdasdasdasdc:lakjsdhlajshlkahsdlkahsldjh:mem:mymemdb";
        ConnectionFactory instance = new ConnectionFactory();
        Connection expResult = null;
        try{
            Connection result = instance.createConn(URL);
            fail();
        }catch(SQLException ee){
            ee.printStackTrace();
        }
   }
}
