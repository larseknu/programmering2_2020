package no.hiof.larseknu.json.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Trollmann.class, name = "trollmann"),
        @JsonSubTypes.Type(value = Barbar.class, name = "barbar")
})*/
public abstract class Yrke {
    private String navn, beskrivelse;
    public int terning;

    public Yrke() {
    }

    public Yrke(String navn, String beskrivelse, int terning) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.terning = terning;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    /*public int getTerning() {
        return terning;
    }

    public void setTerning(int terning) {
        this.terning = terning;
    }*/
}
