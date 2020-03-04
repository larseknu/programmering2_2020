package no.hiof.larseknu.filskriving.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Superhelt {
    private String navn;
    private String alterEgo;

    public Superhelt() {
    }

    public Superhelt(String navn, String alterEgo) {
        this.navn = navn;
        this.alterEgo = alterEgo;
    }

    @JsonProperty("name")
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @JsonProperty("realName")
    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    @Override
    public String toString() {
        return String.format("%s har alteregoet %s", navn, alterEgo);
    }
}