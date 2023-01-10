package modelo;

import java.util.Date;

public class Pago {
	
	private int id;
	private String tipo;
	private Double valor;
	private Date fecha;
	private int id_arriendo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getId_arriendo() {
		return id_arriendo;
	}
	public void setId_arriendo(int id_arriendo) {
		this.id_arriendo = id_arriendo;
	}
	
	

}
