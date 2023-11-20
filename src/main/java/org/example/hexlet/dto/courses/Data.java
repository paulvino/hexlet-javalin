package org.example.hexlet.dto.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.Random;
import java.util.Locale;
import com.github.javafaker.Faker;
import org.example.hexlet.model.Course;

public class Data {
    private static final List<Map<String, Object>> COURSES = new ArrayList<>();

    public static void addCourse(Long id, String name, String description) {
        Map<String, Object> newCourse = Map.of(
                "id", id,
                "name", name,
                "description", description
        );

        COURSES.add(newCourse);
    }

    public static void generateData() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        for (var i = 1; i <= 10; i++) {
            long id = i;
            String name = faker.job().position();
            String description = faker.backToTheFuture().quote();

            addCourse(id, name, description);
        }
    }

    public static List<Map<String, Object>> getData() {
        generateData();
        return new ArrayList<>(COURSES);
    }

    public static Map<String, Object> getCourse(long id) {
        return COURSES.stream()
                .filter(course -> course.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Course> getCoursesList(List<Map<String, Object>> courses) {
        List<Course> coursesList = new ArrayList<>();

        for (var courseMap: courses) {
            var course = new Course(courseMap);
            coursesList.add(course);
        }

        return coursesList;
    }
}
