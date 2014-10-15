<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${param.err!=null}">
		<h2>${param.err}</h2>
	</c:if>
	<h1>Ingrese su nombre y password</h1>
	<form method="post" action="Login">
		<p>
			Nombre:<input type="text" name="txtUsuario" />
		</p>
		<p>
			Password:<input type="password" name="txtPass" />
		</p>
		<p>
			<input type="submit" value="Login" name="btnLogin" /><input
				type="reset" value="Cancelar" />
		</p>
		<a href="altaCliente.jsp" class="alta">Registrarse</a>
	</form>
</body>
</html>