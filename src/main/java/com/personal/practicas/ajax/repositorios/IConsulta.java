package com.personal.practicas.ajax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.practicas.ajax.entidades.Consulta;

@Repository
public interface IConsulta extends CrudRepository<Consulta, Integer>{

}
