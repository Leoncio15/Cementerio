package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
import vista.frmNichos;
import vista.frmNichos_Secciones;
import vista.frmNuevoArrendamiento;
import vista.frmNuevoDifunto;
import vista.frmNuevoResponsable;
import vista.frmPrincipal;
import vista.frmResponsables;
import vista.frmSecciones;

public class CtrlPrincipal implements ActionListener {
	private Difunto model;
	private ConsultasDifunto modelCons;
	private frmDifunto viewDifunto;
	private frmNuevoDifunto view;
	private frmPrincipal viewMain;
	private CtrlDifunto controller;
	private frmEditarDifunto viewEditarDifunto;
	
	private Responsable modelResponsable;
	private ConsultasResponsable modelConsultasResponsable;
	private frmResponsables viewResponsables;
	private frmNuevoResponsable viewNuevoResponsable;
	private frmEditarResponsable viewEditarResponsable;
	private CtrlResponsable controllerResponsable;

	private Seccion modelSeccion;
	private ConsultasSeccion modelConsultasSeccion;
	private frmSecciones viewSecciones;
	private CtrlSeccion controllerSeccion;

	private frmArrendamientos viewArrendamiento;
	private frmNuevoArrendamiento viewNuevoArrendamiento;
	private CtrlArrendamiento controllerArrendamiento;
	
	private frmNichos viewNicho;
	private CtrlNicho controllerNicho;
	private Nicho modelNicho;
	private ConsultasNicho modelConsultasNicho;
	
	private CtrlNicho_Seccion controllerNichoSeccion;
	private frmNichos_Secciones viewNichoSeccion;
	
	private Arriendo modelArriendo;
	private ConsultasArriendo modelConsultasArriendo;
	
	private Contrato modelContrato;
	private ConsultasContrato modelConsultasContrato;

	public CtrlPrincipal(frmPrincipal viewMain) {
		this.viewMain = viewMain;
		this.viewMain.btnAbrirDifuntos_Main.addActionListener(this);
		this.viewMain.btnAbrirSecciones_Main.addActionListener(this);
		this.viewMain.btnAbrirArrendamientos_Main.addActionListener(this);
		this.viewMain.btnabrirContratos_Main.addActionListener(this);
		this.viewMain.btnAbrirPropietarios_Main.addActionListener(this);
		this.viewMain.btnAbrirNichos_Main.addActionListener(this);
	}

	public void iniciar() {
		viewMain.setTitle("Principal");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == viewMain.btnAbrirDifuntos_Main) {

			model = new Difunto();

			modelCons = new ConsultasDifunto();

			viewDifunto = new frmDifunto();

			view = new frmNuevoDifunto();

			viewEditarDifunto = new frmEditarDifunto();
			
			viewNuevoArrendamiento = new frmNuevoArrendamiento();

			controller = new CtrlDifunto(model, modelCons, view, viewDifunto, viewEditarDifunto, viewNuevoArrendamiento );

			controller.iniciarDifuntos();

			viewDifunto.setVisible(true);
		}
		
		if (e.getSource() == viewMain.btnAbrirPropietarios_Main) {

			modelResponsable = new Responsable();

			modelConsultasResponsable = new ConsultasResponsable();

			viewResponsables = new frmResponsables();

			viewNuevoResponsable = new frmNuevoResponsable();

			viewEditarResponsable = new frmEditarResponsable();
			
			viewNuevoArrendamiento = new frmNuevoArrendamiento();

			controllerResponsable = new CtrlResponsable(modelResponsable, modelConsultasResponsable, viewNuevoResponsable, viewResponsables, viewEditarResponsable, viewNuevoArrendamiento );

			controllerResponsable.iniciarResponsables();

			viewResponsables.setVisible(true);
		}

		if (e.getSource() == viewMain.btnAbrirSecciones_Main) {

			modelSeccion = new Seccion();

			modelConsultasSeccion = new ConsultasSeccion();

			viewSecciones = new frmSecciones();

			controllerSeccion = new CtrlSeccion(modelSeccion, modelConsultasSeccion, viewSecciones);

			controllerSeccion.iniciarSecciones();

			viewSecciones.setVisible(true);

		}
		
		if (e.getSource() == viewMain.btnAbrirNichos_Main) {


			//viewNicho = new frmNichos();
			
			modelSeccion = new Seccion();
			
			modelConsultasSeccion = new ConsultasSeccion();
			
			modelNicho = new Nicho();
			
			modelConsultasNicho = new ConsultasNicho();
			
			viewNichoSeccion = new frmNichos_Secciones();
			
			controllerNichoSeccion = new CtrlNicho_Seccion(modelConsultasSeccion, modelSeccion, modelNicho, modelConsultasNicho, viewNichoSeccion);
			
			controllerNichoSeccion.iniciarNichos_Secciones();
			
			viewNichoSeccion.setVisible(true);
			
			/*controllerNicho = new CtrlNicho(viewNicho, modelConsultasSeccion, modelNicho, modelConsultasNicho);
			
			controllerNicho.iniciarNicho();
			
			viewNicho.setVisible(true);*/

		}

		if (e.getSource() == viewMain.btnAbrirArrendamientos_Main) {

			viewArrendamiento = new frmArrendamientos();

			viewNuevoArrendamiento = new frmNuevoArrendamiento();
			
			view = new frmNuevoDifunto();

			modelSeccion = new Seccion();

			modelConsultasSeccion = new ConsultasSeccion();
			
			modelArriendo = new Arriendo();
			
			modelConsultasArriendo = new ConsultasArriendo();
			
			modelContrato = new Contrato();
			
			modelConsultasContrato = new ConsultasContrato();
			
			controllerArrendamiento = new CtrlArrendamiento(viewArrendamiento, viewNuevoArrendamiento, view, modelConsultasSeccion, modelSeccion, modelArriendo, modelConsultasArriendo, modelContrato, modelConsultasContrato);
			
			controllerArrendamiento.iniciarArrendamiento();
			
			viewArrendamiento.setVisible(true);
			
		}
	}

}
