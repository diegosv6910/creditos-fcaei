package vistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginOperaciones {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public int loguear(String user, String pass){
        int nivel=0;
        String sql = "select roles.ID_Rol from roles, usuario where roles.ID_Rol = usuario.ID_Rol and usuario.username='"+user+"' and usuario.password='"+pass+"'";
        try{
        con=cn.conectar();
        ps=con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            nivel=rs.getInt(1);
        }
        cn.desconectar();
        }catch(SQLException ex){
            System.out.println(ex);
        }        
        return nivel;
    }
}
