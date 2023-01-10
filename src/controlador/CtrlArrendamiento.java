package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JTextFieldDateEditor;

import modelo.Arriendo;
import modelo.ConsultasArriendo;
import modelo.ConsultasContrato;
import modelo.ConsultasDifunto;
import modelo.ConsultasNicho;
import modelo.ConsultasResponsable;
import modelo.ConsultasSeccion;
import modelo.Contrato;
import modelo.Difunto;
import modelo.Nicho;
import modelo.Responsable;
import modelo.Seccion;
import vista.frmArrendamientos;
import vista.frmDifunto;
import vista.frmEditarDifunto;
import vista.frmEditarResponsable;
import vista.frmNuevoArrendamiento;
import vista.frmNuevoDifunto;
import vista.frmNuevoResponsable;
import vista.frmResponsables;

public class CtrlArrendamiento implements ActionListener, ItemListener {

	private Arriendo modelArriendo;
	private ConsultasArriendo modelConsultasArriendo;
	private frmArrendamientos viewArrendamiento;
	private frmNuevoArrendamiento viewNuevoArrendamiento;
	private ConsultasSeccion modelConsultasSeccion;
	private Seccion modelSeccion;

	private frmNuevoDifunto viewDifunto;
	private Difunto modelDifunto;
	private ConsultasDifunto modelConsultasDifunto;
	private frmDifunto frmDifunto;
	private frmEditarDifunto viewEditarDifunto;
	private CtrlDifunto controllerDifunto;

	private Responsable modelResponsable;
	private ConsultasResponsable modelConsultasResponsable;
	private frmResponsables viewResponsables;
	private frmNuevoResponsable viewNuevoResponsable;
	private frmEditarResponsable viewEditarResponsable;
	private CtrlResponsable controllerResponsable;
	
	private Nicho modelNicho;
	private ConsultasNicho modelConsultasNicho;
	
	private Contrato modelContrato;
	private ConsultasContrato modelConsultasContrato;
	
	
	public CtrlArrendamiento(frmArrendamientos viewArrendamiento, frmNuevoArrendamiento viewNuevoArrendamiento,
			frmNuevoDifunto viewDifunto, ConsultasSeccion modelConsultasSeccion, Seccion modelSeccion, Arriendo modelArriendo, ConsultasArriendo modelConsultasArriendo,
			Contrato modelContrato, ConsultasContrato modelConsultasContrato) {
		this.viewArrendamiento = viewArrendamiento;
		this.viewNuevoArrendamiento = viewNuevoArrendamiento;
		this.viewDifunto = viewDifunto;
		this.modelConsultasSeccion = modelConsultasSeccion;
		this.modelSeccion = modelSeccion;
		this.modelArriendo = modelArriendo;
		this.modelConsultasArriendo = modelConsultasArriendo;
		this.modelContrato = modelContrato;
		this.modelConsultasContrato = modelConsultasContrato;
		this.viewArrendamiento.btnNuevoArrendamiento.addActionListener(this);
		this.viewNuevoArrendamiento.CboxTipoContrato_Arrendamiento.addItemListener(this);
		this.viewNuevoArrendamiento.CboxSeccion_Arrendamiento.addItemListener(this);
		this.viewNuevoArrendamiento.btnAgregarDif_Arrendamiento.addActionListener(this);
		this.viewNuevoArrendamiento.btnAgregarResp_Arrendamiento.addActionListener(this);
		this.viewNuevoArrendamiento.btnQuitarDif_Arrendamiento.addActionListener(this);
		this.viewNuevoArrendamiento.btnQuitarResp_Arrendamiento.addActionListener(this);
		this.viewNuevoArrendamiento.btnGuardar_Arrendamiento.addActionListener(this);
	}

	public void iniciarArrendamiento() {
		viewArrendamiento.setTitle("Arrendamientos");
		viewArrendamiento.setVisible(true);
		cargarDatosTabla();

	}

	public void iniciarNuevoArrendamiento() {
		viewNuevoArrendamiento.setTitle("Nuevo Arrendamiento");
		viewNuevoArrendamiento.setVisible(true);
		viewNuevoArrendamiento.lblNumeroContrato_Arrendamiento.setText("1");
		llenarComboBoxes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == viewNuevoArrendamiento.btnGuardar_Arrendamiento) {
			
			
			
			String fechaVencimiento;
			
			Date FechaV = null;
			
			Nicho nicho = (Nicho) viewNuevoArrendamiento.CboxNichos_Arrendamiento.getSelectedItem();
			
			if(viewNuevoArrendamiento.lblFechaVencimiento_Arrendamiento.getText().equals("INDEFINIDO")) {
				 fechaVencimiento = "0001-01-01";
				 FechaV = java.sql.Date.valueOf(fechaVencimiento);
			}else {
				 fechaVencimiento = viewNuevoArrendamiento.lblFechaVencimiento_Arrendamiento.getText();
				 FechaV = java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(ParseFecha(fechaVencimiento)));
			}
			
			modelArriendo.setObservaciones("");
			modelArriendo.setId_nicho(nicho.getId());
			
			 
			if(modelConsultasArriendo.resgistrar(modelArriendo)) {
				modelConsultasArriendo.obtenerIdArreindo(modelArriendo);
				
				modelContrato.setNumero(Integer.parseInt(viewNuevoArrendamiento.lblNumeroContrato_Arrendamiento.getText()));
				modelContrato.setTipo(viewNuevoArrendamiento.CboxTipoContrato_Arrendamiento.getSelectedItem().toString());
				modelContrato.setFechaInicio(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(ParseFecha(viewNuevoArrendamiento.lblFechaInicio_Arrendamiento.getText()))));
				modelContrato.setFechaVencimiento(FechaV);
				modelContrato.setPeriodo(viewNuevoArrendamiento.lblPeriodo_Arrendamiento.getText());
				modelContrato.setEstado("VIGENTE");
				modelContrato.setDocumento("");
				modelContrato.setId_responsable(Integer.parseInt(viewNuevoArrendamiento.lblIdResp_Arrendamiento.getText()));
				modelContrato.setId_difunto(Integer.parseInt(viewNuevoArrendamiento.lblIdDif_Arrendamiento.getText()));
				modelContrato.setId_arriendo(modelArriendo.getId());
				
				if(modelConsultasContrato.registrar(modelContrato)) {
					JOptionPane.showMessageDialog(null, "Registro guardado");
					cargarDatosTabla();
					viewNuevoArrendamiento.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar");
				}
				
			}
			
			
		}

		if (e.getSource() == viewArrendamiento.btnNuevoArrendamiento) {
			iniciarNuevoArrendamiento();
		}

		if (e.getSource() == viewNuevoArrendamiento.btnAgregarDif_Arrendamiento) {

			modelDifunto = new Difunto();

			modelConsultasDifunto = new ConsultasDifunto();

			frmDifunto = new frmDifunto();

			viewDifunto = new frmNuevoDifunto();

			viewEditarDifunto = new frmEditarDifunto();

			controllerDifunto = new CtrlDifunto(modelDifunto, modelConsultasDifunto, viewDifunto, frmDifunto,
					viewEditarDifunto, viewNuevoArrendamiento);

			controllerDifunto.iniciarNuevoDifunto();

			viewDifunto.setVisible(true);

		}

		if (e.getSource() == viewNuevoArrendamiento.btnAgregarResp_Arrendamiento) {
			modelResponsable = new Responsable();

			modelConsultasResponsable = new ConsultasResponsable();

			viewResponsables = new frmResponsables();

			viewNuevoResponsable = new frmNuevoResponsable();

			viewEditarResponsable = new frmEditarResponsable();

			controllerResponsable = new CtrlResponsable(modelResponsable, modelConsultasResponsable,
					viewNuevoResponsable, viewResponsables, viewEditarResponsable, viewNuevoArrendamiento);

			controllerResponsable.iniciarNuevoResponsable();

			viewNuevoResponsable.setVisible(true);
		}

		if (e.getSource() == viewNuevoArrendamiento.btnQuitarDif_Arrendamiento) {
			modelDifunto = new Difunto();

			modelConsultasDifunto = new ConsultasDifunto();

			modelDifunto.setCedula(viewNuevoArrendamiento.lblCedulaDif_Arrendamiento.getText());

			int resp = JOptionPane.showConfirmDialog(null, "¿Deseas elimininar el registro el Difunto?",
					"Selecciona una opción", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.OK_OPTION == resp) {
				if (modelConsultasDifunto.eliminar(modelDifunto)) {
					viewNuevoArrendamiento.lblIdDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblCedulaDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblNombreDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblApellidoDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblEdadDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblGeneroDif_Arrendamiento.setText("-");
					viewNuevoArrendamiento.lblFechaFallecimientoDif_Arrendamiento.setText("-");

				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == viewNuevoArrendamiento.CboxTipoContrato_Arrendamiento) {
			Date fecha = new Date();
			String seleccionado = (String) viewNuevoArrendamiento.CboxTipoContrato_Arrendamiento.getSelectedItem();
			if (seleccionado.equals("DEFINIDO")) {

				viewNuevoArrendamiento.lblFechaInicio_Arrendamiento
						.setText(new SimpleDateFormat("yyyy-MMM-dd").format(fecha));

				Calendar c = Calendar.getInstance();
				c.setTime(fecha);
				c.add(Calendar.YEAR, 10);

				fecha = c.getTime();

				viewNuevoArrendamiento.lblFechaVencimiento_Arrendamiento
						.setText(new SimpleDateFormat("yyyy-MMM-dd").format(fecha));

				viewNuevoArrendamiento.lblPeriodo_Arrendamiento.setText("10 AÑOS");
			} else {
				viewNuevoArrendamiento.lblFechaInicio_Arrendamiento
						.setText(new SimpleDateFormat("yyyy-MMM-dd").format(fecha));
				viewNuevoArrendamiento.lblFechaVencimiento_Arrendamiento.setText("INDEFINIDO");

				viewNuevoArrendamiento.lblPeriodo_Arrendamiento.setText("INDEFINIDO");
			}

		}

		if (e.getSource() == viewNuevoArrendamiento.CboxSeccion_Arrendamiento) {
			
			viewNuevoArrendamiento.CboxNichos_Arrendamiento.removeAllItems();
			modelConsultasNicho = new ConsultasNicho();

			Seccion seleccionado = (Seccion) viewNuevoArrendamiento.CboxSeccion_Arrendamiento.getSelectedItem();
			if (seleccionado != null) {
				ResultSet rs = null;

				rs = modelConsultasNicho.listarNichosPorSeccion(seleccionado.getId());

				try {
					while (rs.next()) {

						// Se arega un nuevo ítem al combobox
						modelNicho = new Nicho();

						modelNicho.setId(rs.getInt("id_nicho"));
						modelNicho.setNumero(rs.getInt("numero_nicho"));
						modelNicho.setTipo(rs.getString("tipo_nicho"));

						viewNuevoArrendamiento.CboxNichos_Arrendamiento.addItem(modelNicho);

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}
	
	public void cargarDatosTabla() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(new Object[] { "Cedula Difunto","Nombres Difunto", "Seccion", "Numero Nicho", "Fecha de Fallecimiento", "Numero Contrato","Tipo Contrato", "Fecha Inicio Contrato", "Fecha Fin Contrato",
				"Nombres Responsable", "Estado Contrato", "Observaciones" });

		ResultSet rs = null;

		rs = modelConsultasArriendo.listarArriendos();

		try {
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getString("cedula_difunto"), rs.getString("nombre_difunto") +" " + rs.getString("apellido_difunto"), rs.getString("nombre_seccion"),
						rs.getInt("numero_nicho"),rs.getDate("fechaFallecimiento_difunto"), rs.getString("numero_contrato"), rs.getString("tipo_contrato"), rs.getDate("fechaInicio_contrato"),
						rs.getDate("fechaVencimiento_contrato"), rs.getString("nombre_responsable") +" " + rs.getString("apellido_responsable"), rs.getString("estado_contrato"), rs.getString("observaciones_arriendo") });

			}
			viewArrendamiento.tableArrendamientos.setModel(modelo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void llenarComboBoxes() {
		ResultSet rs = null;

		rs = modelConsultasSeccion.listarSecciones();

		try {
			while (rs.next()) {

				// Se arega un nuevo ítem al combobox
				modelSeccion = new Seccion();

				modelSeccion.setId(rs.getInt("id_seccion"));
				modelSeccion.setNombre(rs.getString("nombre_seccion"));

				viewNuevoArrendamiento.CboxSeccion_Arrendamiento.addItem(modelSeccion);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void llenarFechas() {

		Date fecha = new Date();

		viewNuevoArrendamiento.lblFechaInicio_Arrendamiento.setText(new SimpleDateFormat("yyyy-MMM-dd").format(fecha));

		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.add(Calendar.YEAR, 10);

		fecha = c.getTime();

		viewNuevoArrendamiento.lblFechaVencimiento_Arrendamiento
				.setText(new SimpleDateFormat("yyyy-MMM-dd").format(fecha));

	}
	
	public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MMM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	

}
