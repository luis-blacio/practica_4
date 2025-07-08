package com.example.app.base.Controler.data_struct.Grahps.Dijkstra;

import com.example.app.base.Controler.data_struct.Grahps.GrafoEtiquetasNoDirigido;

public class LaberintoConGrafo {
    
    private static boolean esTransitable(char c) {
        return c == '1' || c == 'S' || c == 'E';
    }

    public static ResultadoLaberinto transformar(String laberintoTexto) {
        
        String[] filas = laberintoTexto.split("\n");
        int r = filas.length;
        int c = filas[0].split(",").length;

        char[][] matriz = new char[r][c];

        for (int i = 0; i < r; i++) {
            String[] elementos = filas[i].split(",");
            for (int j = 0; j < c; j++) {
                matriz[i][j] = elementos[j].charAt(0);
            }
        }

        int contadorNodos = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (esTransitable(matriz[i][j])) {
                    contadorNodos++;
                }
            }
        }

        GrafoEtiquetasNoDirigido<String> grafo = new GrafoEtiquetasNoDirigido<>(contadorNodos, String.class);

        int indice = 1;
        String[][] etiquetas = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (esTransitable(matriz[i][j])) {
                    String etiqueta = i + "," + j;
                    etiquetas[i][j] = etiqueta;
                    grafo.label_vertex(indice, etiqueta);
                    indice++;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (esTransitable(matriz[i][j])) {
                    String etiquetaActual = etiquetas[i][j];

                    // Vecino arriba
                    if (i > 0 && esTransitable(matriz[i - 1][j])) {
                        grafo.insert_label(etiquetaActual, etiquetas[i - 1][j], 1.0f);
                    }
                    // Vecino abajo
                    if (i < r - 1 && esTransitable(matriz[i + 1][j])) {
                        grafo.insert_label(etiquetaActual, etiquetas[i + 1][j], 1.0f);
                    }
                    // Vecino izquierda
                    if (j > 0 && esTransitable(matriz[i][j - 1])) {
                        grafo.insert_label(etiquetaActual, etiquetas[i][j - 1], 1.0f);
                    }
                    // Vecino derecha
                    if (j < c - 1 && esTransitable(matriz[i][j + 1])) {
                        grafo.insert_label(etiquetaActual, etiquetas[i][j + 1], 1.0f);
                    }
                }
            }
        }

        String inicio = null;
        String fin = null;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matriz[i][j] == 'S') {
                    inicio = i + "," + j;
                }
                if (matriz[i][j] == 'E') {
                    fin = i + "," + j;
                }
            }
        }

        return new ResultadoLaberinto(grafo, inicio, fin);
    }


    public static class ResultadoLaberinto {
        public final GrafoEtiquetasNoDirigido<String> grafo;
        public final String inicio;
        public final String fin;

        public ResultadoLaberinto(GrafoEtiquetasNoDirigido<String> grafo, String inicio, String fin) {
            this.grafo = grafo;
            this.inicio = inicio;
            this.fin = fin;
        }
    }


}
