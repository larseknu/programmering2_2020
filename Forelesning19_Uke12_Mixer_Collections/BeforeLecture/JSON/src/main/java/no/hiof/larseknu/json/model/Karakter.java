package no.hiof.larseknu.json.model;

public class Karakter {
    private String navn;
    private Yrke yrke;
    private int level;

    public Karakter() {
    }

    public Karakter(String navn, int level) {
        this.navn = navn;
        this.level = level;
    }

    public Karakter(String navn, Yrke yrke, int level) {
        this.navn = navn;
        this.yrke = yrke;
        this.level = level;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Yrke getYrke() {
        return yrke;
    }

    public void setYrke(Yrke yrke) {
        this.yrke = yrke;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return (yrke != null ? yrke.getNavn() + " " : "") + navn + " - level " + level;
    }
}
