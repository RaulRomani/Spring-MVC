package com.cjavaperu.spring.controllers;
 
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjavaperu.spring.beans.Alumno;
import com.cjavaperu.spring.service.AlumnoService;

@Controller
@RequestMapping("/mantenimiento")
public class AlumnoController {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AlumnoService AlumnoService;

	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model) {
		logger.info("inicio");
		String fecha = Calendar.getInstance().getTime().toString();
		model.addAttribute("bienvenido", "Mantenimiento de Alumnos");
		model.addAttribute("fecha", fecha);
		model.addAttribute("Alumnos", AlumnoService.findAll());
		return "mantenimiento";
	}
	
	@RequestMapping(value="registrarActualizar", method = RequestMethod.POST)
	public String registrarActualizar( @ModelAttribute Alumno Alumno) {
		logger.info("registrarActualizar");
		logger.info("Alumno: " + Alumno);
	
		if(Alumno.getId() == null){
			logger.info("registrar");
			AlumnoService.create(Alumno);
		}else{
			logger.info("actualizar");
			AlumnoService.update(Alumno.getId(), Alumno);	
		}
		
		return "redirect:/mantenimiento";
	}
	
	@RequestMapping(value="cargar", method = RequestMethod.GET)
	public String cargar(@RequestParam("id") Integer id, Model model) {
		String fecha = Calendar.getInstance().getTime().toString();
		logger.info("cargar: " + id);
		model.addAttribute("id", id);
		
		model.addAttribute("Alumno", AlumnoService.find(id));
		model.addAttribute("bienvenido", "Mantenimiento de Alumnos");
		model.addAttribute("fecha", fecha);
		model.addAttribute("Alumnos", AlumnoService.findAll());
		return "mantenimiento";
	}

	@RequestMapping(value="eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Integer id) {
		logger.info("eliminar: " + id);
		AlumnoService.delete(id);
		return "redirect:/mantenimiento";
	}
 
}