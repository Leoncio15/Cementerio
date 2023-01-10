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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;

public class frmArrendamientos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JTable tableArrendamientos;
	public JComboBox CBoxOpciones_Arrendamiento;
	public JButton btnBuscar_Arrendamiento;
	public JButton btnNuevoArrendamiento;
	public JButton btnNuevaOcupacion;
	public JButton btnDetalles_Arrendamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmArrendamientos frame = new frmArrendamientos();
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
	public frmArrendamientos() {
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
		
		JLabel lblNewLabel = new JLabel("ARRENDAMIENTOS");
		lblNewLabel.setBounds(603, 23, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUSCAR POR:");
		lblNewLabel_1.setBounds(81, 105, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		CBoxOpciones_Arrendamiento = new JComboBox();
		CBoxOpciones_Arrendamiento.setModel(new DefaultComboBoxModel(new String[] {"CÉDULA", "NOMBRE", "APELLIDO", "CONTRATOS", "NICHOS", "SECCIONES"}));
		CBoxOpciones_Arrendamiento.setBounds(224, 101, 105, 18);
		contentPane.add(CBoxOpciones_Arrendamiento);
		
		textField = new JTextField();
		textField.setBounds(340, 102, 338, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnBuscar_Arrendamiento = new JButton("BUSCAR");
		btnBuscar_Arrendamiento.setBounds(720, 101, 89, 23);
		contentPane.add(btnBuscar_Arrendamiento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 232, 1061, 381);
		contentPane.add(scrollPane);
		
		tableArrendamientos = new JTable();
		
		scrollPane.setViewportView(tableArrendamientos);
		
		btnNuevoArrendamiento = new JButton("NUEVO ARRENDAMIENTO");
		btnNuevoArrendamiento.setBounds(235, 659, 202, 23);
		contentPane.add(btnNuevoArrendamiento);
		
		btnNuevaOcupacion = new JButton("NUEVA OCUPACIÓN");
		btnNuevaOcupacion.setBounds(485, 659, 158, 23);
		contentPane.add(btnNuevaOcupacion);
		
		btnDetalles_Arrendamiento = new JButton("VER DETALLES");
		btnDetalles_Arrendamiento.setBounds(720, 659, 139, 23);
		contentPane.add(btnDetalles_Arrendamiento);
	}
}
