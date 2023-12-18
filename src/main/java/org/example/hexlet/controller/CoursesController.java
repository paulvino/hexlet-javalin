package org.example.hexlet.controller;

import java.sql.SQLException;
import java.util.Collections;

import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class CoursesController {
    public static void index(Context ctx) throws SQLException {
        var courses = CourseRepository.getEntities();
        var term = ctx.queryParam("term");
        courses = term != null ? CourseRepository.search(term) : CourseRepository.getEntities();

        var page = new CoursesPage(courses, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("courses/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class). get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) throws SQLException {
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
            ctx.sessionAttribute("flash", "Course has been created!");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name").trim();
        var description = ctx.formParam("description").trim();

        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        course.setName(name);
        course.setDescription(description);
        CourseRepository.save(course);
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
