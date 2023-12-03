@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    header = @`
        <form action="/courses" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Искать">
        </form>
    `,
    content = @`
        @for(var course: page.getCourses())
            <h2>${course.getName()}</h2>
            <p>${course.getDescription()}</p>
        @endfor
    `,
    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)
