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

public class frmNuevoResponsable extends JFrame {

	private JPanel contentPane;
	public JTextField txtCedula_ResponsableN;
	public JTextField txtNombre_ResponsableN;
	public JTextField txtApellido_ResponsableN;
	public JTextField txtTelefono_ResponsableN;
	public JTextField txtParentesco_ResponsableN;
	public JButton btnGuardar_ResponsableN;
	public JButton btnCancelar_ResponsableN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNuevoResponsable frame = new frmNuevoResponsable();
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
	public frmNuevoResponsable() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (739 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 739, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUEVO RESPONSABLE");
		lblNewLabel.setBounds(294, 29, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CÉDULA:");
		lblNewLabel_1.setBounds(110, 110, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE:");
		lblNewLabel_1_1.setBounds(110, 162, 65, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO:");
		lblNewLabel_1_2.setBounds(110, 215, 77, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("TELÉFONO:");
		lblNewLabel_1_3.setBounds(110, 286, 65, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("PARENTESCO:");
		lblNewLabel_1_4.setBounds(110, 367, 77, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txtCedula_ResponsableN = new JTextField();
		txtCedula_ResponsableN.setBounds(315, 107, 215, 20);
		contentPane.add(txtCedula_ResponsableN);
		txtCedula_ResponsableN.setColumns(10);
		
		txtNombre_ResponsableN = new JTextField();
		txtNombre_ResponsableN.setColumns(10);
		txtNombre_ResponsableN.setBounds(315, 159, 215, 20);
		contentPane.add(txtNombre_ResponsableN);
		
		txtApellido_ResponsableN = new JTextField();
		txtApellido_ResponsableN.setColumns(10);
		txtApellido_ResponsableN.setBounds(315, 201, 215, 20);
		contentPane.add(txtApellido_ResponsableN);
		
		txtTelefono_ResponsableN = new JTextField();
		txtTelefono_ResponsableN.setColumns(10);
		txtTelefono_ResponsableN.setBounds(315, 280, 215, 20);
		contentPane.add(txtTelefono_ResponsableN);
		
		txtParentesco_ResponsableN = new JTextField();
		txtParentesco_ResponsableN.setColumns(10);
		txtParentesco_ResponsableN.setBounds(315, 364, 215, 20);
		contentPane.add(txtParentesco_ResponsableN);
		
		
		btnGuardar_ResponsableN = new JButton("GUARDAR");
		btnGuardar_ResponsableN.setBounds(149, 525, 89, 23);
		contentPane.add(btnGuardar_ResponsableN);
		
		btnCancelar_ResponsableN = new JButton("CANCELAR");
		btnCancelar_ResponsableN.setBounds(327, 525, 89, 23);
		contentPane.add(btnCancelar_ResponsableN);
	}

}
