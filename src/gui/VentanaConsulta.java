package gui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Operaciones.Persona;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaConsulta extends JFrame {

	private static String VentanaPrincipal;
	private static GraphicsConfiguration modal;
	private JTextArea textArea;
	



	
	public VentanaConsulta(VentanaPrincipal ventanaPrincipal, boolean b, Hashtable<String, Persona> tablaPersona) {
		super(VentanaPrincipal,modal);
		initialize();
		setLocationRelativeTo(null);
		
		
		mostrarListaPersona(tablaPersona);
		
		
		
	}



	private void mostrarListaPersona(Hashtable<String, Persona> tablaPersona) {
		
		String mensaje="";
		
		Enumeration<Persona> elemento=tablaPersona.elements();
		while(elemento.hasMoreElements()) {
			Persona persona =(Persona) elemento.nextElement();
			
			
		}
		textArea.setText(mensaje);
	}



	private void initialize() {
		setSize(300,208);
		
		textArea = new JTextArea();
		textArea.setBounds(10,33,264,102);
		getContentPane().setLayout(null);
		
	
		
		
		
	}
}
