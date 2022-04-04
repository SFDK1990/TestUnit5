package com.nttdata.testing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.testing.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraServiceI {
	
	@Autowired
	private BaseDatosI baseDatos;

	private List<Articulo> cesta = new ArrayList<>();

	@Override
	public void limpiarCesta() {
		cesta.clear();

	}

	@Override
	public void addArticulo(Articulo articulo) {
		cesta.add(articulo);

	}

	@Override
	public Integer getNumArticulos() {
		return cesta.size();
		
	}

	@Override
	public List<Articulo> getArticulos() {
		return cesta;
	}

	@Override
	public Double totalPrice() {
		Double total = 0D;
		for(Articulo articulo : cesta) {
			total = total + articulo.getPrecioDouble();
		}
		return total;
	}

	@Override
	public Double calculadoraDescuento(Double precio, Double porcentaje) {
		return precio - precio*porcentaje/100;
	}

	@Override
	public Double aplicarDescuentoDouble(Integer idArticulo, Double porcentaje) {
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);
		if(Optional.ofNullable(articulo).isPresent()) {
			return calculadoraDescuento(articulo.getPrecioDouble(), porcentaje);
			
		}else {
			System.out.println("No se ha encontrado el articulo con id: " + idArticulo);
		}
		return 0D;
		
	}
	

	//insertamos articulo a la BBDD
	@Override
	public Integer insertarArticulo(Articulo articulo) {
		Integer idArticulo = baseDatos.insertarArticulo(articulo);
		cesta.add(articulo);
		return idArticulo;
	}

	//Recuperamos el producto por el id
	@Override
	public Articulo cogerArticulo(Integer id) {
		if (id <= cesta.size()) {
			return cesta.get(id); 
		}
		
		return null;
	}
	
	

}
