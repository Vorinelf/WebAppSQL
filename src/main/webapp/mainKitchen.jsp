<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KitchenDevice</title>
</head>
<body>
<h2>KitchenDevices List</h2>
<p><a href='<c:url value="/index.jsp" />'>Come back to start page</a></p>
<p><a href='<c:url value="/createKitchen" />'>Create new kitchenDevice</a></p>

<table>
<tr><th>Id</th><th> Name</th><th> PowerSizekW</th><th> PowerON</th><th> MinTemperature</th><th> MaxTemperature</th></tr>
<c:forEach var="kd" items="${kitchenDevicesArrayServ}">
 <tr><td>${kd.id}</td>
    <td>${kd.name}</td>
    <td>${kd.powerSizekW}</td>
    <td>${kd.powerON}</td>
    <td>${kd.minTemperature}</td>
    <td>${kd.maxTemperature}</td>
     <td>
    <a href='<c:url value="/editKitchen?id=${kd.id}"/>'>Edit</a>
    <form method="post" action='<c:url value="/deleteKitchen" />' style="display:inline;">
        <input type="hidden" name="id" value="${kd.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
 </c:forEach>
</table>
</body>
</html>