package com.personal.practicas.ajax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.practicas.ajax.entidades.Especialidad;

@Repository
public interface IEspecialidad extends CrudRepository<Especialidad, Integer>{

}
