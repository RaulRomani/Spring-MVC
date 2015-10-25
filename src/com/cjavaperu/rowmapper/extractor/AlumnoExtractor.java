package com.cjavaperu.rowmapper.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cjavaperu.spring.beans.Alumno;

public class AlumnoExtractor implements ResultSetExtractor<Alumno> {

	@Override
	public Alumno extractData(ResultSet res) throws SQLException, DataAccessException {
		//Para el caso de un solo registro cuando se llama directamente al extractor
		if(res.isBeforeFirst()) res.next();
		Alumno alumno = new Alumno();
		alumno.setId(res.getInt("intAluCodigo"));
		alumno.setNombre(res.getString("vchAluNombre"));
		alumno.setPromedio(res.getDouble("vchAluPromedio"));
		
		return alumno;
	}

}
