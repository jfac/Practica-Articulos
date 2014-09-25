package mod.Cliente;
//importClases locales
import bean.*;
import mod.Bd.Conexion;
//importar librerias
import java.sql.ResultSet;


public class Cliente 
{
	
	public String Insertar(Bean bean)
	{
		String ins = "1";
		String sql = "INSERT into clientes (Nombres,App,Apm,Password,Tipo) values('"+
		bean.getNomClient() + "','"+
		bean.getApP()+"','"+
		bean.getApM()+"','"+
		bean.getPass()+"','"+
		bean.getTipo()+
		"')";
		Conexion con = null;
		try
		{
			con = new Conexion();
			con.actualizar(sql);
		}
		catch (Exception e) 
		{
			e.getStackTrace();
			ins = e.getMessage();
		}
		finally{
			con.closeConexion();
		}
		return ins;
	}//fin insertar
	
	public Boolean autentificar(Bean bean)
	{
		Boolean entrar = false;
		String sql = "select*from clientes where Nombres = '"+
		 bean.getNomClient()+"' and password = '"+ bean.getPass()+"'";
		
		try 
		{
			Conexion con = new Conexion();
			ResultSet rset = con.ejecutar(sql);
			if(rset.next())
			{
				if(bean.getNomClient().equals(rset.getString("Nombres"))&&
						bean.getPass().equals(rset.getString("Password")))
				{
					entrar = true;
					bean.setIdClient(rset.getInt("idClientes"));
					bean.setNomClient(rset.getString("Nombres"));
					bean.setApP(rset.getString("App"));
					bean.setApM(rset.getString("Apm"));
					bean.setTipo(rset.getString("Tipo"));
				}
			}
			rset.close();
		} 
		catch (Exception e) 
		{
			entrar = false;
		}
		return entrar;
	}//finautentificar
	
	
}//fin clase
