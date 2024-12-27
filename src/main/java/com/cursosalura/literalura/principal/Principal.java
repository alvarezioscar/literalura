package com.cursosalura.literalura.principal;

import com.cursosalura.literalura.models.*;
import com.cursosalura.literalura.repository.libroRepository;
import com.cursosalura.literalura.service.ConsumoAPI;
import com.cursosalura.literalura.service.ConvierteDatos;
import com.cursosalura.literalura.repository.autorRepository;

import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos convertirdatos = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private Libro libro;
    private DatosDeLibro datosDeLibro;


    private libroRepository repositorioDeLibros;
    private autorRepository repositorioDeAutor;
    private Optional<Autor> autorEncontrado;

    private List<Libro> libros;
    private List<Autor> autores;


public Principal(autorRepository repositorioDeAutor, libroRepository repositorioDeLibros) {
    this.repositorioDeAutor = repositorioDeAutor;
    this.repositorioDeLibros = repositorioDeLibros;

}

    public void muestraElMenu(){
        var opcion = -1;

        var menu = """
                *************************************************************
                **               BIENVENIDOS A LITERALURA                  **
                **               "Donde los libros viven!"                 **
                *************************************************************
                **                        "MENU"                           **
                **   1.-  Agregar un Libro (titulo) a la base de datos     **
                **   2.-  Libros buscados                                  **
                **   3.-  Listado de Autores                               **
                **   4.-  Listado de Autores vivos en determinado año      **
                **   5.-  Listado de Libros por idioma                     **
                **   0.- Salir                                             **
                *************************************************************
                **            Ingrese la opción del menú que desea         **
                *************************************************************
                
                """;

        var mensaje1 = """
                    
                    *************************************************************
                    **                 Ingrese una opción valida               **
                    *************************************************************
                    """;
        var mensaje2 = """
                    
                    *************************************************************
                    **               Cerrando Aplicación... Adios!             **
                    *************************************************************
                    """;
        var mensaje3 = """
                    
                    *************************************************************
                    **         Opción Incorrecta... Vuelva a intentarlo!       **
                    *************************************************************
                    """;


        while (opcion != 0) {
            System.out.println(menu);
            try{
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e){
                System.out.println(mensaje1);
                teclado.nextLine();
                continue;
            }

            switch (opcion){
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    librosBuscados();
                    break;
                case 3:
                    listaAutores();
                    break;
                case 4:
                    listaAutoresVivos();
                    break;
                case 5:
                    listaLibrosIdioma();
                    break;

                case 0:
                    opcion = 0;
                    System.out.println(mensaje2);
                    break;
                default:
                    System.out.println(mensaje3);
                    break;
            }
        }
    }



    private Datos getDatosLibros() {
        var mensaje4 = """
                    *************************************************************
                    **       Ingrese el nombre del libro que desea buscar:     **
                    *************************************************************
                    """;
        System.out.println(mensaje4);
        String nombreDelLibro = teclado.nextLine().toLowerCase().replace(" ", "%20");
        var json = consumoApi.obtenerDatos(URL_BASE + nombreDelLibro);
        var datos = convertirdatos.convertirDatos(json, Datos.class);
        return datos;
    }

    private void buscarLibro(){
        Datos datos = getDatosLibros();
       // System.out.println(datos);

        Optional<DatosDeLibro> libros = datos.resultados().stream()
                .findFirst();

        if (libros.isPresent()){
           // System.out.println(libros);
          //  System.out.println("Autor: --" + libros.get().autor());
            Libro libro = new Libro(libros.get());
            Autor autor = new Autor(libros.get().autor().get(0));


            if (repositorioDeLibros.existsByTitulo(libro.getTitulo())){
                System.out.println("Este libro ya se encuentra registrado en la base de datos.");

            } else {
                autorEncontrado = repositorioDeAutor.findByNombreContainsIgnoreCase(autor.getNombre());
                if (autorEncontrado.isPresent()){
                    var autorIngresado = autorEncontrado.get();
                    libro.setAutor(autorIngresado);
                    repositorioDeLibros.save(libro);
                } else {
                    autor.setLibrosDelAutor(libro);
                    repositorioDeAutor.save(autor);
                }
                System.out.println(libro.toString());
                System.out.println("Libro registrado en la base con exito.\n");
            }

        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void librosBuscados() {
        var mensaje5 = """
                    *************************************************************
                    **     Los libros buscados y registrados en la BD son:     **
                    *************************************************************
                    """;
        System.out.println(mensaje5);
        libros = repositorioDeLibros.findAll();
        libros.stream()
                .forEach(System.out::println);
    }

    private void listaAutores(){
        autores = repositorioDeAutor.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    private void listaAutoresVivos(){
        var mensaje6 = """
                    *************************************************************
                    ** Indique el año de referencia para buscar autores vivos: **
                    *************************************************************
                    """;
        System.out.println(mensaje6);
        var fechaReferencia = teclado.nextInt();
        teclado.nextLine();
        autores = repositorioDeAutor.findAll();
        autores.stream()
                .filter(a -> (fechaReferencia <= a.getFechaDeDeceso())&&(fechaReferencia >=a.getFechaDeNacimiento()))
                .forEach(System.out::println);
    }

    private void listaLibrosIdioma(){
        var mensaje6 = """
                    *************************************************************
                    **Indique la opción para el idioma de los libros a listar: **
                    **      a - Español   (es)                                 **
                    **      b - Inglés    (en)                                 **
                    **      c - Frances   (fr)                                 **
                    **      d - Portugués (pt)                                 **
                    *************************************************************
                    """;
        var mensaje7 = """
                    *************************************************************
                    **                  Opción no valida!!!!                   **
                    *************************************************************
                    """;
        var mensaje8 = """
                    *************************************************************
                    **                    Libros en Español                    **
                    *************************************************************
                    """;
        var mensaje9 = """
                    *************************************************************
                    **                    Libros en Inglés                     **
                    *************************************************************
                    """;
        var mensaje10 = """
                    *************************************************************
                    **                    Libros en Frances                    **
                    *************************************************************
                    """;
        var mensaje11 = """
                    *************************************************************
                    **                  Libros en Portugues                    **
                    *************************************************************
                    """;

        System.out.println(mensaje6);
        var opcion = teclado.nextLine();
        var idioma = "";
        switch (opcion.toLowerCase()){
            case "a":
                System.out.println(mensaje8);
                idioma="es";
                imprimeLibrosIdioma(idioma);
                break;
            case "b":
                System.out.println(mensaje9);
                idioma="en";
                imprimeLibrosIdioma(idioma);
                break;
            case "c":
                System.out.println(mensaje10);
                idioma="fr";
                imprimeLibrosIdioma(idioma);
                break;
            case "d":
                System.out.println(mensaje11);
                idioma="pt";
                imprimeLibrosIdioma(idioma);
                break;
            default:
                System.out.println(mensaje7);
                break;
        }

    }

    private void imprimeLibrosIdioma(String idioma) {
        libros = repositorioDeLibros.findAll();
        libros.stream()
                .filter(l -> l.getIdioma().equals(idioma))
                .forEach(System.out::println);

    }
}
