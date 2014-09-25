<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getParameter("err")!= null)
{
%>
<h2><%=request.getParameter("err") %></h2>
<% 
}
%>
<h1>Ingrese su nombre y password</h1>
<form method="post" action="Login">
<p>Nombre:<input type="text" name="txtUsuario"/></p>
<p>Password:<input type="password" name="txtPass"/></p>
<p><input type="submit" value="Login" name="btnLogin"/><input type="reset" value="Cancelar"/></p>
<a href="altaCliente.jsp" class="alta">Registrarse</a>
</form>
</body>
</html>