@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.util.NamedRoutes
@param UserPage page

@template.layout.page(
    content = @`
        <h2>${page.getUser().getName()}</h2>
        <p>${page.getUser().getEmail()}</p>
        <div>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.editUserPath(page.getUser().getId())}">Edit user</a>
                </li>
            </ul>
        </div>
    `
)