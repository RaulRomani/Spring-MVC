package com.cjavaperu.spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.cjavaperu.spring.beans.Alumno;

@SuppressWarnings("unchecked")
public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
									  HSSFWorkbook workbook, 
									  HttpServletRequest request, 
									  HttpServletResponse response) throws Exception {
		
		//SI DESEAMOS COLOCAR UN NOMBRE AL ARCHIVO GENERADO
		//response.setHeader( "Content-Disposition", "attachment;filename=" + "archivito.xls" );
		
		List<Alumno> alumnos = (List<Alumno>) model.get("alumnos");
		
		HSSFSheet hoja = workbook.createSheet();
		
		HSSFRow fila = hoja.createRow(0);
		fila.createCell(0).setCellValue("NOMBRES");
		fila.createCell(1).setCellValue("APELLIDOS");
		fila.createCell(2).setCellValue("EDAD");
		
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno Alumno = alumnos.get(i);
			fila = hoja.createRow(i+1);
			fila.createCell(0).setCellValue(Alumno.getNombre());
			fila.createCell(1).setCellValue(Alumno.getPromedio());
			fila.createCell(2).setCellValue(Alumno.getEstado());
		}

	}

}
