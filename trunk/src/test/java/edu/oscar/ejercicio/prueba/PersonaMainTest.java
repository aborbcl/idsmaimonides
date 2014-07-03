package edu.oscar.ejercicio.prueba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import edu.oscar.ejercicio.prueba.ConnectionHSQL;
import edu.oscar.ejercicio.prueba.ModeloDB;
import edu.oscar.ejercicio.prueba.PersonaDAOHSQL;
import edu.oscar.ejercicio.prueba.PersonaMain;
import junit.framework.TestCase;

public class PersonaMainTest extends TestCase {
    public PersonaMain pdao;
    protected void setUp() throws Exception {
        super.setUp();
        ModeloDB modelo=new ModeloDB();
        ConnectionHSQL CHSQLF = new ConnectionHSQL();
        Connection conn = CHSQLF.createConn();
       // modelo.borrarTabla(conn);
        modelo.createModel(conn);
        pdao = new PersonaMain(conn);

    }

  /*  private void destroyDatabase(ConnectionHSQL CHSQLF) throws SQLException {
        Connection conn  = CHSQLF.createConn();
        Statement stst = (Statement) conn.createStatement();
        stst.execute("SHUTDOWN");
    }*/
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        ModeloDB modelo=new ModeloDB();
        ConnectionHSQL CHSQLF = new ConnectionHSQL();
        Connection conn = CHSQLF.createConn();
       modelo.borrarTabla(conn);


    }
    public void testLeeProperties() throws FileNotFoundException, IOException{
    	assertTrue(pdao.cargarPropiedades());
    	
    }
    public void testIntroducePersonas() throws FileNotFoundException, IOException, SQLException{
    	pdao.cargarPropiedades();
    	int tam = pdao.guardarEnDB().size();
    	assertEquals(tam,11); // O igual a 1, dependiendo si es true o false
    	assertTrue(pdao.svcCreado());
    	
    }
}
