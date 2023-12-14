@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    page = page,

    header = @`
        <h1>Users List</h1>
    `,

    content = @`
        @for(var user : page.getUsers())
            <h2>${user.getName()}</h2>
            <p>${user.getEmail()}</p>
        @endfor
    `
)