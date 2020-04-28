package vistas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sentencias_SQL {
    Conexion c;
    
    public boolean create(String id_e,String id_i,String n_e,String f_i,String f_f) {
        c=new Conexion();
        try {
            String sql = "INSERT INTO eventos (ID_Evento, ID_Institucion, Nombre_Evento,Fecha_Inicio,Fecha_Fin) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, id_e);
            ps.setString(2, id_i);
            ps.setString(3, n_e);
            ps.setString(4, f_i);
            ps.setString(5, f_f);
            ps.executeUpdate();
            System.out.println("Registrado :) ");
            ps.close();
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public boolean listar() {
        c=new Conexion();
        try {
            ResultSet rs;
            String sql = "select *from eventos";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            rs=ps.executeQuery(sql);
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean editar(String id_e,String id_i,String n_e,String f_i,String f_f) {
        c=new Conexion();
        try {
            System.out.println(id_e);
            String sql = "update eventos set ID_Institucion = ?, Nombre_Evento = ?,Fecha_Inicio = ?,Fecha_Fin = ? where ID_Evento ="+id_e;
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, id_i);
            ps.setString(2, n_e);
            ps.setString(3, f_i);
            ps.setString(4, f_f);
            ps.executeUpdate();
            System.out.println("Registrado :) ");
            ps.close();
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
}
