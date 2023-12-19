package org.example.hexlet.controller;

import java.sql.SQLException;
import java.util.Collections;

import org.example.hexlet.dto.cars.CarPage;
import org.example.hexlet.dto.cars.CarsPage;
import org.example.hexlet.model.Car;
import org.example.hexlet.repository.CarRepository;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.util.NamedRoutes;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class CarsController {

    public static void index(Context ctx) throws SQLException {
        var cars = CarRepository.getEntities();
        var term = ctx.queryParam("term");
        cars = term != null ? CarRepository.search(term) : CarRepository.getEntities();

        var page = new CarsPage(cars, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("cars/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var car = CarRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Car with id = " + id + " not found"));
        var page = new CarPage(car);
        ctx.render("cars/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("cars/build.jte");
    }

    public static void create(Context ctx) throws SQLException {
        var make = ctx.formParam("make");
        var model = ctx.formParam("model");

        var car = new Car(make, model);
        CarRepository.save(car);
        ctx.redirect(NamedRoutes.carsPath());
    }
}
