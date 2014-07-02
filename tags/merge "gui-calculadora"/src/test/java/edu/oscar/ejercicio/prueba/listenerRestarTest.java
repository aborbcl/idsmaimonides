package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class listenerRestarTest {
	public listenerRestarTest() {
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
     * Test of actionPerformed method, of class lstRestar.
     */
    @Test
    public void testActionPerformed() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        CV.setTxtCampo1("1");
        CV.setTxtCampo2("2");
        System.out.println("Listener Restar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerRestar instance = new listenerRestar(CV, calc);
        instance.actionPerformed(e);
        assertEquals("-1.0", CV.getLblResultado());
    }
    
    
     public void testActionPerformed2() {
        
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerRestar instance = new listenerRestar(CV, calc);
        CV.setTxtCampo1("A");
        CV.setTxtCampo2("2");
        instance.actionPerformed(e);
        assertEquals("Esto falló:For input string: \"A\"",CV.getLblResultado());        
        
    }
    
        
        @Test
    public void testActionPerformed3() {
        
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerRestar instance = new listenerRestar(CV, calc);
        CV.setTxtCampo1("1");
        CV.setTxtCampo2("B");
        instance.actionPerformed(e);
        assertEquals("Esto falló:For input string: \"B\"",CV.getLblResultado());        
        
    }

}
