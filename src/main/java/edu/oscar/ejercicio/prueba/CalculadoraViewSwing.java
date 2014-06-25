package edu.oscar.ejercicio.prueba;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraViewSwing extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void mostrarCalculadora(Calculadora calc)
    {
        setVisible(true);
    }

    public void mostrarResultado(String resultado)
    {
        lblResultado.setText(resultado);
    }

    public String getLblResultado()
    {
        return lblResultado.getText();
    }

    public void mostrarError(String error)
    {
        lblResultado.setText(error);
    }

    public void agregarListenerCmdSumar(ActionListener listener)
    {
        cmdSumar.addActionListener(listener);
    }

    public void agregarListenerCmdRestar(ActionListener listener)
    {
        cmdRestar.addActionListener(listener);
    }

    public void agregarListenerCmdMultiplicar(ActionListener Listener)
    {
        cmdMultiplicar.addActionListener(Listener);
    }

    public void agregarListenerCmdDividir(ActionListener Listener)
    {
        cmdDividir.addActionListener(Listener);
    }

    public Double getTxtCampo1()
    {
        return Double.valueOf(Double.parseDouble(txtCampo1.getText()));
    }

    public Double getTxtCampo2()
        throws NumberFormatException
    {
        return Double.valueOf(Double.parseDouble(txtCampo2.getText()));
    }

    public CalculadoraViewSwing()
    {
        initComponents();
    }

    private void initComponents()
    {
        txtCampo1 = new JTextField();
        txtCampo2 = new JTextField();
        lblResultado = new JLabel();
        cmdSumar = new JButton();
        cmdRestar = new JButton();
        cmdMultiplicar = new JButton();
        cmdDividir = new JButton();
        setDefaultCloseOperation(3);
        getContentPane().setLayout(new GridBagLayout());
        txtCampo1.setText("0");
        txtCampo1.setMinimumSize(new Dimension(20, 28));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 2;
        getContentPane().add(txtCampo1, gridBagConstraints);
        txtCampo2.setText("0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 2;
        getContentPane().add(txtCampo2, gridBagConstraints);
        lblResultado.setText("Resultado");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = 2;
        getContentPane().add(lblResultado, gridBagConstraints);
        cmdSumar.setText("Sumar");
        cmdSumar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                cmdSumarActionPerformed(evt);
            }

            final CalculadoraViewSwing this$0;

            
            {
                this$0 = CalculadoraViewSwing.this;
                super(this$0);
            }
        }
);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = 2;
        getContentPane().add(cmdSumar, gridBagConstraints);
        cmdRestar.setText("Restar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = 2;
        getContentPane().add(cmdRestar, gridBagConstraints);
        cmdMultiplicar.setText("Multiplicar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = 2;
        getContentPane().add(cmdMultiplicar, gridBagConstraints);
        cmdDividir.setText("Dividir");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = 2;
        getContentPane().add(cmdDividir, gridBagConstraints);
        pack();
    }

    private void cmdSumarActionPerformed(ActionEvent actionevent)
    {
    }

    private JButton cmdDividir;
    private JButton cmdMultiplicar;
    private JButton cmdRestar;
    private JButton cmdSumar;
    private JLabel lblResultado;
    private JTextField txtCampo1;
    private JTextField txtCampo2;

}
