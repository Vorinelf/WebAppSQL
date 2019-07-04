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
 <header>
ADD HEADPHONES
  </header>
<form method="POST" action = "mainServlet">
<input input type="hidden" name="id" required pattern="^[0-9]+$" maxlength = "30"/>
<label>BRAND</label><br>
<input name="name" required pattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<label>MODEL</label><br>
<input name="model" required pattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<label>PRICE</label><br>
<input name="price" required pattern="^[0-9]+$" maxlength = "9"/><br><br>
<label>CONSTRUCTION</label><br>
<input name="construction" required pattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<label>HI-RES</label><br>
<input name="hiRes" requiredpattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<label>BLUETOOTH</label><br>
<input name="bluetooth" required pattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<label>RELEASE</label><br>
<input name="release" required pattern="^[0-9]+$" maxlength = "30"/><br><br>
<label>STOCK</label><br>
<input name="stock"required pattern="[a-zA-Z0-9\-\_\#\:\s]+" maxlength = "30"/><br><br>
<input type="hidden" name = "command" value = "create"/>
<button type = "submit">SAVE</button>
</form>
 <form method = "POST" action = "mainServlet">
  <input type = "hidden" name = "command" value = "find_all"/>
        <button type = "submit">BACK</button>
</div>
</body>
</html>