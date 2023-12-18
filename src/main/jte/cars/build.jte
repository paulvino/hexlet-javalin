@import org.example.hexlet.util.NamedRoutes

@template.layout.page(
    content = @`
        <form action="${NamedRoutes.carsPath()}" method="post">
            <div class="form-group">
                <label for="CourseName">Make</label>
                <input type="text" class="form-control" placeholder="Make" name="make" />
            </div>
            <div class="form-group">
                <label for="InputDescription">Model</label>
                <input type="text" class="form-control" placeholder="Model" required name="description" />
            </div>
            <div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Done!</button>
            </div>
        </form>
    `
)

