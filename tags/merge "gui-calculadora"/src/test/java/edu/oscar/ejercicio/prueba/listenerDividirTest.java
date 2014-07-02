package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class listenerDividirTest {
	
	public listenerDividirTest(){
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
     * Test of actionPerformed method, of class lstDividir.
     */
    @Test
    public void testActionPerformed() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        CV.setTxtCampo1("1");
        CV.setTxtCampo2("2");
        System.out.println("Listener Dividir");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerDividir instance = new listenerDividir(CV, calc);
        instance.actionPerformed(e);
        assertEquals("0.5", CV.getLblResultado());
    }
    
    @Test
    public void testActionPerformed2() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("A");
        CV.setTxtCampo2("3");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerDividir instance = new listenerDividir(CV, calc);
        instance.actionPerformed(e);
        assertEquals("For input string: \"A\"",CV.getLblResultado());        
        
    }
    
    @Test
    public void testActionPerformed3() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("1");
        CV.setTxtCampo2("B");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerDividir instance = new listenerDividir(CV, calc);
        instance.actionPerformed(e);
        assertEquals("For input string: \"B\"",CV.getLblResultado());        
        
    }
    
       @Test
    public void testActionPerformed4() {
        Calculadora calc = new Calculadora();
        CalculadoraViewMock CV = new CalculadoraViewMock();
        
        CV.setTxtCampo1("1");
        CV.setTxtCampo2("0");
        
        System.out.println("Listener Sumar");
        ActionEvent e = new ActionEvent(this, 1, null);
        listenerDividir instance = new listenerDividir(CV, calc);
        instance.actionPerformed(e);
        assertEquals("Imposible dividir por 0",CV.getLblResultado());        
        
    }

}
