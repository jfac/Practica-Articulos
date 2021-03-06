package servlet.Cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bean;
import mod.Cliente.Cliente;
import mod.Cliente.Comparar;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String password = request.getParameter("txtPass");
		String usuario = request.getParameter("txtUsuario");
		
		RequestDispatcher rd;
		if (password != "" && password != null && usuario != ""
				&& usuario != null) 
		{
			Cliente mod = new Cliente();
			Comparar comparar = new Comparar();
			Bean bean = new Bean();
			bean.setPass(password);
			bean.setNomClient(usuario);

			if (mod.autentificar(bean)) 
			{
				HttpSession sesion = request.getSession(true);
				String jsp = comparar.comparar(bean.getTipo());
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("id", bean.getIdClient());
				response.sendRedirect(jsp);
			}
			else
			{
				//response.sendRedirect("login.jsp?err=Por favor introdusca usuario y contraseņa correctos...");
				request.setAttribute("err","Por favor introdusca usuario y contraseņa correctos...");
				rd = getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("err","Por favor introdusca usuario y contraseņa correctos...");
			rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}//finmetodo

}
