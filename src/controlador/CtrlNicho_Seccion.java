package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultasNicho;
import modelo.ConsultasSeccion;
import modelo.Nicho;
import modelo.Seccion;
import vista.frmNichos_Secciones;
import vista.frmSecciones;

public class CtrlNicho_Seccion implements ActionListener, ItemListener, MouseListener {
	
	private ConsultasSeccion modelConsultasSeccion;
	private Seccion modelSeccion;
	private Nicho modelNicho;
	private ConsultasNicho modelConsultasNicho;
	private frmNichos_Secciones view;
	private frmSecciones viewSecciones;
	private CtrlSeccion controllerSeccion;

	
	public CtrlNicho_Seccion(ConsultasSeccion modelConsultasSeccion, Seccion modelSeccion, Nicho modelNicho, ConsultasNicho modelConsultasNicho, frmNichos_Secciones view){
		this.modelConsultasSeccion = modelConsultasSeccion;
		this.modelSeccion = modelSeccion;
		this.modelNicho = modelNicho;
		this.modelConsultasNicho = modelConsultasNicho;
		this.view = view;
		this.view.CboxSecciones_NS.addItemListener(this);
		this.view.btnNuevaSeccion_NS.addActionListener(this);
		this.view.btnAgregarNicho_NS.addActionListener(this);
		this.view.btnEliminarSeccion_NS.addActionListener(this);
	}
	
	public void iniciarNichos_Secciones() {
		view.setTitle("Nichos y Secciones");
		llenarComboBoxes();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnNuevaSeccion_NS) {
			
			String nombreSeccion = JOptionPane.showInputDialog("ingrese nueva seccion");
			
			modelSeccion.setNombre(nombreSeccion);
			modelSeccion.setDescripcion("");

			if (modelConsultasSeccion.resgistrar(modelSeccion)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				view.CboxSecciones_NS.removeAllItems();
				llenarComboBoxes();
				view.CboxSecciones_NS.setSelectedIndex(view.CboxSecciones_NS.getItemCount()-1);
			}
		}
		
		if (e.getSource() == view.btnEliminarSeccion_NS) {
			
			modelSeccion = new Seccion();

			modelConsultasSeccion = new ConsultasSeccion();

			viewSecciones = new frmSecciones();

			controllerSeccion = new CtrlSeccion(modelSeccion, modelConsultasSeccion, viewSecciones);

			controllerSeccion.iniciarSecciones();

			viewSecciones.setVisible(true);
			
			/*Seccion seleccionado = (Seccion) view.CboxSecciones_NS.getSelectedItem();
			modelSeccion.setId(seleccionado.getId());

			int resp = JOptionPane.showConfirmDialog(null, "¿Deseas elimininar la sección: "+ seleccionado.getNombre() +" ?", "Selecciona una opción",
					JOptionPane.YES_NO_OPTION);
			if (JOptionPane.OK_OPTION == resp) {
				if (modelConsultasSeccion.eliminar(modelSeccion)) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
					view.CboxSecciones_NS.removeAllItems();
					llenarComboBoxes();
				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}*/

		}
		
		if (e.getSource() == view.btnAgregarNicho_NS) {
			Seccion seleccionado = (Seccion) view.CboxSecciones_NS.getSelectedItem();

			modelNicho.setId_seccion(seleccionado.getId());
			modelNicho.setEstado(view.CboxEstado_Nichos.getSelectedItem().toString());
			modelNicho.setNumero(Integer.parseInt(view.SpnNumero_Nichos.getValue().toString()));
			modelNicho.setTipo(view.CboxTipo_Nichos.getSelectedItem().toString());

			if (modelConsultasNicho.resgistrar(modelNicho)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				cargarDatosTabla(seleccionado.getId());

			}

		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == view.CboxSecciones_NS) {
 
			
			
				Seccion seleccionado = (Seccion) view.CboxSecciones_NS.getSelectedItem();
			if(seleccionado != null) {
				cargarDatosTabla(seleccionado.getId());
				view.lblNombreSeccion_NS.setText(seleccionado.getNombre());
			}
			
		}

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

				
				
				view.CboxSecciones_NS.addItem(modelSeccion);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		view.CboxEstado_Nichos.addItem("DISPONIBLE");
		view.CboxEstado_Nichos.addItem("NO DISPONIBLE");

		view.CboxTipo_Nichos.addItem("ADULTO");
		view.CboxTipo_Nichos.addItem("NIÑO");
	}
	
	public void cargarDatosTabla(int id) {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Id", "Número", "Sección", "Tipo", "Estado" });

		ResultSet rs = null;

		rs = modelConsultasNicho.listarNichosPorSeccion(id);

		try {
			while (rs.next()) {
				
				modelSeccion = new Seccion();
				modelSeccion.setId(rs.getInt("id_seccion"));
				modelSeccion.setNombre(rs.getString("nombre_seccion"));

				modelo.addRow(new Object[] { rs.getInt("id_nicho"), rs.getString("numero_nicho"), modelSeccion,
						rs.getString("tipo_nicho"), rs.getString("estado_nicho") });

			}

			view.tableNichos.setModel(modelo);
			view.tableNichos.getColumnModel().getColumn(0).setMaxWidth(0);
			view.tableNichos.getColumnModel().getColumn(0).setMinWidth(0);
			view.tableNichos.getColumnModel().getColumn(0).setPreferredWidth(0);
			
			

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
