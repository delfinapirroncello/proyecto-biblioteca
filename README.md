# Biblioteca Virtual

Este proyecto es una biblioteca virtual desarrollada en Java, donde se pueden gestionar libros y usuarios, realizar préstamos y devoluciones de libros.

## Descripción

El proyecto "Biblioteca Virtual" permite:

- Crear, actualizar, buscar, listar y eliminar libros.
- Agregar, buscar, actualizar y eliminar usuarios.
- Prestar y devolver libros.

## Funcionalidades

- **Gestión de libros**:
  - Crear libros
  - Actualizar libros
  - Buscar libros por ISBN
  - Buscar libros por título
  - Listar todos los libros
  - Eliminar libros

- **Gestión de usuarios**:
  - Agregar usuarios
  - Actualizar usuarios
  - Buscar usuarios por ID
  - Eliminar usuarios

- **Préstamos y devoluciones**:
  - Prestar libros a usuarios
  - Devolver libros

## Ejemplos de Uso

### Crear un libro
```plaintext
Agregar libro a la biblioteca
Ingrese titulo: El Quijote
Ingrese autor: Miguel de Cervantes
Ingrese ISBN: 978-3-16-148410-0
Ingrese genero: Novela

### Actualizar un libro
Ingrese el ISBN del libro que desea actualizar: 978-3-16-148410-0
Ingrese el nuevo título: Don Quijote de la Mancha
Ingrese el nuevo autor: Miguel de Cervantes Saavedra
Ingrese el nuevo género: Clásico

### Actualizar un usuario
Actualizar libro:
Ingrese el ISBN del libro que desea actualizar: 978-3-16-148410-0
Ingrese el nuevo título: Don Quijote de la Mancha
Ingrese el nuevo autor: Miguel de Cervantes Saavedra
Ingrese el nuevo género: Clásico

### Buscar libro por ISBN
¿Cuál es el ISBN del libro que busca?
Ingrese ISBN: 978-3-16-148410-0

### Buscar un libro por Título
Buscar libro por título
Ingrese título: Don Quijote de la Mancha

### Prestar un libro
Préstamos
Ingrese el ID del usuario: U001
Ingrese el ISBN del libro que quiere pedir: 978-3-16-148410-0

### Devolver un libro
Devoluciones
Ingrese el ID del usuario: U001
Ingrese el ISBN del libro que quiere devolver: 978-3-16-148410-0
