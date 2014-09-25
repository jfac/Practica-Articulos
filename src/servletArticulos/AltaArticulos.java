package servletArticulos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mod.Articulos.Articulos;

import bean.Bean;

/**
 * Servlet implementation class AltaArticulos
 */
@WebServlet("/AltaArticulos")
public class AltaArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaArticulos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Bean bean = new Bean();
		Articulos mod = new Articulos();
		
		try
		{
			String nom  =request.getParameter("txtNombre");
			int stock = Integer.parseInt((request.getParameter("txtStock")));
			double precio = Double.parseDouble(request.getParameter("txtPrecio"));
			bean.setNomArt(nom);
			bean.setStock(stock );
			bean.setPrecio(precio);
			mod.insertar(bean);
			response.sendRedirect("lista.jsp");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
