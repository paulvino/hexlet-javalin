@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    content = @`
        <h1>Courses List</h1>
        <form action="${NamedRoutes.coursesPath()}" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
        @for(var course : page.getCourses())
            <div>
                <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
            <p>${course.getDescription()}</p>
            </div>
        @endfor
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)
