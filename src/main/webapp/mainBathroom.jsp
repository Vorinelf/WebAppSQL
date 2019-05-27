<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BathroomDevice</title>
</head>
<body>
<h2>BathroomDevices List</h2>
<form action = "index.jsp">
<input type="submit" value = "Come back to start page"/>
</form>
        <form action = "createBathroom.jsp">
         <input type="submit" value = "Create new bathroomDevice"/>
                </form>
<table>
<tr><th>Id</th><th> Name</th><th> PowerSizekW</th><th> PowerON</th><th> Waterproof</th></tr>
<c:forEach var="bd" items="${bathroomDeviceArray}">
 <tr><td>${bd.id}</td>
    <td>${bd.name}</td>
    <td>${bd.powerSizekW}</td>
    <td>${bd.powerON}</td>
    <td>${bd.waterproof}</td>
    <td>

    <form method = "POST" action = "mainServlet">
    <input type = "hidden" name = "id" value = "${bd.id}"/>
    <input type = "hidden" name = "command" value = "edit_read"/>
    <input type="submit" value = "Edit"/>
       </form>
        <form method = "POST" action = "mainServlet">
        <input type="hidden" name="id" value="${bd.id}">
        <input type = "hidden" name = "command" value = "delete"/>
      <input type="submit" value="Delete">
    </form>
 </td></tr>
 </c:forEach>
</table>
</body>
</html>