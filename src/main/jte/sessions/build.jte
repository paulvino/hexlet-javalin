@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    content = @`
<%--        <form action="${NamedRoutes.sessionPath()}" method="post">--%>
<%--            <input type="text" placeholder="Nickname" name="nickname">--%>
<%--            <input type="password" placeholder="Password" name="password">--%>
<%--            <input type="submit" />--%>
<%--        </form>--%>
        <div>
            <label>
                Your name
                <input type="text" name="name" placeholder="Name" required value="${page.getName()}" />
            </label>
        </div>
        <div>
            <label>
                Your e-mail
                <input type="email" required name="email" placeholder="E-mail" value="${page.getEmail()}" />
            </label>
        </div>
        <div>
            <label>
                Password
                <input type="password" required name="password" placeholder="password" />
            </label>
        </div>
    <input type="submit" value="Done" />
    `,

    footer = @`
        <a href="https://github.com/paulvino/hexlet-javalin">Project on GitHub</a>
    `
)