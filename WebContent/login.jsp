<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type='text/javascript' src='jQ/jquery-1.11.2.min.js'></script>
<script type='text/javascript' src='jQ/jquery.validate_1.13.1.min.js'></script>
<script type='text/javascript' src='jQ/jsValidacion.js'></script>
</head>
<body>
	<c:choose>
		<c:when test="${err!=null }">
			<h2>${err}</h2>
		</c:when>
		<c:when test="${param.err!=null }">
			<h2>${param.err}</h2>
		</c:when>
	</c:choose>
	<h1>Ingrese su nombre y password</h1>
	<form id="frmLogin" method="post" action="Login">
		<p>
			Nombre:<input type="text" value="${param.txtUsuario}" id="txtUsuario" name="txtUsuario" />
		</p>
		<p>
			Password:<input type="password" value="${param.txtPass}"  id="txtPass" name="txtPass" />
		</p>
		<p>
			<input id="btnLogin" type="submit" value="Login" name="btnLogin" />
			<input type="reset" value="Cancelar" />
		</p>
		<a href="altaCliente.jsp" class="alta">Registrarse</a>
	</form>
</body>
</html>