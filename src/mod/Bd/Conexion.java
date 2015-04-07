package mod.Bd;
//librerias
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Conexion 
{
	private static String url = "jdbc:mysql://localhost/pracextra";
	private static String user = "root";
	private static String pass = "M1B4S3D3D4T0S";
	private Connection cnn = null;
	private ResultSet rset;
	private Statement stmt;
	private InitialContext itc = null;
	private DataSource ds = null;
	
	public Conexion() throws SQLException
	{
		cnn = getCon();
	}
	
	@SuppressWarnings("unused")
	/**
	 * Clase de conexion mediante JDBC MySql
	 * @return MySql JDBC Connection
	 * @exception SQLException
	 */
	private Connection getConexion() throws SQLException
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
	/**
	 * Clase de conexion mediante pool
	 * @return POOL Connection
	 * @exception SQLException
	 */
	private synchronized Connection getCon() throws SQLException{
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
			// the operation requested cannot be performed.
			e.printStackTrace();
		} catch (SQLException e) {
			// Sql Exception
			e.printStackTrace();
		}
		return cnn;
		
	}
	
	/**
	 * Cierra todas las conexiones
	 */
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
	/**
	 * Metodo para ejecutar sentencias SELECT
	 * @param sql
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet ejecutar(String sql) throws SQLException
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
	/**
	 * Actualiza la bd mediante una sentencia de sql INSERT, DELETE, or UPDATE
	 * @param sql
	 * @return int 2 si fue exitosa
	 * @throws SQLException
	 */
	public int actualizar(String sql) throws SQLException
	{
		int result = 0;
		if(stmt!=null){
			try 
			{
				result = stmt.executeUpdate(sql);
			} 
			catch (SQLException e) 
			{
				result = 0;
				printSQLException(e);
			}
		}
		return result;
	}
	/**
	 * Method for custom print SQLExceptions
	 * @param ex
	 */
	public static void printSQLException(SQLException ex){
		for(Throwable e : ex){
			if(e instanceof SQLException){
				if(ignoreSQLException(((SQLException)e).getSQLState()) == false){
					e.printStackTrace(System.err);
					System.err.println("SQLState: "+
					((SQLException)e).getSQLState()
							);
					
					System.err.println("Error Code: "+
							((SQLException)e).getErrorCode()
									);
					
					System.err.println("Message "+ e.getMessage());
					
					Throwable t = ex.getCause();
					while(t !=null){
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	}
	/**
	 * Method for ignore sql exceptions
	 * @param sqlState
	 * @return
	 */
	public static boolean ignoreSQLException(String sqlState) {
	    if (sqlState == null) {
	      System.out.println("The SQL state is not defined!");
	      return false;
	    }
	    //just for example
	    // X0Y32: Jar file already exists in schema
	    if (sqlState.equalsIgnoreCase("X0Y32"))
	      return true;
	    // 42Y55: Table already exists in schema
	    if (sqlState.equalsIgnoreCase("42Y55"))
	      return true;
	    return false;
	  }

}
