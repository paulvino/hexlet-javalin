@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    page = page,
    content = @`
        <h1>Список курсов</h1>
        <form class="navbar-form" action="${NamedRoutes.coursesPath()}" method="get">
            <div class="form-group">
                <input class="form-control" type="search" name="term" placeholder="Для поиска введите название курса" value="${page.getTerm()}">
                <button type="submit" class="btn btn-default">Поиск</button>
            </div>
        </form>

        @if(page.getCourses().isEmpty())
            <p>Список курсов пока пуст</p>
            <p>По кнопке ниже можно это исправить!</p>
        @else
            @for(var course : page.getCourses())
                <div>
                    <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
    `
)
