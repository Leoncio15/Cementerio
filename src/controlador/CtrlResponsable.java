package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultasDifunto;
import modelo.ConsultasResponsable;
import modelo.Difunto;
import modelo.Responsable;
import vista.frmDifunto;
import vista.frmEditarDifunto;
import vista.frmEditarResponsable;
import vista.frmNuevoArrendamiento;
import vista.frmNuevoDifunto;
import vista.frmNuevoResponsable;
import vista.frmResponsables;

public class CtrlResponsable implements ActionListener {

	private Responsable model;
	private ConsultasResponsable modelCons;
	private frmNuevoResponsable view;
	private frmResponsables viewResponsable;
	private frmEditarResponsable viewEditarResponsable;
	private frmNuevoArrendamiento viewNuevoArrendamiento;

	public CtrlResponsable(Responsable model, ConsultasResponsable modelCons, frmNuevoResponsable view, frmResponsables viewResponsable,
			frmEditarResponsable viewEditarResponsable, frmNuevoArrendamiento viewNuevoArrendamiento) {
		this.model = model;
		this.modelCons = modelCons;
		this.view = view;
		this.viewResponsable = viewResponsable;
		this.viewEditarResponsable = viewEditarResponsable;
		this.viewNuevoArrendamiento = viewNuevoArrendamiento;
		this.view.btnGuardar_ResponsableN.addActionListener(this);
		this.viewResponsable.btnNuevo_Responsables.addActionListener(this);
		this.viewResponsable.btnEditar_Responsables.addActionListener(this);
		this.viewResponsable.btnEliminar_Responsables.addActionListener(this);
		this.viewEditarResponsable.btnGuardar_ResponsableE.addActionListener(this);
		/*
		 * this.view.btnModificar_Difunto.addActionListener(this);
		 * this.view.btnEliminar_Difunto.addActionListener(this);
		 * this.view.btnLimpiar_Difunto.addActionListener(this);
		 * this.view.btnBuscar_Difunto.addActionListener(this);
		 */
	}

	public void iniciarResponsables() {
		viewResponsable.setTitle("Responsables");
		viewResponsable.setLocationRelativeTo(null);
		cargarDatosTabla();
	}

	public void iniciarNuevoResponsable() {
		view.setTitle("Nuevo Responsable");
		view.setLocationRelativeTo(null);
	}

	public void iniciarEditarResponsable() {
		view.setTitle("Editar Responsable");
		view.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.btnGuardar_ResponsableN) {
 
			model.setCedula(view.txtCedula_ResponsableN.getText());
			model.setNombre(view.txtNombre_ResponsableN.getText());
			model.setApellido(view.txtApellido_ResponsableN.getText());
			model.setTelefono(view.txtTelefono_ResponsableN.getText());
			model.setParentesco(view.txtParentesco_ResponsableN.getText());;

			if (modelCons.registrar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				cargarDatosTabla();
				limpiar();
				view.setVisible(false);
				if(!view.isVisible()) {
					
					if (modelCons.buscar(model)) {
						viewNuevoArrendamiento.lblIdResp_Arrendamiento.setText(String.valueOf(model.getId()));
						viewNuevoArrendamiento.lblCedulaResp_Arrendamiento.setText(model.getCedula());
						viewNuevoArrendamiento.lblNombreResp_Arrendamiento.setText(model.getNombre());
						viewNuevoArrendamiento.lblApellidoResp_Arrendamiento.setText(model.getApellido());
						viewNuevoArrendamiento.lblTelefonoResp_Arrendamiento.setText(model.getTelefono());
						viewNuevoArrendamiento.lblParentescoResp_Arrendamiento.setText(model.getParentesco());
						
						
					}					
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error al guardar");
				limpiar();
			}
		}

		if (e.getSource() == viewResponsable.btnNuevo_Responsables) {

			iniciarNuevoResponsable();
			view.setVisible(true);
		}

		if (e.getSource() == viewEditarResponsable.btnGuardar_ResponsableE) {
			model.setCedula(viewEditarResponsable.txtCedula_ResponsableE.getText());
			model.setNombre(viewEditarResponsable.txtNombre_ResponsableE.getText());
			model.setApellido(viewEditarResponsable.txtApellido_ResponsableE.getText());
			model.setTelefono(viewEditarResponsable.txtTelefono_responsableE.getText());
			model.setParentesco(viewEditarResponsable.txtParentesco_ResponsableE.getText());;

			if (modelCons.modificar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();
				cargarDatosTabla();
				viewEditarResponsable.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Error al modificar");
				limpiar();
			}
		}

		if (e.getSource() == viewResponsable.btnEliminar_Responsables) {

			int row = viewResponsable.tableResponsables.getSelectedRow();
			String cedula = (String) viewResponsable.tableResponsables.getValueAt(row, 0);
			String nombre = (String) viewResponsable.tableResponsables.getValueAt(row, 1);
			String apellido = (String) viewResponsable.tableResponsables.getValueAt(row, 2);

			model.setCedula(cedula);

			int resp = JOptionPane.showConfirmDialog(null,"¿Deseas elimininar el registro: " + nombre + " " + apellido + " ?", "Selecciona una opción", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.OK_OPTION == resp) {
				if (modelCons.eliminar(model)) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
					cargarDatosTabla();
				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}

		}

		if (e.getSource() == viewResponsable.btnEditar_Responsables) {

			int row = viewResponsable.tableResponsables.getSelectedRow();
			String cedula = (String) viewResponsable.tableResponsables.getValueAt(row, 0);
			model.setCedula(cedula);

			if (modelCons.buscar(model)) {

				viewEditarResponsable.txtCedula_ResponsableE.setText(model.getCedula());
				viewEditarResponsable.txtNombre_ResponsableE.setText(model.getNombre());
				viewEditarResponsable.txtApellido_ResponsableE.setText(model.getApellido());
				viewEditarResponsable.txtTelefono_responsableE.setText(model.getTelefono());
				viewEditarResponsable.txtParentesco_ResponsableE.setText(model.getParentesco());
			

				iniciarEditarResponsable();
				viewEditarResponsable.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro un registro");
				limpiar();
			}
		}

	}

	public void limpiar() {
		view.txtNombre_ResponsableN.setText(null);
		view.txtApellido_ResponsableN.setText(null);
		view.txtCedula_ResponsableN.setText(null);
		view.txtTelefono_ResponsableN.setText(null);
		view.txtParentesco_ResponsableN.setText(null);		

	}

	public void cargarDatosTabla() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Cedula", "Nombre", "Apellido", "Telefono", "Parentescoo" });

		ResultSet rs = null;

		rs = modelCons.listarResponsable(model);

		try {
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getString("cedula_responsable"), rs.getString("nombre_responsable"),
						rs.getString("apellido_responsable"), rs.getString("telefono_responsable"),
						rs.getString("parentesco_responsable") });

			}
			viewResponsable.tableResponsables.setModel(modelo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
