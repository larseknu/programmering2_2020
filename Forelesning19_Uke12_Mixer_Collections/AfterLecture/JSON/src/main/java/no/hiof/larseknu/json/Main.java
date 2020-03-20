package no.hiof.larseknu.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jndi.toolkit.url.Uri;
import no.hiof.larseknu.json.model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Karakter> karakterer = new ArrayList<>();

        Trollmann trollmann = new Trollmann("Spaadoms Trollmann", "En magi bruker", 6);
        trollmann.leggTilTrylleformel("Flammeball");
        trollmann.leggTilTrylleformel("Taskenspilleri");

        Barbar barbar = new Barbar("Berserk Barbar", "En sterk fyr", 12, 3);

        Karakter saeris = new Karakter("Saeris", trollmann, 13);
        Karakter trok = new Karakter("Trok", barbar, 10);

        karakterer.add(saeris);
        karakterer.add(trok);

        System.out.println(karakterer);

        skrivTilJson("karakterer.json", karakterer);

        List<Karakter> nyListe = lesFraJson("karakterer.json");
        System.out.println("*****LEST FRA FIL******");
        System.out.println(nyListe);
    }


    public static void skrivTilJson(String filnavn, List<Karakter> karakterer) {
        try {
            File file = new File(filnavn);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, karakterer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Karakter> lesFraJson(String filnavn) {
        List<Karakter> karakterer = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Karakter[] karakterArray = objectMapper.readValue(new File(filnavn), Karakter[].class);

            karakterer = Arrays.asList(karakterArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return karakterer;
    }
}
