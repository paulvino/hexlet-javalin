package org.example.hexlet.controller;

import java.util.Collections;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class UsersController {
    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var escapedId = StringEscapeUtils.escapeHtml4(String.valueOf(id));
        var user = UserRepository.find(Long.valueOf(escapedId))
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
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
                ctx.redirect("/users");
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();
        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Passwords are not the same")
                    .check(value -> value.length() >= 6, "Password is too short (less than 6 symbols)")
                    .get();
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}

//        app.get(NamedRoutes.buildUserPath(), ctx -> {
//            var page = new BuildUserPage();
//            ctx.render("users/build.jte", Collections.singletonMap("page", page));
//        });
//
//        app.post(NamedRoutes.usersPath(), ctx -> {
//            var name = ctx.formParam("name").trim();
//            var email = ctx.formParam("email").trim().toLowerCase();
//
//            try {
//                var passwordConfirmation = ctx.formParam("passwordConfirmation");
//                var password = ctx.formParamAsClass("password", String.class)
//                        .check(value -> value.equals(passwordConfirmation), "Passwords are not the same")
//                        .check(value -> value.length() >= 6, "Password is too short (less than 6 symbols)")
//                        .get();
//                var user = new User(name, email, password);
//                UserRepository.save(user);
//                ctx.redirect("/users");
//            } catch (ValidationException e) {
//                var page = new BuildUserPage(name, email, e.getErrors());
//                ctx.render("users/build.jte", Collections.singletonMap("page", page));
//            }
//        });
//
////        app.get(NamedRoutes.usersPath(), ctx -> {
////            var term = ctx.queryParam("term");
////            List<User> users;
////
////            if (term != null) {
////                users = UserRepository.search(term);
////            } else {
////                users = UserRepository.getEntities();
////            }
////
////            var page = new UsersPage(users, term);
////            ctx.render("users/index.jte", Collections.singletonMap("page", page));
////        });
//
//        app.get(NamedRoutes.userPath("{id}"), ctx -> {
//            var id = ctx.pathParam("id");
//            var escapedId = StringEscapeUtils.escapeHtml4(id);
//            PolicyFactory policy = new HtmlPolicyBuilder()
//                    .allowElements("a")
//                    .allowUrlProtocols("http")
//                    .allowAttributes("href").onElements("a")
//                    .requireRelNofollowOnLinks()
//                    .toFactory();
//            String safeHTML = policy.sanitize(escapedId);
//            ctx.contentType("text/html");
//            ctx.result(safeHTML);
//        });
//
//        app.get("/users/{id}/post/{postId}", ctx -> {
//            ctx.result("User ID: " + ctx.pathParam("id"));
//            ctx.result("Post ID: " + ctx.pathParam("postId"));
//        });
