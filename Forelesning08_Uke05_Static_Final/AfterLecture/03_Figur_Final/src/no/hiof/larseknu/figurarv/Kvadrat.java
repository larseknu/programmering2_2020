package no.hiof.larseknu.figurarv;

// Satt til final, så ingen kan arve fra Kvadrat klassen
public final class Kvadrat extends Rektangel {
    private double side;

    public Kvadrat(double side) {
        // Kaller konstruktøren til superklassen (Rektangel)
        super(side, side);

        this.side = side;
    }

    @Override
    public String toString() {
        return "Kvadrat med side " + side;
    }
}
