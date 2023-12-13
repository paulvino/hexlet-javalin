package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.util.NamedRoutes;

import java.util.Collections;

public class HelloWorld {

    public static void main(String[] args) {

        var app = Javalin.create(config -> config.plugins.enableDevLogging());

        app.get(NamedRoutes.mainPath(), ctx -> {
//            var visited = Boolean.valueOf(ctx.cookie("visited"));
//            var page = new MainPage(visited);
//            ctx.render("index.jte", Collections.singletonMap("page", page));
//            ctx.render("index.jte");
//            ctx.cookie("visited", String.valueOf(true));

            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });

        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.usersPath(), UsersController::destroy);

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get("/courses/{id}/edit", CoursesController::edit);
        app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursesPath(), CoursesController::destroy);

        // отображение формы логина
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        // процесс логина
        app.post(NamedRoutes.sessionPath(), SessionsController::create);
        // процесс выхода из аккаунта
        app.delete(NamedRoutes.sessionPath(), SessionsController::destroy);

        app.start(7070);
    }
}
