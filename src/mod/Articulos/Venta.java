package mod.Articulos;
//libreria local
import bean.BeanVenta;
import mod.Bd.*;
//libreria
import java.sql.*;

public class Venta 
{
	
	public BeanVenta recuperarCompra(String Id) 
	{
		String strSql = "select idVentas from ventas where idClientes=" + Id;
		BeanVenta bean = new BeanVenta();
		try {
			Conexion bd = new Conexion();
			ResultSet rset = bd.ejecutar(strSql);
			if (rset.next()) 
			{
				bean.setIdVta(rset.getInt(1));
			}
			rset = null;
			String sql = "select cantidad, monto from detallevta where idventas="+bean.getIdVta();
			rset = bd.ejecutar(sql);
			if(rset.next())
			{
				bean.setCantidad(rset.getInt(1));
				bean.setMonto(rset.getDouble(2));
			}
			rset.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bean;
	}//fin recuperar

}
