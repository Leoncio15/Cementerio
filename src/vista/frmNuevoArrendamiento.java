package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class frmNuevoArrendamiento extends JFrame {

	private JPanel contentPane;
	public JButton btnEditarDif_Arrendamiento;
	public JButton btnQuitarDif_Arrendamiento;
	public JButton btnGuardar_Arrendamiento;
	public JButton btnCancelar_Arrendamiento;
	public JButton btnAgregarDif_Arrendamiento;
	public JButton btnQuitarResp_Arrendamiento;
	public JButton btnEditarResp_Arrendamiento;
	public JButton btnAgregarResp_Arrendamiento;
	public JLabel lblFechaFallecimientoDif_Arrendamiento;
	public JLabel lblGeneroDif_Arrendamiento;
	public JLabel lblEdadDif_Arrendamiento;
	public JLabel lblApellidoDif_Arrendamiento;
	public JLabel lblNombreDif_Arrendamiento;
	public JLabel lblCedulaDif_Arrendamiento;
	public JLabel lblFechaVencimiento_Arrendamiento;
	public JLabel lblCedulaResp_Arrendamiento;
	public JLabel lblNombreResp_Arrendamiento;
	public JLabel lblApellidoResp_Arrendamiento;
	public JLabel lblTelefonoResp_Arrendamiento;
	public JLabel lblParentescoResp_Arrendamiento;
	public JLabel lblPeriodo_Arrendamiento;
	public JLabel lblIdDif_Arrendamiento;
	public JComboBox CboxNichos_Arrendamiento;
	public JComboBox CboxSeccion_Arrendamiento;
	public JLabel lblNumeroContrato_Arrendamiento;
	public JComboBox CboxTipoContrato_Arrendamiento;
	public JLabel lblFechaInicio_Arrendamiento;
	public JLabel lblIdResp_Arrendamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNuevoArrendamiento frame = new frmNuevoArrendamiento();
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
	public frmNuevoArrendamiento() {
		
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
		
		JLabel lblNewLabel = new JLabel("NUEVO ARRENDAMIENTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(429, 42, 139, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO DE CONTRATO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(104, 98, 161, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NÚMERO DE CONTRATO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(104, 123, 181, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("SECCIÓN:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(104, 148, 139, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("FECHA DE INICIO:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(104, 198, 139, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("NICHO:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(104, 173, 103, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("PERIODO:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(104, 248, 139, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("FECHA DE VENCIMIENTO:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(104, 223, 181, 14);
		contentPane.add(lblNewLabel_1_3);
		
		
		CboxTipoContrato_Arrendamiento = new JComboBox();
		CboxTipoContrato_Arrendamiento.setModel(new DefaultComboBoxModel(new String[] {"INDEFINIDO", "DEFINIDO"}));
		CboxTipoContrato_Arrendamiento.setBounds(295, 94, 148, 18);
		contentPane.add(CboxTipoContrato_Arrendamiento);
		
		lblNumeroContrato_Arrendamiento = new JLabel("-");
		lblNumeroContrato_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroContrato_Arrendamiento.setForeground(Color.WHITE);
		lblNumeroContrato_Arrendamiento.setBounds(295, 123, 148, 14);
		contentPane.add(lblNumeroContrato_Arrendamiento);
		
		CboxSeccion_Arrendamiento = new JComboBox();
		CboxSeccion_Arrendamiento.setBounds(295, 144, 148, 22);
		contentPane.add(CboxSeccion_Arrendamiento);
		
		CboxNichos_Arrendamiento = new JComboBox();
		CboxNichos_Arrendamiento.setBounds(295, 169, 148, 18);
		contentPane.add(CboxNichos_Arrendamiento);
		
		lblFechaVencimiento_Arrendamiento = new JLabel("-");
		lblFechaVencimiento_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVencimiento_Arrendamiento.setForeground(Color.WHITE);
		lblFechaVencimiento_Arrendamiento.setBounds(295, 223, 148, 14);
		contentPane.add(lblFechaVencimiento_Arrendamiento);
		
		lblPeriodo_Arrendamiento = new JLabel("-");
		lblPeriodo_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodo_Arrendamiento.setForeground(Color.WHITE);
		lblPeriodo_Arrendamiento.setBounds(295, 248, 148, 14);
		contentPane.add(lblPeriodo_Arrendamiento);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(117, 346, 377, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("PARENTESCO:");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_2.setBounds(10, 125, 139, 14);
		panel.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("TELEFONO:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(10, 100, 132, 14);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("APELLIDO:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(10, 75, 139, 14);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 50, 103, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CÉDULA:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 25, 139, 14);
		panel.add(lblNewLabel_2_1_1);
		
		
		
		lblCedulaResp_Arrendamiento = new JLabel("-");
		lblCedulaResp_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedulaResp_Arrendamiento.setBounds(170, 25, 180, 14);
		panel.add(lblCedulaResp_Arrendamiento);
		
		lblNombreResp_Arrendamiento = new JLabel("-");
		lblNombreResp_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreResp_Arrendamiento.setBounds(170, 50, 180, 14);
		panel.add(lblNombreResp_Arrendamiento);
		
		lblApellidoResp_Arrendamiento = new JLabel("-");
		lblApellidoResp_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidoResp_Arrendamiento.setBounds(170, 75, 180, 14);
		panel.add(lblApellidoResp_Arrendamiento);
		
		lblTelefonoResp_Arrendamiento = new JLabel("-");
		lblTelefonoResp_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonoResp_Arrendamiento.setBounds(170, 100, 180, 14);
		panel.add(lblTelefonoResp_Arrendamiento);
		
		lblParentescoResp_Arrendamiento = new JLabel("-");
		lblParentescoResp_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParentescoResp_Arrendamiento.setBounds(170, 125, 180, 14);
		panel.add(lblParentescoResp_Arrendamiento);
		
		lblIdResp_Arrendamiento = new JLabel("-");
		lblIdResp_Arrendamiento.setBounds(10, 0, 46, 14);
		panel.add(lblIdResp_Arrendamiento);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("RESPONSABLE:");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(104, 320, 139, 14);
		contentPane.add(lblNewLabel_2_3_1);
		
		
		
		
		btnAgregarResp_Arrendamiento = new JButton("AGREGAR RESPONSABLE");
		btnAgregarResp_Arrendamiento.setBounds(252, 316, 191, 23);
		contentPane.add(btnAgregarResp_Arrendamiento);
		
		btnEditarResp_Arrendamiento = new JButton("EDITAR");
		btnEditarResp_Arrendamiento.setBounds(176, 553, 89, 23);
		contentPane.add(btnEditarResp_Arrendamiento);
		
		btnQuitarResp_Arrendamiento = new JButton("QUITAR");
		btnQuitarResp_Arrendamiento.setBounds(288, 553, 89, 23);
		contentPane.add(btnQuitarResp_Arrendamiento);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("DIFUNTO:");
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_3_1_1.setBounds(597, 320, 139, 14);
		contentPane.add(lblNewLabel_2_3_1_1);
		
		btnAgregarDif_Arrendamiento = new JButton("AGREGAR DIFUNTO");
		btnAgregarDif_Arrendamiento.setBounds(745, 316, 166, 23);
		contentPane.add(btnAgregarDif_Arrendamiento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(597, 345, 377, 187);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("GÉNERO:");
		lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_2_1.setBounds(10, 125, 139, 14);
		panel_1.add(lblNewLabel_2_3_2_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("EDAD:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(10, 100, 132, 14);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("APELLIDO:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(10, 75, 139, 14);
		panel_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("NOMBRE:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 50, 103, 14);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CÉDULA:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 25, 139, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
				
		lblCedulaDif_Arrendamiento = new JLabel("-");
		lblCedulaDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedulaDif_Arrendamiento.setBounds(170, 25, 175, 14);
		panel_1.add(lblCedulaDif_Arrendamiento);
		
		lblNombreDif_Arrendamiento = new JLabel("-");
		lblNombreDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDif_Arrendamiento.setBounds(170, 50, 175, 14);
		panel_1.add(lblNombreDif_Arrendamiento);
		
		lblApellidoDif_Arrendamiento = new JLabel("-");
		lblApellidoDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidoDif_Arrendamiento.setBounds(170, 75, 175, 14);
		panel_1.add(lblApellidoDif_Arrendamiento);
		
		lblEdadDif_Arrendamiento = new JLabel("-");
		lblEdadDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdadDif_Arrendamiento.setBounds(170, 100, 175, 14);
		panel_1.add(lblEdadDif_Arrendamiento);	
		
		
		lblGeneroDif_Arrendamiento = new JLabel("-");
		lblGeneroDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGeneroDif_Arrendamiento.setBounds(170, 125, 175, 14);
		panel_1.add(lblGeneroDif_Arrendamiento);
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("FECHA FALLECIMIENTO:");
		lblNewLabel_2_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_2_1_1.setBounds(10, 150, 156, 14);
		panel_1.add(lblNewLabel_2_3_2_1_1);
		
		lblFechaFallecimientoDif_Arrendamiento = new JLabel("-");
		lblFechaFallecimientoDif_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFallecimientoDif_Arrendamiento.setBounds(170, 150, 175, 14);
		panel_1.add(lblFechaFallecimientoDif_Arrendamiento);
		
		lblIdDif_Arrendamiento = new JLabel("-");
		lblIdDif_Arrendamiento.setBounds(10, 0, 46, 14);
		panel_1.add(lblIdDif_Arrendamiento);
		
		btnEditarDif_Arrendamiento = new JButton("EDITAR");
		btnEditarDif_Arrendamiento.setBounds(669, 553, 89, 23);
		contentPane.add(btnEditarDif_Arrendamiento);
		
		btnQuitarDif_Arrendamiento = new JButton("QUITAR");
		btnQuitarDif_Arrendamiento.setBounds(781, 553, 89, 23);
		contentPane.add(btnQuitarDif_Arrendamiento);
		
		btnGuardar_Arrendamiento = new JButton("GUARDAR");
		btnGuardar_Arrendamiento.setBounds(370, 698, 89, 23);
		contentPane.add(btnGuardar_Arrendamiento);
		
		btnCancelar_Arrendamiento = new JButton("CANCELAR");
		btnCancelar_Arrendamiento.setBounds(494, 698, 89, 23);
		contentPane.add(btnCancelar_Arrendamiento);
		
		lblFechaInicio_Arrendamiento = new JLabel("-");
		lblFechaInicio_Arrendamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaInicio_Arrendamiento.setForeground(Color.WHITE);
		lblFechaInicio_Arrendamiento.setBounds(295, 198, 148, 14);
		contentPane.add(lblFechaInicio_Arrendamiento);
	}
}
