package mod.Bd;
//librerias
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class Conexion 
{
	private String url = "jdbc:mysql://localhost/pracextra";
	private String user = "root";
	private String pass = "M1B4S3D3D4T0S";
	private Connection cnn = null;
	private ResultSet rset;
	private Statement stmt;
	private InitialContext itc = null;
	private Context cnt = null;
	private DataSource ds = null;
	
	public Conexion()
	{
		cnn = getCon();
	}
	
	@SuppressWarnings("unused")
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
	private Connection getCon(){
		try {
			itc= new InitialContext();
			ds = (DataSource) itc.lookup("java:comp/env/jdbc/pracextra");
			cnn = ds.getConnection();
			if(cnn == null){
				throw new SQLException("Error establishing connection!");
			}else{
				stmt = cnn.createStatement();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
			if(rset!=null){
				rset.close();
				rset = null;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet ejecutar(String sql)
	{
		if(stmt!=null)
		{
			try 
			{
				rset = stmt.executeQuery(sql);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return rset;
	}
	
	public int actualizar(String sql)
	{
		int result = 0;
		if(stmt!=null){
			try 
			{
				result = stmt.executeUpdate(sql);
			} 
			catch (Exception e) 
			{
				result = 2;
				e.printStackTrace();
			}
		}
		return result;
	}

}
