<%@page import="Clases.LibrosDAO"  %>
<%@page import="Clases.Libros"%>
<%@page import="java.util.List"%>  


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca Codo a Codo - Modificar Libro</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 style="text-align: center">Modificar Libro</h1>

		<div class="row" >
				<%
				String id=request.getParameter("id");
				int mid;
				mid=Integer.parseInt(id);				
				Libros resultado=null;
				LibrosDAO  libro=new LibrosDAO();
				resultado=libro.mostrarLibro(mid);				
				%>
		
		<form class="p-5" action="LibrosController?accion=actualizar" method="post">
			
			<div class="mb-3">			
				<input type="hidden"  class="form-control" id="id" name="id"  value=<%=resultado.getId_libro() %> >
			</div>
			
			
			<div class="mb-3">
				<label for="titulo" class="form-label" >Título</label>
				<input type="text" class="form-control" id="titulo" name="titulo"  value=<%=resultado.getTitulo() %> >
			</div>
			
			<div class="mb-3">
				<label for="autor" class="form-label" >Autor</label>
				<input type="text" class="form-control" id="autor" name="autor" value=<%=resultado.getAutor() %> >
			</div>
			
			<div class="mb-3">
				<label for="edicion" class="form-label" >Edición</label>
				<input type="text" class="form-control" id="edicion" name="edicion" value=<%=resultado.getEdicion() %> >
			</div>
			
			<div class="mb-3">
				<label for="genero" class="form-label" >Género</label>
				<input type="text" class="form-control" id="genero" name="genero" value=<%=resultado.getGenero() %> >
			</div>
			
			<button type="submit" class="btn btn-outline-success btn-md col-2 m-4">Aceptar</button>
			
			</form>

		</div>	
	
	</div>

</body>
</html>