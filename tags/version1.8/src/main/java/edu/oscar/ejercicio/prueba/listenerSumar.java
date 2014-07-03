package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listenerSumar implements ActionListener {
	public listenerSumar(CalculadoraViewSwing vista, Calculadora modelo)
    {
        calcView = vista;
        modeloCalc = modelo;
    }

	public void actionPerformed(ActionEvent arg0) {
		try
        {
            Double numA = calcView.getTxtCampo1();
            Double numB = calcView.getTxtCampo2();
            Double resultado = modeloCalc.Sumar(numA.doubleValue(), numB.doubleValue());
            calcView.mostrarResultado(resultado.toString());
        }
        catch(NumberFormatException ex)
        {
            calcView.mostrarError((new StringBuilder()).append("Esto fall\363:").append(ex.getLocalizedMessage()).toString());
        }
    }

    private CalculadoraViewSwing calcView;
    private Calculadora modeloCalc;
}