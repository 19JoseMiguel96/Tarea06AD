/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoBD;

/** Clase que contendrá los datos de acceso a la base de datos
 *
 * @author José Miguel
 */



public class ConfigBBDD {
    
    private String address;
    private String port;
    private String dbname;
    private String username;
    private String password;
    
    public ConfigBBDD(){}

    public ConfigBBDD(String address, String port, String dbname, String username, String password) {
        this.address = address;
        this.port = port;
        this.dbname = dbname;
        this.username = username;
        this.password = password;
    }
        

    public String getAddress() {
        return address;
    }

    public String getPort() {
        return port;
    }

    public String getDbname() {
        return dbname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
       
    
}
