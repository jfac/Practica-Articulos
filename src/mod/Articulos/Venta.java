package mod.Articulos;
//libreria local
import bean.BeanVenta;
import mod.Bd.*;
//libreria
import java.sql.*;

public class Venta 
{
	
	public BeanVenta recuperarCompra(String IdVta) 
	{
		BeanVenta bean = new BeanVenta();
		try {
			Conexion bd = new Conexion();
			ResultSet rset = null;
			String sql = "select cantidad, monto, idarticulos from detallevta where idventas="+IdVta;
			rset = bd.ejecutar(sql);
			if(rset.next())
			{
				bean.setCantidad(rset.getInt(1));
				bean.setMonto(rset.getDouble(2));
				bean.setIdArticulos(rset.getInt(3));
				bean.setIdVta(Integer.valueOf(IdVta));
			}
			rset.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bean;
	}//fin recuperar

}
