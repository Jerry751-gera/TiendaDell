package com.mx.TiendaDell.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.TiendaDell.Dominio.Computadoras;

@Repository
public interface CompDao extends CrudRepository<Computadoras, Integer> {

}
