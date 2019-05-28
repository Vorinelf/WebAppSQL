<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head><title>RegistrationOk</title></head>
<body>
<h3> Successful registration, Congratulations!!!</h3>
<h3> Welcome, ${user.firstName} ${user.secondName} </h3>
<form action = "index2.jsp">
<input type="submit" value = "Go to site"/>
</form>
</body>
</html>