package com.cjavaperu.spring.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cjavaperu.spring.beans.Alumno;;

@Component
public class AlumnoValidator implements Validator{
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public boolean supports(Class<?> arg0) {
		return Alumno.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		logger.info("validate");
		Alumno Alumno = (Alumno) arg0;
		
		if(Alumno.getNombre() == null || ("").equals(Alumno.getNombre()))
			arg1.rejectValue("nombre", "null", "Ingrese su nombre");
		
		if(Alumno.getPromedio() == 0 )
			arg1.rejectValue("promedio", "null", "Ingrese su promedio");
		
		
		
		
	}

}
