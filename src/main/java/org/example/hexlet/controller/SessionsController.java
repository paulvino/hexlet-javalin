package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

public class SessionsController {
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParam("password");

        // тут должна быть проверка пароля

        var user = new User(name, email, password);
        UserRepository.save(user);

        ctx.sessionAttribute("currentUser", name);
        ctx.redirect(NamedRoutes.mainPath());
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.mainPath());
    }
}
