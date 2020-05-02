package vistas;



public class Almacenar {
    
    public void Recibir(String id_e,String id_i,String nom_e, String f_i, String f_f,String D){
        Sentencias_SQL sen = new Sentencias_SQL();
        sen.create(id_e,id_i,nom_e,f_i,f_f,D);
    }
    public void RecibirEditar(String id_e,String id_i,String nom_e, String f_i, String f_f){
        Sentencias_SQL sen = new Sentencias_SQL();
        sen.editar(id_e,id_i,nom_e,f_i,f_f);
    }
    public void RecibirEvidencia(String url){
        Sentencias_SQL sen = new Sentencias_SQL();
        sen.createE(url);
    }
    
}
