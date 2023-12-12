@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.util.NamedRoutes
@param UserPage page

@template.layout.page(
    content = @`
        <h2>${page.getUser().getName()}</h2>
        <p>${page.getUser().getEmail()}</p>
        <div>
            <a href="${NamedRoutes.editUserPath(page.getUser().getId())}">Edit user</a>
        </div>
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)