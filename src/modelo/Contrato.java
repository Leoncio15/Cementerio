package modelo;

import java.util.Date;

public class Contrato {

	private int id;
	private int numero;
	private String tipo;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private String periodo;
	private String estado;
	private String documento;
	private int id_responsable;
	private int id_difunto;
	private int id_arriendo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public int getId_responsable() {
		return id_responsable;
	}
	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}
	public int getId_difunto() {
		return id_difunto;
	}
	public void setId_difunto(int id_difunto) {
		this.id_difunto = id_difunto;
	}
	public int getId_arriendo() {
		return id_arriendo;
	}
	public void setId_arriendo(int id_arriendo) {
		this.id_arriendo = id_arriendo;
	}
	
	
	
	
}
