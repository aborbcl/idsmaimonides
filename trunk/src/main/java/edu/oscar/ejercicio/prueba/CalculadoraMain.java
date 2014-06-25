package edu.oscar.ejercicio.prueba;

public class CalculadoraMain {
	 public CalculadoraMain()
	    {
	    }

	    public static void main(String args[])
	    {
	        Calculadora calc = new Calculadora();
	        CalculadoraViewSwing CV = new CalculadoraViewSwing();
	        CalculadoraControlador CC = new CalculadoraControlador(CV, calc);
	    }
}
