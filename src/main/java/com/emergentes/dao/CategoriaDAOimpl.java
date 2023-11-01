package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO {
    
      @Override
    public void insert(Categorias categorias) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO Categorias(id_cat, categoria)values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, categorias.getId());
            ps.setString(2, categorias.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categorias categorias) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE Categorias SET id_cat=?, categoria=? WHERE id_cat = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql); 
            ps.setInt(1, categorias.getId());
            ps.setString(2, categorias.getCategoria());

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
            String sql = "DELETE FROM Categorias WHERE id_cat=?";
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
    public Categorias getById(int id) throws Exception {
        Categorias alm = new Categorias();
        try {
            this.conectar();
            String sql = "SELECT * FROM Categorias WHERE id_cat=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alm.setId(rs.getInt("id_cat"));
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
    public List<Categorias> getAll() throws Exception {
        ArrayList<Categorias> lista = new ArrayList<Categorias>();
        try {
            this.conectar();
            String sql = "SELECT * FROM Categorias";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categorias alm = new Categorias();

                alm.setId(rs.getInt("id_lib"));
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
