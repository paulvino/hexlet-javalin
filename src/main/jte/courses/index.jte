@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<html lang="en">
    <head>
        <title>Хекслет</title>
    </head>
    <body>
        <main>
            @for(var course: page.getCourses())
                <h1>${course.getName()}</h1>
                <p>${course.getDescription()}</p>
            @endfor
        </main>
    </body>
</html>