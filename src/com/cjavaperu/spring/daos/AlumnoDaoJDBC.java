package com.cjavaperu.spring.daos;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cjavaperu.spring.beans.Alumno;
import com.cjavaperu.rowmapper.extractor.AlumnoExtractor;
import com.cjavaperu.rowmapper.mappers.AlumnoRowMapper;

@Repository
public class AlumnoDaoJDBC implements AlumnoDao {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Alumno Alumno) {
		jdbcTemplate.update("insert into Alumno (vchAluNombre, vchAluPromedio) values (?,?)",
				Alumno.getNombre(), 
				Alumno.getPromedio() 
				);
	}

	@Override
	public void update(Integer id,Alumno Alumno) {
		jdbcTemplate.update("update Alumno set vchAluNombre = ?, vchAluPromedio = ? where intAluCodigo = ?",
				Alumno.getNombre(),  
				Alumno.getPromedio(), 
				id);
	}

	@Override
	public Alumno find(Integer id) {
		return jdbcTemplate.query("select * from Alumno where intAluCodigo = ?", new AlumnoExtractor(), id);
	}

	@Override
	public int delete(Integer id) {
		return jdbcTemplate.update("delete from Alumno where intAluCodigo = ?", id);
	}

	@Override
	public List<Alumno> findAll() {
		return jdbcTemplate.query("select * from Alumno", new AlumnoRowMapper());
	}

}
