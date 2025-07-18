package com.mx.TiendaDell.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.TiendaDell.Dao.CompDao;
import com.mx.TiendaDell.Dominio.Computadoras;
import com.mx.TiendaDell.Respuesta.Respuesta;

@Service

public class Implementacion implements Metodos {

	@Autowired
	CompDao dao;

	@Override
	public Respuesta guardar(Computadoras compu) {
		// TODO Auto-generated method stub
		if (dao.existsById(compu.getId())) {
			return new Respuesta("La compu ya existe", false, null);

		} else {
			LocalDateTime hoy = LocalDateTime.now();
			dao.save(compu);
			return new Respuesta("Se guardo la computadora ", false, compu);
		}
	}

	@Override
	public Respuesta editar(Computadoras compu) {
		// TODO Auto-generated method stub
		if (dao.existsById(compu.getId())) {
			LocalDateTime hoy = LocalDateTime.now();
			compu.setFechaVenta(hoy);
			dao.save(compu);
			return new Respuesta("Se edito la computadora ya existe", true, compu);

		} else {
			return new Respuesta(" No existe la computadora a editar ", false, null);
		}
	}

	@Override
	public Respuesta eliminar(Computadoras compu) {
		// TODO Auto-generated method stub
		if (dao.existsById(compu.getId())) {
			dao.delete(compu);
			return new Respuesta("Se elimino la computadora", true, compu);

		} else {

			return new Respuesta("No existe la computadora a elminar ", false, null);
		}
	}

	@Override
	public Respuesta buscar(Computadoras compu) {
		// TODO Auto-generated method stub
		Computadoras compuBuscar = dao.findById(compu.getId()).orElse(null);
		if (compuBuscar != null) {

			return new Respuesta("Se encontro la computadora", true, compuBuscar);

		} else {

			return new Respuesta("No existe la computadora a buscar ", false, null);
		}

	}

	@Override
	public Respuesta listar() {
		// TODO Auto-generated method stub
		List<Computadoras> listar = (List<Computadoras>) dao.findAll();
		if (!listar.isEmpty()) {

			return new Respuesta("Lista de computadoras:", true, listar);

		} else {

			return new Respuesta("La lista no contiene  computadoras: ", false, null);
		}

	}

	// METODOS PROPIOS

	public Respuesta buscarModelo(String modelo) {
		List<Computadoras> lista = (List<Computadoras>) dao.findAll();

		Computadoras modeloBuscar = null;
		for (Computadoras c : dao.findAll()) {
			if (c.getModelo().equals(modelo)) {
				modeloBuscar = c;
			}
		}
		return new Respuesta("Se encontro la computadora por modelo", true, modeloBuscar);
	}
	
	public Respuesta eliminarModelo(String modelo) {
		List<Computadoras> lista = (List<Computadoras>) dao.findAll();

		
		for (Computadoras c : dao.findAll()) {
			if (c.getModelo().equals(modelo)) {
				 dao.delete(c);
			}
		}
		return new Respuesta("Se elimino la computadora por modelo", true, null);
	}

}
