package com.personal.practicas.ajax.controladores;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.practicas.ajax.Services.ConsultaService;
import com.personal.practicas.ajax.entidades.Consulta;

@Controller
@RequestMapping(value = "consulta")
public class ConsultaController {
	
	@Autowired
	ConsultaService daoConsulta;
	
	@GetMapping(value = "all")
	@ResponseBody
	public List<Consulta> listar(){
		return daoConsulta.listConsulta();
	}
	
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> guardar(@RequestParam(name = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam int idDoctor){
		HashMap<String, String> hs = new HashMap<String, String>(); 
		Consulta con = new Consulta();
		con.setFecha(fecha);
		con.setSintomas(sintomas);
		con.setDiagnostico(diagnostico);
		con.setIdDoctor(daoConsulta.getIdDorctor(idDoctor));
		try {
			daoConsulta.saveOrUpdate(con);
			hs.put("estado", "OK");
			hs.put("Mensaje", "Registro guardado");
			return hs;
		} catch (Exception e) {
			hs.put("estado", "No OK");
			hs.put("Mensaje", "Registro no guardado");
			return hs;
		}
	}
	
	@GetMapping("update/{id}")
	@ResponseBody
	public HashMap<String, String> actualizar(@RequestParam int id, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha, @RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam int idDoctor){
		HashMap<String, String> hs = new HashMap<String, String>();
		
		Consulta con = new Consulta();
		con.setId(id);
		con.setFecha(fecha);
		con.setSintomas(sintomas);
		con.setIdDoctor(daoConsulta.getIdDorctor(idDoctor));
		
		try {
			daoConsulta.saveOrUpdate(con);
			hs.put("estado", "OK");
			hs.put("Mensaje", "Registro Actualizado");
			return hs;
		} catch (Exception e) {
			hs.put("estado", "No OK");
			hs.put("Mensaje", "Registro no Actualizado");
			return hs;
		}
	}
	
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> borrar(@PathVariable int id){
		HashMap<String, String> hs = new HashMap<String, String>();
		Consulta con = daoConsulta.getIdConsulta(id);
		try {
			daoConsulta.delete(con);
			hs.put("estado", "OK");
			hs.put("Mensaje", "Registro Eliminado");
			return hs;
		} catch (Exception e) {
			hs.put("estado", "No OK");
			hs.put("Mensaje", "Registro no Eliminado");
			return hs;
		}
	}

}
