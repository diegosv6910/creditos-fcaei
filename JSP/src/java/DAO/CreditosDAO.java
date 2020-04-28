package DAO;

import Interfaces.listar_creditos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vistas.Conexion;
import vistas.Creditos;


public class CreditosDAO implements listar_creditos {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void iniciar_v(){
        Creditos cred = new Creditos();
        System.out.println(cred.getM_Busqueda());
    }

    @Override
    public List listar_creditos(Creditos cred) {
        System.out.println("Dato: "+cred.M_Busqueda);
        System.out.println("Aplicacion "+cred.getM_Busqueda());
        String M = cred.getM_Busqueda();
        ArrayList<Creditos>list = new ArrayList<>();
        String sql = "select * from creditos where Matricula = "+M;
        try{
            PreparedStatement ps = cn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Creditos cre = new Creditos();
                cre.setID_Creditos(rs.getInt("ID_Creditos"));
                cre.setMatricula(rs.getInt("Matricula"));
                cre.setID_Evento(rs.getInt("ID_Evento"));
                cre.setID_Log_Evidencia(rs.getInt("ID_Log_Evidencia"));
                cre.setTipo_Credito(rs.getString("Tipo_Evento"));
                list.add(cre);
                cred.setM_Busqueda(null);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return list;
    }
    
    
}
