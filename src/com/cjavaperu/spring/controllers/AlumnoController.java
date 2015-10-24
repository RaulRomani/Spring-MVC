package com.cjavaperu.spring.controllers;
 
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;











import com.cjavaperu.spring.beans.Alumno;
import com.cjavaperu.spring.service.AlumnoService;
import com.cjavaperu.spring.validator.AlumnoValidator;;;


@Controller
@RequestMapping("/mantenimiento")
public class AlumnoController {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AlumnoService alumnoService;
	
	
	@Autowired
	AlumnoValidator AlumnoValidator;
	
	List<Alumno> alumnos;

	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model) {
		logger.info("inicio");

//		alumnos = alumnoService.findAll();
//		model.addAttribute("alumnos", alumnos);
		
		return "mantenimiento";
	}
	
	@ModelAttribute("alumnos")
	public List<Alumno> getAlumnos() {
		logger.info("getAlumnos");
		alumnos = alumnoService.findAll();
//		model.addAttribute("alumnos", alumnos);
		return alumnos;
	}
	
	@ModelAttribute("fecha")
	public String getTime() {
		logger.info("getTime");
		return Calendar.getInstance().getTime().toString();
	}
	
	
	@RequestMapping(value="registrarActualizar", method = RequestMethod.POST)
	public String registrarActualizar( @Valid Alumno Alumno, BindingResult result, Model model) {
		
		logger.info("registrarActualizar");
		logger.info("Alumno: " + Alumno);
		
		//Para manejar validaciones
		if(result.hasErrors()){
			logger.info("existen errores");
			for(FieldError error : result.getFieldErrors()){
				model.addAttribute("error" + error.getField(), error.getDefaultMessage());
			}
			return "mantenimiento";
		}
	
		if(Alumno.getId() == null){
			logger.info("registrar");
			alumnoService.create(Alumno);
		}else{
			logger.info("actualizar");
			alumnoService.update(Alumno.getId(), Alumno);	
		}
		
		return "redirect:/mantenimiento";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("initBinder");
		binder.addValidators(AlumnoValidator);
	}
	
	@RequestMapping(value="cargar", method = RequestMethod.GET)
	public String cargar(@RequestParam("id") Integer id, Model model) {
		String fecha = Calendar.getInstance().getTime().toString();
		logger.info("cargar: " + id);
//		model.addAttribute("id", id);
//		
//		model.addAttribute("alumno", alumnoService.find(id));
//		model.addAttribute("bienvenido", "Mantenimiento de Alumnos");
//		model.addAttribute("fecha", fecha);
//		model.addAttribute("Alumnos", alumnoService.findAll());
		
		Alumno alumno = alumnoService.find(id);
		alumno.setId(id);
		model.addAttribute("alumno", alumno);
		return "mantenimiento";
	}

	@RequestMapping(value="eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Integer id) {
		logger.info("eliminar: " + id);
		alumnoService.delete(id);
		return "redirect:/mantenimiento";
	}
	
	
	
	
	
	@RequestMapping(value = "descargar", method = RequestMethod.GET)
	public String descargar(@RequestParam("formato") String formato, Model model) {
		logger.info("descargar " + formato);
		String  pagina = "mantenimiento";
		
		if(formato.equals("excel")){
			pagina = "excelView";
		}else if(formato.equals("pdf")){
			pagina = "pdfView";
		}
		
//		model.addAttribute("alumnos", alumnos); No es necesario porque tengo un ModelAtribute
		return pagina;

	}
 
}