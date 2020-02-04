package no.hiof.larseknu.figurarv;

/**
 * Abstract Klasse som representerer en generisk figur
 * Kan ikke opprettes egne objekter av Figur-klassen (siden den er abstract)
 */
public abstract class Figur {
    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    public abstract double areal();

    public abstract double omkrets();

    public static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    public boolean erStorreMetodeSomIkkeErStatisk(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    public boolean erStorreMetodeSomIkkeErStatisk(Figur sammenligningsFigur)
    {
        return this.areal() > sammenligningsFigur.areal();
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
