package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultasSeccion;
import modelo.Seccion;
import vista.frmSecciones;

public class CtrlSeccion implements ActionListener, MouseListener {

	private Seccion model;
	private ConsultasSeccion modelConsultas;
	private frmSecciones view;

	public CtrlSeccion(Seccion model, ConsultasSeccion modelConsultas, frmSecciones view) {
		this.model = model;
		this.modelConsultas = modelConsultas;
		this.view = view;
		this.view.btnAgregar_Secciones.addActionListener(this);
		this.view.btnEditar_Secciones.addActionListener(this);
		this.view.btnEliminar_Secciones.addActionListener(this);
		this.view.btnBuscar_Secciones.addActionListener(this);
		this.view.tableSecciones.addMouseListener(this);

	}

	public void iniciarSecciones() {
		view.setTitle("Secciones");
		view.setLocationRelativeTo(null);
		cargarDatosTabla();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnAgregar_Secciones) {
			model.setNombre(view.txtNombre_Secciones.getText());
			model.setDescripcion(view.txtDescripcion_Secciones.getText());

			if (modelConsultas.resgistrar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				cargarDatosTabla();
				limpiar();
			}
		}

		if (e.getSource() == view.btnEditar_Secciones) {
			model.setId(Integer.parseInt(view.lblId_Seccion.getText()));
			model.setNombre(view.txtNombre_Secciones.getText());
			model.setDescripcion(view.txtDescripcion_Secciones.getText());

			if (modelConsultas.modificar(model)) {
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				cargarDatosTabla();
				limpiar();
			}
		}

		if (e.getSource() == view.btnEliminar_Secciones) {
			model.setId(Integer.parseInt(view.lblId_Seccion.getText()));

			int resp = JOptionPane.showConfirmDialog(null, "¿Deseas elimininar la sección?", "Selecciona una opción",
					JOptionPane.YES_NO_OPTION);
			if (JOptionPane.OK_OPTION == resp) {
				if (modelConsultas.eliminar(model)) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
					cargarDatosTabla();
				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub.
		if (e.getSource() == view.tableSecciones) {

			int row = view.tableSecciones.getSelectedRow();

			view.txtNombre_Secciones.setText((String) view.tableSecciones.getValueAt(row, 0));
			view.txtDescripcion_Secciones.setText((String) view.tableSecciones.getValueAt(row, 1));
			view.lblId_Seccion.setText(String.valueOf((int) view.tableSecciones.getValueAt(row, 2)));

		}

	}

	public void cargarDatosTabla() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Nombre", "Descripcion", "" });

		ResultSet rs = null;

		rs = modelConsultas.listarSecciones();

		try {
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getString("nombre_seccion"), rs.getString("descripcion_seccion"),
						rs.getInt("id_seccion") });

			}

			view.tableSecciones.setModel(modelo);
			view.tableSecciones.getColumnModel().getColumn(2).setMaxWidth(0);
			view.tableSecciones.getColumnModel().getColumn(2).setMinWidth(0);
			view.tableSecciones.getColumnModel().getColumn(2).setPreferredWidth(0);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void limpiar() {
		view.txtNombre_Secciones.setText(null);
		view.txtDescripcion_Secciones.setText(null);

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
