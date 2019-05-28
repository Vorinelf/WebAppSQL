<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devices</title>
</head>
<body>
<h2>Select Devices List</h2>

<form method = "POST" action = "mainServlet">
    <input type = "hidden" name = "command" value = "find_all"/>
    <input type="submit" value = "Select all bathroom devices"/>
        <input type = "hidden" name = "command" value = "no value"/>
        <input type="submit" value = "Select all kitchen device"/>
        </form>

</body>
</html>