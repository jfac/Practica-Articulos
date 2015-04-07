<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrate</title>
</head>
<body>
	<c:if test="${empty param.err}">
		<h2>${param.err}</h2>
	</c:if>

	<h1>Ingrese los siguientes datos:</h1>
	<form method="post" action="AltaCliente">
		<p>
			Nombre:<input type="text" name="txtNombre" />
		</p>
		<p>Apellidos</p>
		<p>
			Paterno<input type="text" name="txtApp" />
		</p>
		<p>
			Materno<input type="text" name="txtApm" />
		</p>
		<p>
			Password<input type="password" name="txtPass" />
		</p>
		<p>
			<input type="submit" value="Registrar" name="btnRegistrar" /><input
				type="reset" value="Cancelar" />
		</p>
	</form>
</body>
</html>