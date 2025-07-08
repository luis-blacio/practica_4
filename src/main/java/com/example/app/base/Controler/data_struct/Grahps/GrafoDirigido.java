package com.example.app.base.Controler.data_struct.Grahps;

import com.example.app.base.Controler.data_struct.list.Linkendlist;

public class GrafoDirigido extends Grahp {
 private Integer nro_vertex;
    private Integer nro_edge;
    private Linkendlist<Adyacencia> list_adjacencies[];

public GrafoDirigido (Integer nro_vertex) {
        this.nro_vertex = nro_vertex;
        this.nro_edge = 0;
        list_adjacencies = new Linkendlist[nro_vertex + 1];
        for (int i = 1; i <= nro_vertex; i++) {
            list_adjacencies[i] = new Linkendlist<>(); 
        }
    }       

    public void setNro_edge(Integer nro_edge){
        this.nro_edge = nro_edge;
    }


    public Linkendlist<Adyacencia> [] getList_adjacencies() {
        return this.list_adjacencies;
    }

    public void setList_adjacencies(Linkendlist<Adyacencia> [] list_adjacencies) {
        this.list_adjacencies = list_adjacencies;
    }

    @Override
    public Integer nro_vertex() {
        return this.nro_vertex;
    }

    @Override
    public Integer nro_edge() {
        return this.nro_edge;
    }

    @Override
    public Adyacencia exist_edge(Integer o, Integer d) {
        Adyacencia band = null;
        if (o.intValue() <= nro_vertex.intValue() && d.intValue() <= nro_vertex.intValue()) { 
            Linkendlist<Adyacencia> list = list_adjacencies[o];
            if (!list.isEmpty()) {
                Adyacencia[] matrix = list.toArray(); //// recorre las adyacencias
                for (Adyacencia adj : matrix) {
                    if (adj.getDestiny().intValue() == d.intValue()) { 
                                                                       
                        band = adj;
                        break;
                    }
                }
            }
        }
        return band;
    }

    @Override
    public Float wight_edge(Integer o, Integer d) {
        Adyacencia adj = exist_edge(o, d);
        if (adj != null) {
            return adj.getWeigth();
        }
        return Float.NaN;
    }

    @Override
    public void insert(Integer o, Integer d) {
        insert(o, d, Float.NaN);
    }

    @Override
    public void insert(Integer o, Integer d, Float weight) {
        if (o.intValue() <= nro_vertex.intValue() && d.intValue() <= nro_vertex.intValue()){
            if(exist_edge(o, d) == null){
                nro_edge++;
                Adyacencia aux = new Adyacencia();
                aux.setWeigth(weight);
                aux.setDestiny(d);
                list_adjacencies[o].add(aux); //al vertice origen le voy a fijar la nueva adyacencia que estoy creando
            }
        }else{
            throw new ArrayIndexOutOfBoundsException("xddddd ");
        }
    }

    @Override
    public Linkendlist<Adyacencia> adyacencias(Integer o) {
        return list_adjacencies[o];
    }

    public static void main(String[] args) {
        // Crear un grafo dirigido con 3 vértices
        GrafoDirigido graph = new GrafoDirigido(3);

        // Insertar algunas aristas
        graph.insert(1, 2, 1.5f);
        graph.insert(1, 3, 2.0f);
        graph.insert(2, 3, 3.5f);

        // Mostrar las adyacencias de cada vértice
        for (int i = 1; i <= graph.nro_vertex(); i++) {
            System.out.print("Adyacencias de " + i + ": ");
            Linkendlist<Adyacencia> adjList = graph.adyacencias(i);
            for (Adyacencia adj : adjList.toArray()) {
                System.out.print("-> " + adj.getDestiny() + " (Peso: " + adj.getWeigth() + ") ");
            }
            System.out.println();
        }

     
    }

}   

