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
