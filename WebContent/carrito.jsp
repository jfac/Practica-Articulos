<%
	HttpSession sesion = request.getSession(true);

	if (sesion.getAttribute("usuario") == null) {
		response.sendRedirect("login.jsp?err=Inicie sesion para poder accesar...");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='artMod' class="mod.Articulos.Articulos" scope='request'></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito</title>
<script type='text/javascript' src='js/jquery-1.7.1.js'></script>
<script type='text/javascript' src='js/jquery.validate.js'></script>
<script type='text/javascript' src='js/jsLista.js'></script>
<script type='text/javascript' src='js/jsValidacion.js'></script>
</head>
<body>
	<c:set var="art" value="${artMod.recuperarArt(param.idArt)}" />
	<form action="ComprarServl" method="POST">
		<input type="TEXT" id="txtIdArt" name="txtIdArt" readonly="readonly"
			value="${art.getIdArt()}" />
		<p>
			Nombre:<input type="text" id="txtNombre" name="txtNombre"
				value="${art.getNomArt()}" />
		</p>
		<p>
			Stock:<input type="text" id="txtStock" name="txtStock"
				value="${art.getStock()}" />
		</p>
		<p>
			Precio:<input type="text" id="txtPrecio" name="txtPrecio"
				value="${art.getPrecio()}" />
		</p>
		<p>
			Cantidad: <select name="optCantidad" id="optCantidad">
				<c:forEach begin="1" end="${art.getStock()}" varStatus="status">
					<option value="${status.count}">${status.count }</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Comprar" name="btnComprar" />
	</form>
</body>
</html>