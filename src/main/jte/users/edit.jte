@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.EditUserPage
@param EditUserPage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <div class="mb-3">
                <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif

        <form action="${NamedRoutes.usersPath()}" method="post">
            <div>
                <label>
                    <h3>
                        Edit User
                    </h3>
                </label>
            </div>
            <div>
                <label>
                    Name
                    <input type="text" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div>
                <label>
                    E-mail
                    <input type="email" required name="email" value="${page.getEmail()}" />
                </label>
            </div>
            <div>
                <label>
                    Password
                    <input type="password" required name="password" />
                </label>
            </div>
            <div>
                <label>
                    Password confirmation
                    <input type="password" required name="passwordConfirmation" />
                </label>
            </div>
        <input type="submit" value="Save" />
    </form>
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)