var x;
function EliminarArticulo(idArt)
{
	if(confirm("Seguro que desa eliminar el articulo con id"+idArt+"?"))
		{
		  $.post("EliminarArticulo",{txtId:idArt},resultado);
		  //return false;
		  x = $('#'+idArt);
		}
}

function resultado(datos)
{
	if(datos==1)
	{
		x.fadeOut("slow",Elimanar);
	}
	else
	{
		alert("Error: "+ datos);
	}
}
function elimnarDiv()
{
	x.empty();
}