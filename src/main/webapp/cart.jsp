<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>BathroomDevice</title>
<html>
</head>
<body>
<h2>Your cart</h2>
 <form method = "POST" action = "mainServlet">
  <input type = "hidden" name = "command" value = "find_all"/>
<input type="submit" value = "Back to main page"/>
</form>
<table>
<tr><th>Id</th><th> Name</th><th> PowerSizekW</th><th> PowerON</th><th> Waterproof</th></tr>
<c:forEach var="bd" items="${cart}">
 <tr><td>${bd.id}</td>
    <td>${bd.name}</td>
    <td>${bd.powerSizekW}</td>
    <td>${bd.powerON}</td>
    <td>${bd.waterproof}</td>
    <td>
<form method = "POST" action = "mainServlet">
<input type = "hidden" name = "id" value = "${bd.id}"/>
<input type = "hidden" name = "command" value = "delete_from_cart"/>
<input type="submit" value = "delete"/>
</form>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>