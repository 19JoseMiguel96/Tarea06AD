package MongoBD;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.BsonDocument;


/**
 *
 * @author José Miguel
 */

public class BaseDatos {
    
    private  ConfigBBDD accesoBBDD;
    private  DB db;
    
    private static final String C_USUARIO = "usuario";  
    private static final String C_MENSAJE = "mensaje";  

    private MongoClient mongoClient;
    
    public BaseDatos() {
        cargarConfiguracion();
        conectar();
    }
    
    // Método para conectar con la base de datos
    private  void conectar() {
        
        // Cadena de conexión a la base de datos local, sin autenticarse
        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://" + accesoBBDD.getAddress() + ":" + accesoBBDD.getPort()));
    
        // Cadena de conexión a la base de datos con autenticación
        mongoClient = new MongoClient(new MongoClientURI("mongodb://" + accesoBBDD.getUsername() +":" + accesoBBDD.getPassword() + "@"
                                                                                  + accesoBBDD.getAddress() + ":" + accesoBBDD.getPort() + "/" + accesoBBDD.getDbname() + "?retryWrites=false"));

        db = mongoClient.getDB(accesoBBDD.getDbname());
    }
    
    // Método para cerrar la conexión con la base de datos
    public void cerrar() {
        mongoClient.close();
    }
        
    
    // Método que devuelve un boolean en el que se comprueba si existe un usuario que recibe como parámetro
    public  boolean existeUsuario(String usuario) {

        boolean existe;
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        DBObject consulta = new BasicDBObject("username", usuario);
        DBCursor cursor = colUsuario.find(consulta);

        existe = (cursor.count() >0);
        cursor.close();
        
        return existe;
        
    }
    
    // Método que devuelve un boolean en el que se comprueba si existe un usuario con una contraseña dada
    public  boolean existeUsuarioContra(String usuario, String contra) {
        
        boolean existe;
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        
        Bson filtro = Filters.and(Filters.eq("username",usuario), Filters.eq("password",contra));
        DBObject consulta = new BasicDBObject(filtro.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = colUsuario.find(consulta);
        
        existe = (cursor.count() > 0);
        cursor.close();
        
        return existe;
        
    }
    
    // Método para guardar los datos de un nuevo usuario
    public  void guardarUsuario(Usuario usuario) {
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        
        DBObject usu = new BasicDBObject()
                .append("nombre", usuario.getNombre())
                .append("username", usuario.getUsuario())
                .append("password", usuario.getContra())
                .append("follows", usuario.getSigue());
        
        colUsuario.insert(usu);
       
    }
    
    // Método que  devuelve un objeto Usuario 
    public  Usuario getUsuario(String usuario) {
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        
        Bson filtro = Filters.eq("username",usuario);
        DBObject consulta = new BasicDBObject(filtro.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = colUsuario.find(consulta);
        
        Usuario usu = null;
        
        while (cursor.hasNext()) {
            DBObject usuAux = cursor.next();
            String sigo = usuAux.get("follows").toString().replace("[", "").replace("]","");
            
            ArrayList<String> sigo3 = new ArrayList<String>(Arrays.asList(sigo.split(", ")));
                                    
            usu = new Usuario(usuAux.get("nombre").toString(), usuAux.get("username").toString(),usuAux.get("password").toString(), sigo3);
            
        }
        
        cursor.close();
        return usu;
        
    }
    
    // Método que guarda un mensaje nuevo
    public  void enviarMensaje(String texto, String nombreUsuario, String userUsuario, List hashtags) {
                
        DBCollection colMensaje = db.getCollection(C_MENSAJE);
        
        Date data = new Date();

        DBObject mensaje = new BasicDBObject()
                .append("text", texto)
                .append("user", new BasicDBObject()
                                .append("nombre", nombreUsuario)
                                .append("username", userUsuario))
                .append("date", new BasicDBObject("date", data))
                .append("hashtags", hashtags);
        
        colMensaje.insert(mensaje);
        
    }
    
    // Método que devuelve un ArrayList con todos los mensajes
    public ArrayList<Mensaje> getMensajes(int salto, int limite) {
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        
        DBCollection colMensaje = db.getCollection(C_MENSAJE);
        
        DBCollectionFindOptions opcions = new DBCollectionFindOptions();
        Bson projectionAux = Projections.include(Arrays.asList("user.nombre", "user.username", "text", "date"));
        DBObject projection = new BasicDBObject(projectionAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.projection(projection);
        
        // Leemos un registro más para saber si llego al final o hay más registros
        opcions.limit(limite + 1);          
        opcions.skip(salto);
        
        // Establecemos el orden descendiente de clasificación por fecha
        Bson sortAux = Sorts.descending("date");
        DBObject sort = new BasicDBObject(sortAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.sort(sort);
        
        DBCursor cursor = colMensaje.find(new BasicDBObject(),opcions);
        
        while (cursor.hasNext()) {
            DBObject docAux = cursor.next();
            DBObject docUser = (BasicDBObject) docAux.get("user");
            
            Mensaje mensaje = new Mensaje(
                    docUser.get("nombre").toString(),
                    docUser.get("username").toString(),
                    docAux.get("text").toString(),
                    docAux.get("date").toString());
            
            mensajes.add(mensaje);
        }
        
        cursor.close();
        return mensajes;
    
    }
    
    // Método que devuelve los mensajes de los usuarios a los que se sigue
    public ArrayList<Mensaje> getMensajesUsuarios(int salto, int limite, ArrayList<String> sigue) {
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        
        DBCollection colMensaje = db.getCollection(C_MENSAJE);
        
        Bson filtro = Filters.in("user.username", sigue);
        DBObject consulta = new BasicDBObject(filtro.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        
        DBCollectionFindOptions opcions = new DBCollectionFindOptions();
        Bson projectionAux = Projections.include(Arrays.asList("user.nombre", "user.username", "text", "date"));        
        DBObject projection = new BasicDBObject(projectionAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.projection(projection);
        
        // Leemos un registro más para saber si llego al final o hay más registros
        opcions.limit(limite + 1);  
        opcions.skip(salto);
        
        // Establecemos el orden descendiente de clasificación por fecha
        Bson sortAux = Sorts.descending("date");
        DBObject sort = new BasicDBObject(sortAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.sort(sort);
        
        DBCursor cursor = colMensaje.find(consulta, opcions);
        
        
        while (cursor.hasNext()) {
            DBObject docAux = cursor.next();
            DBObject docUser = (BasicDBObject) docAux.get("user");
            
            Mensaje mensaje = new Mensaje(
                    docUser.get("nombre").toString(),
                    docUser.get("username").toString(),
                    docAux.get("text").toString(),
                    docAux.get("date").toString());
            
            mensajes.add(mensaje);
        }
        
        cursor.close();
        return mensajes;
    
    }
    
    // Método que devuelve todos los mensajes con un determinado hashtag
    public ArrayList<Mensaje> getMensajesHashtag(int salto, int limite, String hashtag) {
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        
        DBCollection colMensaje = db.getCollection(C_MENSAJE);
        
        DBObject consulta = new BasicDBObject("hashtags", hashtag);
        
        DBCollectionFindOptions opcions = new DBCollectionFindOptions();
        Bson projectionAux = Projections.include(Arrays.asList("user.nombre", "user.username", "text", "date"));        
        DBObject projection = new BasicDBObject(projectionAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.projection(projection);
        
        // Leemos un registro más para saber si llego al final o hay más registros
        opcions.limit(limite + 1);  
        opcions.skip(salto);
        
        // Establecemos el orden descendiente de clasificación por fecha
        Bson sortAux = Sorts.descending("date");
        DBObject sort = new BasicDBObject(sortAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.sort(sort);
        
        DBCursor cursor = colMensaje.find(consulta, opcions);
        
        while (cursor.hasNext()) {
            DBObject docAux = cursor.next();
            DBObject docUser = (BasicDBObject) docAux.get("user");
            
            Mensaje mensaje = new Mensaje(
                    docUser.get("nombre").toString(),
                    docUser.get("username").toString(),
                    docAux.get("text").toString(),
                    docAux.get("date").toString());
            
            mensajes.add(mensaje);
        }
        
        cursor.close();
        return mensajes;
    
    }
    
    /* Método que devuelve la lista de usuarios registrados que coincida totalmente 
    o en parte con el con un username que se le pasa como filtro.
    Si el filtro está vacío muestra todos.
    */
    public ArrayList<Usuario> getUsuarios(int salto, int limite, String filtro2) {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        
        // Si el filtro está vacío, creamos un regex que seleccione todos los usuarios
        if (filtro2.equals("")) { filtro2 = ".*";}
        
        Bson filtro = Filters.regex("username", filtro2);
        DBObject consulta = new BasicDBObject(filtro.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        
        DBCollectionFindOptions opcions = new DBCollectionFindOptions();
        Bson projectionAux = Projections.include(Arrays.asList("nombre", "username", "password", "follows"));        
        DBObject projection = new BasicDBObject(projectionAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        opcions.projection(projection);
        
        // Leemos un registro más para saber si llego al final o hay más registros
        opcions.limit(limite + 1);
        opcions.skip(salto);
        DBCursor cursor = colUsuario.find(consulta, opcions);
        
        while (cursor.hasNext()) {
            DBObject docAux = cursor.next();
            usuarios.add(getUsuario(docAux.get("username").toString()));
        }
        
        cursor.close();
        return usuarios;
    
    }
    
    // Método que actualiza la lista de usuari@s a l@s que sigue
    public void actualizarUsuariosSigue(String usu, ArrayList<String> seguido) {
        
        DBCollection colUsuario = db.getCollection(C_USUARIO);
        
        Bson filtro = Filters.eq("username",usu);
        DBObject consulta = new BasicDBObject(filtro.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        Bson actualizAux = Updates.set("follows", seguido);        
        DBObject actualiz = new BasicDBObject(actualizAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        colUsuario.update(consulta, actualiz);
        DBCursor cursor = colUsuario.find(new BasicDBObject());
        cursor.close();
        
    }
    
    // Método para cargar la configuración de acceso a la base de datos
    private  void cargarConfiguracion() {            

        // Cargamos los datos de configuración de acceso a la BBDD
        File arquivoConf = new File("config.json");

        // Comprobamos si existe el archivo de configuración
        if (arquivoConf.exists()) {

            try {
                // Creamos el flujo de datos
                FileReader flujoDatos = new FileReader(arquivoConf);
                BufferedReader entrada = new BufferedReader(flujoDatos);

                StringBuilder jsonBuilder = new StringBuilder();
                String linea;

                // Leemos el archivo línea a línea
                while ((linea = entrada.readLine()) != null) {
                    jsonBuilder.append(linea).append("\n");
                }

                // Cerrarmos el archivo
                entrada.close();

                // Construimos la cadena json
                String json = jsonBuilder.toString();
                Gson gson = new Gson();

                // Creamos el objeeto de configuración de acceso a la base de datos
                // con los datos leídos.
                accesoBBDD = gson.fromJson(json, ConfigBBDD.class);

            }
            catch (IOException erro) {
                System.out.println("Error cargando la configuración de conexión a la base de datos.");
            }
        }
    }
    
    
}
