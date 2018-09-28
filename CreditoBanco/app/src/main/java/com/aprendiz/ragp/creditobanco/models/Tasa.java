package com.aprendiz.ragp.creditobanco.models;

class Tasa {
    private int rTapizar;
    private int tamano;
    private int tasaTa;

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

    public int getTasaTa() {
        return tasaTa;
    }

    public void setTasaTa(int tasaTa) {
        this.tasaTa = tasaTa;
    }
}
