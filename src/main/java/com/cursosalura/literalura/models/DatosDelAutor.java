package com.cursosalura.literalura.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosDelAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer cumpleanios,
        @JsonAlias("death_year") Integer fechaFallecimiento
) {

}
