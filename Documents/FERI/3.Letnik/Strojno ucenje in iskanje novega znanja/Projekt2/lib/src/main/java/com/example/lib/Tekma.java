package com.example.lib;

/**
 * Created by Bostjan on 03/01/2018.
 */

public class Tekma {
    private int id;
    private int steliNaGol;
    private int vsiStreli;

    public Tekma(int id, int steliNaGol, int vsiStreli) {
        this.id = id;
        this.steliNaGol = steliNaGol;
        this.vsiStreli = vsiStreli;
    }

    public Tekma(int steliNaGol, int vsiStreli) {
        this.steliNaGol = steliNaGol;
        this.vsiStreli = vsiStreli;
    }

    @Override
    public String toString() {
        return "Tekma{" +
                "steliNaGol=" + steliNaGol +
                ", vsiStreli=" + vsiStreli +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSteliNaGol() {
        return steliNaGol;
    }

    public void setSteliNaGol(int steliNaGol) {
        this.steliNaGol = steliNaGol;
    }

    public int getVsiStreli() {
        return vsiStreli;
    }

    public void setVsiStreli(int vsiStreli) {
        this.vsiStreli = vsiStreli;
    }
}
