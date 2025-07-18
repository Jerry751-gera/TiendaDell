package com.mx.TiendaDell.Controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.TiendaDell.Dominio.Computadoras;
import com.mx.TiendaDell.Respuesta.Respuesta;
import com.mx.TiendaDell.Service.Implementacion;

@RestController
@RequestMapping(path = "CompusWS")
@CrossOrigin

public class CompuWS {
	@Autowired

	Implementacion imp;

// http://localhost:9003/CompusWS/listar

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public Respuesta listar() {
		return imp.listar();
	}

	// http://localhost:9003/CompusWS/guardar

	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public Respuesta guardar(@RequestBody Computadoras compu) {
		return imp.guardar(compu);
	}

	// http://localhost:9003/CompusWS/editar

	@RequestMapping(value = "editar", method = RequestMethod.POST)
	public Respuesta editar(@RequestBody Computadoras compu) {
		return imp.editar(compu);
	}

	// http://localhost:9003/CompusWS/eliminar

	@RequestMapping(value = "eliminar", method = RequestMethod.POST)
	public Respuesta eliminar(@RequestBody Computadoras compu) {
		return imp.eliminar(compu);
	}

	// http://localhost:9003/CompusWS/buscar

	@RequestMapping(value = "buscar", method = RequestMethod.POST)
	public Respuesta buscar(@RequestBody Computadoras compu) {
		return imp.buscar(compu);
	}

//BUSCAR CON FOREACH
	// http://localhost:9003/CompusWS/buscarModelo
	@RequestMapping(value = "buscarModelo/{modelo}", method = RequestMethod.POST)
	public Respuesta buscarModelo(@PathVariable("modelo") String modelo) {
		return imp.buscarModelo(modelo);

	}
	
	//BUSCAR CON FOREACH
		// http://localhost:9003/CompusWS/eliminarModelo /aqui va el modelo
		@RequestMapping(value = "eliminarModelo/{modelo}", method = RequestMethod.POST)
		public Respuesta eliminarModelo(@PathVariable("modelo") String modelo) {
			return imp.eliminarModelo(modelo);

		}
}
