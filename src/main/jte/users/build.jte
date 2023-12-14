@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

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

        <form action="${NamedRoutes.usersPath()}" method="post">
            <div class="form-group">
                <label for="InputName">Name</label>
                <input type="text" class="form-control" placeholder="Name" name="name" value="${page.getName()}" />
            </div>
            <div class="form-group">
                <label for="Email">E-mail</label>
                <input type="email" class="form-control" placeholder="Email" required name="email" value="${page.getEmail()}" />
            </div>
            <div class="form-group">
                <label for="Password">Password</label>
                <input type="password" class="form-control" placeholder="Password" required name="password" />
            </div>
            <div class="form-group">
                <label for="PasswordConfirmation">Password confirmation</label>
                <input type="password" class="form-control" placeholder="PasswordConfirmation" required name="passwordConfirmation" />
            </div>
            <div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Done!</button>
            </div>
        </form>
    `
)