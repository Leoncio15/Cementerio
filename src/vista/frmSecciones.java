package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class frmSecciones extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	public JTable tableSecciones;
	public JTextField txtNombre_Secciones;
	public JButton btnBuscar_Secciones;
	public JTextArea txtDescripcion_Secciones;
	public JButton btnAgregar_Secciones;
	public JButton btnEditar_Secciones;
	public JButton btnEliminar_Secciones;
	public JLabel lblId_Seccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSecciones frame = new frmSecciones();
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
	public frmSecciones() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (1200 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 38, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SECCIONES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(531, 44, 146, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUSCAR POR:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(47, 130, 138, 24);
		contentPane.add(lblNewLabel_1);
		
		JComboBox CBoxOpciones_Secciones = new JComboBox();
		CBoxOpciones_Secciones.setForeground(Color.WHITE);
		CBoxOpciones_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CBoxOpciones_Secciones.setBackground(new Color(0, 156, 227));
		CBoxOpciones_Secciones.setBounds(176, 126, 106, 31);
		contentPane.add(CBoxOpciones_Secciones);
		
		textField = new JTextField();
		textField.setBounds(288, 126, 253, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar_Secciones = new JButton("BUSCAR");
		btnBuscar_Secciones.setForeground(Color.WHITE);
		btnBuscar_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar_Secciones.setBackground(new Color(0, 156, 227));
		btnBuscar_Secciones.setBounds(547, 126, 106, 31);
		contentPane.add(btnBuscar_Secciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 185, 606, 530);
		contentPane.add(scrollPane);
		
		tableSecciones = new JTable();
		tableSecciones.setSelectionForeground(Color.WHITE);
		tableSecciones.setSelectionBackground(new Color(0, 156, 227));
		tableSecciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane.setViewportView(tableSecciones);
		
		
		txtNombre_Secciones = new JTextField();
		txtNombre_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre_Secciones.setBounds(828, 224, 336, 31);
		contentPane.add(txtNombre_Secciones);
		txtNombre_Secciones.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(665, 228, 92, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DESCRIPCIÓN:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(665, 324, 141, 24);
		contentPane.add(lblNewLabel_3);
		
		
		txtDescripcion_Secciones = new JTextArea();
		txtDescripcion_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescripcion_Secciones.setBounds(828, 329, 336, 108);
		contentPane.add(txtDescripcion_Secciones);
		
		btnAgregar_Secciones = new JButton("AGREGAR");
		btnAgregar_Secciones.setForeground(Color.WHITE);
		btnAgregar_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregar_Secciones.setBackground(new Color(0, 156, 227));
		btnAgregar_Secciones.setBounds(725, 684, 132, 31);
		contentPane.add(btnAgregar_Secciones);
		
		btnEditar_Secciones = new JButton("EDITAR");
		btnEditar_Secciones.setForeground(Color.WHITE);
		btnEditar_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar_Secciones.setBackground(new Color(0, 156, 227));
		btnEditar_Secciones.setBounds(872, 684, 132, 31);
		contentPane.add(btnEditar_Secciones);
		btnEliminar_Secciones = new JButton("ELIMINAR");
		btnEliminar_Secciones.setForeground(Color.WHITE);
		btnEliminar_Secciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar_Secciones.setBackground(new Color(0, 156, 227));
		btnEliminar_Secciones.setBounds(1020, 684, 132, 31);
		contentPane.add(btnEliminar_Secciones);
		
		lblId_Seccion = new JLabel("");
		lblId_Seccion.setVisible(false);
		lblId_Seccion.setBounds(896, 112, 46, 14);
		contentPane.add(lblId_Seccion);
	}
}
