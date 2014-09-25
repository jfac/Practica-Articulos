package servlet.Cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mod.Cliente.Cliente;

import bean.Bean;

/**
 * Servlet implementation class AltaCliente
 */
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request, response);
	}

	protected void doGetPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		Bean bean = new Bean();
		Cliente mod = new  Cliente();
		
		try
		{
			bean.setNomClient(request.getParameter("txtNombre"));
			bean.setApP(request.getParameter("txtApp"));
			bean.setApM(request.getParameter("txtApm"));
			bean.setPass(request.getParameter("txtPass"));
			bean.setTipo("nor");
			String res = mod.Insertar(bean);
			if(res.equals("1"))
			{
			response.sendRedirect("login.jsp");
			}
			else 
			{
				response.sendRedirect("altaCliente.jsp?err=Error");
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
