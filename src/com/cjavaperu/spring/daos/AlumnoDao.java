package com.cjavaperu.spring.daos;

import java.util.List;

import com.cjavaperu.spring.beans.Alumno;

public interface AlumnoDao {

	void create(Alumno Alumno);

	void update(Integer id, Alumno Alumno);
	
	Alumno find(Integer id);
	
	int delete(Integer id);

	List<Alumno> findAll();

}
