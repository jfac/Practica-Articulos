package mod.Articulos;

//librerias
import bean.*;
import mod.Bd.*;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Articulos {

	/**
	 * Insert into table articulos
	 * @param Bean
	 * @return String number of rows affected or the error message
	 */
	public String insertar(Bean bean) {
		String Ins = "1";
		String sql = "INSERT INTO articulos(Nom,Stock,precio)" + "values('"
				+ bean.getNomArt() + "','" + bean.getStock() + "','"
				+ bean.getPrecio() + "')";
		try {
			Conexion con = new Conexion();
			con.actualizar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			Ins = e.getMessage();
		}
		return Ins;
	}// fin insertar

	/**
	 * method for a Sell
	 * @param Bean
	 * @return String if the sell was correct or the message if something go wrong.
	 * @throws ParseException
	 */
	public String Compra(Bean bean) throws ParseException {
		String Ins = "1";
		java.util.Date date = new java.util.Date();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dates = date.toString();
		int res = 0;
		// dates = format.parse(dates).toString();
		String sqlCliente = "Select idClientes from clientes where Nombres='"
				+ bean.getNomClient() + "'";
		Conexion con = null;
		try {
			con = new Conexion();
			ResultSet resu = con.ejecutar(sqlCliente);
			while (resu.next()) {
				bean.setIdClient(resu.getInt(1));
			}
			resu.close();
			String sql = "INSERT INTO ventas(idClientes, fecha)" + "values('"
					+ bean.getIdClient() + "','" + dates + "')";
			res = con.actualizar(sql);
			if (res == 1) {
				Ins = detalleCompra(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Ins = e.getMessage();
		} finally {
			con.closeConexion();
		}
		return Ins;
	}// fin comprar

	/**
	 * Detail of the sell
	 * @param bean
	 * @return String 1 if everything was correct or a error message if something was wrong
	 */
	private String detalleCompra(Bean bean) {
		String Ins = "1";
		String sqlvta = "select max(idVentas) from ventas";
		Conexion con = null;
		try {
			con = new Conexion();
			ResultSet rset = con.ejecutar(sqlvta);
			while (rset.next()) {
				bean.setIdVta(rset.getInt(1));
			}
			rset.close();
			Double monto = bean.getPrecio() * bean.getCantidad();
			bean.setMonto(monto);

			String sqlDetalle = "INSERT INTO detallevta(idventas,idArticulos,cantidad,monto)"
					+ "values('"
					+ bean.getIdVta()
					+ "','"
					+ bean.getIdArt()
					+ "','"
					+ bean.getCantidad()
					+ "','"
					+ bean.getMonto()
					+ "')";

			int res = con.actualizar(sqlDetalle);
			if (res == 1) {
				Ins = Integer.toString(res);
				bean.setStock(bean.getStock()-bean.getCantidad());
				actualizar(bean); 
			}

			// actualizar(bean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Ins = e.getMessage();
		} finally {
			con.closeConexion();
		}
		return Ins;
	}// fin insertar

	/**
	 * A list of all the articulos
	 * @return List Bean
	 */
	public List<Bean> recuperar() {
		List<Bean> lst = new ArrayList<Bean>();
		String sql = "select * from articulos";
		Conexion con = null;
		try {
			con = new Conexion();
			ResultSet rset = con.ejecutar(sql);
			while (rset.next()) {
				Bean bean = new Bean();
				bean.setIdArt(rset.getInt(1));
				bean.setNomArt(rset.getString(2));
				bean.setStock(rset.getInt(3));
				bean.setPrecio(rset.getDouble(4));
				lst.add(bean);
			}
			rset.close();
		} catch (Exception e) {
			lst = null;
			e.printStackTrace();
		} finally {
			con.closeConexion();
		}
		return lst;
	}// fin de la lista
		// verifica si esta vacia la consulta

	/**
	 * Method for show if the table articulos are fill
	 * @return true if no articulos or false if there is something
	 */
	public boolean isEmpty() {
		boolean res = true;
		String sql = "select count(*) from articulos";
		Conexion con = null;
		try {
			con = new Conexion();
			ResultSet rset = con.ejecutar(sql);
			if (rset.next()) {
				res = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			res = true;
		} finally {
			con.closeConexion();
		}
		return res;
	}

	/**
	 * Get the data of one article 
	 * @param String id of the article
	 * @return bean of the idArticulos requested
	 */
	public Bean recuperarArt(String IdArt) {
		String sql = "select*from articulos where idArticulos=" + IdArt;
		Bean bean = new Bean();
		try {
			Conexion bd = new Conexion();
			ResultSet rset = bd.ejecutar(sql);
			if (rset.next()) {
				bean.setIdArt(rset.getInt(1));
				bean.setNomArt(rset.getString(2));
				bean.setStock(rset.getInt(3));
				bean.setPrecio(rset.getDouble(4));
			}
			rset.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bean;
	}// fin recuperar

	/**
	 * Update de table articulos with the current information
	 * @param Bean
	 * @return String with the number of row affected or the error message if something go wrong
	 */
	public String actualizar(Bean bean) {
		int modificar = 0;
		String Modifi = "0";
		String sql = "update articulos set Nom = '" + bean.getNomArt()
				+ "', Stock = '" + bean.getStock() + "',precio='"
				+ bean.getPrecio() + "' where idArticulos = '"
				+ bean.getIdArt() + "'";
		Conexion con = null;
		try {
			con = new Conexion();
			modificar = con.actualizar(sql);
			Modifi = Integer.toString(modificar);
		} catch (Exception e) {
			e.printStackTrace();
			Modifi = e.getMessage();
		}finally{
			con.closeConexion();
		}
		return Modifi;
	}// fin actualizarArticulos

	/**
	 * Delete an article using the requested id
	 * @param String id of the article
	 * @return String The number of rows affected or the error message if something get wrong
	 */
	public String Eliminar(String idArt) {
		String eliminar = "1";
		String sql = "delete from articulos where idArticulos ='" + idArt + "'";
		try {
			Conexion con = new Conexion();
			con.actualizar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			eliminar = e.getMessage();
		}
		return eliminar;
	}

}
