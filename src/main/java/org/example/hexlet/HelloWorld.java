package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

//        app.get("/", ctx -> {
//            ctx.contentType("text/html");
//            ctx.result("<h1>Hello Hexlet</h1>");
//        });

//        app.get("/users", ctx -> {
//            ctx.result("GET /users");
//        });
//
//        app.post("/users", ctx -> {
//            ctx.result("POST /users");
//        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
//            if (name != null) {
//                ctx.result("Hello, " + name + "!");
//            } else {
//                ctx.result("Hello, World!");
//            }
//            Замена кода выше (5 строк) тернарным оператором
            var msg = (name != null) ? "Hello, " + name + "!" : "Hello, World!";
//            ctx.result(msg); // обычный вывод, без форматирования
            ctx.contentType("text/html"); // вывод с форматированием в html
            ctx.result("<h1>" + msg + "</h1>");
        });

        app.start(7070);
    }
}
