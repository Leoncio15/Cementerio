package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;

public class frmResponsables extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JTable tableResponsables;
	public JButton btnNuevo_Responsables;
	public JButton btnEditar_Responsables;
	public JButton btnEliminar_Responsables;
	public JButton btnBuscar_Responsables;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmResponsables frame = new frmResponsables();
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
	public frmResponsables() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (1200 / 2);
		int y = (alto / 2) - (800 / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESPONSABLES");
		lblNewLabel.setBounds(434, 44, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUSCAR POR:");
		lblNewLabel_1.setBounds(45, 112, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 108, 108, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(265, 109, 383, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnBuscar_Responsables = new JButton("BUSCAR");
		btnBuscar_Responsables.setBounds(676, 108, 89, 23);
		contentPane.add(btnBuscar_Responsables);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 232, 1061, 381);
		contentPane.add(scrollPane);
		
		tableResponsables = new JTable();
		
		scrollPane.setViewportView(tableResponsables);
		
		
		
		btnNuevo_Responsables = new JButton("NUEVO");
		btnNuevo_Responsables.setBounds(277, 675, 89, 23);
		contentPane.add(btnNuevo_Responsables);
		
		btnEditar_Responsables = new JButton("EDITAR");
		btnEditar_Responsables.setBounds(399, 675, 89, 23);
		contentPane.add(btnEditar_Responsables);
		
		btnEliminar_Responsables = new JButton("ELIMINAR");
		btnEliminar_Responsables.setBounds(517, 675, 89, 23);
		contentPane.add(btnEliminar_Responsables);
	}
}
