@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    content = @`
        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div>
                <label>
                    Name
                    <input type="text" name="name" value="${page.getCourse().getName()}"/>
                </label>
            </div>
            <div>
                <label>
                    Description
                    <input type="text" required name="description" value="${page.getCourse().getDescription()}"/>
                </label>
            </div>
            <input type="submit" value="Done!" />
    </form>
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)