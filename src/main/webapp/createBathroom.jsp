<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create bathroomDevice</title>
</head>
<body>
<h3>New bathroomDevice</h3>
<form method="post">
<label>Id</label><br>
<input name="id"/><br><br>
<label>Name</label><br>
<input name="name"/><br><br>
<label>PowerSizekW</label><br>
<input name="powerSizekW"/><br><br>
<label>PowerON</label><br>
<input name="powerON"/><br><br>
<label>Waterproof</label><br>
<input name="waterproof"/><br><br>


action='<c:url value="/mainServlet" />' style="display:inline;">
        <input type="hidden" name="command" value="create">
        <input type="submit" value="Save">
</form>
</body>
</html>