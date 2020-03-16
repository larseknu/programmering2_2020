package no.hiof.larseknu.hashmaptest;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
       HashMap<Integer, String> maanedOversikt = new HashMap<>();

       maanedOversikt.put(1, "Januar");
       maanedOversikt.put(2, "Febru");
       maanedOversikt.put(2, "Fuar");
       maanedOversikt.put(2, "Februar");

        System.out.println(maanedOversikt);

        maanedOversikt.put(3, "Mars");
        maanedOversikt.put(4, "April");

        System.out.println(maanedOversikt);

        System.out.println("Vi henter her verdien ved hjelp av nökkelen: " + maanedOversikt.get(3));

        for (Integer key : maanedOversikt.keySet()) {
            System.out.println(key + " tilsvarer måneden " + maanedOversikt.get(key));
        }

        for (String value : maanedOversikt.values()) {
            System.out.println(value);
        }

        if (!maanedOversikt.containsKey(5))
           maanedOversikt.put(5, "Mai");

        System.out.println(maanedOversikt);
    }
}
