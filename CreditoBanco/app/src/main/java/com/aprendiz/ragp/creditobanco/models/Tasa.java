package com.aprendiz.ragp.creditobanco.models;

public class Tasa {
    private int rTapizar;
    private int tamano;
    private float tasaTa;

    public Tasa() {
    }

    public int getrTapizar() {
        return rTapizar;
    }

    public void setrTapizar(int rTapizar) {
        this.rTapizar = rTapizar;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public float getTasaTa() {
        return tasaTa;
    }

    public void setTasaTa(float tasaTa) {
        this.tasaTa = tasaTa;
    }
}
