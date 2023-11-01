<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%
    List<Libros> libros = (List<Libros>) request.getAttribute("libros");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Registro de estudiantes</title>
        <style>
            .box {
                margin: auto;
                width: 50%;
                padding: 10px;
                border: 1px solid #ccc;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="box">
            <h3>SEGUNDO PARCIAL TEM-742</h3>
            <p>Nombre: Abel Fenando Guachalla Fernandez</p>
            <p>Carnet: 10076417/p>
        </div>
        <h1>Gestion de libros</h1>
        <a href="Inicio?action=add">Nuevo</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${libros}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.disponible}</td>
                    <td>${item.categoria}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro__ de eliminar???'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>    
    </body>
</html>
