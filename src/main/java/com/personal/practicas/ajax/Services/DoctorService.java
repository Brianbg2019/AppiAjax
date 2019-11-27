package com.personal.practicas.ajax.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.practicas.ajax.entidades.Doctores;
import com.personal.practicas.ajax.entidades.Especialidad;
import com.personal.practicas.ajax.repositorios.IDoctores;
import com.personal.practicas.ajax.repositorios.IEspecialidad;

@Service
public class DoctorService {
		@Autowired
		IDoctores idoctores;
		@Autowired
		IEspecialidad iespecialidad;
		
		
	@Transactional
	public List<Doctores> doctoresList(){
		return (List<Doctores>) idoctores.findAll();
	}
	
	@Transactional
	public Boolean SaveOrUpdate(Doctores doctor) {
		
		try {
			idoctores.save(doctor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public Especialidad getEspecialidad(Integer id) {
		return iespecialidad.findById(id).get();
	}
	@Transactional
	public Boolean Delete(Doctores doctor) {
		
		try {
			idoctores.delete(doctor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	public Doctores getDoctor(Integer id) {
		return idoctores.findById(id).get();
	}
}
