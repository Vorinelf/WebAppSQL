<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create kitchenDevice</title>
</head>
<body>
<h3>New kitchenDevice</h3>
<form method="post">
<label>Id</label><br>
<input name="id"/><br><br>
<label>Name</label><br>
<input name="name"/><br><br>
<label>PowerSizekW</label><br>
<input name="powerSizekW"/><br><br>
<label>PowerON</label><br>
<input name="powerON"/><br><br>
<label>MaxTemperature</label><br>
<input name="minTemperature"/><br><br>
<label>MinTemperature</label><br>
<input name="maxTemperature"/><br><br>
<input type="submit" value="Save" />
</form>
</body>
</html>