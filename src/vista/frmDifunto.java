package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Toolkit;

public class frmDifunto extends JFrame {

	public JPanel contentPane;
	public JButton btnNuevo_Difunto;
	public JButton btnBuscar_Difunto;
	public JButton btnEditar_Difunto;
	public JButton btnEliminar_Difunto;
	public JComboBox CboxGenero_Difunto;
	public JTable tableDifunto;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDifunto frame = new frmDifunto();
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
	public frmDifunto() {
		
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
		
		JLabel lblNewLabel_1 = new JLabel("BUSCAR POR:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(120, 180, 136, 24);
		contentPane.add(lblNewLabel_1);
		
		btnNuevo_Difunto = new JButton("NUEVO");
		btnNuevo_Difunto.setForeground(new Color(255, 255, 255));
		btnNuevo_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNuevo_Difunto.setBackground(new Color(0, 158, 227));
		btnNuevo_Difunto.setBounds(304, 657, 162, 31);
		contentPane.add(btnNuevo_Difunto);
		
		btnBuscar_Difunto = new JButton("BUSCAR");
		btnBuscar_Difunto.setBackground(new Color(0, 158, 227));
		btnBuscar_Difunto.setForeground(new Color(255, 255, 255));
		btnBuscar_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar_Difunto.setBounds(884, 177, 162, 31);
		contentPane.add(btnBuscar_Difunto);
		
		btnEditar_Difunto = new JButton("EDITAR");
		btnEditar_Difunto.setBackground(new Color(0, 158, 227));
		btnEditar_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar_Difunto.setForeground(new Color(255, 255, 255));
		btnEditar_Difunto.setBounds(484, 657, 162, 31);
		contentPane.add(btnEditar_Difunto);
		
		btnEliminar_Difunto = new JButton("ELIMINAR");
		btnEliminar_Difunto.setForeground(new Color(255, 255, 255));
		btnEliminar_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar_Difunto.setBackground(new Color(0, 158, 227));
		btnEliminar_Difunto.setBounds(664, 657, 162, 31);
		contentPane.add(btnEliminar_Difunto);
		
		CboxGenero_Difunto = new JComboBox();
		CboxGenero_Difunto.setForeground(new Color(255, 255, 255));
		CboxGenero_Difunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CboxGenero_Difunto.setBackground(new Color(0, 158, 227));
		CboxGenero_Difunto.setModel(new DefaultComboBoxModel(new String[] {"CEDULA", "NOMBRE", "APELLIDO"}));
		CboxGenero_Difunto.setBounds(276, 177, 166, 31);
		contentPane.add(CboxGenero_Difunto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 232, 1061, 381);
		contentPane.add(scrollPane);
		
		tableDifunto = new JTable();
		tableDifunto.setBackground(Color.WHITE);
		tableDifunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		scrollPane.setViewportView(tableDifunto);
		
		JLabel lblNewLabel = new JLabel("DIFUNTOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(547, 62, 147, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(446, 177, 397, 31);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
