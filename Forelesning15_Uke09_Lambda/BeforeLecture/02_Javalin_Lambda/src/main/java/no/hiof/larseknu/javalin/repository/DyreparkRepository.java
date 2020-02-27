package no.hiof.larseknu.javalin.repository;

import no.hiof.larseknu.javalin.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DyreparkRepository implements IDyreparkRepository {
    public ArrayList<Dyrepark> dyreParker = new ArrayList<>();

    public DyreparkRepository() {
        Dyrepark kristiansandDyrepark = new Dyrepark("Kristiansand Dyrepark");

        HonningGrevling honningGrevlingenNils = new HonningGrevling("Nils", LocalDate.of(2013, 3, 2));
        Sjimpanse sjimpansenArne = new Sjimpanse("Arne", LocalDate.of(2017, 3, 17), 60);
        Sjimpanse sjimpansenJulius = new Sjimpanse("Julius", LocalDate.of(2017, 3, 17), 90);
        Panda pandaenTrine = new Panda("Trine", LocalDate.of(2014, 4, 13), "Hvit");

        kristiansandDyrepark.leggTilEttDyrIDyreparken(sjimpansenArne);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(sjimpansenJulius);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(pandaenTrine);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(honningGrevlingenNils);

        Dyrepark boraasDjurpark = new Dyrepark("Boraas Djurpark");

        boraasDjurpark.leggTilEttDyrIDyreparken(new HonningGrevling("Lille Nils", LocalDate.of(2020, 1, 1)));
        boraasDjurpark.leggTilEttDyrIDyreparken(new Sjimpanse("Stian", LocalDate.of(2019, 2, 3), 80));
        boraasDjurpark.leggTilEttDyrIDyreparken(new Panda("Anna", LocalDate.of(2018, 3, 2), "Gult"));

        dyreParker.add(kristiansandDyrepark);
        dyreParker.add(boraasDjurpark);
    }

    public ArrayList<Dyr> getAlleDyrIDyrepark(String parkNavn) {
        Dyrepark aktuellDyrepark = getDyrepark(parkNavn);

        if (aktuellDyrepark != null)
            return aktuellDyrepark.getDyrIDyreparken();

        return new ArrayList<>();
    }

    public Dyr getDyr(String parkNavn, String dyreNavn) {
        Dyrepark aktuellDyrepark = getDyrepark(parkNavn);

        if (aktuellDyrepark != null) {
            for (Dyr etDyr : aktuellDyrepark.getDyrIDyreparken()) {
                if (etDyr.getNavn().equals(parkNavn))
                    return etDyr;
            }
        }

        return null;
    }

    public Dyr getDyr(String parkNavn, int dyreId) {
        Dyrepark aktuellDyrepark = getDyrepark(parkNavn);

        if (aktuellDyrepark != null) {
            for (Dyr etDyr : aktuellDyrepark.getDyrIDyreparken()) {
                if (etDyr.getId() == dyreId)
                    return etDyr;
            }
        }

        return null;
    }

    public Dyrepark getDyrepark(String parkNavn) {
        for (Dyrepark dyrepark : dyreParker) {
            if (dyrepark.getNavn().equals(parkNavn))
                return dyrepark;
        }

        return null;
    }
}
