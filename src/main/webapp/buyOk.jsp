<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>cart</title>
<link href="stylesCart.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<div id="wrapper">
<p>YOUR ORDER IS SUCCESSFULLY COMPLETED</p>
<p>THANK FOR YOUR BUY</p>
<form action="mainServlet" method "POST">
    <input type="hidden" name="command" value="buy_ok"/>
    <button type = "submit">OK</button>
</form>
</div>
</body>
</html>
