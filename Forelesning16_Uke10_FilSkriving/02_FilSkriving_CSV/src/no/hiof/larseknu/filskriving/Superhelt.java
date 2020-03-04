package no.hiof.larseknu.filskriving;

public class Superhelt {
    private String navn;
    private String alterEgo;

    public Superhelt(String navn, String alterEgo) {
        this.navn = navn;
        this.alterEgo = alterEgo;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

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
