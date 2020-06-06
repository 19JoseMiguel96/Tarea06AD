/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoBD;

import java.util.ArrayList;

/** Clase que contendrá los datos de un usuario registrado
 *
 * @author José Miguel
 */
public class Usuario {
    
    private String nombre;
    private String usuario;
    private String contra;
    private ArrayList<String> sigue;

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String contra, ArrayList<String> sigue) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
        this.sigue = sigue;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public String getContra() {
        return contra;
    }

    public ArrayList<String> getSigue() {
        return sigue;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setSigue(ArrayList<String> sigue) {
        this.sigue = sigue;
    }
    
    
    
}
