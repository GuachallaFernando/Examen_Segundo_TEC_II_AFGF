package com.emergentes.dao;
import com.emergentes.modelo.Categorias;
import java.util.List;

public interface CategoriaDAO {
    public void insert(Categorias categorias) throws Exception;
    public void update(Categorias categorias) throws Exception;
    public void delete(int id) throws Exception;
    public Categorias getById(int id) throws Exception;
    public List<Categorias> getAll() throws Exception;
}