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

public class frmEditarResponsable extends JFrame {

	private JPanel contentPane;
	public JTextField txtCedula_ResponsableE;
	public JTextField txtNombre_ResponsableE;
	public JTextField txtApellido_ResponsableE;
	public JTextField txtTelefono_responsableE;
	public JTextField txtParentesco_ResponsableE;
	public JButton btnGuardar_ResponsableE;
	public JButton btnCancelar_ResponsableE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarResponsable frame = new frmEditarResponsable();
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
	public frmEditarResponsable() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (739 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 739, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarResponsable = new JLabel("EDITAR RESPONSABLE");
		lblEditarResponsable.setBounds(332, 56, 146, 14);
		contentPane.add(lblEditarResponsable);
		
		JLabel lblNewLabel_1 = new JLabel("CÉDULA:");
		lblNewLabel_1.setBounds(148, 137, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCedula_ResponsableE = new JTextField();
		txtCedula_ResponsableE.setColumns(10);
		txtCedula_ResponsableE.setBounds(353, 134, 215, 20);
		contentPane.add(txtCedula_ResponsableE);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE:");
		lblNewLabel_1_1.setBounds(148, 189, 65, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtNombre_ResponsableE = new JTextField();
		txtNombre_ResponsableE.setColumns(10);
		txtNombre_ResponsableE.setBounds(353, 186, 215, 20);
		contentPane.add(txtNombre_ResponsableE);
		
		txtApellido_ResponsableE = new JTextField();
		txtApellido_ResponsableE.setColumns(10);
		txtApellido_ResponsableE.setBounds(353, 228, 215, 20);
		contentPane.add(txtApellido_ResponsableE);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO:");
		lblNewLabel_1_2.setBounds(148, 242, 77, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("TELÉFONO:");
		lblNewLabel_1_3.setBounds(148, 313, 65, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtTelefono_responsableE = new JTextField();
		txtTelefono_responsableE.setColumns(10);
		txtTelefono_responsableE.setBounds(353, 307, 215, 20);
		contentPane.add(txtTelefono_responsableE);
		
		txtParentesco_ResponsableE = new JTextField();
		txtParentesco_ResponsableE.setColumns(10);
		txtParentesco_ResponsableE.setBounds(353, 391, 215, 20);
		contentPane.add(txtParentesco_ResponsableE);
		
		JLabel lblNewLabel_1_4 = new JLabel("PARENTESCO:");
		lblNewLabel_1_4.setBounds(148, 394, 77, 14);
		contentPane.add(lblNewLabel_1_4);
		
		
		
		btnGuardar_ResponsableE = new JButton("EDITAR");
		btnGuardar_ResponsableE.setBounds(187, 552, 89, 23);
		contentPane.add(btnGuardar_ResponsableE);
		
		btnCancelar_ResponsableE = new JButton("CANCELAR");
		btnCancelar_ResponsableE.setBounds(365, 552, 89, 23);
		contentPane.add(btnCancelar_ResponsableE);
	}

}
