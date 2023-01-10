package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class frmNuevoDifunto extends JFrame {

	private JPanel contentPane;
	public JTextField txtCedula_Difunto;
	public JTextField txtNombre_Difunto;
	public JTextField txtApellido_Difunto;
	public JTextField txtEdad_Difunto;
	public JButton btnGuardar_Difunto;
	public JButton btnCancelar_Difunto;
	public JComboBox CboxGenero_Difunto;
	public JDateChooser CalendarFechaFallecimieto_Difunto;
	public JDateChooser CalendarFechaNacimieto_Difunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNuevoDifunto frame = new frmNuevoDifunto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmNuevoDifunto() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (739 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 739, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 38, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUEVO DIFUNTO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(279, 62, 210, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CÉDULA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(114, 175, 66, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(114, 240, 69, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("APELLIDO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(114, 308, 76, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FECHA FALLECIMIENTO:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(114, 373, 175, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FECHA NACIMIENTO:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(114, 438, 153, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("EDAD:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(114, 503, 45, 18);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("GENERO:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(114, 568, 66, 18);
		contentPane.add(lblNewLabel_7);
		
		txtCedula_Difunto = new JTextField();
		txtCedula_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCedula_Difunto.setBounds(309, 171, 253, 31);
		contentPane.add(txtCedula_Difunto);
		txtCedula_Difunto.setColumns(10);
		
		txtNombre_Difunto = new JTextField();
		txtNombre_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre_Difunto.setBounds(309, 234, 253, 31);
		contentPane.add(txtNombre_Difunto);
		txtNombre_Difunto.setColumns(10);
		
		btnGuardar_Difunto = new JButton("GUARDAR");
		btnGuardar_Difunto.setForeground(new Color(255, 255, 255));
		btnGuardar_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar_Difunto.setBackground(new Color(38, 156, 71));
		btnGuardar_Difunto.setBounds(202, 726, 162, 31);
		contentPane.add(btnGuardar_Difunto);
		
		btnCancelar_Difunto = new JButton("CANCELAR");
		btnCancelar_Difunto.setForeground(new Color(255, 255, 255));
		btnCancelar_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar_Difunto.setBackground(new Color(165, 43, 43));
		btnCancelar_Difunto.setBounds(384, 726, 162, 31);
		contentPane.add(btnCancelar_Difunto);
		
		txtApellido_Difunto = new JTextField();
		txtApellido_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellido_Difunto.setColumns(10);
		txtApellido_Difunto.setBounds(309, 297, 253, 31);
		contentPane.add(txtApellido_Difunto);
		
		txtEdad_Difunto = new JTextField();
		txtEdad_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdad_Difunto.setColumns(10);
		txtEdad_Difunto.setBounds(309, 490, 253, 31);
		contentPane.add(txtEdad_Difunto);
		
		CboxGenero_Difunto = new JComboBox();
		CboxGenero_Difunto.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMENINO"}));
		CboxGenero_Difunto.setBackground(new Color(0, 158, 227));
		CboxGenero_Difunto.setForeground(new Color(255, 255, 255));
		CboxGenero_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CboxGenero_Difunto.setBounds(309, 557, 253, 31);
		contentPane.add(CboxGenero_Difunto);
		
		CalendarFechaFallecimieto_Difunto = new JDateChooser();
		CalendarFechaFallecimieto_Difunto.setBackground(new Color(0, 158, 227));
		CalendarFechaFallecimieto_Difunto.setBounds(308, 360, 254, 31);
		contentPane.add(CalendarFechaFallecimieto_Difunto);
		
		CalendarFechaNacimieto_Difunto = new JDateChooser();
		CalendarFechaNacimieto_Difunto.setBounds(309, 427, 253, 31);
		contentPane.add(CalendarFechaNacimieto_Difunto);
	}
}
