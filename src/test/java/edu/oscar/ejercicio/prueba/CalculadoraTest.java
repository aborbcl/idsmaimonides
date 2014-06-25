package edu.oscar.ejercicio.prueba;

import junit.framework.TestCase;

import org.junit.Test;

public class CalculadoraTest extends TestCase{
	
	public CalculadoraTest(String testName) {
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
	
    public void testDividir() throws CalculadoraException{
        System.out.println("division");
        double num = 6.0;
        double denum = 3.0;
        Calculadora instance = new Calculadora();
        Double expResult = 2.0;
        Double result=instance.dividir(num, denum);
        assertEquals(expResult, result);
    }
    

	@Test
	public void dividirPor0DaNull() throws CalculadoraException {
		Calculadora calc = new Calculadora();
		Double x = calc.dividir(1, 0);
		System.out.println(x);
		assertNull(x);
	}
	@Test
	
	public void dividirOk() throws CalculadoraException {
		Calculadora calc = new Calculadora();
		Double x = calc.dividir(1, 2);
		System.out.println(x);
		assertEquals(0.5, x, 0.01);
	}
	@Test
	public void Multiplicar() {
		Calculadora calc = new Calculadora();
		double x = calc.Multiplicar(2, 2);
		System.out.println(x);
		assertEquals(4, x, 0.01);	
	}
	@Test
	public void Sumar() {
		Calculadora calc = new Calculadora();
		double x = calc.Sumar(3, 2);
		System.out.println(x);
		assertEquals(5, x, 0.01);
	}
	@Test
	public void Restar() {
		Calculadora calc = new Calculadora();
		double x = calc.Restar(4, 2);
		System.out.println(x);
		assertEquals(2, x, 0.01);
	}
}
