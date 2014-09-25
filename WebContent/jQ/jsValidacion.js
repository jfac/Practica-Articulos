var x;
x=$(document);
x.ready(inicializarEventos);

function inicialiazarEventos()
{
	$("#frmArticulos").validate
	(
			{
				rules:
					{
					txtStock:
						{
						required :true,
						digits: true,
						minlegth: 1,
						maxlenght: 3
						}?//fin txt
			        txtNombre:
			        	{
			        	required: true,
			        	char:true,
			        	minlegth:3,
			        	maxlenght:45
			        	}?
			        txtPrecio:
					    {
					     required: true,
					     digit:true,
					     minlegth:4,
					     maxlenght:10
					    }?
			        txtCantidad:
					    {
					     required: true,
					     digit:true,
					     minlegth:1,
					     maxlenght:10
					    }
					}//finrules
			}
	);//fin frmArticulos
}