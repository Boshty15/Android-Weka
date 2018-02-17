package com.example.lib;

import java.util.ArrayList;

/**
 * Created by Bostjan on 11/01/2018.
 */

public class DataAll {
    private ArrayList<Igralec> igralec;
    private ArrayList<IgralniPolozaj> igralniPolozajs;
    private ArrayList<Tekma> tekme;

    public void addIgralniPolozajAll(){
        this.igralniPolozajs = new ArrayList<>();
        igralniPolozajs.add(new IgralniPolozaj(0, "Levo Krilo", "LK"));
        igralniPolozajs.add(new IgralniPolozaj(0, "Desno Krilo", "DK"));
        igralniPolozajs.add(new IgralniPolozaj(0, "Levi Zunanji", "LZ"));
        igralniPolozajs.add(new IgralniPolozaj(0, "Desni Zunanji", "DZ"));
        igralniPolozajs.add(new IgralniPolozaj(0, "Srednji Zunanji", "SZ"));
        igralniPolozajs.add(new IgralniPolozaj(0, "Pivot", "PV"));

        this.tekme = new ArrayList<>();
        tekme.add(new Tekma(10,10));
    }

    public Igralec getIgralec(){
        return igralec.get(0);
    }
    public void addIgralec(){
        this.igralec = new ArrayList<>();
        igralec.add(new Igralec("Bostjan", "Kostomaj", igralniPolozajs.get(0), tekme));
    }

    public static DataAll scenarijA(){
        DataAll da = new DataAll();
        da.addIgralniPolozajAll();

        da.addIgralec();

        return da;
    }
}
