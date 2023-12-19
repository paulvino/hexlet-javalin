@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.cars.CarsPage
@param CarsPage page

@template.layout.page(
    page = page,
    content = @`
        <h1>Список машин</h1>
        <form class="navbar-form" action="${NamedRoutes.carsPath()}" method="get">
            <div class="form-group">
                <input class="form-control" type="search" name="term" placeholder="Для поиска введите название машины" value="${page.getTerm()}">
                <button type="submit" class="btn btn-default">Поиск</button>
            </div>
        </form>

        @if(page.getCars().isEmpty())
            <p>Список машин пока пуст</p>
            <p>По кнопке ниже можно это исправить!</p>
        @else
            @for(var car : page.getCars())
               <div>
                   <h2>
                       <a href="${NamedRoutes.carPath(car.getId())}">${car.getName()}</a>
                   </h2>
               </div>
            @endfor
        @endif
    `
)

