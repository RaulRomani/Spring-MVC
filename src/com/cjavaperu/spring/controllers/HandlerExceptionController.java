package com.cjavaperu.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjavaperu.spring.exception.CustomException;

@Controller
@RequestMapping("/excepcion")
public class HandlerExceptionController {

	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String init(@RequestParam(value="tipo", required=false) String tipo) throws Exception {
		logger.info("init: " + tipo);
		
		if("personalizado".equals(tipo)){
			throw new CustomException("error personalizado");	
		}else if("generico".equals(tipo)){
			throw new Exception("error generico");
		}
		
		return "/error/excepcion";
	}
	
}
