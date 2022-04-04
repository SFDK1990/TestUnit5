package com.nttdata.testing.model;

public class Articulo {

	private String nombre;
	private Double precioDouble;

	public Articulo() {
	}

	public Articulo(String nombre, Double precioDouble) {
		this.nombre = nombre;
		this.precioDouble = precioDouble;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioDouble() {
		return precioDouble;
	}

	public void setPrecioDouble(Double precioDouble) {
		this.precioDouble = precioDouble;
	}

}
