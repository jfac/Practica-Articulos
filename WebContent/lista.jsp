<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="bean.Bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.usuario==null }">
	<jsp:forward page="login.jsp">
		<jsp:param name="err" value="Inicie sesion para poder accesar..."/>
	</jsp:forward>
</c:if>
<jsp:useBean id='listaArt' class="mod.Articulos.Articulos" scope='request'></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Articulos</title>
<script type='text/javascript' src='jQ/jquery-1.7.1.js'></script>
<script type='text/javascript' src='jQ/jquery.validate.js'></script>
<script type='text/javascript' src='jQ/jsLista.js'></script>
<script type='text/javascript' src='jQ/jsValidacion.js'></script>
</head>
<body>
<form method="post" action="LoginOut">
<p><input type="submit" value="LoginOut" name="btnLoginOut"/></p>
</form>
<a href="altaArticulo.jsp" class="actualizar">Nuevo articulo</a>

<c:if test="${listaArt.isEmpty()}">No hay articulos</c:if>
	<c:choose>
		<c:when test="${listaArt.isEmpty()}">No hay articulos</c:when>
		<c:otherwise>
			<c:forEach items="${listaArt.recuperar()}" var="art" varStatus="status">
				<div class="pane" id="${art.getIdArt()}">
					<div class="data">
						<h3>${art.getNomArt()}</h3>
						<p>${art.getStock()}</p>
						<p>${art.getPrecio()}</p>
						<button onClick="EliminarArticulo('${art.getIdArt()}');" id="idArt" alt="delete" class="delete" name="btnEliminar">Eliminar</button>
						<a href="modificarArticulo.jsp?idArt=${art.getIdArt()} " class="actualizar">Modificar</a>
					</div>
				</div>
				<div></div>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>