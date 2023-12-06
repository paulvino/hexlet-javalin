package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.owasp.html.HtmlPolicyBuilder;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.Data;
import org.example.hexlet.model.Course;
import org.owasp.html.PolicyFactory;

import java.util.ArrayList;
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

        app.get("/", ctx -> ctx.render("greeting.jte"));

        app.get("/users/build", ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/users", ctx -> {
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
        });

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;

            if (term != null) {
                users = UserRepository.search(term);
            } else {
                users = UserRepository.getEntities();
            }

            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("http")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(escapedId);
            ctx.contentType("text/html");
            ctx.result(safeHTML);
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });

        app.get("/courses/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            try {
                var courseName = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Name of course is too short (less than 3 symbols)")
                        .get();
                var courseDescription = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() >= 10, "Description is too short (less than 10 symbols)")
                        .get();
                var course = new Course(courseName, courseDescription);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courses;

            if (term != null) {
                courses = CourseRepository.search(term);
            } else {
                courses = CourseRepository.getEntities();
            }

            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");

            var courseMap = Data.getCourse(Long.parseLong(id));
            if (courseMap == null) {
                throw new NotFoundResponse("Course not found");
            }

            var course = new Course(courseMap);
            var page = new CoursePage(course);

            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });

        app.start(7070);
    }
}
