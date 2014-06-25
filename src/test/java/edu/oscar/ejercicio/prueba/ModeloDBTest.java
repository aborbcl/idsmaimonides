package edu.oscar.ejercicio.prueba;

import java.sql.Connection;

import junit.framework.TestCase;

public class ModeloDBTest extends TestCase {
	public ModeloDBTest(String testName) {
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
     * Test of createModel method, of class ModeloDB.
     * @throws java.lang.Exception
     */
    public void testCreateModelo() throws Exception {
        System.out.println("createModel");
        ConnectionHSQL chsql= new ConnectionHSQL();        
        ModeloDB instance=new ModeloDB();
        Connection conn;
        conn = chsql.createConn();
        assertNotNull( instance.createModel(conn));
     
    }
}
