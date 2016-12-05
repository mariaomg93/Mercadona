

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class ControladorEntrada
 */
@WebServlet("/ControladorEntrada")
public class ControladorEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEntrada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String nombre= request.getParameter("nombre");
		String edad= request.getParameter ("edad");
		String usuario= request.getParameter("usuario");
		String contraseña= request.getParameter("contrasenha");
		String usuarioReg= request.getParameter("user");
		String passReg= request.getParameter("password");
				
		MysqlConnect con=MysqlConnect.getDbCon();
		ResultSet rs=null;
		ResultSet login= null;
		if(request.getParameter("aceptar1") != null)
		{
			try {
				login= con.query("SELECT * FROM clientes WHERE PASSWORD='"+contraseña+"' and user='"+usuario+"'");
				if(login.next())
				{
					request.setAttribute("usuario", login);
					request.getRequestDispatcher("html/Miperfil.html").forward(request, response);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (request.getParameter("aceptar2") != null){
			try {
				String query="insert into clientes values(null,'"+nombre+"','"+edad+"','"+usuarioReg+"','"+passReg+"')";
				System.out.print(query);
				con.insert(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
		if (request.getParameter("inicio") != null){
			request.getRequestDispatcher("index.html").forward(request, response);
			
}
		
		if (request.getParameter("productos") != null){
			request.getRequestDispatcher("html/productos.html").forward(request, response);
}
		
		if (request.getParameter("miperfil") != null){
			request.getRequestDispatcher("html/Miperfil.html").forward(request, response);
}
		
		}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}}
	


