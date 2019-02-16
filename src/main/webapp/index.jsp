<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h2>Products List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
<tr><th>Name</th><th> PowerSizekW</th><th> PowerON</th><th> MinTemperature</th><th>MaxTemperature</th></tr>
<c:forEach var="kd" items="${kitchenDevicesArrayServ}">
 <tr><td>${kd.name}</td>
    <td>${kd.powerSizekW}</td>
    <td>${kd.powerON}</td>
    <td>${kd.minTemperature}</td>
    <td>${kd.maxTemperature}</td>

            <c:out value="${kd}"/>

    </c:forEach>
    <c:forEach var="i" begin="1" end="5">
        Item <c:out value="${i}"/><p>

    </c:forEach>
    <td>
    <a href='<c:url value="/edit?id=${kd.name}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${kd.name}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
<c:out value="${12+56*2}" />
<c:out value="${kitchenDevicesArrayServ}" />
</table>
</body>
</html>