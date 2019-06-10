 
package gestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class AsistenteBD {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String driver = "org.sqlite.JDBC";
    String nombreBD = "empresa.sqlite";
    String url = "jdbc:sqlite:"+nombreBD;
    
    public void  crearBD(){
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e.getMessage());
            
        }
        System.out.println("Base de datos Creada con Exito");
    }
    
    
    public void CrearTabla(){
    
             try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String tabla = "CREATE TABLE cliente"
                    + "(Id  int PRIMARY KEY NOT NULL,"+
                    "Nombre TEXT NOT NULL,"+
                    "Apellido TEXT NOT NULL,"+
                    "Edad INT NOT NULL)";
            
           String insert = "INSERT INTO cliente"
                    + "(Id,Nombre,Apellido,Edad)"+
                    "VALUES("+
                    "123656,'KIMI','SOAZO',19)";
           
     // SENTENCIA DE SELECT       
           String select = "select * from cliente";
           resultados = sentencia.executeQuery(select);
           
           while(resultados.next()){
               int id = resultados.getInt("Id");
               String nombre = resultados.getString("Nombre");
               String apellido = resultados.getString("Apellido");
               int edad = resultados.getInt("Edad");
               
               System.out.println("\nId: "+id+"\nNombre: "+nombre+
                       "\nApellido: "+ apellido+"\nEdad: "+edad);
                       
           }//fin while
           //FIN SELECT
           
           
           
//            sentencia.executeUpdate(insert);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e.getMessage());
            
        }
        System.out.println("Exito");
}
}

