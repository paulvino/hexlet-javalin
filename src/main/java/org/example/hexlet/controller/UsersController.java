package org.example.hexlet.controller;

import java.sql.SQLException;
import java.util.Collections;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class UsersController {
    public static void index(Context ctx) throws SQLException {
        var users = UserRepository.getEntities();
        var page = new UsersPage(users);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var escapedId = StringEscapeUtils.escapeHtml4(String.valueOf(id));
        var user = UserRepository.find(Long.valueOf(escapedId))
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Passwords are not the same")
                        .check(value -> value.length() >= 6, "Password is too short (less than 6 symbols)")
                        .get();
                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.sessionAttribute("flash", "User has been created!");
                ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new EditUserPage(user.getName(), user.getEmail(), null);
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));

        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "The name cannot be shorter than 2 characters")
                    .get();
            var email = ctx.formParamAsClass("email", String.class)
                    .check(value -> value.contains("@"), "E-mail isn't looks like one")
                    .get();

            user.setName(name);
            user.setEmail(email);

            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email");
            var page = new EditUserPage(name, email, e.getErrors());
            ctx.render("users/edit.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}