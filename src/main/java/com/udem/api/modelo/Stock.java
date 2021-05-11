package com.udem.api.modelo;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Stock")
public class Stock {
	private long id;
	private String nombre_produ;
	private long cantidad;
	private long cmin;
	private long cmax;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_produ() {
		return nombre_produ;
	}
	public void setNombre_produ(String nombre_produ) {
		this.nombre_produ = nombre_produ;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public long getCmin() {
		return cmin;
	}
	public void setCmin(long cmin) {
		this.cmin = cmin;
	}
	public long getCmax() {
		return cmax;
	}
	public void setCmax(long cmax) {
		this.cmax = cmax;
	}
	
}
