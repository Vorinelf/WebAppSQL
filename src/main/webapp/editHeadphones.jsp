<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Headphones shop</title>
    <link href="stylesCart.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<div id="wrapper">
<h3>EDIT HEADPHONES</h3>
<form method="POST" action = "mainServlet">
<input type="hidden" name="id" value="${headphones.id}" required/>
<label>BRAND</label><br>
<input name="name" value="${headphones.name}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>MODEL</label><br>
<input name="model" value="${headphones.model}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>PRICE</label><br>
<input name="price" value="${headphones.price}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>CONSTRUCTION</label><br>
<input name="construction" value="${headphones.construction}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>HI-RES</label><br>
<input name="hiRes" value="${headphones.hiRes}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>BLUETOOTH</label><br>
<input name="bluetooth" value="${headphones.bluetooth}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>RELEASE</label><br>
<input name="release" value="${headphones.release}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<label>STOCK</label><br>
<input name="stock" value="${headphones.stock}" required pattern="[a-zA-Z0-9]+" maxlength = "30"/><br><br>
<input type="hidden" name = "command" value = "edit_write"/>
<button type = "submit">UPDATE</button>
</form>
</div>
</body>
</html>
