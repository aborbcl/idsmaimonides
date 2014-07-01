package edu.oscar.ejercicio.prueba;

public class CalculadoraException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CalculadoraException(){
		super("Excepcion de calculadora");
	}
	CalculadoraException(String s){
		super(s);
	}
}
