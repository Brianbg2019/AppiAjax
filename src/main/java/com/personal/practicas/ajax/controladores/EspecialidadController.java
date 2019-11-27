package com.personal.practicas.ajax.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.practicas.ajax.entidades.Especialidad;
import com.personal.practicas.ajax.repositorios.IEspecialidad;

@Controller
@RequestMapping(value = "especialidad")
public class EspecialidadController {
	
	@Autowired
	IEspecialidad iespecialidad;
	
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Especialidad> MostrarDoctores() {
		return (List<Especialidad>) iespecialidad.findAll();
	}
	
	//Save
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> GuardarDoctor(@RequestParam String especialidad) {
		Especialidad es = new  Especialidad();
		HashMap<String, String> hs = new HashMap<String, String>();
		
		es.setEspecialidad(especialidad);
		
		try {
		    iespecialidad.save(es);
		    hs.put("Estado", "OK");
		    hs.put("Mensaje", "Registro Guardado");
		    return hs;
		} catch (Exception e) {
			hs.put("Error","La acción fallo");
			hs.put("Mensaje", "El registro no se guardo");
			return hs;
		}

	}
	
	//Update
	@GetMapping(value = "update/{id}")
	@ResponseBody
	public HashMap<String, String> EditarDoctor(@RequestParam int id, @RequestParam String especialidad) {
		Especialidad es = new  Especialidad();
		HashMap<String, String> hs = new HashMap<String, String>();
		es.setId(id);
		es.setEspecialidad(especialidad);
		
		try {
		    iespecialidad.save(es);
		    hs.put("Estado", "OK");
		    hs.put("Mensaje", "Registro Actualizado");
		    return hs;
		} catch (Exception e) {
			hs.put("Error","La acción fallo");
			hs.put("Mensaje", "El registro no se Actualizo");
			return hs;
		}
	}
	
	//Delete
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> EliminarDoctor(@PathVariable int id) {
		HashMap<String, String> hs = new HashMap<String, String>();
		Especialidad es = iespecialidad.findById(id).get();
		try {
		    iespecialidad.delete(es);
		    hs.put("Estado", "OK");
		    hs.put("Mensaje", "Registro Eliminado");
		    return hs;
		} catch (Exception e) {
			hs.put("Error","La acción fallo");
			hs.put("Mensaje", "El registro no se Elimino");
			return hs;
		}
		
	}
}
