package Clases;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/LibrosController")
public class LibrosController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public LibrosController() 
    {
        super();        
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LibrosDAO librosDAO=null;
		try 
		{
		librosDAO=new LibrosDAO();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String accion;
		RequestDispatcher dispatcher=null;
		
		accion=request.getParameter("accion");
		
		if(accion==null||accion.isEmpty())		
		{
			dispatcher=request.getRequestDispatcher("Vistas/Libros.jsp");
		}	
		else if(accion.equals("modificar"))
		{
			dispatcher=request.getRequestDispatcher("Vistas/modificar.jsp");
		}
		else if(accion.equals("actualizar"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String titulo=request.getParameter("titulo");
			String autor=request.getParameter("autor");
			int edicion=Integer.parseInt(request.getParameter("edicion"));
			String genero=request.getParameter("genero");			
			Libros libro=new Libros(id,titulo,autor,edicion,genero,true);			
			librosDAO.actualizarLibro(libro);			
			dispatcher=request.getRequestDispatcher("Vistas/Libros.jsp");			
		}
		else if(accion.equals("eliminar"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			librosDAO.eliminarLibro(id);
			dispatcher=request.getRequestDispatcher("Vistas/Libros.jsp");
		}
		else if(accion.equals("nuevo"))
		{
			dispatcher=request.getRequestDispatcher("Vistas/nuevo.jsp");
		}
		else if(accion.equals("insert"))
		{
			String titulo=request.getParameter("titulo");
			String autor=request.getParameter("autor");
			int edicion=Integer.parseInt(request.getParameter("edicion"));
			String genero=request.getParameter("genero");			
			Libros libro=new Libros(0,titulo,autor,edicion,genero,true);	
			librosDAO.insertarLibro(libro);
			dispatcher=request.getRequestDispatcher("Vistas/Libros.jsp");
		}
			
		
		
		
		
		
		
		
		
		
		
		
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
