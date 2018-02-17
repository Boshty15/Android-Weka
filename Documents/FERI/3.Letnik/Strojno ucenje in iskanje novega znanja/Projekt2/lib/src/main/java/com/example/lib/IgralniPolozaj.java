package com.example.lib;

/**
 * Created by Bostjan on 03/01/2018.
 */

public class IgralniPolozaj {
    private int id;
    private String polozaj;
    private String kratica;

    public IgralniPolozaj(int id, String polozaj, String kratica) {
        this.id = id;
        this.polozaj = polozaj;
        this.kratica = kratica;
    }

    @Override
    public String toString() {
        return "IgralniPolozaj{" +
                "id=" + id +
                ", polozaj='" + polozaj + '\'' +
                ", kratica='" + kratica + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolozaj() {
        return polozaj;
    }

    public void setPolozaj(String polozaj) {
        this.polozaj = polozaj;
    }

    public String getKratica() {
        return kratica;
    }

    public void setKratica(String kratica) {
        this.kratica = kratica;
    }
}
