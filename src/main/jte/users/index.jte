@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    header = @`
        <h1>Users</h1>
        <form action="${NamedRoutes.usersPath()}" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
    `,

    content = @`
        @for(var user : page.getUsers())
            <h2>${user.getName()}</h2>
            <p>${user.getEmail()}</p>
        @endfor
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)