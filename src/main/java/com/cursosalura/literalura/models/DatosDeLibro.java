package com.cursosalura.literalura.models.records;

import com.cursosalura.literalura.models.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosDeLibro(
    @JsonAlias("id") Long libroId,
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<Autor> autor,
    @JsonAlias("subjects")
    List<String> genero,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("formats") ImagenDeLibro imagen,
    @JsonAlias("download_count") Long cantidadDescargas)
{
}
