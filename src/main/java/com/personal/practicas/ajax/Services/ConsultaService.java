package com.personal.practicas.ajax.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.practicas.ajax.entidades.Consulta;
import com.personal.practicas.ajax.entidades.Doctores;
import com.personal.practicas.ajax.repositorios.IConsulta;
import com.personal.practicas.ajax.repositorios.IDoctores;

@Service
public class ConsultaService {

	@Autowired
	IConsulta iconsulta;
	@Autowired
	IDoctores idoctores;
	
	
	@Transactional
	public List<Consulta> listConsulta(){
		return (List<Consulta>) iconsulta.findAll();
	}
	
	@Transactional
	public Boolean saveOrUpdate(Consulta consulta) {
		try {
			iconsulta.save(consulta);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	@Transactional
	public Boolean delete(Consulta consulta) {
		try {
			iconsulta.delete(consulta);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public Doctores getIdDorctor(Integer id) {
		return idoctores.findById(id).get();
	}
	public Consulta getIdConsulta(Integer id) {
		return iconsulta.findById(id).get();
	}
}
