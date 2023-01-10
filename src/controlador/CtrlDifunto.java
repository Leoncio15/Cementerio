package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConsultasDifunto;
import modelo.Difunto;
import vista.frmDifunto;
import vista.frmEditarDifunto;
import vista.frmNuevoArrendamiento;
import vista.frmNuevoDifunto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlDifunto implements ActionListener {

	private Difunto model;
	private ConsultasDifunto modelCons;
	private frmNuevoDifunto view;
	private frmDifunto viewDifunto;
	private frmEditarDifunto viewEditarDifunto;
	private frmNuevoArrendamiento viewNuevoArrendamiento;

	public CtrlDifunto(Difunto model, ConsultasDifunto modelCons, frmNuevoDifunto view, frmDifunto viewDifunto,
			frmEditarDifunto viewEditarDifunto, frmNuevoArrendamiento viewNuevoArrendamiento) {
		this.model = model;
		this.modelCons = modelCons;
		this.view = view;
		this.viewDifunto = viewDifunto;
		this.viewEditarDifunto = viewEditarDifunto;
		this.viewNuevoArrendamiento = viewNuevoArrendamiento;
		this.view.btnGuardar_Difunto.addActionListener(this);
		this.viewDifunto.btnNuevo_Difunto.addActionListener(this);
		this.viewDifunto.btnEditar_Difunto.addActionListener(this);
		this.viewDifunto.btnEliminar_Difunto.addActionListener(this);
		this.viewEditarDifunto.btnGuardar_Difunto.addActionListener(this);
		/*
		 * this.view.btnModificar_Difunto.addActionListener(this);
		 * this.view.btnEliminar_Difunto.addActionListener(this);
		 * this.view.btnLimpiar_Difunto.addActionListener(this);
		 * this.view.btnBuscar_Difunto.addActionListener(this);
		 */
	}

	public void iniciarDifuntos() {
		viewDifunto.setTitle("Difuntos");
		viewDifunto.setLocationRelativeTo(null);
		cargarDatosTabla();
	}

	public void iniciarNuevoDifunto() {
		view.setTitle("Nuevo Difunto");
		view.setLocationRelativeTo(null);
	}

	public void iniciarEditarDifunto() {
		view.setTitle("Editar Difunto");
		view.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.btnGuardar_Difunto) {

			model.setCedula(view.txtCedula_Difunto.getText());
			model.setNombre(view.txtNombre_Difunto.getText());
			model.setApellido(view.txtApellido_Difunto.getText());
			model.setEdad(Integer.parseInt(view.txtEdad_Difunto.getText()));
			model.setFechaFallecimiento(Date.valueOf(
					new SimpleDateFormat("yyyy-MM-dd").format(view.CalendarFechaFallecimieto_Difunto.getDate())));
			model.setGenero(view.CboxGenero_Difunto.getSelectedItem().toString());
			model.setFechaNacimiento(Date
					.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(view.CalendarFechaNacimieto_Difunto.getDate())));

			if (modelCons.registrar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				cargarDatosTabla();
				limpiar();
				view.setVisible(false);
				if(!view.isVisible()) {
					
					if (modelCons.buscar(model)) {
						viewNuevoArrendamiento.lblIdDif_Arrendamiento.setText(String.valueOf(model.getId()));
						viewNuevoArrendamiento.lblCedulaDif_Arrendamiento.setText(model.getCedula());
						viewNuevoArrendamiento.lblNombreDif_Arrendamiento.setText(model.getNombre());
						viewNuevoArrendamiento.lblApellidoDif_Arrendamiento.setText(model.getApellido());
						viewNuevoArrendamiento.lblEdadDif_Arrendamiento.setText(String.valueOf(model.getEdad()));
						viewNuevoArrendamiento.lblGeneroDif_Arrendamiento.setText(model.getGenero());
						viewNuevoArrendamiento.lblFechaFallecimientoDif_Arrendamiento.setText(String.valueOf(model.getFechaFallecimiento()));
						
					}					
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error al guardar");
				limpiar();
			}
		}

		if (e.getSource() == viewDifunto.btnNuevo_Difunto) {

			iniciarNuevoDifunto();
			view.setVisible(true);
		}

		if (e.getSource() == viewEditarDifunto.btnGuardar_Difunto) {
			model.setCedula(viewEditarDifunto.txtCedula_Difunto.getText());
			model.setNombre(viewEditarDifunto.txtNombre_Difunto.getText());
			model.setApellido(viewEditarDifunto.txtApellido_Difunto.getText());
			model.setEdad(Integer.parseInt(viewEditarDifunto.txtEdad_Difunto.getText()));
			model.setFechaFallecimiento(Date.valueOf(new SimpleDateFormat("yyyy-MM-dd")
					.format(viewEditarDifunto.CalendarFechaFallecimieto_Difunto.getDate())));
			model.setGenero(viewEditarDifunto.CboxGenero_Difunto.getSelectedItem().toString());
			model.setFechaNacimiento(Date.valueOf(new SimpleDateFormat("yyyy-MM-dd")
					.format(viewEditarDifunto.CalendarFechaNacimieto_Difunto.getDate())));

			if (modelCons.modificar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();
				cargarDatosTabla();
				viewEditarDifunto.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Error al modificar");
				limpiar();
			}
		}

		if (e.getSource() == viewDifunto.btnEliminar_Difunto) {

			int row = viewDifunto.tableDifunto.getSelectedRow();
			String cedula = (String) viewDifunto.tableDifunto.getValueAt(row, 0);
			String nombre = (String) viewDifunto.tableDifunto.getValueAt(row, 1);
			String apellido = (String) viewDifunto.tableDifunto.getValueAt(row, 2);

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

		if (e.getSource() == viewDifunto.btnEditar_Difunto) {

			int row = viewDifunto.tableDifunto.getSelectedRow();
			String cedula = (String) viewDifunto.tableDifunto.getValueAt(row, 0);
			model.setCedula(cedula);

			if (modelCons.buscar(model)) {

				viewEditarDifunto.txtCedula_Difunto.setText(model.getCedula());
				viewEditarDifunto.txtNombre_Difunto.setText(model.getNombre());
				viewEditarDifunto.txtApellido_Difunto.setText(model.getApellido());
				viewEditarDifunto.txtEdad_Difunto.setText(String.valueOf(model.getEdad()));
				viewEditarDifunto.CalendarFechaFallecimieto_Difunto.setDate(model.getFechaFallecimiento());
				viewEditarDifunto.CboxGenero_Difunto.setSelectedItem((String) model.getGenero());
				viewEditarDifunto.CalendarFechaNacimieto_Difunto.setDate(model.getFechaNacimiento());

				iniciarEditarDifunto();
				viewEditarDifunto.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro un registro");
				limpiar();
			}
		}

	}

	public void limpiar() {
		view.txtNombre_Difunto.setText(null);
		view.txtApellido_Difunto.setText(null);
		view.txtCedula_Difunto.setText(null);
		view.txtEdad_Difunto.setText(null);
		view.CalendarFechaFallecimieto_Difunto.setDate(null);		
		view.CalendarFechaNacimieto_Difunto.setDate(null);
	}

	public void cargarDatosTabla() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Cedula", "Nombre", "Apellido", "Edad", "Fecha de Fallecimiento",
				"Genero", "Fecha de Nacimiento" });

		ResultSet rs = null;

		rs = modelCons.listarDifuntos(model);

		try {
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getString("cedula_difunto"), rs.getString("nombre_difunto"),
						rs.getString("apellido_difunto"), rs.getInt("edad_difunto"),
						rs.getDate("fechaFallecimiento_difunto"), rs.getString("genero_difunto"),
						rs.getDate("fechaNacimiento_difunto") });

			}
			viewDifunto.tableDifunto.setModel(modelo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
