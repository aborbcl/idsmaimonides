package edu.oscar.ejercicio.prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class CalculadoraViewSwing extends JFrame implements CalculadoraView{

	private JPanel contentPane;
	static JTextField num;
	static JTextField denum;
	static CalculadoraViewSwing frame;
	static JLabel label;
	static Calculadora cal;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					 frame = new CalculadoraViewSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public CalculadoraViewSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		num = new JTextField();
		num.setBounds(27, 11, 309, 38);
		contentPane.add(num);
		num.setColumns(10);
		
		denum = new JTextField();
		denum.setBounds(27, 74, 309, 38);
		contentPane.add(denum);
		denum.setColumns(10);
		
		JButton sumar = new JButton("+");
		sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sumar.addMouseListener(new sumarListener());
		sumar.setBounds(27, 169, 58, 53);
		contentPane.add(sumar);
		
		JButton restar = new JButton("-");
		restar.addMouseListener(new restaListener());

		restar.setBounds(109, 169, 58, 53);
		contentPane.add(restar);
		
		JButton multiplicar = new JButton("X");
		multiplicar.addMouseListener(new multiplicacionListener());
		multiplicar.setBounds(190, 169, 58, 53);
		contentPane.add(multiplicar);
		
		JButton dividir = new JButton("/");
		dividir.addMouseListener(new dividirListener());
		dividir.setBounds(269, 169, 58, 53);
		contentPane.add(dividir);
		
		 label = new JLabel("Resultado: ");
		 label.setBounds(27, 125, 300, 22);
		contentPane.add(label);
	}
	class sumarListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			if(!camposVacios()){

			double x = Double.parseDouble(num.getText());
			double y = Double.parseDouble(denum.getText());
			mostrarResultado(cal.Sumar(x,y).toString());
			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class restaListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			if(!camposVacios()){
			double x = Double.parseDouble(num.getText());
			double y = Double.parseDouble(denum.getText());
			mostrarResultado(cal.Restar(x,y).toString());
			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class multiplicacionListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			if(!camposVacios()){

			double x = Double.parseDouble(num.getText());
			double y = Double.parseDouble(denum.getText());
			mostrarResultado(cal.Multiplicar(x,y).toString());
			}
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class dividirListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			if(!camposVacios()){

			double x = Double.parseDouble(num.getText());
			double y = Double.parseDouble(denum.getText());
			try {
				mostrarResultado(cal.dividir(x,y).toString());
			} catch (CalculadoraException e) {
				mostrarError("No se puede dividir por 0");

				
			}
			}
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void mostrarCalculadora(Calculadora calculadora) {
		try {

			 frame = new CalculadoraViewSwing();
			frame.setVisible(true);
			cal=calculadora;
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void mostrarResultado(String resultado) {
		label.setText("Resultado: "+resultado);
	}
	public boolean camposVacios(){
		if(num.getText().isEmpty() || denum.getText().isEmpty()){
			mostrarError("Error: Alguno de los campos est� vac�o");
			return true;
			}
		else return false;
		
	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(
				   frame,
				   error);
		
	}



}
