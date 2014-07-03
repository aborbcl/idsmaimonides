package edu.oscar.ejercicio.prueba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraControladorTest {
	public CalculadoraControladorTest(){
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

    @Test
    public void testMain() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        CalculadoraControlador CC = new CalculadoraControlador(CV, calc);
        assertTrue(CV.isVisible());
        
    }

}
