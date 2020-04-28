package DAO;

import Interfaces.listar_evidencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vistas.Conexion;
import vistas.Eventos;
import vistas.Evidencias;

public class EvidenciasDAO implements listar_evidencias {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Evidencias evi = new Evidencias();
     
    @Override
    public List listar() {
        ArrayList<Evidencias>list = new ArrayList<>();
        String sql = "select *from log_evidencia";
        try{
            con = cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Evidencias evi = new Evidencias();
                evi.setId_e(rs.getInt("ID_Log_Evidencia"));
                evi.setUrl(rs.getString("URL_Evidencia"));
                list.add(evi);
                
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return list;
    }
    
}
