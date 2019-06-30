<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Headphones shop</title>
<link href="stylesCart.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css"/>
</head>
<body>
<div id="wrapper">
    <header>
 YOUR CART
    </header>
    <header1>

    </header1>
    <main>
  <table>
 <th>BRAND</th><th>MODEL</th><th>PRICE</th><th>CONSTRUCTION</th><th>HI-RES</th><th>BLUETOOTH</th><th>RELEASE</th><th>IN STOCK</th></tr>
<c:forEach var="hp" items="${cart}">
 <tr>
                <td>${hp.name}</td>
                <td>${hp.model}</td>
                <td>${hp.price}$</td>
                <td>${hp.construction}</td>
                <td>${hp.hiRes}</td>
                <td>${hp.bluetooth}</td>
                <td>${hp.release}</td>
                <td>${hp.stock}</td>
                <td>
<form method = "POST" action = "mainServlet">
<input type = "hidden" name = "id" value = "${hp.id}"/>
<input type = "hidden" name = "command" value = "delete_from_cart"/>
   <button type = "submit">DELETE</button>
</form>
</td>
</tr>
</c:forEach>
</table>

 <form method = "POST" action = "mainServlet">
  <input type = "hidden" name = "command" value = "find_all"/>
        <button type = "submit">CONTINUE SHOPPING</button>
</form>
 <form method = "POST" action = "mainServlet">
  <input type = "hidden" name = "command" value = "order"/>
        <button type = "submit">ORDER</button>
</form>
</div>
</body>
</html>