package no.hiof.larseknu.javalin.controller;

import io.javalin.http.Context;
import no.hiof.larseknu.javalin.model.Dyr;
import no.hiof.larseknu.javalin.repository.DyreparkRepository;

import java.util.ArrayList;

public class DyrController {

    private DyreparkRepository dyreparkRepository;

    public DyrController(DyreparkRepository dyreparkRepository) {
        this.dyreparkRepository = dyreparkRepository;
    }

    public void getAlleDyr(Context context) {
        String parkNavn = context.pathParam(":dyrepark-id");

        ArrayList<Dyr> alleDyrIParken = dyreparkRepository.getAlleDyrIDyrepark(parkNavn);

        context.json(alleDyrIParken);
    }

}
