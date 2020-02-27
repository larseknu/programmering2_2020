package no.hiof.larseknu.javalin.repository;

import no.hiof.larseknu.javalin.model.Dyr;
import no.hiof.larseknu.javalin.model.Dyrepark;

import java.util.ArrayList;

public interface IDyreparkRepository {
    ArrayList<Dyr> getAlleDyrIDyrepark(String parkNavn);
    Dyr getDyr(String parkNavn, String dyreNavn);
    Dyr getDyr(String parkNavn, int dyreId);
    Dyrepark getDyrepark(String parkNavn);
}
