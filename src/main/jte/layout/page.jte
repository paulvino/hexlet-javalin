@import gg.jte.Content
@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.BasePage
@param Content content
@param BasePage page = null
@param Content header = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${NamedRoutes.mainPath()}">Main</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${NamedRoutes.usersPath()}">Users</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${NamedRoutes.coursesPath()}">Courses</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${NamedRoutes.carsPath()}">Cars</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <p>
            @if(page != null && page.getFlash() != null)
                <div class="alert alert-success" role="alert">
                ${page.getFlash()}
                </div>
            @endif
        </p>
        ${header}
        ${content}
        <div>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.buildUserPath()}">Add new user</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.buildCoursePath()}">Add new course</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.buildCarPath()}">Add new car</a>
                </li>
            </ul>
        </div>
        <a href="https://github.com/paulvino/hexlet-javalin" class="badge badge-info">Project on GitHub</a>
    </body>
</html>
