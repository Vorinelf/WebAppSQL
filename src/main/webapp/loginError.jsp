<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <title>
            Headphones shop
        </title>
        <link href="stylesCart.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    </head>
    <body>
        <div id="wrapper">
            <header>
                LOGIN ERROR
            </header>
            <h3>
                ERROR LOGIN OR PASSWORD
            </h3>
            <form method = "POST" action = "mainServlet">
                <input type = "hidden" name = "command" value = "find_all"/>
                <button type = "submit">OK</button>
            </form>
        </div>
    </body>
</html>