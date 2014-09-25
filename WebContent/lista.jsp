<%
HttpSession sesion = request.getSession(true);

if (sesion.getAttribute("usuario") == null) 
{
	response.sendRedirect("login.jsp?err=Inicie sesion para poder accesar...");
}
%>
<%@page import = "bean.Bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="bean.Bean.*" %>

<script type='text/javascript' src='jQ/jquery-1.7.1.js'></script>
<script type='text/javascript' src='jQ/jquery.validate.js'></script>
<script type='text/javascript' src='jQ/jsLista.js'></script>
<script type='text/javascript' src='jQ/jsValidacion.js'></script>

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
<a href="altaArticulo.jsp" class="actualizar">Nuevo articulo</a>
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
<button onClick="EliminarArticulo('<%=bean.getIdArt() %>');" id="idArt" alt="delete" class="delete" name="btnEliminar">Eliminar</button>
<a href="modificarArticulo.jsp?idArt=<%=bean.getIdArt() %>" class="actualizar">Modificar</a>
<%
}
%>


</body>
</html>