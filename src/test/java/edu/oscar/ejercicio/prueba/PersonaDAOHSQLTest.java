package edu.oscar.ejercicio.prueba;


import static org.junit.Assert.*;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;
import edu.oscar.ejercicio.prueba.ConnectionHSQL;
import edu.oscar.ejercicio.prueba.ModeloDB;
import edu.oscar.ejercicio.prueba.Persona;
import edu.oscar.ejercicio.prueba.PersonaDAOHSQL;

import org.hsqldb.Statement;
import org.junit.Test;

public class PersonaDAOHSQLTest extends TestCase{
	public PersonaDAOHSQL pdao; 
	public PersonaDAOHSQLTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ModeloDB modelo=new ModeloDB();
        ConnectionHSQL CHSQLF = new ConnectionHSQL();
        Connection conn = CHSQLF.createConn();
       // modelo.borrarTabla(conn);
        modelo.createModel(conn);
        pdao = new PersonaDAOHSQL(conn);

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
    
    public void testGuardar() throws Exception {
        System.out.println("Guardar");
        
        Persona pp = new Persona();
        pp.setDni(12012771);
        pp.setNombre("Juan");
        pp.setApellido("Lode");
        pdao.crear(pp);
        pp.setNombre("Pepe");
        boolean expResult = false;
        if(!pdao.guardar(pp)){
            fail();
        }
        ArrayList result=pdao.listar();
        assertEquals(result.size(), 1); 
        Persona PersonaModificada = (Persona) result.get(0);
        assertEquals(PersonaModificada, pp);
    }
    public void testCrear() throws Exception {
        System.out.println("crear");

        Persona pp = new Persona();
        pp.setDni(120120000);
        pp.setNombre("Juan");
        pp.setApellido("Lope");
        boolean result = pdao.crear(pp);
        assertTrue(result);
        ArrayList lista = pdao.listar();
        Object PersonaNueva = lista.get(0);
        assertEquals(PersonaNueva, pp);

    }

    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Persona pp = new Persona();
        ArrayList listaTest;
        pp.setDni(12012771);
        pp.setNombre("Juan");
        pp.setApellido("Lope");
        pdao.crear(pp);
        listaTest = pdao.listar();
        assertFalse(listaTest.isEmpty());
        boolean expResult = false;
        boolean result = pdao.borrar(pp);
        assertTrue(result);
        listaTest = pdao.listar();
        assertTrue(listaTest.isEmpty());
    }
    public void testListar() throws SQLException {
        System.out.println("listar");
        Persona pp = new Persona();
        pp.setDni(12012771);
        pp.setNombre("Juan");
        pp.setApellido("Lope");
        pdao.crear(pp);
        ArrayList result = pdao.listar();
        assertFalse(result.isEmpty());
    }
    
     public void testCrear2Usuarios() throws SQLException {
        System.out.println("Crear 2 Usuarios");
        Persona pp = new Persona();
        pp.setDni(80945666);
        pp.setNombre("andres");
        pp.setApellido("hurguen");
        pdao.crear(pp);
        pdao.crear(pp);
        ArrayList result = pdao.listar();
        assertEquals(result.size(), 2);
    }
        public void testCrear2UsuariosBorrar1() throws SQLException {
        System.out.println("Crear 2 , Borrar 1");
        ArrayList result;
        Persona pp1 = new Persona();
        Persona pp2 = new Persona();
        pp1.setDni(94425677);
        pp1.setNombre("oscar");
        pp1.setApellido("borbon");
        pdao.crear(pp1);
        pp2.setDni(94425677);
        pp2.setNombre("lauren");
        pp2.setApellido("bulla");
        pdao.crear(pp2);
        result = pdao.listar();
        assertEquals(result.size(), 2);
        pdao.borrar(pp2);
        result = pdao.listar();        
        Persona PersonaModificada = (Persona) result.get(0);
        assertEquals(PersonaModificada, pp1);
        assertEquals(result.size(), 1);
             
    }
        public void testCrear3Modificar1() throws SQLException {
        System.out.println("Crear 3 - Modificar 1");
        Persona pp1 = new Persona("mario", "duarte", 80221455);
        Persona pp2 = new Persona("joaquin", "sabina", 89034566);
        Persona pp3 = new Persona("pedro", "pablo", 80932249);
        pdao.crear(pp1);
        pdao.crear(pp2);
        pdao.crear(pp3);
        pp3.setNombre("pepa");
        pdao.guardar(pp3);
        ArrayList result = pdao.listar();
        assertTrue(result.contains(pp1));
        assertTrue(result.contains(pp2));
        assertTrue(result.contains(pp3));
    }
}
