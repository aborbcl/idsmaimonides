package edu.oscar.ejercicio.prueba;

import java.sql.Connection;

import main.ConnectionHSQL;
import junit.framework.TestCase;

public class ConnectionHSQLTest extends TestCase {
	public ConnectionHSQLTest(String testName) {
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
     * Test of createConn method, of class ConnectionHSQL.
     */
    public void testCreateConn() throws Exception {
        System.out.println("createConn");
        ConnectionHSQL instance = new ConnectionHSQL();
        Connection result = instance.createConn();
        assertNotNull(!result.isClosed());
    }
}
