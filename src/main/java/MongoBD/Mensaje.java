/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoBD;

/** Clase con los datos necesarios para listar un mensaje
 *
 * @author José Miguel
 */
public class Mensaje {
    private String nombreUsuario;
    private String userUsuario;
    private String texto;
    private String data;

    public Mensaje() {
    }

    public Mensaje(String nombreUsuario, String userUsuario, String texto, String data) {
        this.nombreUsuario = nombreUsuario;
        this.userUsuario = userUsuario;
        this.texto = texto;
        this.data = data;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public String getData() {
        return data;
    }
    
        
}
