package com.example.app.base.admin;

public class Point {

    Integer r;
    Integer c;
    Point parent;

    public Point(int x, int y, Point p) {
        r = x;
        c = y;
        parent = p;
    }
    // compute opposite node given that it is in the other direction from the parent

    public Point opposite() {
        if (this.r.compareTo(parent.r) != 0) {
            return new Point(this.r + this.r.compareTo(parent.r), this.c, this);
        }
        if (this.c.compareTo(parent.c) != 0) {
            return new Point(this.r, this.c + this.c.compareTo(parent.c), this);
        }
        return null;
    }

    //corrida
    public static void main(String[] args) throws Exception {
        Practica4 p = new Practica4();
        String aux = p.generar(10, 10);
        System.out.println(aux);
    }
}
