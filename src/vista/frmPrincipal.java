package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	public JButton btnAbrirDifuntos_Main;
	public JButton btnAbrirArrendamientos_Main;
	public JButton btnabrirContratos_Main;
	public JButton btnAbrirSecciones_Main;
	public JButton btnAbrirNichos_Main;
	public JButton btnAbrirPropietarios_Main;
	public JButton btnCerrarSesion_Main;
	public JLabel lblNameUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		setBackground(Color.BLUE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int ancho = (int)d.getWidth();
		int alto = (int)d.getHeight();

		int x = (ancho / 2) - (1200 / 2);
		int y = (alto / 2) - (800 / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 38, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAbrirDifuntos_Main = new JButton("Difuntos");
		btnAbrirDifuntos_Main.setBackground(new Color(0, 156, 227));
		btnAbrirDifuntos_Main.setForeground(new Color(255, 255, 255));
		btnAbrirDifuntos_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAbrirDifuntos_Main.setBounds(474, 286, 253, 43);
		contentPane.add(btnAbrirDifuntos_Main);
		
		
		btnAbrirArrendamientos_Main = new JButton("Arrendamientos");
		btnAbrirArrendamientos_Main.setForeground(new Color(255, 255, 255));
		btnAbrirArrendamientos_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAbrirArrendamientos_Main.setBackground(new Color(0, 156, 227));
		btnAbrirArrendamientos_Main.setBounds(474, 210, 253, 43);
		contentPane.add(btnAbrirArrendamientos_Main);
		
		btnabrirContratos_Main = new JButton("Contratos");
		btnabrirContratos_Main.setBackground(new Color(0, 156, 227));
		btnabrirContratos_Main.setForeground(new Color(255, 255, 255));
		btnabrirContratos_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnabrirContratos_Main.setBounds(474, 438, 253, 43);
		contentPane.add(btnabrirContratos_Main);
		
		btnAbrirSecciones_Main = new JButton("Secciones");
		btnAbrirSecciones_Main.setBackground(new Color(0, 156, 227));
		btnAbrirSecciones_Main.setForeground(new Color(255, 255, 255));
		btnAbrirSecciones_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAbrirSecciones_Main.setBounds(474, 590, 253, 43);
		contentPane.add(btnAbrirSecciones_Main);
		
		btnAbrirNichos_Main = new JButton("Nichos");
		btnAbrirNichos_Main.setBackground(new Color(0, 156, 227));
		btnAbrirNichos_Main.setForeground(new Color(255, 255, 255));
		btnAbrirNichos_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAbrirNichos_Main.setBounds(474, 514, 253, 43);
		contentPane.add(btnAbrirNichos_Main);
		
		btnAbrirPropietarios_Main = new JButton("Propietarios");
		btnAbrirPropietarios_Main.setBackground(new Color(0, 156, 227));
		btnAbrirPropietarios_Main.setForeground(new Color(255, 255, 255));
		btnAbrirPropietarios_Main.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAbrirPropietarios_Main.setBounds(474, 362, 253, 43);
		contentPane.add(btnAbrirPropietarios_Main);
		
		JLabel lblNewLabel = new JLabel("CEMENTERIO DE LA PARROQUIA DE CONOCOTO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(318, 63, 593, 30);
		contentPane.add(lblNewLabel);
		
		lblNameUser = new JLabel("New label");
		lblNameUser.setForeground(Color.WHITE);
		lblNameUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameUser.setBounds(54, 700, 400, 24);
		contentPane.add(lblNameUser);
		
		btnCerrarSesion_Main = new JButton("Cerrar Sesión");
		btnCerrarSesion_Main.setForeground(Color.WHITE);
		btnCerrarSesion_Main.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCerrarSesion_Main.setBackground(new Color(197, 43, 43));
		btnCerrarSesion_Main.setBounds(970, 700, 202, 28);
		contentPane.add(btnCerrarSesion_Main);
	}
}
