package com.personal.practicas.ajax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.practicas.ajax.entidades.Pacientes;

@Repository
public interface IPacientes extends CrudRepository<Pacientes, Integer>{

}
