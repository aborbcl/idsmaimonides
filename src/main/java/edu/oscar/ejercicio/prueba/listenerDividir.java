package edu.oscar.ejercicio.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listenerDividir implements ActionListener {
	public listenerDividir(CalculadoraViewSwing calcView, Calculadora modeloCalc)
    {
        this.calcView = calcView;
        this.modeloCalc = modeloCalc;
    }
	public void actionPerformed(ActionEvent e) {
		  try
	        {
	            Double numA = calcView.getTxtCampo1();
	            Double numB = calcView.getTxtCampo2();
	            Double resultado = modeloCalc.dividir(numA.doubleValue(), numB.doubleValue());
	            calcView.mostrarResultado(resultado.toString());
	        }
	        catch(NumberFormatException ex)
	        {
	            calcView.mostrarError((new StringBuilder()).append("Formato:").append(ex.getLocalizedMessage()).toString());
	        }
	        catch(CalculadoraException ex)
	        {
	            calcView.mostrarError("Imposible dividir por 0");
	        }
		
	}
	
	private CalculadoraViewSwing calcView;
    private Calculadora modeloCalc;

}
