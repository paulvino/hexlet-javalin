package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.courses.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final List<Map<String, Object>> DATA = Data.getData();

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            var msg = (name != null) ? "Hello, " + name + "!" : "Hello, World!";
//            ctx.result(msg); // обычный вывод, без форматирования
            ctx.contentType("text/html"); // вывод с форматированием в html
            ctx.result("<h1>" + msg + "</h1>");
        });

        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.get("/users", UsersController::index);
        app.get("/users/build", UsersController::build);
        app.get("/users/{id}", UsersController::show);
        app.post("/users", UsersController::create);
        app.get("/users/{id}/edit", UsersController::edit);
        app.patch("/users/{id}", UsersController::update);
        app.delete("/users", UsersController::destroy);

        app.get("/courses", CoursesController::index);
        app.get("/courses/build", CoursesController::build);
        app.get("/courses/{id}", CoursesController::show);
        app.post("/courses", CoursesController::create);
        app.get("/courses/{id}/edit", CoursesController::edit);
        app.patch("/courses/{id}", CoursesController::update);
        app.delete("/courses", CoursesController::destroy);

        app.start(7070);
    }
}
