@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <div class="alert alert-danger" role="alert">
                            ${error.getMessage()}
                        </div>
                    @endfor
                @endfor
            </ul>
        @endif

        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div class="form-group">
                <label for="CourseName">Course name</label>
                <input type="text" class="form-control" placeholder="Course Name" name="name" value="${page.getName()}" />
            </div>
            <div class="form-group">
                <label for="InputDescription">Description</label>
                <input type="text" class="form-control" placeholder="Description" required name="description" value="${page.getDescription()}" />
            </div>
            <div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Done!</button>
            </div>
        </form>
    `
)