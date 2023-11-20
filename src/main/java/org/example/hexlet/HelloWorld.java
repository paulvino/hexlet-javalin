package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.Data;
import org.example.hexlet.model.Course;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HelloWorld {

    private static final List<Map<String, Object>> DATA = Data.getData();

    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });



        app.get("/users", ctx -> {
            ctx.result("GET /users");
        });

        app.post("/users", ctx -> {
            ctx.result("POST /users");
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            var msg = (name != null) ? "Hello, " + name + "!" : "Hello, World!";
//            ctx.result(msg); // обычный вывод, без форматирования
            ctx.contentType("text/html"); // вывод с форматированием в html
            ctx.result("<h1>" + msg + "</h1>");
        });

        app.get("/", ctx -> ctx.render("index.jte"));

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

        app.get("/courses", ctx -> {
            var coursesPage = new CoursesPage(Data.getCoursesList(DATA));
            ctx.render("courses/index.jte", Collections.singletonMap("page", coursesPage));
        });

        app.start(7070);
    }
}
