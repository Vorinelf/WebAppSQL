<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
<head>
<title>Welcome<title/>
</head>
<body>
<h3>Welcome</h3>
<hr/>
${user}, hello!
<hr/>
<a href = "mainServlet?command = Logout"> Logout</a>
</body></html>