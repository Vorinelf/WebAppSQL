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
<h3>PLEASE, ENTER YOUR INFORMATION</h3>
<body>
<div id="wrapper">
<form method="POST" action = "mainServlet">
<name="isAdmin" value = "false"/>
<label>LOGIN</label><br>
<input name="login" required/><br><br>
<label>PASSWORD</label><br>
<input name="password" required/><br><br>
<label>FIRST NAME</label><br>
<input name="firstName" required/><br><br>
<label>SECOND </label><br>
<input name="secondName" required/><br><br>
<label>COUNTRY</label><br>
<input name="country" required/><br><br>
<label>CITY</label><br>
<input name="city" required/><br><br>
<label>STREET, HOUSE NUMBER</label><br>
<input name="street" required/><br><br>
<label>POST INDEX</label><br>
<input name="postIndex" required/><br><br>
<label>PHONE</label><br>
<input name="phone" required/><br><br>
<input type = "hidden" name = "command" value = "registration"/>
<button type = "submit">REGISTRATION</button></form>
</form>
</div>
</body>
</html>