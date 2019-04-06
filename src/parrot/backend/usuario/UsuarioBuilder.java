/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parrot.backend.usuario;

/**
 *
 * @author fabricio
 */
public class UsuarioBuilder {
    
    String id;
    String nombre;
    String pass;

    public UsuarioBuilder() {
    }

    public UsuarioBuilder id(String id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder pass(String pass) {
        this.pass = pass;
        return this;
    }
    
    public Usuario build(){
        return new Usuario(this);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
    
}
