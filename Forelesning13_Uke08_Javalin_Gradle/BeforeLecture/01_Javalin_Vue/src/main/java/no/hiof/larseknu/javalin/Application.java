package no.hiof.larseknu.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.get("/", new Handler() {
            @Override
            public void handle(Context ctx) {
                ctx.result("Hello, world");
            }
        });

        app.get("/another-page", new Handler() {
            @Override
            public void handle(Context ctx) {
                ctx.result("Hello from the other side!");
            }
        });
    }

}
