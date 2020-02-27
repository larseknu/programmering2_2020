package no.hiof.larseknu.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.larseknu.javalin.controller.DyrController;
import no.hiof.larseknu.javalin.repository.DyreparkRepository;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        // Views
        app.get("/", new VueComponent("hello-world"));
        app.get("/dyrepark/:dyrepark-id", new VueComponent("dyrepark-detail"));


        DyreparkRepository dyreparkRepository = new DyreparkRepository();
        DyrController dyrController = new DyrController(dyreparkRepository);

        // API
        // Anonym indre klasse
        /*app.get("api/dyrepark/:dyrepark-id", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                dyrController.getAlleDyr(ctx);
            }
        });*/

        // Lambda
        //app.get("api/dyrepark/:dyrepark-id", ctx -> dyrController.getAlleDyr(ctx));

        // Lambda
        app.get("api/dyrepark/:dyrepark-id", dyrController::getAlleDyr);
    }
}
