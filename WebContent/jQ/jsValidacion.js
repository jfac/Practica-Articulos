var x;
x=$(document);
x.ready(inicialiazarEventos);
function inicialiazarEventos()
{
	$("#frmLogin").validate({
		  rules:{
			  txtUsuario:{
				  required: true,
				  minlength: 2,
				  maxlength: 30
				  },
			  txtPass:{
				  required: true,
				  minlength: 4,
				  maxlength: 30
				  }
			  },
			messages:{
				txtUsuario:{
					required: "Se requiere su usuario",
					minlength: $.validator.format("Por lo menos {0} caracteres"),
					maxlength: $.validator.format("Maximo {0} caracteres")
					},
					txtPass:{
						required: "Se requiere la contraseña",
						minlength: $.validator.format("Por lo menos {0} caracteres"),
						maxlength: $.validator.format("Maximo {0} caracteres")
					}
				}
		});
}