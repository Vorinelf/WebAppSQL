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
 <header>
  REGISTRATION NEW ADMIN
  </header>
<h3>PLEASE, ENTER INFORMATION</h3>
<form method="POST" action = "mainServlet">
<input type ="hidden" name="isAdmin" value = "true"/>
<label>LOGIN</label><br>
<input name="login" required pattern="[a-zA-Z0-9\(\)\[\]\-\_\@\.\,\?\!\:\$\s\;]+" maxlength = "30"/><br><br>
<label>PASSWORD</label><br>
<input name="password" required pattern="[a-zA-Z0-9\(\)\[\]\-\_\@\.\,\?\!\:\$\s\;]+" maxlength = "30"/><br><br>
<label>FIRST NAME</label><br>
<input name="firstName" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]" maxlength = "30"/><br><br>
<label>SECOND </label><br>
<input name="secondName" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
<input type = "hidden" name = "command" value = "add_admin"/>
<button type = "submit">REGISTRATION</button></form>
</form>
</div>
</body>
</html>