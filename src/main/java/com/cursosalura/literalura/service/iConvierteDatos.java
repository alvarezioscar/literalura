package com.cursosalura.literalura.service;

public interface iConvierteDatos {
    <T> T convertirDatos(String json, Class<T> clase);
}
