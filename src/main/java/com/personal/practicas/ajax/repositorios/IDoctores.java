package com.personal.practicas.ajax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.practicas.ajax.entidades.Doctores;

@Repository
public interface IDoctores extends CrudRepository<Doctores, Integer>{

}
