package com.emergentes.controlador;

import com.emergentes.dao.LibrosDAO;
import com.emergentes.dao.LibrosDAOimpl;
import com.emergentes.modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Libros alm = new Libros();
            LibrosDAO dao = new LibrosDAOimpl();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                    request.setAttribute("libros", alm);
                    request.getRequestDispatcher("frmlibros.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_lib"));
                    alm = dao.getById(id);
                    
                    request.setAttribute("libros", alm);
                    request.getRequestDispatcher("frmlibros.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_lib"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Libros> lista = dao.getAll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            LibrosDAO dao = new LibrosDAOimpl();
        
        int id = Integer.parseInt(request.getParameter("id_lib"));
        String descripcion = request.getParameter("descripcion");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria");
        
        Libros alm = new Libros();
        alm.setId(id);
        alm.setTitulo("titulo");
        alm.setAutor("autor");
        alm.setDisponible("disponible");
        alm.setCategoria("categoria");
        try {
            if (id == 0) {
                //Adicionar reg
                dao.insert(alm);
            } else {
                //Actualizar reg
                dao.update(alm);
            }
        } catch (Exception ex) {
            System.out.println("Error al guardar datos...");
        }
        
        response.sendRedirect("Inicio");
    }
    }

