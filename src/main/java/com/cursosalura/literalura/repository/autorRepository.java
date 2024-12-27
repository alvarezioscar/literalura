package com.cursosalura.literalura.repository;

import com.cursosalura.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface iAutorRepository extends JpaRepository<Autor, Long> {
    Autor findAuthorByName(String name);

    @Query(value = "SELECT * FROM authors WHERE :year >= birth_year AND :year <= death_year", nativeQuery = true)
    List<Autor> findAuthorBetweenYear(int year);
}
