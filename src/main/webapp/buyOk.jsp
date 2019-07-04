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
 <header>
  SUCCESSFULL ORDER
  </header>
<h3>YOUR ORDER IS SUCCESSFULLY COMPLETED</h3>
<h3>THANKS FOR YOUR BUY</h3>
<form action="mainServlet" method "POST">
    <input type="hidden" name="command" value="find_all"/>
    <button type = "submit">OK</button>
</form>
</div>
</body>
</html>
