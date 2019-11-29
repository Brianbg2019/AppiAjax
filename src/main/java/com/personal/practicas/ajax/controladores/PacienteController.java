package com.personal.practicas.ajax.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.practicas.ajax.Services.PacienteService;
import com.personal.practicas.ajax.entidades.Pacientes;

@Controller
@RequestMapping(value = "paciente")
public class PacienteController {
	
	@Autowired
	PacienteService daoPaciente;
	
	@GetMapping(value = "index")
	public String mostrar() {
		return "views/Paciente/Paciente";
	}
	
	@GetMapping(value = "all")
	@ResponseBody
	@CrossOrigin
	public List<Pacientes> listPacientes(){
		return daoPaciente.listPacientes();
	}
	
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> savePaciente(@RequestParam String nombre, @RequestParam String direccion){
		HashMap<String, String> hs = new HashMap<String, String>();
		Pacientes paciente = new Pacientes();
		
		paciente.setNombre(nombre);
		paciente.setDireccion(direccion);
		try {
			daoPaciente.SaveOrUpdate(paciente);
			hs.put("Estado", "Ok");
			hs.put("Mensaje", "Se guardarón los registros");
			return hs;
		} catch (Exception e) {
			hs.put("Estado", "No Ok");
			hs.put("Mensaje", "NO Se guardarón los registros");
			return hs;
		}
	}
	
	@GetMapping(value = "update/{id}")
	@ResponseBody
	public HashMap<String, String> updatePaciente(@RequestParam int id,@RequestParam String nombre, @RequestParam String direccion){
		HashMap<String, String> hs = new HashMap<String, String>();
		Pacientes paciente = new Pacientes();
		
		paciente.setId(id);
		paciente.setNombre(nombre);
		paciente.setDireccion(direccion);
		try {
			daoPaciente.SaveOrUpdate(paciente);
			hs.put("Estado", "Ok");
			hs.put("Mensaje", "Se Actualizo los registros");
			return hs;
		} catch (Exception e) {
			hs.put("Estado", "No Ok");
			hs.put("Mensaje", "NO Se Actualizo los registros");
			return hs;
		}
	}
	
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> deletePaciente(@PathVariable int id){
		HashMap<String, String> hs = new HashMap<String, String>();
		Pacientes paciente = daoPaciente.getPaciente(id);
		
		try {
			daoPaciente.deletePaciente(paciente);
			hs.put("Estado", "Ok");
			hs.put("Mensaje", "Se Borro los registros");
			return hs;
		} catch (Exception e) {
			hs.put("Estado", "No Ok");
			hs.put("Mensaje", "NO Se Borro los registros");
			return hs;
		}
	}

}
