<%@page import="Clases.LibrosDAO"  %>
<%@page import="Clases.Libros"%>
<%@page import="java.util.List"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca Codo a Codo - Inicio</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw==" crossorigin="anonymous" referrerpolicy="no-referrer" /> 
</head>
<body>
<h1 style="text-align: center">Listado de Libros</h1>

<div  class="container" >
		<div class="row" >
				<a class="btn btn-outline-success btn-md col-2 m-4" href="LibrosController?accion=nuevo">Agregar Libro</a>
				
				<table class="table table-success" >
				<thead>
					<th>Id</th>
					<th>Título</th>
					<th>Autor</th>
					<th>Edición</th>
					<th>Género</th>					
					<th>Estado</th>
					<th class="text-center">Modificar</th>
					<th class="text-center">Eliminar</th>				
				</thead>
				<%
				List<Libros> resultado=null;
				LibrosDAO libro=new LibrosDAO();
				resultado=libro.listarLibros();
				
				
				
				for(int i=0;i<resultado.size();i++)
				{
				String ruta="LibrosController?accion=modificar&id="+resultado.get(i).getId_libro();	
				String rutaE="LibrosController?accion=eliminar&id="+resultado.get(i).getId_libro();
				%>			
				<tr>
				<td><%=resultado.get(i).getId_libro()%></td>				
				<td><%=resultado.get(i).getTitulo() %></td>				
				<td><%=resultado.get(i).getAutor() %></td>
				<td><%=resultado.get(i).getEdicion()%></td>
				<td><%=resultado.get(i).getGenero() %></td>			
				<td><%=resultado.get(i).getEstado()%></td>
				<td class="text-center"><a href=<%=ruta%>> <i class="far fa-edit"></i> </a></td>
				<td class="text-center"><a href=<%=rutaE%>><i class="far fa-trash-alt"></i> </a></td>
				</tr>
				
				<%
				}
				%>

				</table>
	
		</div>
</div>
</body>
</html>