package edu.oscar.ejercicio.prueba;

public class Calculadora {
        
        public Double dividir(double num, double denum)
        {
                double x = 0;
                if (denum == 0){
                	return null;
                }
                x = num/denum;
       
                return x;
    }
        
        public Double Multiplicar(double num, double denum)
        {
                double x = 0;
                x = num * denum;
                return x;
        }
        
        public Double Sumar(double num, double denum)
        {
                double x = 0;
                x = num + denum;
                return x;
        }
        
        public Double Restar(double num, double denum)
        {
                double x = 0;
                x = num - denum;
                return x;
        }
}
