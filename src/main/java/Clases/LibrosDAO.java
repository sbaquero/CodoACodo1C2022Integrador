package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrosDAO 
{
	Connection conexion;
	
	public LibrosDAO() throws ClassNotFoundException
	{
		Conexion con=new Conexion();
		conexion=con.getConnection();
	}
	
	
	public List<Libros> listarLibros()
	{
		PreparedStatement ps;
		ResultSet rs;
		List<Libros> lista=new ArrayList<>();
		
		
		try
		{
			ps=conexion.prepareStatement("select * from libros");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt("id_libro");
				String titulo=rs.getString("titulo");
				String autor=rs.getString("autor");
				int edicion=rs.getInt("edicion");
				String genero=rs.getString("genero");				
				boolean estado=rs.getBoolean("estado");				
				Libros libro=new Libros(id,titulo,autor,edicion,genero,estado);
				lista.add(libro);
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			return null;			
		}
		
		
		
		return lista;		
		
		
	}
	
	
	
	public Libros mostrarLibro(int _id)
	{
		PreparedStatement ps;
		ResultSet rs;
		Libros libro=null;
		
		
		try
		{
			ps=conexion.prepareStatement("select * from libros where id_libro=?");
			ps.setInt(1, _id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt("id_libro");
				String titulo=rs.getString("titulo");
				String autor=rs.getString("autor");
				int edicion=rs.getInt("edicion");
				String genero=rs.getString("genero");			
				boolean estado=rs.getBoolean("estado");				
				libro=new Libros(id,titulo,autor,edicion,genero,estado);							
			}	
			return libro;	
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			return null;	
		}
		
		
		
	}
	
	
	
	public boolean insertarLibro(Libros libro)
	{
		PreparedStatement ps;
		try
		{
			ps=conexion.prepareStatement("insert into libros (titulo,autor,edicion,genero,estado) values (?,?,?,?,?)");
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setInt(3, libro.getEdicion());
			ps.setString(4, libro.getGenero());			
			ps.setBoolean(5, libro.getEstado());
			ps.execute();	
			
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			return false;			
		}	
	}
	
	public boolean actualizarLibro(Libros libro)
	{
		PreparedStatement ps;
		try
		{
			ps=conexion.prepareStatement("update libros set titulo=? ,autor=?,edicion=?,genero=?,estado=? where id_libro=?");
			
			
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setInt(3, libro.getEdicion());
			ps.setString(4, libro.getGenero());			
			ps.setBoolean(5, libro.getEstado());
			ps.setInt(6, libro.getId_libro());
			ps.execute();
			
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			return false;			
		}
	}
	
	
	
		public boolean eliminarLibro(int _id)
		{
			PreparedStatement ps;
			try
			{
				ps=conexion.prepareStatement("delete from libros where id_libro=?");
				ps.setInt(1, _id);
				ps.execute();	
				
				return true;		
			}
			catch(SQLException e)
			{
				System.out.println("Error de conexion");
				return false;			
			}

		}
	
	
	
}
