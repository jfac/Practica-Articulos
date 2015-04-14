package mod.Bd;
//librerias
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.SQLWarning;
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
			//e.printStackTrace();
			PracticaUtilities.printSQLException(e);
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
	 * @param String
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet ejecutar(String sql) throws SQLException
	{
		//verify statement is created
		if(stmt!=null)
		{
			try
			{
				rset = stmt.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				PracticaUtilities.printSQLException(e);
				getWarningFromResulSet(rset);
			}
		}
		else
		{
			getWarningFromStatement(stmt);
		}
		return rset;
	}
	/**
	 * Actualiza la bd mediante una sentencia de sql INSERT, DELETE, or UPDATE
	 * @param String
	 * @return int numero de rows afectados
	 * @throws SQLException
	 */
	public int actualizar(String sql) throws SQLException
	{
		int result = 0;
		//verify statement is created
		if(stmt!=null){
			try 
			{
				result = stmt.executeUpdate(sql);
			} 
			catch (SQLException e) 
			{
				result = 0;
				PracticaUtilities.printSQLException(e);
			}
		}
		else{
			getWarningFromStatement(stmt);
		}
		return result;
	}
	
	/**
	 * Custom warning message for ResultSet
	 * @param ResultSet
	 * @throws SQLException
	 */
	public static void getWarningFromResulSet(ResultSet res) throws SQLException{
		Conexion.printWarnings(res.getWarnings());
	}
	
	/**
	 * Custom warning message for Statements
	 * @param Statement
	 * @throws SQLException
	 */
	public static void getWarningFromStatement(Statement stat)throws SQLException{
		printWarnings(stat.getWarnings());
	}
	
	/**
	 * Private method to create the custom message for ResultSet and Statements
	 * @param SQLWarning
	 * @throws SQLException
	 */
	private static void printWarnings(SQLWarning warning) throws SQLException{
		if(warning !=null){
			System.out.println("Message " + warning.getMessage());
			System.out.println("SQLState " + warning.getSQLState());
			System.out.println("Vender error code: ");
			System.out.println(warning.getErrorCode());
			System.out.println(" ");
			warning = warning.getNextWarning();
		}
	}
}
