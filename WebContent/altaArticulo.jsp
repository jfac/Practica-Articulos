<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Articulos</title>
<script type='text/javascript' src='jQ/jquery-1.7.1.js'></script>
<script type='text/javascript' src='jQ/jquery.validate.js'></script>
<script type='text/javascript' src='jQ/jsLista.js'></script>
<script type='text/javascript' src='jQ/jsValidacion.js'></script>
</head>
<body>
	<c:if test="${not empty param.err}">
		<h2>${param.err}</h2>
	</c:if>

	<form method="post" action="LoginOut">
		<input type="submit" value="Login Out" name="btnLoginOut" />
	</form>
	<a href="lista.jsp"> Lista</a>

	<h1>Ingrese los siguientes datos:</h1>
	<form id="frmArticulos" method="post" action="AltaArticulos">
		<p>
			Nombre:<input type="text" name="txtNombre" />
		</p>
		<p>
			Stock:<input type="text" name="txtStock" />
		</p>
		<p>
			Precio:<input type="text" name="txtPrecio" />
		</p>
		<p>
			<input type="submit" value="Guardar" name="btnGuardar" /><input
				type="reset" value="Cancelar" />
		</p>
	</form>
</body>
</html>