
package com.emergentes.modelo;


public class Libros {
    private int id;
    private String titulo;
    private String autor;
    private String disponible;
    private String categoria;

    public Libros() {
        this.id = 0;
        this.titulo = "";
        this.autor = "";
        this.disponible = "";
        this.categoria = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return "Libros{" + "id_lib=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponible=" + disponible + ", categoria=" + categoria + '}';
    }
}
