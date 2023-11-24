@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    content = @`
        @for(var course: page.getCourses())
            <h2>${course.getName()}</h2>
            <p>${course.getDescription()}</p>
        @endfor
    `
)
