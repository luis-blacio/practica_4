package com.example.app.base.Controler.data_struct.Grahps.Dijkstra;

import com.example.app.base.Controler.data_struct.Grahps.GrafoEtiquetasNoDirigido;

public class ResultadoLaberinto {

    public GrafoEtiquetasNoDirigido<String> grafo;
    public String inicio;
    public String fin;

    public ResultadoLaberinto(GrafoEtiquetasNoDirigido<String> grafo, String inicio, String fin) {
        this.grafo = grafo;
        this.inicio = inicio;
        this.fin = fin;
    }
}
