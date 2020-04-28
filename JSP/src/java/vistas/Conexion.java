package vistas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection cx;
    String bd="proyecto";
    String url="jdbc:mysql://localhost:3307/"+bd;
    String user="root";
    String pass="123456789";
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");         
            cx=(Connection)DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado");
        } catch (ClassNotFoundException|SQLException ex) {
            System.out.println(ex);
    }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
            System.out.println("Desconectado");
        } catch (SQLException ex) {
        }
        
    }
}
