package Interfaz;
import Metodos.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PicoPlaca {

	private JFrame frmClculoPicoY;
	private JTextField tfPlaca;
	private JTextField tfFecha;
	private JTextField tfRespuesta;
	private JTextField tfHora;

	/**
	 * Launch the application.
	 */
	calculoPicoPlaca calculo= new calculoPicoPlaca();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicoPlaca window = new PicoPlaca();
					window.frmClculoPicoY.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public PicoPlaca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClculoPicoY = new JFrame();
		frmClculoPicoY.setTitle("C\u00E1lculo Pico y Placa");
		frmClculoPicoY.setResizable(false);
		frmClculoPicoY.setBounds(100, 100, 570, 300);
		frmClculoPicoY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClculoPicoY.getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(40, 34, 46, 14);
		frmClculoPicoY.getContentPane().add(lblPlaca);
		
		tfPlaca = new JTextField();
		tfPlaca.setBounds(96, 31, 113, 20);
		frmClculoPicoY.getContentPane().add(tfPlaca);
		tfPlaca.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(40, 71, 46, 14);
		frmClculoPicoY.getContentPane().add(lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.setText("12/05/2017");
		tfFecha.setBounds(96, 68, 113, 20);
		frmClculoPicoY.getContentPane().add(tfFecha);
		tfFecha.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(40, 107, 46, 14);
		frmClculoPicoY.getContentPane().add(lblHora);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String fechai= obtFecha();
			String hora= obtHora();
			String placa= obtPlaca();
			String res=calculo.verificarHora(hora, fechai, placa);
			tfRespuesta.setText(res);
				}
		});
		btnCalcular.setBounds(96, 163, 89, 23);
		frmClculoPicoY.getContentPane().add(btnCalcular);
		
		tfRespuesta = new JTextField();
		tfRespuesta.setEditable(false);
		tfRespuesta.setBounds(114, 209, 47, 20);
		frmClculoPicoY.getContentPane().add(tfRespuesta);
		tfRespuesta.setColumns(10);
		
		JLabel lblElVehculo = new JLabel("El veh\u00EDculo ");
		lblElVehculo.setBounds(40, 211, 70, 17);
		frmClculoPicoY.getContentPane().add(lblElVehculo);
		
		JLabel lblPuedeCircularEn = new JLabel("puede circular a la hora y fecha ingresado.");
		lblPuedeCircularEn.setBounds(183, 211, 284, 17);
		frmClculoPicoY.getContentPane().add(lblPuedeCircularEn);
		
		tfHora = new JTextField();
		tfHora.setDropMode(DropMode.INSERT);
		tfHora.setText("hh:mm:ss");
		tfHora.setBounds(96, 104, 86, 20);
		frmClculoPicoY.getContentPane().add(tfHora);
		tfHora.setColumns(10);
	}
	
	public String obtFecha(){
	String fecha=tfFecha.getText();
	return fecha;
	}
	
	public String obtHora(){
	String hora=tfHora.getText();
	return hora;
	}
	
	public String obtPlaca(){
	String placa=tfPlaca.getText();
	return placa;
	}
	
}
