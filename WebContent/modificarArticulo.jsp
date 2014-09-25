<%@page import="bean.Bean"%>
<%@page import="mod.Articulos.Articulos"%>
<%
HttpSession sesion = request.getSession(true);

if (sesion.getAttribute("usuario") == null) 
{
	response.sendRedirect("login.jsp?err=Inicie sesion para poder accesar...");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bean.Bean.*" %>

<jsp:useBean id='artMod' class="mod.Articulos.Articulos" scope='request'></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Articulos</title>
<script type='text/javascript' src='js/jquery-1.7.1.js'></script>
<script type='text/javascript' src='js/jquery.validate.js'></script>
<script type='text/javascript' src='js/jsLista.js'></script>
<script type='text/javascript' src='js/jsValidacion.js'></script>
</head>
<body>
<%
Bean bean = new Bean();
String idArt = request.getParameter("idArt");
bean = artMod.recuperarArt(idArt); 
%>
<form name="frmArticulos" method="post" action="ModificarArticulos"  >
<p>Clave:<input type="text" id="txtIdArt" name="txtIdArt" readonly="readonly" value="<%=bean.getIdArt()%>"/></p>
<p>Nombre:<input type="text" id="txtNombre" name="txtNombre" value="<%=bean.getNomArt()%>"/></p>
<p>Stock:<input type="text" id="txtStock" name="txtStock" value="<%=bean.getStock()%>"/></p>
<p>Precio:<input type="text" id="txtPrecio" name="txtPrecio" value="<%=bean.getPrecio()%>"/></p>
<input type="submit" value="Modificar" name="btnModificar"/>
</form>
</body>
</html>