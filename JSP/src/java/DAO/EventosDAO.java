package DAO;

import Interfaces.listar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vistas.Conexion;
import vistas.Eventos;

public class EventosDAO implements listar {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Eventos eve = new Eventos();
    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Eventos>list = new ArrayList<>();
        String sql = "select distinct eventos.ID_Evento, institucionacademica.Nombre_Inst, eventos.Nombre_Evento, eventos.Fecha_Inicio, eventos.Fecha_Fin, eventos.Descripcion_E from institucionacademica,eventos where institucionacademica.ID_InstitucionA=eventos.ID_Institucion;";
        try{
            con = cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Eventos eve = new Eventos();
                eve.setID_Evento(rs.getInt("ID_Evento"));
                eve.setNom_Inst(rs.getString("Nombre_Inst"));
                eve.setNombre_Evento(rs.getString("Nombre_Evento"));
                eve.setFecha_Inicio(rs.getString("Fecha_Inicio"));
                eve.setFecha_Final(rs.getString("Fecha_Fin"));
                eve.setDescripcion(rs.getString("Descripcion_E"));
                list.add(eve);
                
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Eventos listar(int i) {
                String sql = "select *from eventos where ID_Evento="+i;
        try{
            con = cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                eve.setID_Evento(rs.getInt("ID_Evento"));
                eve.setID_Institucion(rs.getInt("ID_Institucion"));
                eve.setNombre_Evento(rs.getString("Nombre_Evento"));
                eve.setFecha_Inicio(rs.getString("Fecha_Inicio"));
                eve.setFecha_Final(rs.getString("Fecha_Fin"));
                eve.setDescripcion(rs.getString("Descripcion_E"));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return eve;
    }

    @Override
    public boolean editar(Eventos events) {
        String sql = "UPDATE eventos set ID_Institucion='"+events.getID_Institucion()+"',Nombre_Evento='"+events.getNombre_Evento()+"',Fecha_Inicio='"+events.getFecha_Inicio()+"',Fecha_Fin='"+events.getFecha_Final()+"',Descripcion_E='"+events.getDescripcion()+"' where ID_Evento='"+events.getID_Evento()+"'";
        try{
        con=cn.conectar();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int ID_Evento) {
        String sql = "DELETE from eventos where ID_Evento="+ID_Evento;
        try{
        con=cn.conectar();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return false;
    }
    
}
