package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //listas de libros que se ingresan a la biblioteca
        ArrayList<Libro> biblioteca = new ArrayList<>();
        //lista de usuarios nuevos que se van a dar de alta en el sistema
        ArrayList<Usuario> usuarios = new ArrayList<>();

        //Crear e instanciar los servicios
        LibroService libroService = new LibroService(biblioteca);
        UsuarioService usuarioService = new UsuarioService(usuarios);

        Scanner scan = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("=== Biblioteca Virtual ===");
            System.out.println("---Selecciona una opción---");
            System.out.println("1_ Crear libro");
            System.out.println("2_ Actualizar libro");
            System.out.println("3_ Buscar libro por ISBN");
            System.out.println("4_ Buscar por titulo");
            System.out.println("5_ Listar libros");
            System.out.println("6_ Eliminar libros");
            System.out.println("7_ Agregar usuario");
            System.out.println("8_ Prestamos");
            System.out.println("9_ Devoluciones");
            System.out.println("10_ Salir");

            opcion = scan.nextInt(); //guardamos la opcion ingresada
            scan.nextLine();//salto de linea

            switch (opcion) {
                case 1:
                    System.out.println("Agregar libro a la biblioteca");
                    System.out.println("Ingrese titulo:");
                    String titulo = scan.nextLine();
                    System.out.println("Ingrese autor:");
                    String autor = scan.nextLine();
                    System.out.println("Ingrese ISBN:");
                    String isbn = scan.nextLine();
                    System.out.println("Ingrese genero:");
                    String genero = scan.nextLine();

                    libroService.crearLibro(titulo, autor, isbn, genero);
                    System.out.println("El libro fue creado.");
                    break;

                case 2:
                    System.out.println("Actualizar libro: ");
                    System.out.println("Ingrese el ISBN del libro que desea actualizar:");
                    String nuevoISBN = scan.nextLine();
                    System.out.println("Ingrese el nuevo título:");
                    String nuevoTitulo = scan.nextLine();
                    System.out.println("Ingrese el nuevo autor:");
                    String nuevoAutor = scan.nextLine();
                    System.out.println("Ingrese el nuevo género:");
                    String nuevoGenero = scan.nextLine();

                    libroService.actualizarLibro(nuevoTitulo,
                            nuevoAutor, nuevoISBN, nuevoGenero);
                    break;

                case 3:
                    System.out.println("¿Cual es el ISBN del libro que busca?");
                    String buscarPorISBN = scan.nextLine();

                    Libro libroBuscado =
                            libroService.buscarLibroUnico(buscarPorISBN);

                    if (libroBuscado != null){
                        System.out.println(libroBuscado);
                    }else {
                        System.out.println("El libro con ISBN " +
                                buscarPorISBN + " no se encuentraen la biblioteca.");
                    }
                    break;

                case 4:
                    System.out.println("Buscar libro por titulo");
                    String buscarPorTitulo = scan.nextLine();

                    Libro libroBuscadoTitulo =
                            libroService.buscarLibroNombre(buscarPorTitulo);

                    if (libroBuscadoTitulo != null){
                        System.out.println(libroBuscadoTitulo);
                    }else {
                        System.out.println("El libro con titulo " +
                                buscarPorTitulo + " no se encuentra en la biblioteca.");
                    }
                    break;

                case 5:
                    System.out.println("Listar libros");
                    ArrayList<Libro> listaLibros = libroService.getBiblioteca();
                    if (!listaLibros.isEmpty()){
                        for (Libro libro : listaLibros) {
                            System.out.println(libro);
                        }
                    }else {
                        System.out.println("La biblioteca está vacía.");
                    }
                    break;

                case 6:
                    System.out.println("¿Qué libro quiere eliminar? Ingrese el ISBN:");
                    String isbnEliminar = scan.nextLine();

                    if (libroService.eliminarLibro(isbnEliminar)){
                        System.out.println("Libro " + isbnEliminar + " eliminado correctamente.");
                    }else {
                        System.out.println("No se encontro un libro con el ISBN " + isbnEliminar + " correspondiente");
                    }

                    break;

                case 7:
                    System.out.println("Agregar usuario al sistema");
                    System.out.println("Ingrese el ID del usuario:");
                    String idCrearUsuario = scan.nextLine();

                    //verificar si existe el usuario
                    boolean usuarioExiste = false;
                    for (Usuario u: usuarios){
                        if (u.getId().equals(idCrearUsuario)){
                            usuarioExiste = true;
                            break;
                        }
                    }
                    if (usuarioExiste){
                        System.out.println("El usuario ya existe en el sistema.");
                    }else {
                        System.out.println("Ingrese el nombre del usuario");
                        String nombreUsuario = scan.nextLine();

                        //creo el usuario si no existe previamente
                        usuarioService.crearUsuario(nombreUsuario, idCrearUsuario);
                        System.out.println("Usuario " + nombreUsuario + " agregado correctamente.");

                        //Mostrar la lista de todos los usuarios
                        usuarioService.mostrarListaUsuarios();
                    }
                    break;

                case 8:
                    System.out.println("Prestamos");
                    System.out.println("Ingrese el ID del usuario:");
                    String idUsuario = scan.nextLine();

                    //verificar si existe el id del usuario
                    Usuario usuarioPrestamo = usuarioService.buscarUsuarioUnico(idUsuario);


                    if (usuarioPrestamo != null) {
                        System.out.println("Ingrese el ISBN del libro que quiere pedir: ");
                        String isbnLibroPrestamo = scan.nextLine();

                        Libro libroPrestamo = libroService.buscarLibroUnico(isbnLibroPrestamo);

                        if (libroPrestamo != null) {
                            if (libroService.verificarDisponibilidad(libroPrestamo)) {
                                usuarioService.prestarLibro(usuarioPrestamo, libroPrestamo);
                                System.out.println("El libro " + libroPrestamo  + " fue prestado correctamente a " + usuarioPrestamo);
                            } else {
                                System.out.println("El libro no está disponible para préstamos en este momento.");
                            }

                        } else {
                            System.out.println("El libro no se encuentra en la biblioteca.");
                        }
                    }

                    break;

                case 9:
                    System.out.println("Devoluciones");
                    System.out.println("Ingrese el ID del usuario:");
                    String idUsuarioDevolucion = scan.nextLine();

                    //verificamos si el usuario existe
                    Usuario idDevolucion = usuarioService.buscarUsuarioUnico(idUsuarioDevolucion);

                    //si no existe, se envia un mensaje de error y sale del caso
                    if (idDevolucion == null) {
                        System.out.println("El usuario con ID " + idUsuarioDevolucion + " no existe. No se puede realizar la devolución");
                        break;
                    }

                    //continuamos con el proceso de devolucion
                    System.out.println("Ingrese el ISBN del libro que quiere devolver:");
                    String isbnLibroDevolucion = scan.nextLine();

                    Libro libroDevolucion = libroService.buscarLibroUnico(isbnLibroDevolucion);

                    if (idDevolucion != null && libroDevolucion != null) {
                        usuarioService.devolverLibro(idDevolucion, libroDevolucion);
                        System.out.println("El libro fue devuelto correctamente.");
                    } else {
                        System.out.println("El libro no se encuentra en la biblioteca.");
                    }
                    break;

                case 10:
                    System.out.println("Salir");
                    break;

            }
        }   while (opcion != 10) ;
    }
}