package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en figur av typen Rektangel
 */
public class Rektangel extends Figur {
    // Instansvariabler
    private double side1;
    private double side2;

    public Rektangel(double side1, double side2, String farge) {
        super(farge);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double areal() {
        return side1 * side2;
    }

    @Override
    public double omkrets() {
        return (side1 + side2) * 2;
    }

    @Override
    public String toString() {
        return getFarge() + " Rektangel med sidene: " + side1 + ", " + side2;
    }

}
