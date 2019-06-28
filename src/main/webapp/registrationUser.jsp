<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head><title>Registration</title></head>
<h3> Please, enter your information</h3>
<body>
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
<label>STREET</label><br>
<input name="street" required/><br><br>
<label>POST INDEX</label><br>
<input name="postIndex" required/><br><br>
<label>PHONE</label><br>
<input name="phone" required/><br><br>
<input type = "hidden" name = "command" value = "registration"/>
<input type="submit" value="Registration">
</form>
</body>
</html>