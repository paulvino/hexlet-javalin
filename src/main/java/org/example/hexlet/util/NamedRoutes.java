package org.example.hexlet.util;

public class NamedRoutes {

    public static String mainPath() {
        return "/";
    }

    public static String sessionPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return sessionPath() + "/build";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String buildUserPath() {
        return usersPath() + "/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return usersPath() + "/" + id;
    }

    public static String editUserPath(Long id) {
        return editUserPath(String.valueOf(id));
    }

    public static String editUserPath(String id) {
        return usersPath() + "/" + id + "/edit";
    }

    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return coursesPath() + "/build";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return coursesPath() + "/" + id;
    }
}
