package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {

    //ATRIBUTOS
    //Array list que va a contener una lista de todos los libros
    private ArrayList<Libro> biblioteca;


    //CONSTRUCTOR
    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    //METODO CRUD: C(crear), R(read), U(update), D(delete)

    //Metodo: listar todos los libros de la biblioteca
    //CREAR libros de la biblioteca
    public void crearLibro(String titulo, String autor, String ISBN, String genero){
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //LEER la biblioteca
    public ArrayList<Libro> getBiblioteca(){
        return biblioteca;
    }

    //ACTUALIZAR libro
    public void actualizarLibro(String nuevoTitulo, String nuevoAutor, String ISBN, String nuevoGenero){

        //Recorremos cada libro de la biblioteca buscando un ISBN similar
        for(Libro libro:biblioteca){
            if(libro.getISBN().equals(ISBN)){
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
    }

    //ELIMINAR libro
    public boolean eliminarLibro(String ISBN){
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                biblioteca.remove(libro);
                return true;
            }
        }
        return false;
    }

    //BUSCAR un libro UNICO por ISBN
    public Libro buscarLibroUnico(String ISBN){
        for(Libro libro:biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    //BUSCAR libro por nombre
    public Libro buscarLibroNombre(String titulo){
        for(Libro libro:biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    //FUNCION PARA VERIFICAR DISPONIBILIDAD
    public Boolean verificarDisponibilidad(Libro libro){
        return libro.isDisponible();
    }

}

