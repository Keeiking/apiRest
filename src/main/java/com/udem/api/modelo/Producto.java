package com.udem.api.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Producto")
public class Producto {
	private Long referencia;
	private Long precio;
	private String descripcion;
	private Long garantia;
	
	public Long getReferencia() {
		return referencia;
	}
	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getGarantia() {
		return garantia;
	}
	public void setGarantia(Long garantia) {
		this.garantia = garantia;
	}

}
