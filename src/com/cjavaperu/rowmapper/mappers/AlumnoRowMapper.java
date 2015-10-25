package com.cjavaperu.rowmapper.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cjavaperu.spring.beans.Alumno;
import com.cjavaperu.rowmapper.extractor.AlumnoExtractor;

public class AlumnoRowMapper implements RowMapper<Alumno> {

	@Override
	public Alumno mapRow(ResultSet res, int line) throws SQLException {
		return new AlumnoExtractor().extractData(res);
	}

}
