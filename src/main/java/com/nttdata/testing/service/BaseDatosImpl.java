package com.nttdata.testing.service;

import java.util.Map;

import com.nttdata.testing.model.Articulo;

public class BaseDatosImpl implements BaseDatosI{

	private Map<Integer, Articulo> baseDatos;
	
	
	@Override
	public void iniciar() {
		baseDatos.put(1, new Articulo("Camiseta", 20.00));
		baseDatos.put(2, new Articulo("Pantalon", 10.00));
		baseDatos.put(3, new Articulo("Jersey", 40.00));
		baseDatos.put(4, new Articulo("Pala", 30.00));
		
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		baseDatos.put(baseDatos.size()+1, articulo);
		return baseDatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		return baseDatos.get(identificador);
	}

	@Override
	public Articulo buscarArticulo(Articulo identificador) {
		// TODO Auto-generated method stub
		return null;
	}

}
