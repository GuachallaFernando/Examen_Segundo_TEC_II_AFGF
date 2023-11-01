
package com.emergentes.dao;

import com.emergentes.modelo.Libros;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LibrosDAOimpl extends ConexionDB implements LibrosDAO {
    
      @Override
    public void insert(Libros libros) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO libros(id_lib, titulo, autor, disponible, categoria)values(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, libros.getId());
            ps.setString(2, libros.getTitulo());
            ps.setString(3, libros.getAutor());
            ps.setString(4, libros.getDisponible());
            ps.setString(5, libros.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Libros libros) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE Libros SET id_lib=?, titulo=? ,autor=?, disponible=?, categoria=? WHERE id_lib = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql); 
            ps.setInt(1, libros.getId());
            ps.setString(2, libros.getTitulo());
            ps.setString(3, libros.getAutor());
            ps.setString(4, libros.getDisponible());
            ps.setString(5, libros.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM libros WHERE id_lib=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Libros getById(int id) throws Exception {
        Libros alm = new Libros();
        try {
            this.conectar();
            String sql = "SELECT * FROM libros WHERE id_lib=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alm.setId(rs.getInt("id_lib"));
                alm.setTitulo(rs.getString("titulo"));
                alm.setAutor(rs.getString("autor"));
                alm.setDisponible(rs.getString("disponible"));
                alm.setCategoria(rs.getString("categoria"));
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return alm;
    }

    @Override
    public List<Libros> getAll() throws Exception {
        ArrayList<Libros> lista = new ArrayList<Libros>();
        try {
            this.conectar();
            String sql = "SELECT * FROM libros";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libros alm = new Libros();

                alm.setId(rs.getInt("id_lib"));
                alm.setTitulo(rs.getString("titulo"));
                alm.setAutor(rs.getString("autor"));
                alm.setDisponible(rs.getString("disponible"));
                alm.setCategoria(rs.getString("categoria"));

                lista.add(alm);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
