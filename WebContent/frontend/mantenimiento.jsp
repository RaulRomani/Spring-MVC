<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento de Alumnos</title>
</head>
<body>
	<h1>${bienvenido}</h1>
	<h3>${fecha}</h3>
	<span>${mensaje}</span>
	
	<form action="${pageContext.request.contextPath}/mantenimiento/registrarActualizar" method="post" >
		
		<input type="hidden" name="id" value="${id}" />
		<table>
			<tbody>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="nombre" value="${Alumno.nombre}" /></td>
				</tr>
				
				<tr>
					<td>Promedio</td>
					<td><input type="text" name="promedio" value="${Alumno.promedio}" /></td>
				</tr>
				<tr>
					<td colspan="2" ><input type="submit" value="Guardar" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	
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
			<c:forEach var="Alumno" items="${Alumnos}" varStatus="id">
				<tr>
					<td><c:out value="${Alumno.nombre}"></c:out></td>
					<td><c:out value="${Alumno.estado}"></c:out></td>
					<td><c:out value="${Alumno.promedio}"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath}/mantenimiento/cargar?id=${id.count}">Actualizar</a>/
						<a
						href="${pageContext.request.contextPath}/mantenimiento/eliminar?id=${id.count}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  
</body>
</html>