package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class frmNichos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JTable tableNichos;
	public JComboBox CBoxBuscar_Nichos;
	public JButton btnEliminar_Nichos;
	public JButton btnEditar_Nichos;
	public JButton btnAgregar_Nichos;
	public JComboBox CboxSecciones_Nichos;
	public JComboBox CboxEstado_Nichos;
	public JSpinner SpnNumero_Nichos;
	public JComboBox CboxTipo_Nichos;
	public JLabel lblId;
	public JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNichos frame = new frmNichos();
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
	public frmNichos() {
		
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
		
		JLabel lblNichos = new JLabel("NICHOS");
		lblNichos.setForeground(Color.WHITE);
		lblNichos.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNichos.setBounds(547, 64, 106, 30);
		contentPane.add(lblNichos);
		
		JButton btnBuscar_Nichos = new JButton("BUSCAR");
		btnBuscar_Nichos.setForeground(Color.WHITE);
		btnBuscar_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar_Nichos.setBackground(new Color(0, 156, 227));
		btnBuscar_Nichos.setBounds(547, 126, 106, 31);
		contentPane.add(btnBuscar_Nichos);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(288, 126, 253, 31);
		contentPane.add(textField);
		
		
		
		CBoxBuscar_Nichos = new JComboBox();
		CBoxBuscar_Nichos.setForeground(Color.WHITE);
		CBoxBuscar_Nichos.setBackground(new Color(0, 156, 227));
		CBoxBuscar_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CBoxBuscar_Nichos.setBounds(176, 126, 106, 31);
		contentPane.add(CBoxBuscar_Nichos);
		
		JLabel lblNewLabel_1 = new JLabel("BUSCAR POR:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(47, 130, 138, 24);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 185, 606, 530);
		contentPane.add(scrollPane);
		
		tableNichos = new JTable();
		tableNichos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane.setViewportView(tableNichos);
		
		JLabel lblNewLabel_2 = new JLabel("SECCIÓN:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(725, 237, 102, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ESTADO:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(725, 338, 102, 24);
		contentPane.add(lblNewLabel_3);
		
		
		
		btnEliminar_Nichos = new JButton("ELIMINAR");
		btnEliminar_Nichos.setForeground(Color.WHITE);
		btnEliminar_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar_Nichos.setBackground(new Color(0, 156, 227));
		btnEliminar_Nichos.setBounds(1020, 684, 132, 31);
		contentPane.add(btnEliminar_Nichos);
		
		btnEditar_Nichos = new JButton("EDITAR");
		btnEditar_Nichos.setForeground(Color.WHITE);
		btnEditar_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar_Nichos.setBackground(new Color(0, 156, 227));
		btnEditar_Nichos.setBounds(872, 684, 132, 31);
		contentPane.add(btnEditar_Nichos);
		
		btnAgregar_Nichos = new JButton("AGREGAR");
		btnAgregar_Nichos.setForeground(Color.WHITE);
		btnAgregar_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregar_Nichos.setBackground(new Color(0, 156, 227));
		btnAgregar_Nichos.setBounds(725, 684, 132, 31);
		contentPane.add(btnAgregar_Nichos);
		
		JLabel lblNewLabel_2_1 = new JLabel("NÚMERO:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(725, 439, 115, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("TIPO:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(725, 540, 102, 24);
		contentPane.add(lblNewLabel_3_1);
		
		CboxSecciones_Nichos = new JComboBox();
		CboxSecciones_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxSecciones_Nichos.setBackground(new Color(0, 156, 227));
		CboxSecciones_Nichos.setBounds(866, 233, 255, 31);
		contentPane.add(CboxSecciones_Nichos);
		
		CboxEstado_Nichos = new JComboBox();
		CboxEstado_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxEstado_Nichos.setBackground(new Color(0, 156, 227));
		CboxEstado_Nichos.setBounds(866, 334, 255, 31);
		contentPane.add(CboxEstado_Nichos);
		
		
		
		SpnNumero_Nichos = new JSpinner();
		SpnNumero_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SpnNumero_Nichos.setBackground(new Color(0, 156, 227));
		SpnNumero_Nichos.setBounds(866, 435, 255, 31);
		contentPane.add(SpnNumero_Nichos);
		
		CboxTipo_Nichos = new JComboBox();
		CboxTipo_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxTipo_Nichos.setBackground(new Color(0, 156, 227));
		CboxTipo_Nichos.setBounds(866, 536, 255, 31);
		contentPane.add(CboxTipo_Nichos);
		
		txtId = new JTextField();
		txtId.setBounds(939, 173, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
	}
}
