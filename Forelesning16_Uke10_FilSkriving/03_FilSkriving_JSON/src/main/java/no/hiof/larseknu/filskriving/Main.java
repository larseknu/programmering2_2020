package no.hiof.larseknu.filskriving;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.larseknu.filskriving.model.Superhelt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)  {
        ObjectMapper objectMapper = new ObjectMapper();

        // Konvertere superhelt-objekt til JSON og tilbake igjen
        try {
            String jsonText = objectMapper.writeValueAsString(new Superhelt("Superman", "Clark Kent"));
            System.out.println("JSON objekt: " + jsonText);
            Superhelt superman = objectMapper.readValue(jsonText, Superhelt.class);
            System.out.println("Konvertert fra JSON: " + superman);

            ArrayList<Superhelt> superhelter = new ArrayList<>();
            superhelter.add(new Superhelt("Batman", "Bruce Wayne"));
            superhelter.add(new Superhelt("The Hulk", "Bruce Banner"));
            superhelter.add(superman);

            // Skriver listen til JSON-fil
            skrivTilJSONFil(superhelter, "superhelter.json");

            // Leser liste fra JSON-fil
            ArrayList<Superhelt> superhelterFraJSONFil = lesFraJSONFil("superhelter.json");

            System.out.println("**********Liste lest fra fil**********");
            // Skriver ut superhelter leste fra fil
            for (Superhelt enHelt : superhelterFraJSONFil) {
                System.out.println(enHelt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static void skrivTilJSONFil(ArrayList<Superhelt> superhelter, String filsti) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filsti), superhelter);
    }

    private static ArrayList<Superhelt> lesFraJSONFil(String filnavn) {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Superhelt> superheltListeFraFil = new ArrayList<>();

        try {
            Superhelt[] superheltArray = objectMapper.readValue(new File(filnavn), Superhelt[].class);

            superheltListeFraFil.addAll(Arrays.asList(superheltArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return superheltListeFraFil;
    }

}
