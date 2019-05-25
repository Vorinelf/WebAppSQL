<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BathroomDevice</title>
</head>
<body>
<h2>BathroomDevices List</h2>
<p><a href='<c:url value="/index.jsp"/>'>Come back to start page</a></p>
<p><a href='<c:url value="/createBathroom.jsp"/>'>Create new bathroomDevice</a></p>
<table>
<tr><th>Id</th><th> Name</th><th> PowerSizekW</th><th> PowerON</th><th> Waterproof</th></tr>
<c:forEach var="bd" items="${bathroomDeviceArray}">
 <tr><td>${bd.id}</td>
    <td>${bd.name}</td>
    <td>${bd.powerSizekW}</td>
    <td>${bd.powerON}</td>
    <td>${bd.waterproof}</td>
    <td>
    <a href='<c:url value="/editBathroom?id=${bd.id}"/>'>Edit</a>
    <form method="post" action='<c:url value="/deleteBathroom" />' style="display:inline;">
        <input type="hidden" name="id" value="${bd.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
 </c:forEach>
</table>
</body>
</html>