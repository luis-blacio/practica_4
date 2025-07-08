package com.example.app.base.Controler.data_struct.Grahps.Dijkstra;

import java.util.LinkedList;

import com.example.app.base.admin.Practica4;


public class LaberintoConCamino {

    public static void imprimirLaberintoConCamino(char[][] matriz, LinkedList<String> camino) {

        String[] pasos = camino.toArray(new String[0]);

        for (String paso : pasos) {
            String[] partes = paso.split(",");
            int fila = Integer.parseInt(partes[0]);
            int columna = Integer.parseInt(partes[1]);

            if (matriz[fila][columna] != 'S' && matriz[fila][columna] != 'E') {
                matriz[fila][columna] = '*';
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Practica4 generador = new Practica4();
        String laberintoTexto = generador.generar(30, 30); // Cambié de 100x100 a 10x10

        LaberintoConGrafo.ResultadoLaberinto resultado = LaberintoConGrafo.transformar(laberintoTexto);

        String[] predecesores = Dijkstra.dijkstra(resultado.grafo, resultado.inicio);

        LinkedList<String> camino = Dijkstra.reconstruirCamino(resultado.grafo, resultado.inicio, resultado.fin, predecesores);

        System.out.println("Camino encontrado:");
        System.out.println(camino.toString());

        char[][] matriz = Dijkstra.textoAMatriz(laberintoTexto);

        LaberintoConCamino.imprimirLaberintoConCamino(matriz, camino);
        
        Interfaz.mostrar(matriz, camino);

    }
}