package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangelet = new Rektangel(4, 5);

        Sirkel sirkelen = new Sirkel(3);

        System.out.println(rektangelet + " Areal: " + rektangelet.areal() + " Omkrets: " + rektangelet.omkrets());
        // String.format() gjør det her mulig å skrive en mer oversiktling string,
        // i tillegg kan man gjøre praktiske ting som å runde av double-verdien til å kun vise 2 desimaler
        System.out.println(String.format("%s Areal: %.2f Omkrets %.2f",sirkelen, sirkelen.areal(), sirkelen.omkrets()));

    }
}
