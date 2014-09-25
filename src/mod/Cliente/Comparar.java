package mod.Cliente;

public class Comparar 
{
	public String comparar(String tipos)
	{
		
		String res = "nor";
		if(tipos.equals(res))
		 {
			 res="listaArticulos.jsp";
		 }
		 else if(tipos.equals("adm"))
		 {
			 res="lista.jsp";
		 }
		 else 
		 {
			 res = "login.jsp?err=Por favor introdusca usuario y contraseña correctos...";
		 }
		return res;
	}

}
