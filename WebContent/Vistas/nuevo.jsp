<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca Codo a Codo - Nuevo Libro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<h1 style="text-align: center">Agregar Libro</h1>

<div  class="container" >
		<div class="row" >
				
				<form action="LibrosController?accion=insert" method="post">   
				
				<div class="mb-3">
					<label for="titulo" class="form-label">Título</label>
					<input type="text" class="form-control" id="titulo" name="titulo" >					
				</div>
				
				
				<div class="mb-3">
					<label for="autor" class="form-label">Autor</label>
					<input type="text" class="form-control" id="autor" name="autor" >					
				</div>
				
				<div class="mb-3">
					<label for="edicion" class="form-label">Edición</label>
					<input type="number" class="form-control" id="edicion" name="edicion" >					
				</div>	
				
				
				<div class="mb-3">
					<label for="genero" class="form-label">Género</label>
					<input type="text" class="form-control" id="genero" name="genero" >					
				</div>
					
				<button type="submit" class="btn btn-outline-success btn-md col-2 m-4"> Agregar</button>
				
				</form>
				
		</div>
</div>

</body>
</html>