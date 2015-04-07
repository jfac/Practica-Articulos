var x;
x=$(document);
x.ready(inicialiazarEventos);

function inicialiazarEventos()
{
	$("#frmLogin").validate
	(
			{
				rules:
					{
					txtUsuario:
						{
						required :true,
						digits: true,
						minlegth: 3,
						maxlenght: 20
						}?
					txtPass:
			        	{
			        	required: true,
			        	char:true,
			        	minlegth:3,
			        	maxlenght:45
			        	}
					}//finrules
			}
	);//fin frmArticulos
	
}