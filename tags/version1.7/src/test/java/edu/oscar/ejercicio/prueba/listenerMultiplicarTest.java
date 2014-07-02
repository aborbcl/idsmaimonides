package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class listenerMultiplicarTest {
	public listenerMultiplicarTest() {
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
     * Test of actionPerformed method, of class lstMultiplicar.
     */
    @Test
    public void testActionPerformed() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("3");
        CV.setTxtCampo2("2");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerMultiplicar instance = new listenerMultiplicar(CV, calc);
        instance.actionPerformed(e);
        assertEquals("6.0", CV.getLblResultado());    
        
    }
    @Test
    public void testActionPerformed2() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("A");
        CV.setTxtCampo2("3");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerMultiplicar instance = new listenerMultiplicar(CV, calc);
        instance.actionPerformed(e);
        assertEquals("Esto falló:For input string: \"A\"",CV.getLblResultado());        
        
    }
    @Test
    public void testActionPerformed3() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("3");
        CV.setTxtCampo2("B");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerMultiplicar instance = new listenerMultiplicar(CV, calc);
        instance.actionPerformed(e);
                assertEquals("Esto falló:For input string: \"B\"",CV.getLblResultado());        
       
    }

}
