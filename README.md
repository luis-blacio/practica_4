# Práctica 4 - Generador y Solucionador de Laberintos

Este proyecto implementa un generador de laberintos utilizando el algoritmo de Prim y un solucionador que encuentra el camino más corto usando el algoritmo de Dijkstra.

## Características

- **Generación de laberintos**: Utiliza el algoritmo de Prim modificado para crear laberintos aleatorios
- **Conversión a grafo**: Transforma laberintos en grafos etiquetados no dirigidos
- **Algoritmo de Dijkstra**: Encuentra el camino más corto entre el inicio y el fin
- **Visualización gráfica**: Interfaz Swing con colores personalizados
- **Múltiples tamaños**: Configurable desde pequeños (5x5) hasta grandes (100x100)

## Estructura del proyecto

- `Practica4.java`: Generador de laberintos con algoritmo de Prim
- `LaberintoConGrafo.java`: Conversor de laberinto a grafo
- `Dijkstra.java`: Implementación del algoritmo de Dijkstra
- `Interfaz.java`: Interfaz gráfica para visualización
- `LaberintoConCamino.java`: Clase principal que integra toda la funcionalidad

## Cómo ejecutar

Para ejecutar el generador y solucionador de laberintos:

```bash
# Compilar
javac -cp "src/main/java" src/main/java/com/example/app/base/Controler/data_struct/Grahps/Dijkstra/LaberintoConCamino.java

# Ejecutar
java -cp "src/main/java" com.example.app.base.Controler.data_struct.Grahps.Dijkstra.LaberintoConCamino
```

## Colores en la interfaz

- **Negro**: Paredes
- **Blanco**: Caminos libres
- **Azul**: Punto de inicio (S)
- **Magenta**: Punto de destino (E)
- **Naranja**: Camino solución

## Personalización

Para cambiar el tamaño del laberinto, modifica los parámetros en `LaberintoConCamino.java`:
```java
String laberintoTexto = generador.generar(filas, columnas);
```
My Application implementation. You'll learn how to set up your development environment, understand the project 
structure, and find resources to help you add muscles to your skeleton — transforming it into a fully-featured 
application.
