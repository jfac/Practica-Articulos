<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type='text/javascript' src='jQ/jquery-1.7.1.js'></script>
<script type='text/javascript' src='jQ/jquery.validate.js'></script>
</head>
<body>
	<c:if test="${err!=null}">
		<h2>${err}</h2>
	</c:if>
	<h1>Ingrese su nombre y password</h1>
	<form id="frmLogin" method="post" action="Login">
		<p>
			Nombre:<input type="text" id="txtUsuario" name="txtUsuario" />
		</p>
		<p>
			Password:<input type="password" id="txtPass" name="txtPass" />
		</p>
		<p>
			<input type="submit" value="Login" name="btnLogin" /><input
				type="reset" value="Cancelar" />
		</p>
		<a href="altaCliente.jsp" class="alta">Registrarse</a>
	</form>
</body>
</html>