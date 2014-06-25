package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listenerRestar implements ActionListener {
	 public listenerRestar(CalculadoraViewSwing calcView, Calculadora modeloCalc)
	    {
	        this.calcView = calcView;
	        this.modeloCalc = modeloCalc;
	    }
	public void actionPerformed(ActionEvent e) {
		try
        {
            numA = calcView.getTxtCampo1();
            numB = calcView.getTxtCampo2();
            resultado = modeloCalc.Restar(numA.doubleValue(), numB.doubleValue());
            calcView.mostrarResultado(resultado.toString());
        }
        catch(NumberFormatException ex)
        {
            calcView.mostrarError((new StringBuilder()).append("Err:").append(ex.getLocalizedMessage()).toString());
        }
    }

    private CalculadoraViewSwing calcView;
    private Calculadora modeloCalc;
    Double numA;
    Double numB;
    Double resultado;

}