<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento de Alumnos</title>
</head>
<body>
	<h1>Mantenimiento de Alumnos</h1>
	<h3>${fecha}</h3>
	<span>${mensaje}</span>
	
	<form action="${pageContext.request.contextPath}/mantenimiento/registrarActualizar" method="post" >
		
		<input type="hidden" name="id" value="${alumno.id}" />
		<table>
			<tbody>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="nombre" value="${alumno.nombre}" /> <span style="color: red;" >${errornombre}</span></td>
				</tr>
				
				<tr>
					<td>Promedio</td>
					<td><input type="text" name="promedio" value="${alumno.promedio}" /> <span style="color: red;" >${errorpromedio}</span></td>
				</tr>
				<tr>
					<td colspan="2" ><input type="submit" value="Guardar" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<a href="${pageContext.request.contextPath}/mantenimiento/descargar?formato=excel">Descargar Excel</a>
	<a href="${pageContext.request.contextPath}/mantenimiento/descargar?formato=pdf">Descargar PDF</a>
	
	
		<table border="1px" cellpadding="5px" cellspacing="0">
		<thead>
			<tr>
				<th style="width:120px" >Nombre</th>
				<th style="width:120px" >Estado</th>
				<th style="width:50px" >Promedio</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="alumno" items="${alumnos}" varStatus="id">
				<tr>
					<td><c:out value="${alumno.nombre}"></c:out></td>
					<td><c:out value="${alumno.estado}"></c:out></td>
					<td><c:out value="${alumno.promedio}"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath}/mantenimiento/cargar?id=${alumno.id}">Actualizar</a>/
						<a
						href="${pageContext.request.contextPath}/mantenimiento/eliminar?id=${alumno.id}">Eliminar</a>
					</td>
<!-- 					<td><a -->
<%-- 						href="${pageContext.request.contextPath}/mantenimiento/cargar?id=${id.count}">Actualizar</a>/ --%>
<!-- 						<a -->
<%-- 						href="${pageContext.request.contextPath}/mantenimiento/eliminar?id=${id.count}">Eliminar</a> --%>
<!-- 					</td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
  
</body>
</html>