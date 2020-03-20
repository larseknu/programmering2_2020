package no.hiof.larseknu.json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Trollmann extends Yrke {
    private ArrayList<String> trylleformler = new ArrayList<>();

    public Trollmann() {
    }

    public Trollmann(String navn, String beskrivelse, int terning) {
        super(navn, beskrivelse, terning);
    }

    public void leggTilTrylleformel(String trylleformel) {
        trylleformler.add(trylleformel);
    }

    @JsonIgnore
    public String getHemmeligTrylleformel() {
        return "Wish";
    }

    public ArrayList<String> getTrylleformler() {
        return new ArrayList<>(trylleformler);
    }

    public void setTrylleformler(ArrayList<String> trylleformler) {
        this.trylleformler = trylleformler;
    }
}
