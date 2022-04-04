package com.nttdata.testing.service;

import org.springframework.stereotype.Service;

import com.nttdata.testing.model.Articulo;

@Service
public interface BaseDatosI {
	
	public void iniciar();
	public Integer insertarArticulo(Articulo articulo);
	public Articulo buscarArticulo(Articulo identificador);
	Articulo buscarArticulo(Integer identificador);
		
	

}
