package com.mx.TiendaDell.Service;

import com.mx.TiendaDell.Dominio.Computadoras;
import com.mx.TiendaDell.Respuesta.Respuesta;

public interface Metodos {
	Respuesta guardar(Computadoras compu);

	Respuesta editar(Computadoras compu);

	Respuesta eliminar(Computadoras compu);

	Respuesta buscar(Computadoras compu);

	Respuesta listar();
}
