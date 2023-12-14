@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    content = @`
        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div class="form-group">
                <label for="InputName">Name</label>
                <input type="text" class="form-control" placeholder="Name" name="name" value="${page.getCourse().getName()}"/>
            </div>
            <div class="form-group">
                <label for="InputDescription">Description</label>
                <input type="text" class="form-control" placeholder="Description" required name="description" value="${page.getCourse().getDescription()}"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Done!</button>
            </div>
    </form>
    `
)