package edu.oscar.ejercicio.prueba;

public class CalculadoraControlador {
	public CalculadoraControlador(CalculadoraViewSwing vista, Calculadora modelo) {
		
        calcView = vista;
        modeloCalc = modelo;
        calcView.agregarListenerCmdSumar(new listenerSumar(vista, modelo));
        calcView.agregarListenerCmdDividir(new listenerDividir(vista, modelo));
        calcView.agregarListenerCmdMultiplicar(new listenerMultiplicar(vista, modelo));
        calcView.agregarListenerCmdRestar(new listenerRestar(vista, modelo));
        calcView.mostrarCalculadora(modeloCalc);
    }

    private CalculadoraViewSwing calcView;
    private Calculadora modeloCalc;


}
