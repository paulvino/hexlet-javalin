@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h2>${page.getUser().getName()}</h2>
        <p>${page.getUser().getEmail()}</p>
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)