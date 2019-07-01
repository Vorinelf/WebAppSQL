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
<input input type="hidden" name="id" required/>
<label>BRAND</label><br>
<input name="name" required/><br><br>
<label>MODEL</label><br>
<input name="model" required/><br><br>
<label>PRICE</label><br>
<input name="price" required/><br><br>
<label>CONSTRUCTION</label><br>
<input name="construction" required/><br><br>
<label>HI-RES</label><br>
<input name="hiRes" required/><br><br>
<label>BLUETOOTH</label><br>
<input name="bluetooth" required/><br><br>
<label>RELEASE</label><br>
<input name="release" required/><br><br>
<label>STOCK</label><br>
<input name="stock"required/><br><br>
<input type="hidden" name = "command" value = "create"/>
<button type = "submit">SAVE</button>
</form>
</div>
</body>
</html>