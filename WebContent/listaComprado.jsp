<%@page import="mod.Articulos.Venta"%>
<%@page import="bean.BeanVenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.usuario==null }">
	<jsp:forward page="login.jsp">
		<jsp:param name="err" value="Inicie sesion para poder accesar..."/>
	</jsp:forward>
</c:if>
<jsp:useBean id='listaArt' class="mod.Articulos.Venta" scope='request'></jsp:useBean>
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
<c:set var="compra" value="${listaArt.recuperarCompra(idVta)}" />
<table>
	<tr>
		<td>Clave Venta</td>
		<td>Clave Articulo</td>
		<td>Cantidad</td>
		<td>Monto</td>
	</tr>
	<tr>
		<td>${compra.getIdVta()}</td>
		<td>${compra.getIdArticulos()}</td>
		<td>${compra.getCantidad()}</td>
		<td>${compra.getMonto()}</td>
	</tr>
</table>
</body>
</html>