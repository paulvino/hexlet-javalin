@import gg.jte.Content
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <p>
            <h1><a href="/">Main</a> <a href="/courses">Courses</a></h1>
        </p>
        ${footer}
        ${content}
    </body>
</html>