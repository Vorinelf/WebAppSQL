<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit kitchenDevice</title>
</head>
<body>
<h3>Edit kitchenDevice</h3>
<form method="post">
<input type="hidden" value="${kitchenDevice.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${kitchenDevice.name}" /><br><br>
<label>PowerSizekW</label><br>
<input name="powerSizekW" value="${kitchenDevice.powerSizekW}" /><br><br>
<label>PowerON</label><br>
<input name="powerON" value="${kitchenDevice.powerON}" /><br><br>
<label>MinTemperature</label><br>
<input name="minTemperature" value="${kitchenDevice.minTemperature}" /><br><br>
<label>MaxTemperature</label><br>
<input name="maxTemperature" value="${kitchenDevice.maxTemperature}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>
