package servletArticulos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mod.Articulos.Articulos;

/**
 * Servlet implementation class EliminarArticulo
 */
@WebServlet("/EliminarArticulo")
public class EliminarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarArticulo() {
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
		String Result = "";

		response.setContentType("txt/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("txtId");
		Articulos mod =new Articulos();

		try 
		{
			Result = mod.Eliminar(id);
			if (Result.equals("1")) 
			{
				Result = "1";
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			Result = e.getMessage();
		}

		out.println(Result);
	}

}
