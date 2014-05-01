package edu.oscar.ejercicio.prueba;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {
	
	

	@Test
	public void dividirPor0DaNull() {
		Calculadora calc = new Calculadora();
		Double x = calc.dividir(1, 0);
		System.out.println(x);
		assertNull(x);
				
	}

	@Test
	public void dividirOk() {
		Calculadora calc = new Calculadora();
		Double x = calc.dividir(1, 2);
		System.out.println(x);
		assertEquals(0.5, x, 0.01);
				
	}
	
}
