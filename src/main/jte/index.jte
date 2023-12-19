@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        <main>
            <h1>Привет, Путник!</h1>
            <p>Я рад приветствовать тебя на странице своего учебного проекта</p>
            <p>Не будь слишком строг к автору этого скромного сайта, ведь все когда-то чему-то только учились :)</p>
            @if(page.getCurrentUser() != null)
                Добро пожаловать, ${page.getCurrentUser()}.
                Чтобы разлогиниться, удалите куку JSESSIONID из браузера.
            @endif
        </main>
    `
)