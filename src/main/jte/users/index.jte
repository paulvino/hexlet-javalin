@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.util.NamedRoutes
@param UsersPage page

@template.layout.page(
    page = page,

    header = @`
        <h1>Список пользователей</h1>
        <form class="navbar-form" action="${NamedRoutes.usersPath()}" method="get">
            <div class="form-group">
                <input class="form-control" type="search" name="term" placeholder="Для поиска введите имя пользователя" value="${page.getTerm()}">
                <button type="submit" class="btn btn-default">Поиск</button>
            </div>
        </form>
    `,

    content = @`
        @if (page.getUsers().isEmpty())
            <p>Список пользователей пока пуст</p>
            <p>По кнопке ниже можно это исправить!</p>
        @else
            @for(var user : page.getUsers())
                <h2>${user.getName()}</h2>
                <p>${user.getEmail()}</p>
            @endfor
        @endif
    `
)