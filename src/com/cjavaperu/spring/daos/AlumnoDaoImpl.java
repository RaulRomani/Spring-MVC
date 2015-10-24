package com.cjavaperu.spring.daos;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cjavaperu.spring.beans.Alumno;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<Alumno> Alumnos = new ArrayList<Alumno>();
	
	public AlumnoDaoImpl() {
		logger.info("Obteniendo Data");
		Alumno alumno;
		for (int i = 1; i <= 10; i++) {
			alumno = new Alumno();
			alumno.setNombre("Nombre"+i);
			alumno.setPromedio(10+i);
			Alumnos.add(alumno);
		}
	}

	@Override
	public void create(Alumno Alumno) {
		Alumnos.add(Alumno);
	}

	@Override
	public void update(Integer id, Alumno Alumno) {
		Alumnos.set(id-1, Alumno);
	}

	@Override
	public Alumno find(Integer id) {
		return Alumnos.get(id.intValue()-1);
	}

	@Override
	public Alumno delete(Integer id) {
		return Alumnos.remove(id.intValue()-1);
	}

	@Override
	public List<Alumno> findAll() {
		return Alumnos;
	}

}
