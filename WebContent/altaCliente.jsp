<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrate</title>
</head>
<body>
<%
if(request.getParameter("err")!=null)
{
%>
<h2><%=request.getParameter("err") %></h2>
<% 
}
%>
<h1>Ingrese los siguientes datos:</h1>
<form method="post" action="AltaCliente">
<p>Nombre:<input type="text" name="txtNombre"/></p>
<p>Apellidos</p>
<p>Paterno<input type="text" name="txtApp"/></p>
<p>Materno<input type="text" name="txtApm"/></p>
<p>Password<input type="password" name="txtPass"/></p>
<p><input type="submit" value="Registrar" name="btnRegistrar"/><input type="reset" value="Cancelar"/></p>
</form>
</body>
</html>