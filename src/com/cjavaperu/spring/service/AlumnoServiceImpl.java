package com.cjavaperu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjavaperu.spring.beans.Alumno;
import com.cjavaperu.spring.daos.AlumnoDao;;



@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoDao AlumnoDao; // Va a buscar al DAO que tenga el estereotipo Repository

	@Override
	public void create(Alumno Alumno) {
		AlumnoDao.create(Alumno);
	}

	@Override
	public void update(Integer id, Alumno Alumno) {
		AlumnoDao.update(id, Alumno);
	}

	@Override
	public Alumno find(Integer id) {
		return AlumnoDao.find(id);
	}

	@Override
	public Alumno delete(Integer id) {
		return AlumnoDao.delete(id);
	}

	@Override
	public List<Alumno> findAll() {
		return AlumnoDao.findAll();
	}

}
