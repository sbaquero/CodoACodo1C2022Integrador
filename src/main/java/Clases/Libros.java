package Clases;

public class Libros 
{
	private int id_libro;
	private String titulo;
	private String autor;
	private int edicion;
	private String genero;
	private boolean estado;
	
	public Libros(int id,String titulo,String autor,int edicion,String genero,boolean estado)
	{
		this.setId_libro(id);     
		this.setTitulo(titulo);  
		this.setAutor(autor);
		this.setEdicion(edicion);
		this.setGenero(genero);	
		this.setEstado(estado);
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
