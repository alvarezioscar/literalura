package com.cursosalura.literalura.repository;

import com.cursosalura.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iLibroRepository extends JpaRepository<Libro, Long> {
    boolean existsByTitulo(String titulo);

    List<Libro> findByIdioma(String idioma);

}
