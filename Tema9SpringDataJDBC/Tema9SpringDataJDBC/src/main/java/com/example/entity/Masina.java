package com.example.entity;

public class Masina {
    private String nr_inmatriculare;
    private String marca;
    private int an_fabricatie;
    private String culoare;
    private int nr_kilometrii;

    public Masina() {}

    public Masina(String nr_inmatriculare, String marca, int an_fabricatie, String culoare, int nr_kilometrii) {
        this.nr_inmatriculare = nr_inmatriculare;
        this.marca = marca;
        this.an_fabricatie = an_fabricatie;
        this.culoare = culoare;
        this.nr_kilometrii = nr_kilometrii;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNr_kilometrii() {
        return nr_kilometrii;
    }

    public void setNr_kilometrii(int nr_kilometrii) {
        this.nr_kilometrii = nr_kilometrii;
    }

    @Override
    public String toString() {
        return nr_inmatriculare + ", " + marca + ", " + an_fabricatie + ", " + culoare + ", " + nr_kilometrii;

    }
}