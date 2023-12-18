@import org.example.hexlet.dto.cars.CarPage
@param CarPage page

@template.layout.page(
    page = page,
    content = @`
        <h1>${page.getCar().getName()}</h1>
    `
)

