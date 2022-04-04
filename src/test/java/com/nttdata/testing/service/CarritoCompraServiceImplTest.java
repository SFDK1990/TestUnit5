package com.nttdata.testing.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.nttdata.testing.model.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

	// Inyeccion moks en el service
	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	// Mokear la BBDD
	@Mock
	private BaseDatosI baseDatos;

	@Test
	public void testLimpiarCesta() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testAddArticulo() {
		assertTrue(carritoService.getArticulos().isEmpty());
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testGetNumArticulos() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertEquals(Integer.valueOf(1), carritoService.getNumArticulos());

	}

	@Test
	public void testGetArticulos() {
		carritoService.addArticulo(new Articulo("Camiseta", 15D));
		List<Articulo> listArticulos = carritoService.getArticulos();
		assertEquals("Camiseta", listArticulos.get(0).getNombre());
		assertEquals(1, listArticulos.size());
	}

	@Test
	public void testTotalPrice() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		Double res = carritoService.totalPrice();
		assertEquals(Double.valueOf(15.99), res);
	}

	@Test
	public void testCalculadoraDescuento() {
		assertEquals(Double.valueOf(90D), carritoService.calculadoraDescuento(100D, 10D));
	}

	@Test
	public void testAplicarDescuento() {
		Articulo articulo = new Articulo("Camiseta", 20D);
		when(baseDatos.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double respuesta = carritoService.aplicarDescuentoDouble(1, 10D);
		assertEquals(Double.valueOf(18D), respuesta);
	}
	
	@Test
	public void testInsertarBuscar() {
		Articulo articulo = new Articulo("Camiseta", 20D);
		List<Articulo> listArticulos = carritoService.getArticulos();
		when(baseDatos.insertarArticulo(articulo)).thenReturn(1);
		
		Integer idArticuloInteger = carritoService.insertarArticulo(articulo);
		//Comprobamos que que el id es igual a la posicion
		assertEquals(Integer.valueOf(1), idArticuloInteger);
		//Comprobamos que el articulo sea el correcto
		assertEquals("Camiseta", listArticulos.get(0).getNombre());
		//Verificamos que el articulo esta en la BBDD
		verify(baseDatos, times(1)).insertarArticulo(articulo);

	}

}
