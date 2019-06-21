<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head><title>Login</title></head>
<body>
<h3>Please, enter your login and password </h3>
<form method="POST" action = "mainServlet">
<label>Login</label><br>
<input name="login" required/><br><br>
<label>Password</label><br>
<input name="password" required/><br><br>
<input type = "hidden" name = "command" value = "login"/>
<input type="submit" value="Log in">
</form>
<form action = "registrationUser.jsp">
<input type="submit" value = "Registration"/>
</form>
</body>
</html>
