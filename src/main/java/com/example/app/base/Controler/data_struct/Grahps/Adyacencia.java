package com.example.app.base.Controler.data_struct.Grahps;

public class Adyacencia {
    private Float weigth;
    private Integer destiny;

    public Adyacencia() {
    }

    public Adyacencia(Integer destiny) {
        this.destiny = destiny;
        this.weigth = Float.NaN;
    }

    public Adyacencia(Integer destiny, Float weigth) {
        this.destiny = destiny;
        this.weigth = weigth;
    }

    public Float getWeigth() {
        return this.weigth;
    }

    public void setWeigth(Float weigth) {
        this.weigth = weigth;
    }

    public Integer getDestiny() {
        return this.destiny;
    }

    public void setDestiny(Integer destiny) {
        this.destiny = destiny;
    }
}