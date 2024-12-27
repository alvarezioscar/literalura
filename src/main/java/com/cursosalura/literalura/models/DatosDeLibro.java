package com.cursosalura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosDeLibro(
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<DatosDelAutor> autor,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count") Long numeroDeDescargas)
{
}
