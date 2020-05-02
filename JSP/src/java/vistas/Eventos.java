package vistas;

public class Eventos {
    public  int ID_Evento;
    public  int ID_Institucion;
    public String Nombre_Evento;
    public String Fecha_Inicio;
    public String Fecha_Final;
    public String Nom_Inst;
    public String Descripcion;
    
    

    public Eventos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getID_Evento() {
        return ID_Evento;
    }

    public void setID_Evento(int ID_Evento) {
        this.ID_Evento = ID_Evento;
    }

    public int getID_Institucion() {
        return ID_Institucion;
    }

    public void setID_Institucion(int ID_Institucion) {
        this.ID_Institucion = ID_Institucion;
    }

    public String getNombre_Evento() {
        return Nombre_Evento;
    }

    public void setNombre_Evento(String Nombre_Evento) {
        this.Nombre_Evento = Nombre_Evento;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Final() {
        return Fecha_Final;
    }

    public void setFecha_Final(String Fecha_Final) {
        this.Fecha_Final = Fecha_Final;
    }

    public String getNom_Inst() {
        return Nom_Inst;
    }

    public void setNom_Inst(String Nom_Inst) {
        this.Nom_Inst = Nom_Inst;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
    
}
