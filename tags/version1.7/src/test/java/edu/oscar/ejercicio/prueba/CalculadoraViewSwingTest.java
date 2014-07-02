package edu.oscar.ejercicio.prueba;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraViewSwingTest {
	
	public CalculadoraViewSwingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Assert true-muestra la pantalla swing
     */
    @Test
    public void testMostrarCalculadora() {
        System.out.println("mostrarCalculadora");
        Calculadora calc = null;
        CalculadoraViewMock instance = new CalculadoraViewMock();
        instance.mostrarCalculadora(calc);
        assertTrue(instance.isVisible());
        
    }

    /**
     * Test of mostrarResultado method, of class CalculadoraViewSwing.
     */
    @Test
    public void testMostrarResultado() {
        System.out.println("mostrarResultado");
        String resultado = "resultado";
        CalculadoraViewMock instance = new CalculadoraViewMock();
        instance.mostrarResultado(resultado);
        
        assertTrue((resultado.equals(instance.getLblResultado())));
        
    }

    /**
     * Test of mostrarError method, of class CalculadoraViewSwing.
     */
    @Test
    public void testMostrarError() {
        System.out.println("mostrarError");
        String error = "mi error";
        CalculadoraViewMock instance = new CalculadoraViewMock();
        instance.mostrarError(error);
        assertTrue((error==instance.getLblResultado()));
    }

    /**
     * Test of getTxtCampo1 method, of class CalculadoraViewSwing.
     */
    @Test
    public void testGetTxtCampo1() {
        System.out.println("getTxtCampo1");
        CalculadoraViewMock instance = new CalculadoraViewMock();
        Double expResult = 0.0;
        Double result = instance.getTxtCampo1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTxtCampo2 method, of class CalculadoraViewSwing.
     */
    @Test
    public void testGetTxtCampo2() {
        System.out.println("getTxtCampo2");
        CalculadoraViewMock instance = new CalculadoraViewMock();
        Double expResult = 0.0;
        Double result = instance.getTxtCampo2();
        assertEquals(expResult, result);
    }

}
