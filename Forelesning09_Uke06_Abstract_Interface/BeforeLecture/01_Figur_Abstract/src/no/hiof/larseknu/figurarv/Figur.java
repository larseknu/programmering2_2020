package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en generisk figur
 */
public class Figur {

    public double areal() {
        return 0;
    }

    public double omkrets() {
        return 0;
    }

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

}
