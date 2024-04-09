package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    //ATRIBUTOS
    private ArrayList<Usuario> usuarios;

    //CONSTRUCTOR
    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    //METODOS CRUD

    //CREAR usuario
    public void crearUsuario(String nombre, String id){
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuarios.add(nuevoUsuario);
    }

    //LEER usuarios
    public ArrayList<Usuario> listaUsuarios(){
        return usuarios;
    }

    //MOSTRAR lista usuarios

    public void mostrarListaUsuarios(){
        System.out.println("Lista usuarios:");
        for (Usuario usuario: usuarios){
            System.out.println("Nombre: " + usuario.getNombre() + ", ID: " + usuario.getId());
        }
        System.out.println();
    }

    //ACTUALIZAR usuario por ID
    public void actualizarUsuarios(String nuevoNombre, String id){

        for(Usuario usuario:usuarios){
            if(usuario.getId().equals(id)){
                usuario.setNombre(nuevoNombre);
                usuario.setId(id);
            }
        }
    }

    //ELIMINAR usuario por id
    public void eliminarUsuario(String id){
        usuarios.removeIf(usuario ->
                usuario.getId().equals(id));
    }

    //BUSCAR usuario por id
    public Usuario buscarUsuarioUnico(String id){
        for(Usuario usuario:usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    //METODO para PRESTAR libro al usuario por ISBN
    public void prestarLibro(Usuario usuario, Libro libro){
        //verificamos si el libro esta disponible
        if (libro.isDisponible()){
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
        }else {
            System.out.println("No esta disponible el libro que buscas.");
        }
    }

    //DEVOLVER libro
    public void devolverLibro(Usuario usuario, Libro libro){
        if (usuario.getLibrosPrestados().contains(libro)){
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        }else {
            System.out.println("No se ha encuentrado un libro para devolver.");
        }
    }

}
