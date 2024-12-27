
# LiterAlura

Desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios, proporcionando al menos 5 opciones de interacción. Los libros se buscarán a través de una API específica. La información sobre la API y las opciones de interacción con el usuario se detallará en la columna "Backlog"/"Listo para iniciar".

Los pasos para completar este desafío se detallarán a continuación:

* Configuración del Ambiente Java;

* Creación del Proyecto;

* Consumo de la API;

* Análisis de la Respuesta JSON;

* Inserción y consulta en la base de datos;

* Exibición de resultados a los usuarios;


## API Reference

#### Get all items

```http
  GET https://gutendex.com/books
```

#### Get item

```http
  GET /books?search=dickens%20great
```

