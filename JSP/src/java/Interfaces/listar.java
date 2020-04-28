package Interfaces;

import java.util.List;
import vistas.Eventos;

public interface listar {
    public List listar();
    public Eventos listar(int ID_Evento);
    public boolean editar(Eventos eve);
    public boolean eliminar(int ID_Evento);
}

