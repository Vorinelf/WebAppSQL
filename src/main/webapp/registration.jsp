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
  REGISTRATION
  </header>
<h3>PLEASE, ENTER YOUR INFORMATION</h3>
<form method="POST" action = "mainServlet">
<name="isAdmin" value = "false"/>
<label>LOGIN</label><br>
<input name="login" required pattern="[a-zA-Z0-9\(\)\[\]\-\_\@\.\,\?\!\:\$\s\;]+" maxlength = "30"/><br><br>
<label>PASSWORD</label><br>
<input name="password" required pattern="[a-zA-Z0-9\(\)\[\]\-\_\@\.\,\?\!\:\$\s\;]+" maxlength = "30"/><br><br>
<label>FIRST NAME</label><br>
<input name="firstName" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]" maxlength = "30"/><br><br>
<label>SECOND </label><br>
<input name="secondName" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
<label>COUNTRY</label><br>
<input name="country" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
<label>CITY</label><br>
<input name="city" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
<label>STREET, HOUSE NUMBER</label><br>
<input name="street" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
<label>POST INDEX</label><br>
<input name="postIndex" required pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,\:\;]+" maxlength = "30"/><br><br>
<label>PHONE</label><br>
<input name="phone" pattern="[^[ 0-9]+$\-\+]+" maxlength = "30"/><br><br>
<input type = "hidden" name = "command" value = "registration"/>
<button type = "submit">REGISTRATION</button></form>
</form>
</div>
</body>
</html>