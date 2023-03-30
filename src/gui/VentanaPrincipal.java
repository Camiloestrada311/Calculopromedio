package gui;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.SwingConstants;

import Operaciones.Persona;
import Operaciones.Procesos;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;



public class  VentanaPrincipal extends JFrame implements ActionListener{

private JPanel panelPrincipal;
private JTextField txtNota3;
private JTextField txtNombre;
private JTextField txtDocumento;
private JTextField txtNota;
private JTextField txtNota2;
private JButton btnCalcular;
private double promedio;
private JLabel lblResPromedio;
private JLabel lblTotal;

Procesos misProcesos;
private JButton btnImprimir;
private JButton btnEliminar;

Hashtable<String,Persona> tablaPersona;
private JButton btnRegistrar;
private JButton btnBuscar;


public VentanaPrincipal() {
misProcesos=new Procesos();
setSize(491,382);
setTitle("Calcular Promedio");
setLocationRelativeTo(null);
setResizable(false);
iniciarComponentes();

tablaPersona =new Hashtable<String,Persona>();


}

private void iniciarComponentes() {
panelPrincipal = new JPanel();
setContentPane(panelPrincipal);
panelPrincipal.setLayout(null);

JLabel lblTitulo = new JLabel("Calcular Promedio");
lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
lblTitulo.setForeground(new Color(255, 0, 0));
lblTitulo.setOpaque(true);
lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
lblTitulo.setBounds(144, 11, 211, 31);
panelPrincipal.add(lblTitulo);

JLabel lblNota3 = new JLabel("Nota 3");
lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblNota3.setBounds(290, 180, 50, 17);
panelPrincipal.add(lblNota3);

txtNota3 = new JTextField();
txtNota3.setBounds(350, 180, 55, 20);
panelPrincipal.add(txtNota3);
txtNota3.setColumns(10);

txtNombre = new JTextField();
txtNombre.setColumns(10);
txtNombre.setBounds(122, 79, 292, 20);
panelPrincipal.add(txtNombre);

JLabel lblNombre = new JLabel("Nombre");
lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblNombre.setBounds(31, 82, 69, 17);
panelPrincipal.add(lblNombre);


JLabel lblDocumento= new JLabel("Documento");
lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblDocumento.setBounds(31, 129, 86, 17);
panelPrincipal.add(lblDocumento);

txtDocumento = new JTextField();
txtDocumento.setColumns(10);
txtDocumento.setBounds(122, 129, 292, 20);
panelPrincipal.add(txtDocumento);

JLabel lblNota = new JLabel("Nota 1");
lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblNota.setBounds(46, 183, 50, 17);
panelPrincipal.add(lblNota);

txtNota = new JTextField();
txtNota.setColumns(10);
txtNota.setBounds(100, 180, 50, 20);
panelPrincipal.add(txtNota);

txtNota2 = new JTextField();
txtNota2.setColumns(10);
txtNota2.setBounds(225, 180, 55, 20);
panelPrincipal.add(txtNota2);

JLabel lblNota2 = new JLabel("Nota 2");
lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblNota2.setBounds(165, 180, 50, 17);
panelPrincipal.add(lblNota2);

JLabel lblPromedio = new JLabel("Promedio:");
lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblPromedio.setBounds(31, 226, 231, 20);
panelPrincipal.add(lblPromedio);

lblResPromedio = new JLabel("");
lblResPromedio.setFont(new Font("Tahoma",Font.PLAIN,14));
lblResPromedio.setBounds(140,235,271,31);
panelPrincipal.add(lblResPromedio);

lblTotal = new JLabel("");
lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
lblTotal.setBounds(46, 269, 368, 14);
panelPrincipal.add(lblTotal);

btnCalcular = new JButton();
btnCalcular.setText("Calcular");
btnCalcular.setBounds(363, 227, 89, 23);
btnCalcular.addActionListener(this);
panelPrincipal.add(btnCalcular);

btnBuscar = new JButton("Buscar");
btnBuscar.setBounds(144, 294, 89, 23);
btnBuscar.addActionListener(this);
panelPrincipal.add(btnBuscar);

btnImprimir = new JButton("Imprimir");
btnImprimir.setBounds(243, 294, 89, 23);
btnImprimir.addActionListener(this);
panelPrincipal.add(btnImprimir);

btnEliminar = new JButton("Eliminar");
btnEliminar.setBounds(350, 294, 89, 23);
btnEliminar.addActionListener(this);
panelPrincipal.add(btnEliminar);

btnRegistrar = new JButton("Registrar");
btnRegistrar.setBounds(31, 294, 89, 23);
btnRegistrar.addActionListener(this);
panelPrincipal.add(btnRegistrar);
}

@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()== btnCalcular) {
CalcularPromedio();
}
if(e.getSource()== btnRegistrar) {
	registrarpersona(tablaPersona);
}
if(e.getSource()== btnBuscar) {
	consultarPersona(tablaPersona);
}

if(e.getSource()== btnImprimir) {
	VentanaConsulta ventanaconsulta=new VentanaConsulta(this,true,tablaPersona);
	ventanaconsulta.setVisible(true);
}
if(e.getSource()== btnEliminar) {
	eliminar(tablaPersona);
}
}

private void eliminar(Hashtable<String, Persona> tablaPersona) {
	String documento=JOptionPane.showInputDialog("Ingrese el documento del estudiante a eliminar");
	if(tablaPersona.containsKey(documento)) {
		tablaPersona.remove(documento);
	}else {
		JOptionPane.showMessageDialog(null, "El documento no existe", "Error", JOptionPane.WARNING_MESSAGE);
	}
	
}

private void consultarPersona(Hashtable<String, Persona> tablaPersona) {
	String mensaje="Datos de la persona\n";
	String documento = JOptionPane.showInputDialog("Ingresar el documento del estudiante");
	
	if (tablaPersona.containsKey(documento)== true) {
		Persona persona=tablaPersona.get(documento);
		mensaje+="Documento"+ persona.getDocumento()+ "\n";
		mensaje+="Nombre"+ Persona.getNombre()+ "\n";
		
		
		JOptionPane.showMessageDialog(null, mensaje);
	}else {
		JOptionPane.showMessageDialog(null, "El documento no existe", "Error", JOptionPane.WARNING_MESSAGE);
	}
	
}

private void registrarpersona(Hashtable<String, Persona> tablaPersona) {
	Persona miPersona=new Persona(); 
		miPersona.setDocumento(txtDocumento.getText());
		miPersona.setNombre(txtNombre.getText());
		/*miPersona.getNota1(Integer.parseInt(txtNota.getText()));
		miPersona.getNota2(Integer.parseInt(txtNota2.getText()));
		miPersona.getNota3(Integer.parseInt(txtNota3.getText()));*/
		
		if(tablaPersona.containsKey(miPersona.getDocumento())== false) {
			tablaPersona.put(miPersona.getDocumento(), miPersona);
			System.out.println("Almacenado");
		}else {
			JOptionPane.showMessageDialog(null, "El documento ya fue registrado", "Advertendcia", JOptionPane.WARNING_MESSAGE);
		}
		
}

private void CalcularPromedio() {
Persona estudiante = new Persona();

estudiante.setNombre(txtNombre.getText());

try {
estudiante.setNota1(Double.parseDouble(txtNota.getText()));
estudiante.setNota2(Double.parseDouble(txtNota2.getText()));
estudiante.setNota3(Double.parseDouble(txtNota3.getText()));

promedio=misProcesos.calcularPromedio(estudiante);

lblResPromedio.setText(promedio+"" );

String Total=misProcesos.calcularDefinitiva(estudiante.getPromedio());



} catch(NumberFormatException e) {
JOptionPane.showMessageDialog(null,"Error de ingreso de datos",
"Error", JOptionPane.ERROR_MESSAGE);
System.out.println(e.getMessage());

} catch(Exception e) {
JOptionPane.showMessageDialog(null,"No puedes ingresar letras, verifique los datos",
"Error", JOptionPane.ERROR_MESSAGE);
System.out.println("Este es el error" +e.getMessage());
e.printStackTrace();
}

}
}