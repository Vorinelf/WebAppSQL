<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head><title>Registration</title></head>
<h3> Please, enter your information</h3>
<body>
<form method="POST" action = "mainServlet">
<label>First name</label><br>
<input name="firstName" required/><br><br>
<label>Second Name</label><br>
<input name="secondName" required/><br><br>
<label>Login</label><br>
<input name="login" required/><br><br>
<label>Password</label><br>
<input name="password" required/><br><br>
<name="isAdmin" value = "false"/>
<input type = "hidden" name = "command" value = "registration"/>
<input type="submit" value="Registration">
</form>
</body>
</html>