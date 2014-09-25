package mod.Bd;
//librerias
import java.sql.*;
import java.sql.ResultSet;

public class Conexion 
{
	private String url = "jdbc:mysql://localhost/pracextra";
	private String user = "root";
	private String pass = "Skoliro";
	private Connection cnn = null;
	private ResultSet rset;
	private Statement stmt;
	
	public Conexion()
	{
		cnn = getConexion();
	}
	
	private Connection getConexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			cnn = java.sql.DriverManager.getConnection(url,user,pass);
			if(cnn != null)
			{
				stmt = cnn.createStatement();
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cnn;
	}
	
	public void closeConexion()
	{
		try 
		{
			if(cnn != null)
			{
				cnn.close();
				cnn = null;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet ejecutar(String sql)
	{
		try 
		{
			rset = stmt.executeQuery(sql);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rset;
	}
	
	public int actualizar(String sql)
	{
		int result = 0;
		try 
		{
			result = stmt.executeUpdate(sql);
		} 
		catch (Exception e) 
		{
			result = 2;
			e.printStackTrace();
		}
		return result;
	}

}
