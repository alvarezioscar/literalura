package com.cursosalura.literalura.config.iConfig;

public interface iConvierteDatos {
    <T> T obtenerDatos(String jason, Class<T> clase);
}
