
package com.personal.practicas.ajax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.practicas.ajax.entidades.Persona;

/**
 * IPersonaRepository
 */
@Repository
public interface IPersonaRepository extends CrudRepository<Persona,Integer>{

    
}