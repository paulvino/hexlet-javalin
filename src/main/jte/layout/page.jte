@import gg.jte.Content
@import org.example.hexlet.util.NamedRoutes
@param Content content
@param Content footer = null
@param Content header = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <p>
        <h1><a href="${NamedRoutes.mainPath()}">Main</a> <a href="${NamedRoutes.usersPath()}">Users</a> <a href="${NamedRoutes.coursesPath()}">Courses</a> </h1>
        </p>
        ${header}
        ${content}
        ${footer}
        <p>
        <a href="${NamedRoutes.buildUserPath()}">New user</a>
        </p>
    </body>
</html>
