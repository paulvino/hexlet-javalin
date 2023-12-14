@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    content = @`
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
    `
)