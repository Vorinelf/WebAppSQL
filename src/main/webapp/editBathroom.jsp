<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit bathroomDevice</title>
</head>
<body>
<h3>Edit bathroomDevice</h3>
<form method="post">
<input type="hidden" value="${bathroomDevice.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${bathroomDevice.name}" /><br><br>
<label>PowerSizekW</label><br>
<input name="powerSizekW" value="${bathroomDevice.powerSizekW}" /><br><br>
<label>PowerON</label><br>
<input name="powerON" value="${bathroomDevice.powerON}" /><br><br>
<label>Waterproof</label><br>
<input name="waterproof" value="${bathroomDevice.waterproof}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>
