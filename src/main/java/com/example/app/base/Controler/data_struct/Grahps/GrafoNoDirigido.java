package com.example.app.base.Controler.data_struct.Grahps;

public class GrafoNoDirigido extends GrafoDirigido {
    public GrafoNoDirigido(Integer nro_vertex) {
        super(nro_vertex);
    }
    
    @Override
    public void insert(Integer o, Integer d, Float weight) {
        if (o.intValue() <= nro_vertex().intValue() && d.intValue() <= nro_vertex().intValue()){
            if(exist_edge(o, d) == null){
                //nro_edge++;
                setNro_edge(nro_edge()+1);
                //origen
                Adyacencia aux = new Adyacencia();
                aux.setWeigth(weight);
                aux.setDestiny(d);
                getList_adjacencies()[o].add(aux);
                //destiny
                Adyacencia auxD = new Adyacencia();
                auxD.setWeigth(weight);
                auxD.setDestiny(o);
                getList_adjacencies()[d].add(auxD);

            }
        }else{
            throw new ArrayIndexOutOfBoundsException("Vertex origin o destiny index out ");
        }
    }

}