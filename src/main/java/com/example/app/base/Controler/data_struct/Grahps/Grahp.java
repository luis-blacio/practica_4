package  com.example.app.base.Controler.data_struct.Grahps;

import com.example.app.base.Controler.data_struct.list.Linkendlist;

public abstract class Grahp {
    public abstract Integer nro_vertex();
    public abstract Integer nro_edge();
    public abstract Adyacencia exist_edge(Integer o, Integer d); //origen y destino
    public abstract Float wight_edge(Integer o, Integer d);
    public abstract void insert(Integer o, Integer d);
    public abstract void insert(Integer o, Integer d, Float weight);
   
    public abstract Linkendlist<Adyacencia> adyacencias(Integer o);


    @Override 
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i=1; i<= nro_vertex(); i++){
            sb.append("Vertex =").append(String.valueOf(i)).append("\n");
            Linkendlist<Adyacencia> list = adyacencias(i);
            if(!list.isEmpty()){
                Adyacencia [] matrix = list.toArray();
                for(Adyacencia ad: matrix){
                    sb.append("\tAdyacencia = ").append("\n").append("Vertex = ").append(String.valueOf(ad.getDestiny()));
                    if(!ad.getWeigth().isNaN()){
                        sb.append(" weight = "+ ad.getWeigth().toString()).append("\n");
                    }
                    //52:56
                }
            }
        }
        return sb.toString();
    }

}

