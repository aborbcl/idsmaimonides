package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import junit.framework.TestCase;

public class PersonaDAOHSQLTest extends TestCase {
PersonaDAOHSQL pdao;
    
    public PersonaDAOHSQLTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        ModeloDB modelo=new ModeloDB();
        ConnectionHSQL CHSQLF = new ConnectionHSQL();
        destroyDatabase(CHSQLF);
        Connection conn = CHSQLF.createConn();
        modelo.createModel(conn);
        pdao = new PersonaDAOHSQL(conn);

    }

    private void destroyDatabase(ConnectionHSQL CHSQLF) throws SQLException {
        Connection conn  = CHSQLF.createConn();
        Statement stst = conn.createStatement();
        stst.execute("SHUTDOWN");
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of crear method, of class PersonaDAOHSQL.
     * @throws java.lang.Exception
     */
    public void testAlta() throws Exception {
        System.out.println("alta");

        Persona pp = new Persona();
        pp.setDni(94425677);
        pp.setNombre("Os");
        pp.setApellido("Bor");
        boolean result = pdao.alta(pp);
        assertTrue(result);
        
        List lista = (List) pdao.listar();
        Object PersonaNueva = lista.get(0);
        assertEquals(PersonaNueva, pp);

    }

    /**
     * Test of borrar method, of class PersonaDAOHSQL.
     */
    public void testbaja() throws Exception {
        System.out.println("baja");
        Persona pp = new Persona();
        List listaTest;
                
        pp.setDni(94606766);
        pp.setNombre("Lu");
        pp.setApellido("bc");
        pdao.baja(pp);
        listaTest = (List) pdao.listar();
        assertFalse(listaTest.isEmpty());
        
        
        boolean expResult = false;
        boolean result = pdao.baja(pp);
        assertTrue(result);
        listaTest = (List) pdao.listar();
        assertTrue(listaTest.isEmpty());

        
    }

    /**
     * Test of guardar method, of class PersonaDAOHSQL.
     */
    public void testModif() throws Exception {
        System.out.println("Modif");
        
        Persona pp = new Persona();
        pp.setDni(80932249);
        pp.setNombre("Os");
        pp.setApellido("Bor");
        pdao.modif(pp);
        
        pp.setNombre("Roc");
        
        boolean expResult = false;
        if(!pdao.modif(pp)){
            fail();
        }

        List<Persona> result=(List<Persona>) pdao.listar();
        assertEquals(result.size(), 1); 
        Persona DatosModificados = result.get(0);
        assertEquals(DatosModificados, pp);

    }

    /**
     * Test of listar method, of class PersonaDAOHSQL.
     * @throws java.sql.SQLException
     */
    public void testListar() throws SQLException {
        System.out.println("listar");
        
        Persona pp = new Persona();
        pp.setDni(87655444);
        pp.setNombre("Pedro");
        pp.setApellido("Kremer");
        pdao.alta(pp);
        
        List result = (List) pdao.listar();
        assertFalse(result.isEmpty());
    }
    
     public void testCrear2Usuarios() throws SQLException {
        System.out.println("Crea 2 Usuarios");
        
        Persona pp = new Persona();
        pp.setDni(12345677);
        pp.setNombre("Camilo");
        pp.setApellido("Roque");
        pdao.alta(pp);
        pdao.alta(pp);
        
        List result = (List) pdao.listar();
        assertEquals(result.size(), 2);
        
    }
    
      public void testCrear2UsuariosBorrar1() throws SQLException {
        System.out.println("Crea 2 , Borrar 1");
        List result;
                
        Persona pp1 = new Persona();
        Persona pp2 = new Persona();
        pp1.setDni(12012771);
        pp1.setNombre("Juan");
        pp1.setApellido("Lope");
        pdao.alta(pp1);
        
        pp2.setDni(124567);
        pp2.setNombre("Pablo");
        pp2.setApellido("Ivanoff");
        pdao.alta(pp2);
        
        result = (List) pdao.listar();
        assertEquals(result.size(), 2);
        
        pdao.baja(pp2);
        
        result = (List) pdao.listar();        
        Persona DatosModificados = (Persona) result.get(0);
        assertEquals(DatosModificados, pp1);
        assertEquals(result.size(), 1);
        
        
    }
      
        public void testCrear3Modificar1() throws SQLException {
        System.out.println("Crea 3 , Modifica 1");
        
        Persona pp1 = new Persona("Lucas", "Papas", 8510087,0);
        Persona pp2 = new Persona("Rubén", "Pecas", 8510089,0);
        Persona pp3 = new Persona("Martín", "Pablos", 8510085,0);
        pdao.alta(pp1);
        pdao.alta(pp2);
        pdao.alta(pp3);
        
        pp3.setNombre("Jose");
        pdao.modif(pp3);
        
        List result = (List) pdao.listar();
        assertTrue(result.contains(pp1));
        assertTrue(result.contains(pp2));
        assertTrue(result.contains(pp3));
    }

}
