package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.apache.commons.text.StringEscapeUtils;
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
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            UsersPage page = new UsersPage(users);
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
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
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
