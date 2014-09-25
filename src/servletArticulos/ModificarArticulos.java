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
 * Servlet implementation class ModificarArticulos
 */
@WebServlet("/ModificarArticulos")
public class ModificarArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarArticulos() {
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
		Bean bean =new Bean();
		Articulos mod = new Articulos();
		
		bean.setIdArt(Integer.parseInt(request.getParameter("txtIdArt")));
		bean.setNomArt(request.getParameter("txtNombre"));
		bean.setStock(Integer.parseInt(request.getParameter("txtStock")));
		bean.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
		
		try
		{
			String res = mod.actualizar(bean);
			if(res.equals("1"))
			{
				response.sendRedirect("lista.jsp");
			}
			else
			{
				response.sendRedirect("modificarArticulo.jsp?err=Error al modificar");
			}
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}
	

}
