package com.actosoftcommunity.consumiendodatadefirebase;

public class Post {

    private String titulo;
    private String cuerpo;
    private String autor;
    private String imagen;
    private boolean publicado;

    public Post(String titulo, String cuerpo, String autor, String imagen, boolean publicado)
    {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.imagen = imagen;
        this.publicado = publicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
}
