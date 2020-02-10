package no.hiof.larseknu.figurarv;

/**
 * Abstract Klasse som representerer en generisk figur
 * Kan ikke opprettes egne objekter av Figur-klassen (siden den er abstract)
 */
public abstract class Figur implements Tegnbar, Comparable<Figur>{
    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    public abstract double areal();

    public abstract double omkrets();

    @Override
    public int compareTo(Figur sammenLigningsFigur) {
        /*
        // Sjekker hvilken figur som er størt ved hjelp av rekke if-else spørringer
        if (this.areal() > sammenLigningsFigur.areal())
            return 1;
        else if (this.areal() < sammenLigningsFigur.areal())
            return -1;
        else {
            if (this.omkrets() > sammenLigningsFigur.omkrets())
                return 1;
            else if (this.omkrets() < sammenLigningsFigur.omkrets())
                return -1;
            else return 0;
        }*/

        // Finner ut hvilket areal som er størst (NB: når vi konverterer fra double til int her, mister vi noe nøyaktighet)
        // Positiv verdi - denne(this) figuren er størst
        // Negativ verdi - sammenLigningsFigur er størst
        // 0 - de er like store
        int returVerdi = (int)(this.areal() - sammenLigningsFigur.areal());

        // Hvis returVerdi er 0, har de like stort areal, sammenligner derfor omkrets
        if (returVerdi == 0)
            // Finner ut hvilken omkrets som er størst (eller om de er like)
            returVerdi = (int)(this.omkrets() - sammenLigningsFigur.omkrets());

        return returVerdi;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
