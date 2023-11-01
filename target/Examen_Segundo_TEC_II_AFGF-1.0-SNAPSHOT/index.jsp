<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ventanas Emergentes y Texto Fijo</title>
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    flex-direction: column;
  }
  .ventana {
    width: 300px;
    height: 200px;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    padding: 20px;
    text-align: center;
  }
  .contenido {
    flex: 1;
    padding: 20px;
  }
  .esquina-inferior-derecha {
    position: fixed;
    bottom: 10px;
    right: 10px;
    background-color: #f0f0f0;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
</style>
</head>
<body>
  <div class="ventana">
    <h1>Biblioteca</h1>
    <a href="index_libros.jsp" target="_blank">Libros</a>
    <br>
    <a href="index_categorias.jsp" target="_blank">Categorias</a>
  </div>
  <div class="contenido">
    <!-- Contenido principal aquí -->
  </div>
  <div class="esquina-inferior-derecha">
    Nombre: Abel Fernando Guachalla Fernandez
  </div>
</body>
</html>


