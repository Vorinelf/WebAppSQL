<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Headphones shop</title>
<link href="stylesCart.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css"/>
</head>
<body>
<div id="wrapper">
<h3> SUCCESSFUL REGISTRATION!</h3>
<h3> Welcome, ${user.firstName} ${user.secondName} </h3>
   <form method = "POST" action = "mainServlet">
    <input type = "hidden" name = "command" value = "find_all"/>
    <button type = "submit">GO TO SITE</button>
                    </form>
</form>
</div>
</body>
</html>