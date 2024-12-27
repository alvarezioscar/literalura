# Badges
![Badge Release](https://img.shields.io/badge/Release%20Date:-Diciembre-blue)
![Badge Java](https://img.shields.io/badge/Java:-17-blue)
![Badge Java](https://img.shields.io/badge/Spring%20Boot:-3.4.1-blue)
![Badge Finalizado](https://img.shields.io/badge/Status:-Finalizado-blue)

# LiterAlura 🏠

Desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios, proporcionando al menos 5 opciones de interacción. Los libros se buscarán a través de una API específica. La información sobre la API y las opciones de interacción con el usuario se detallará en la columna "Backlog"/"Listo para iniciar".

Los pasos para completar este desafío se detallarán a continuación:

* Configuración del Ambiente Java;

* Creación del Proyecto;

* Consumo de la API;

* Análisis de la Respuesta JSON;

* Inserción y consulta en la base de datos;

* Exibición de resultados a los usuarios;


## API Reference 🛒

#### Get all items

```http
  GET https://gutendex.com/books
```

#### Get item

```http
  GET /books?search=dickens%20great
```

## WorkShop 🚀
* Menú Principal
  
![image](https://github.com/user-attachments/assets/03eb83a5-29e8-4e6e-b67d-8458b5c8897f)

* Opciones del programa
1.-  Agregar un Libro (titulo) a la base de datos     

![image](https://github.com/user-attachments/assets/a78852b9-60b4-42f0-af76-e33ee5391ed0)


2.-  Libros buscados                                  

![image](https://github.com/user-attachments/assets/86f240e0-26ec-4d59-9bab-636619f0ecd9)


3.-  Listado de Autores                               


![image](https://github.com/user-attachments/assets/71bd91c4-daf8-4d8e-a9bc-eed294f3be5a)

4.-  Listado de Autores vivos en determinado año 

![image](https://github.com/user-attachments/assets/302b1fdd-b3f8-4332-95a6-335c7b271382)

5.-  Listado de Libros por idioma       

![image](https://github.com/user-attachments/assets/36a01fbf-47fd-45d1-a43c-fc155c289a93)

0.- Salir     

![image](https://github.com/user-attachments/assets/bd82bc92-a412-4c39-9644-9a11725272c8)

* Base de Datos

Tabla libros:

  ![image](https://github.com/user-attachments/assets/02cf5dd9-be0a-4480-9af7-a01b34c520b3)

Tabla autores

![image](https://github.com/user-attachments/assets/7005f004-833c-4864-8777-e0d47c3b2e6e)


## Environment Variables 🖍

Para ejecutar este programa, se necesita agregar las siguientes variables de ambiente en su equipo:

![image](https://github.com/user-attachments/assets/5761c4ac-7ccf-4c4b-bf7f-63bd361d9d19)


## Construido con 🛠️

Para desarrollar el proyecto, se utilizaron las siguientes herramientas:

* [Trello](https://trello.com/es) - Herramienta de gestión de proyectos.
* [PostgreSQL](https://www.postgresql.org/) - Sistema de gestión de bases de datos.
* [Java 17](https://www.oracle.com/java/) - Lenguaje de programación.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - Entorno de desarrollo integrado para el desarrollo de programas informáticos.
* [Spring Boot](https://start.spring.io/) - Herramienta que hace que el desarrollo de aplicaciones web y microservicios con Spring Framework sea más rápido y fácil.

