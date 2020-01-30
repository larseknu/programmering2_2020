package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en generisk figur
 */
public class Figur {
    private static final double CM_TIL_METER = 100;
    private String farge;

    public double areal() {
        return 0;
    }

    public double omkrets() {
        return 0;
    }

    public double arealIMeter() {
        return areal() / CM_TIL_METER;
    }

    public double omkretsIMeter() {
        return omkrets() / CM_TIL_METER;
    }

    /**
     * Metode for å sammenligne to figurer
     * Vi kan kalle den direkte med klassen, uten å instansiere ett objekt først, fordi den er statisk
     */
    public static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    /**
     * Metode for å sammenligne to figurer
     * Denne er ikke statisk, så vi må ha en instans av Figur-klassen for å kunne kalle den
     */
    public boolean erStorreMetodeSomIkkeErStatisk(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    /**
     * Metode for å sammenligne to figurer
     * Denne er ikke statisk, så vi må ha en instans av Figur-klassen for å kunne kalle den
     */
    public boolean erStorreMetodeSomIkkeErStatisk(Figur sammenLigningsFigur)
    {
        return this.areal() > sammenLigningsFigur.areal();
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
