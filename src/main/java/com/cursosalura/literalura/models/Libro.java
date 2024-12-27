package com.cursosalura.literalura.models;

import com.cursosalura.literalura.dto.Genero;
import com.cursosalura.literalura.models.records.DatosDeLibro;
import com.cursosalura.literalura.models.records.ImagenDeLibro;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long libroId;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    //@Transient
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String idioma;
    private String imagen;
    private Long cantidadDescargas;

public Libro(){
    }

    public Libro(DatosDeLibro datosDeLibro) {
        this.libroId = datosDeLibro.libroId();
        this.titulo = datosDeLibro.titulo();

        if (datosDeLibro.autor() != null && !datosDeLibro.autor().isEmpty()) {
            this.autor = new Autor(datosDeLibro.autor().get(0));
        } else {
            this.autor = null;
        }
        this.genero = generoModificado(datosDeLibro.genero());
        this.idioma = idiomaModificado(datosDeLibro.idioma());
        this.imagen = imagenModificada(datosDeLibro.imagen());
        this.cantidadDescargas = datosDeLibro.cantidadDescargas();
    }

    public Libro(Libro libro){

    }

    private String imagenModificada(ImagenDeLibro imagen) {
        if (imagen == null || imagen.imagen().isEmpty()) {
            return "Sin imagen";
        }
        return imagen.imagen();
    }

    private String idiomaModificado(List<String> idioma) {
        if (idioma == null || idioma.isEmpty()) {
            return "Desconocido";
        }
        return idioma.get(0);
    }

    private Genero generoModificado(List<String> genero) {
        if (genero == null || genero.isEmpty()) {
            return Genero.DESCONOCIDO;
        }
        Optional<String> PrimerGenero = genero.stream()
                .map(g -> {
                    int index = g.indexOf("--");
                    return index != -1 ? g.substring(index + 2).trim() : null;
                })
                .filter(Objects::nonNull)
                .findFirst();
        return PrimerGenero.map(Genero::fromString).orElse(Genero.DESCONOCIDO);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Long cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }
}