package com.example.app.base.Controler.data_struct.Grahps.Dijkstra;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
public class Interfaz  extends JFrame {
    

    private char[][] matriz;
    private LinkedList<String> camino;
    private int cellSize = 20;
    private JPanel panel;

    public Interfaz(char[][] matriz, LinkedList<String> camino) {
        this.matriz = matriz;
        this.camino = camino;

        marcarCamino();

        setTitle("Laberinto - Dijkstra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarLaberinto(g);
            }
        };

        panel.setPreferredSize(new Dimension(matriz[0].length * cellSize, matriz.length * cellSize));

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void marcarCamino() {
        if (camino != null) {
            String[] pasos = camino.toArray(new String[0]);
            for (String paso : pasos) {
                String[] partes = paso.split(",");
                int fila = Integer.parseInt(partes[0]);
                int columna = Integer.parseInt(partes[1]);
                if (matriz[fila][columna] != 'S' && matriz[fila][columna] != 'E') {
                    matriz[fila][columna] = '*';
                }
            }
        }
    }

    private void dibujarLaberinto(Graphics g) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int x = j * cellSize;
                int y = i * cellSize;

                switch (matriz[i][j]) {
                    case '0' ->
                        g.setColor(Color.BLACK);           // Pared - Negro sólido
                    case '1' ->
                        g.setColor(Color.WHITE);           // Camino libre - Blanco
                    case 'S' ->
                        g.setColor(Color.BLUE);            // Inicio - Azul brillante
                    case 'E' ->
                        g.setColor(Color.MAGENTA);         // Fin - Magenta
                    case '*' ->
                        g.setColor(Color.ORANGE);          // Camino Correcto - Naranja
                    default ->
                        g.setColor(Color.LIGHT_GRAY);
                }

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(Color.DARK_GRAY);               // Borde - Gris oscuro
                g.drawRect(x, y, cellSize, cellSize);

                
            }
        }
    }

    public static void mostrar(char[][] matriz, LinkedList<String> camino) {
        SwingUtilities.invokeLater(() -> new Interfaz(matriz, camino));
    }
}
