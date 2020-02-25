package no.hiof.larseknu.javalin.controller;

import io.javalin.http.Context;
import no.hiof.larseknu.javalin.model.Dyr;
import no.hiof.larseknu.javalin.repository.IDyreparkRepository;

import java.util.ArrayList;

public class DyrController {
    private IDyreparkRepository dyreparkRepository;

    public DyrController(IDyreparkRepository dyreparkRepository) {
        this.dyreparkRepository = dyreparkRepository;
    }

    public void getAlleDyr(Context context) {
        String parkId = context.pathParam(":dyrepark-id");

        ArrayList<Dyr> alleDyrIParken = dyreparkRepository.getAlleDyrIDyrepark(parkId);

        context.json(alleDyrIParken);
    }

}
