package com.cjavaperu.spring.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );

	@Override
	public boolean preHandle( HttpServletRequest request, 
			                  HttpServletResponse response, 
			                  Object handler ) throws Exception{
		logger.info( "preHandle" );
		/*AGREGAR LOGICA*/
		return super.preHandle( request, response, handler );
	}
	
	@Override
	public void postHandle( HttpServletRequest request, 
			                HttpServletResponse response, 
			                Object handler, 
			                ModelAndView modelAndView ) throws Exception{
		logger.info( "postHandle");
		/*AGREGAR LOGICA*/
		super.postHandle( request, response, handler, modelAndView );
	}
	
}
