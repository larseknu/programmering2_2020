package no.hiof.larseknu.json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Karakter {
    private String navn;
    private Klasse klasse;
    private int level;

    public Karakter() {
    }

    public Karakter(String navn, int level) {
        this.navn = navn;
        this.level = level;
    }

    public Karakter(String navn, Klasse klasse, int level) {
        this.navn = navn;
        this.klasse = klasse;
        this.level = level;
    }

    @JsonIgnore
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return (klasse != null ? klasse.getNavn() + " " : "") + navn + " - level " + level;
    }
}
