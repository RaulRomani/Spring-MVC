package com.cjavaperu.spring.beans;

public class Profesor extends Persona{
	
	private String categoria;
	private double sueldo;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
