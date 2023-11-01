package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.modelo.Categorias;
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

@WebServlet(name = "Inicio_Cat", urlPatterns = {"/Inicio_Cat"})
public class Inicio_Cat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Categorias alm = new Categorias();
            CategoriaDAO dao = new CategoriaDAOimpl();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                    request.setAttribute("categorias", alm);
                    request.getRequestDispatcher("frmcategorias.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_cat"));
                    alm = dao.getById(id);
                    
                    request.setAttribute("categorias", alm);
                    request.getRequestDispatcher("frmcategorias.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_cat"));
                    dao.delete(id);
                    response.sendRedirect("Inicio_Cat");
                    break;
                case "view":
                    List<Categorias> lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("index_categorias.jsp").forward(request, response);
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
            CategoriaDAO dao = new CategoriaDAOimpl();
        
        int id = Integer.parseInt(request.getParameter("id_cat"));
        String categoria = request.getParameter("categoria");
        
        Categorias alm = new Categorias();
        alm.setId(id);
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
