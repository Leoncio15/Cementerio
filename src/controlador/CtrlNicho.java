package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultasNicho;
import modelo.ConsultasSeccion;
import modelo.Nicho;
import modelo.Seccion;
import vista.frmNichos;

public class CtrlNicho implements ActionListener, ItemListener, MouseListener {

	private frmNichos viewNicho;
	private ConsultasSeccion modelConsultasSeccion;
	private Seccion modelSeccion;
	private Nicho modelNicho;
	private ConsultasNicho modelConsultasNicho;

	public CtrlNicho(frmNichos viewNicho, ConsultasSeccion modelConsultasSeccion, Nicho modelNicho,
			ConsultasNicho modelConsultasNicho) {
		this.viewNicho = viewNicho;
		this.modelConsultasSeccion = modelConsultasSeccion;
		this.modelNicho = modelNicho;
		this.modelConsultasNicho = modelConsultasNicho;
		this.viewNicho.CboxSecciones_Nichos.addItemListener(this);
		this.viewNicho.btnAgregar_Nichos.addActionListener(this);
		this.viewNicho.tableNichos.addMouseListener(this);
	}

	public void iniciarNicho() {
		viewNicho.setTitle("Nichos");
		viewNicho.setLocationRelativeTo(null);
		llenarComboBoxes();
		cargarDatosTabla();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == viewNicho.btnAgregar_Nichos) {
			Seccion seleccionado = (Seccion) viewNicho.CboxSecciones_Nichos.getSelectedItem();

			modelNicho.setId_seccion(seleccionado.getId());
			modelNicho.setEstado(viewNicho.CboxEstado_Nichos.getSelectedItem().toString());
			modelNicho.setNumero(Integer.parseInt(viewNicho.SpnNumero_Nichos.getValue().toString()));
			modelNicho.setTipo(viewNicho.CboxTipo_Nichos.getSelectedItem().toString());

			if (modelConsultasNicho.resgistrar(modelNicho)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				cargarDatosTabla();

			}

		}

		if (e.getSource() == viewNicho.btnEditar_Nichos) {
			
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub.
		if (e.getSource() == viewNicho.tableNichos) {
			
			int row = viewNicho.tableNichos.getSelectedRow();
			
			Seccion seleccionado = (Seccion) viewNicho.tableNichos.getValueAt(row, 2);
		
			viewNicho.txtId.setText(seleccionado.getNombre());
			viewNicho.SpnNumero_Nichos.setValue(Integer.parseInt((String) viewNicho.tableNichos.getValueAt(row, 1)));
			
			viewNicho.CboxTipo_Nichos.setSelectedItem((String) viewNicho.tableNichos.getValueAt(row, 3));
			viewNicho.CboxEstado_Nichos.setSelectedItem((String) viewNicho.tableNichos.getValueAt(row, 4));

		}

	}

	public void itemStateChanged(ItemEvent e) {

		/*if (e.getSource() == viewNicho.CboxSecciones_Nichos) {

			Seccion seleccionado = (Seccion) viewNicho.CboxSecciones_Nichos.getSelectedItem();

			viewNicho.txtId.setText(String.valueOf(seleccionado.getId()));
		}*/

	}

	public void llenarComboBoxes() {
		ResultSet rs = null;

		rs = modelConsultasSeccion.listarSecciones();

		try {
			while (rs.next()) {

				// String nombre = rs.getString("id_seccion") + " " +
				// rs.getString("nombre_seccion");
				// Se arega un nuevo ítem al combobox
				modelSeccion = new Seccion();

				modelSeccion.setId(rs.getInt("id_seccion"));
				modelSeccion.setNombre(rs.getString("nombre_seccion"));

				viewNicho.CboxSecciones_Nichos.addItem(modelSeccion);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		viewNicho.CboxEstado_Nichos.addItem("DISPONIBLE");
		viewNicho.CboxEstado_Nichos.addItem("NO DISPONIBLE");

		viewNicho.CboxTipo_Nichos.addItem("ADULTO");
		viewNicho.CboxTipo_Nichos.addItem("NIÑO");
	}

	public void cargarDatosTabla() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Id", "Número", "Sección", "Tipo", "Estado" });

		ResultSet rs = null;

		rs = modelConsultasNicho.listarNichos();

		try {
			while (rs.next()) {
				
				modelSeccion = new Seccion();
				modelSeccion.setId(rs.getInt("id_seccion"));
				modelSeccion.setNombre(rs.getString("nombre_seccion"));

				modelo.addRow(new Object[] { rs.getInt("id_nicho"), rs.getString("numero_nicho"), modelSeccion,
						rs.getString("tipo_nicho"), rs.getString("estado_nicho") });

			}

			viewNicho.tableNichos.setModel(modelo);
			viewNicho.tableNichos.getColumnModel().getColumn(0).setMaxWidth(0);
			viewNicho.tableNichos.getColumnModel().getColumn(0).setMinWidth(0);
			viewNicho.tableNichos.getColumnModel().getColumn(0).setPreferredWidth(0);
			
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
