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

import com.personal.practicas.ajax.Services.DoctorService;
import com.personal.practicas.ajax.entidades.Doctores;
import com.personal.practicas.ajax.repositorios.IDoctores;

@Controller
@RequestMapping(value = "doctores")
public class DoctoresController {
	
	@Autowired
	DoctorService daoDoctor;
	
	
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Doctores> MostrarDoctores() {
		return daoDoctor.doctoresList();
	}
	
	//Save
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> GuardarDoctor(@RequestParam String nombre, @RequestParam String direccion, @RequestParam int idEspecialidad) {
		Doctores doc = new  Doctores();
		HashMap<String, String> hs = new HashMap<String, String>();
		
		doc.setNombre(nombre);
		doc.setDireccion(direccion);
		doc.setEspecialidad(daoDoctor.getEspecialidad(idEspecialidad));
		
		try {
		    daoDoctor.SaveOrUpdate(doc);
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
	public HashMap<String, String> EditarDoctor(@RequestParam int id, @RequestParam String nombre, @RequestParam String direccion) {
		Doctores doc = new  Doctores();
		HashMap<String, String> hs = new HashMap<String, String>();
		doc.setId(id);
		doc.setNombre(nombre);
		doc.setDireccion(direccion);
		
		try {
		    daoDoctor.SaveOrUpdate(doc);
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
		Doctores doc = daoDoctor.getDoctor(id);
		try {
		    daoDoctor.Delete(doc);
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
