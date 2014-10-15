<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="bean.Bean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.usuario==null }">
	<c:redirect url="login.jsp" >
		<c:param name="err" value="Inicie sesion para poder accesar..." />
	</c:redirect>
</c:if>
<jsp:useBean id='listaArt' class="mod.Articulos.Articulos" scope='request'></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Articulos</title>
</head>
<body>
	<form method="post" action="LoginOut">
		<p>
			<input type="submit" value="LoginOut" name="btnLoginOut" />
		</p>
	</form>
	<c:if test="${listaArt.isEmpty()}">No hay articulos</c:if>
	<c:choose>
		<c:when test="${listaArt.isEmpty()}">No hay articulos</c:when>
		<c:otherwise>
			<c:forEach items="${listaArt.recuperar()}" var="art"
				varStatus="status">
				<div class="pane" id="${status.count}">
					<div class="data">
						<h3>${art.getNomArt()}</h3>
						<p>${art.getStock()}</p>
						<p>${art.getPrecio()}</p>
						<form name="add-articule" method="POST" action="carrito.jsp">
							<input type="hidden" id="idArt" name="idArt"
								value="${art.getIdArt()}"> <input type="submit"
								value="agregar al carrito">
						</form>
					</div>
				</div>
				<div></div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>