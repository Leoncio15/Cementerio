package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSpinner;

public class frmNichos_Secciones extends JFrame {

	public JPanel contentPane;
	public JTable tableNichos;
	public JLabel lblNombreSeccion_NS;
	public JComboBox CboxEstado_Nichos;
	public JSpinner SpnNumero_Nichos;
	public JComboBox CboxTipo_Nichos;
	public JComboBox CboxSecciones_NS;
	public JButton btnEliminarNicho_NS;
	public JButton btnEditarNicho_NS;
	public JButton btnAgregarNicho_NS;
	public JButton btnNuevaSeccion_NS;
	public JButton btnEditarSeccion_NS;
	public JButton btnEliminarSeccion_NS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNichos_Secciones frame = new frmNichos_Secciones();
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
	public frmNichos_Secciones() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (1200 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 70, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SECCIONES");
		lblNewLabel.setBounds(585, 37, 174, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SELECCIONE UNA SECCIÓN:");
		lblNewLabel_1.setBounds(80, 101, 174, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		CboxSecciones_NS = new JComboBox();
		CboxSecciones_NS.setBounds(241, 97, 214, 22);
		contentPane.add(CboxSecciones_NS);
		
		btnNuevaSeccion_NS = new JButton("Nueva");
		btnNuevaSeccion_NS.setBounds(565, 97, 89, 23);
		contentPane.add(btnNuevaSeccion_NS);
		
		btnEditarSeccion_NS = new JButton("Editar");
		btnEditarSeccion_NS.setBounds(691, 97, 89, 23);
		contentPane.add(btnEditarSeccion_NS);
		
		 btnEliminarSeccion_NS = new JButton("Eliminar");
		btnEliminarSeccion_NS.setBounds(811, 97, 89, 23);
		contentPane.add(btnEliminarSeccion_NS);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 185, 606, 530);
		contentPane.add(scrollPane);
		
		tableNichos = new JTable();
		tableNichos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane.setViewportView(tableNichos);
		
		
		
		btnAgregarNicho_NS = new JButton("Agregar");
		btnAgregarNicho_NS.setBounds(781, 664, 89, 23);
		contentPane.add(btnAgregarNicho_NS);
		
		btnEditarNicho_NS = new JButton("Editar");
		btnEditarNicho_NS.setBounds(907, 664, 89, 23);
		contentPane.add(btnEditarNicho_NS);
		
		btnEliminarNicho_NS = new JButton("Eliminar");
		btnEliminarNicho_NS.setBounds(1027, 664, 89, 23);
		contentPane.add(btnEliminarNicho_NS);
		
		CboxTipo_Nichos = new JComboBox();
		CboxTipo_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxTipo_Nichos.setBackground(new Color(0, 156, 227));
		CboxTipo_Nichos.setBounds(861, 541, 255, 31);
		contentPane.add(CboxTipo_Nichos);
		
		JLabel lblNewLabel_3_1 = new JLabel("TIPO:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(720, 545, 102, 24);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("NÚMERO:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(720, 444, 115, 24);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		SpnNumero_Nichos = new JSpinner();
		SpnNumero_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SpnNumero_Nichos.setBackground(new Color(0, 156, 227));
		SpnNumero_Nichos.setBounds(861, 440, 255, 31);
		contentPane.add(SpnNumero_Nichos);
		
		CboxEstado_Nichos = new JComboBox();
		CboxEstado_Nichos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxEstado_Nichos.setBackground(new Color(0, 156, 227));
		CboxEstado_Nichos.setBounds(861, 339, 255, 31);
		contentPane.add(CboxEstado_Nichos);
		
		JLabel lblNewLabel_3 = new JLabel("ESTADO:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(720, 343, 102, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("SECCIÓN:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(720, 242, 102, 24);
		contentPane.add(lblNewLabel_2);
		
		lblNombreSeccion_NS = new JLabel("-");
		lblNombreSeccion_NS.setForeground(Color.WHITE);
		lblNombreSeccion_NS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreSeccion_NS.setBounds(861, 242, 255, 24);
		contentPane.add(lblNombreSeccion_NS);
	}
}
