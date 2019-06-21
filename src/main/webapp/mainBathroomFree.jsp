<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BathroomDevice</title>
<link href="styles.css" rel="stylesheet" type="text/css" />

</head>
<body>
<body>
<div id="container">
	<div id="header">
	<h2>HEADPHONES SHOP (Headphones shop)</h2>
<form action = "index.jsp">
    <input type="submit" value = "Back to start page"/>
    </form>
    <form action = "cart.jsp">
    <input type="submit" value = "My cart ${sizeOfCart}"/>
    </form>
	</div>

	<div id="navigation">
	<h2>Sort</h2>

	</div>

	<div id="sidebar">
	<h2>Choice</h2>
	</div>

	<div id="content">
	<h2>List of headphones</h2>
	</div>

	<div id="clear">


	</div>

	<div id="footer">
	<h2>Background</h2>
	</div>
</div>
</body>
<h2>BathroomDevices List</h2>

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
        <input type = "hidden" name = "command" value = "in_cart"/>
        <input type="submit" value = "in cart"/>
           </form>
           </td>
</tr>
 </c:forEach>
</table>
</body>
</html>