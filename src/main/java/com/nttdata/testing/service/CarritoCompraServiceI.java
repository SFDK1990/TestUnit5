package com.nttdata.testing.service;

import java.util.List;

import com.nttdata.testing.model.Articulo;

public interface CarritoCompraServiceI {
	
	public void limpiarCesta();
	
	public void addArticulo(Articulo articulo );
	
	public Integer getNumArticulos();
	
	public List<Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadoraDescuento(Double precio, Double porcentaje);
	
	public Double aplicarDescuentoDouble(Integer idArticulo, Double porcentaje);
	
	public Integer insertarArticulo(Articulo articulo);
	
	public Articulo cogerArticulo(Integer id);

}
