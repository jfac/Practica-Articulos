package servletArticulos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mod.Articulos.Articulos;
import bean.Bean;

/**
 * Servlet implementation class ComprarServl
 */
@WebServlet("/ComprarServl")
public class ComprarServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarServl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		Bean bean = new Bean();
		Articulos mod = new Articulos();
		HttpSession sesion = request.getSession();
		try
		{
			
			bean.setNomArt(request.getParameter("txtNombre"));
			bean.setIdArt(Integer.parseInt(request.getParameter("txtIdArt")));
			String opt[]=request.getParameterValues("optCantidad");
			bean.setCantidad(Integer.parseInt(opt[0]));
			bean.setStock(Integer.parseInt(request.getParameter("txtStock")));
			bean.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
			bean.setNomClient(sesion.getAttribute("usuario").toString());
			String res = mod.Compra(bean);
			if(res.equals("1"))
			{
				request.setAttribute("idVta", String.valueOf(bean.getIdVta()));
				RequestDispatcher rd = request.getRequestDispatcher("listaComprado.jsp");
				rd.forward(request, response);
			}
			else
			{
				
				response.sendRedirect("carrito.jsp?err=Error no se pudo realizar su compra");
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
