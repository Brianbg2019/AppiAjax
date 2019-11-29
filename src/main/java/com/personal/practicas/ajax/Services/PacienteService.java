package com.personal.practicas.ajax.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.practicas.ajax.entidades.Pacientes;
import com.personal.practicas.ajax.repositorios.IPacientes;

@Service
public class PacienteService {

	@Autowired
	IPacientes ipacientes;
	
	@Transactional
	public List<Pacientes> listPacientes(){
		return (List<Pacientes>) ipacientes.findAll();
	}
	
	@Transactional
	public Pacientes getPaciente(Integer id) {
		return ipacientes.findById(id).get();
	}
	
	@Transactional
	public Boolean SaveOrUpdate(Pacientes paciente) {
		try {
			ipacientes.save(paciente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public Boolean deletePaciente(Pacientes paciente) {
		try {
			ipacientes.delete(paciente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
