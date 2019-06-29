<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>cart</title>
<link href="stylesCart.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<table>
<tr>
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
</td>
</tr>
</c:forEach>
</table>
<p>YOUR ORDER: ${orderCount} headphones</p>
<p>TOTAL SUM: ${totalSum}</p>

<p>COMPLETE THE FORM OF DELIVERY</p>
<form method="POST" action = "mainServlet">
<label>FIRST NAME</label><br>
<input name="firstName"  value ="${userOrder.firstName}"/><br><br>
<label>SECOND </label><br>
<input name="secondName" required value ="${userOrder.secondName}"/><br><br>
<label>COUNTRY</label><br>
<input name="country" required value ="${userOrder.country}"/><br><br>
<label>CITY</label><br>
<input name="city" required value ="${userOrder.city}"/><br><br>
<label>STREET, HOUSE NUMBER</label><br>
<input name="street" required value ="${userOrder.street}"/><br><br>
<label>POST INDEX</label><br>
<input name="postIndex" required value ="${userOrder.postIndex}"/><br><br>
<label>PHONE</label><br>
<input name="phone" required value ="${userOrder.phone}"/><br><br>
<input type = "hidden" name = "command" value = "buy"/>
<input type="submit" value="BUY">
</form>
</body>
</html>
