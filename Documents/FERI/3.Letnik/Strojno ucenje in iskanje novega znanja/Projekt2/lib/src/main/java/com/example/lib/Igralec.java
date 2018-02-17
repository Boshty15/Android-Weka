package com.example.lib;

import java.util.ArrayList;

/**
 * Created by Bostjan on 03/01/2018.
 */

public class Igralec {
    private String ime;
    private String priimek;
    private IgralniPolozaj igralniPolozaj;
    private ArrayList<Tekma> tekme;

    @Override
    public String toString() {
        return "Igralec{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", igralniPolozaj=" + igralniPolozaj +
                ", tekme=" + tekme +
                '}';
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public IgralniPolozaj getIgralniPolozaj() {
        return igralniPolozaj;
    }

    public void setIgralniPolozaj(IgralniPolozaj igralniPolozaj) {
        this.igralniPolozaj = igralniPolozaj;
    }

    public ArrayList<Tekma> getTekme() {
        return tekme;
    }

    public void setTekme(ArrayList<Tekma> tekme) {
        this.tekme = tekme;
    }

    public Igralec(String ime, String priimek, IgralniPolozaj igralniPolozaj, ArrayList<Tekma> tekme) {

        this.ime = ime;
        this.priimek = priimek;
        this.igralniPolozaj = igralniPolozaj;
        this.tekme = tekme;
    }
}
