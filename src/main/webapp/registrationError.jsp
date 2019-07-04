<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Headphones shop</title>
    <link href="stylesCart.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<div id="wrapper">
<header>
REGISTRATION ERROR
</header>
<h3> User with this login and password already exists </h3>
<form method = "POST" action = "mainServlet">
  <input type = "hidden" name = "command" value = "find_all"/>
        <button type = "submit">OK</button>
        </form>
<form action = "registration.jsp">
<button type = "submit">TO REGISTER AGAIN</button>
</form>
</div>
</body>
</html>