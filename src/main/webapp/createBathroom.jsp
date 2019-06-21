<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create bathroomDevice</title>
</head>
<body>
<h3>New bathroomDevice</h3>
<form method="POST" action = "mainServlet">
<label>Name</label><br>
<input name="name" required/><br><br>
<label>PowerSizekW</label><br>
<input name="powerSizekW" required/><br><br>
<label>PowerON</label><br>
<input name="powerON" required/><br><br>
<label>Waterproof</label><br>
<input name="waterproof" required/><br><br>
<input type="hidden" name = "command" value = "create"/>
<input type="submit" value="Save">
</form>
</body>
</html>