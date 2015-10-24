package com.cjavaperu.spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.cjavaperu.spring.beans.Alumno;
//import com.lowagie.text.Document;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfWriter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
//import com.lowagie.text.Document;
import com.itextpdf.text.Document;

@SuppressWarnings("unchecked")
public class PdfView extends AbstractIText5PdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
									Document document,
									PdfWriter writer, 
			                        HttpServletRequest request, 
			                        HttpServletResponse response) throws Exception {
		
		//SI DESEAMOS COLOCAR UN NOMBRE AL ARCHIVO GENERADO
		//SI DESEAMOS QUE EL ARCHIVO PDF SE DESCARGUE AUTOMÁTICAMENTE COLOCAMOS attachment
		response.setHeader( "Content-Disposition", "attachment;filename=" + "Itext5.pdf" );
		
		List<Alumno> alumnos = (List<Alumno>) model.get("alumnos");
		
		PdfPTable tabla = new PdfPTable(3);
		
		tabla.addCell("NOMBRE");
		tabla.addCell("PROMEDIO");
		tabla.addCell("ESTADO");
		
		for (Alumno alumno : alumnos) {
			;
			tabla.addCell(alumno.getNombre());
			tabla.addCell(alumno.getPromedio()+"");
			tabla.addCell(alumno.getEstado());
		}
		
		Paragraph header = new Paragraph(new Chunk("Reporte de Alumnos",FontFactory.getFont(FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk("Author: Raúl ",FontFactory.getFont(FontFactory.HELVETICA, 20)));
		Paragraph espacio = new Paragraph(new Chunk(" "));
		
		document.add(header);
		
		document.add(espacio);
		document.add(tabla);
		
		document.add(by);
		
	}

	

	

}
