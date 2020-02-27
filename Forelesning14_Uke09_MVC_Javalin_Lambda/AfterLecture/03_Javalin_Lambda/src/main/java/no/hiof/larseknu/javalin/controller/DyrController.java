package no.hiof.larseknu.javalin.controller;

import io.javalin.http.Context;
import no.hiof.larseknu.javalin.model.Dyr;
import no.hiof.larseknu.javalin.repository.IDyreparkRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public class DyrController {
    private IDyreparkRepository dyreparkRepository;

    public DyrController(IDyreparkRepository dyreparkRepository) {
        this.dyreparkRepository = dyreparkRepository;
    }

    public void getAlleDyr(Context context) {
        String parkId = context.pathParam(":dyrepark-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Dyr> alleDyrIParken = dyreparkRepository.getAlleDyrIDyrepark(parkId);

        if (sortBy != null) {
            switch (sortBy) {
                case "id":
                    Collections.sort(alleDyrIParken);
                    break;
                case "navn":
                    alleDyrIParken.sort((dyr1, dyr2) -> dyr1.getNavn().compareTo(dyr2.getNavn()));
                    break;
                case "alder":
                    alleDyrIParken.sort((dyr1, dyr2) -> dyr1.getFodselsDato().compareTo(dyr2.getFodselsDato()));
                    break;
            }
        }

        context.json(alleDyrIParken);
    }

}
