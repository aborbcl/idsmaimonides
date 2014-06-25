package edu.oscar.ejercicio.prueba;

public class Calculadora {
        
        public Double dividir(double num, double denum)
        	throws CalculadoraException
        {
        		if(0.0!=denum)
        		    return Double.valueOf(num / denum);
       		        else
       		        	throw new CalculadoraException("Error: Denominador NULO");
        }
        
        public Double Multiplicar(double num, double denum)
        {
        	return Double.valueOf(num * denum);
        }
        
        public Double Sumar(double num, double denum)
        {
        	return Double.valueOf(num + denum);
        }
        
        public Double Restar(double num, double denum)
        {
        	return Double.valueOf(num - denum);
        }
}
