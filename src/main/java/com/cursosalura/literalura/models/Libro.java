package com.cursosalura.literalura.models;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    @Column(unique = true)
    private String titulo;
    private String nombreAutor;
    private String idioma;
    private Long cantidadDescargas;
    @ManyToOne()
    private Autor autor;


    public Libro(){
    }

    public Libro(DatosDeLibro libro) {
        this.titulo = libro.titulo();
        this.cantidadDescargas = libro.numeroDeDescargas();
        Autor autor = new Autor(libro.autor().get(0));
        this.nombreAutor = autor.getNombre();
        this.idioma = libro.idioma().get(0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Long cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString(){
        return "Titulo = " + titulo +
                "\nAutor = " + nombreAutor +
                "\nIdioma = " + idioma +
                "\nNumero de descargas = " + cantidadDescargas +
                "\n ----------------------------------------";
    }
}