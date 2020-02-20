package no.hiof.larseknu.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/", new VueComponent("hello-world"));

        app.get("/another-page", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                ctx.result("Hello from the other side!");
            }
        });
    }
}
