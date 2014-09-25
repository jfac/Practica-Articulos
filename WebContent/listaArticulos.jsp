<%
HttpSession sesion = request.getSession(true);

if (sesion.getAttribute("usuario") == null) 
{
	response.sendRedirect("login.jsp?err=Inicie sesion para poder accesar...");
}
%>
<%@page import = "bean.Bean" %>
<%@ page language="java" contentType="text/plain"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="bean.Bean.*" %>

<jsp:useBean id='listaArt' class="mod.Articulos.Articulos" scope='request'></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Articulos</title>
</head>
<body>
<form method="post" action="LoginOut">
<p><input type="submit" value="LoginOut" name="btnLoginOut"/></p>
</form>

<%
List<Bean>lista = new ArrayList<Bean>();
lista.addAll(listaArt.recuperar());
for(Bean bean: lista)
{
%>
<div class="pane" id="<%=bean.getIdArt() %>"></div>
<h3><%=bean.getNomArt() %></h3>
<p><%=bean.getStock() %></p>
<p><%=bean.getPrecio() %></p>
<a href="carrito.jsp?idArt=<%=bean.getIdArt()%>" class="Comprar">Comprar</a>
<%
}
%>


</body>
</html>