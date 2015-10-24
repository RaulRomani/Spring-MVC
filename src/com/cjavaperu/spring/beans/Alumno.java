package com.cjavaperu.spring.beans;

public class Alumno extends Persona{
	
	private String estado;
	private double promedio;
	public String getEstado() {
		return (promedio>=13)?"aprobado":"desaprobado";
	}
	
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}


	
	
	public static void main(String[] args) {
		Alumno alumndo = new Alumno();
	}
	


	
}
