<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
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
  LIST OF USERS
  </header>
  <table>
                <tr>
                    <th>IS ADMIN</th>
                    <th>LOGIN</th>
                    <th>PASSWORD</th>
                    <th>FIRST NAME</th>
                    <th>SECOND NAME</th>
                    <th>COUNTRY</th>
                    <th>CITY</th>
                    <th>STREET, HOUSE</th>
                    <th>POST INDEX</th>
                    <th>PHONE</th>
                </tr>
                <c:forEach var="user" items="${usersArray}">
                    <tr>
                        <td>${user.isAdmin}</td>
                        <td>${user.login}</td>
                        <td>${user.password}$</td>
                        <td>${user.firstName}</td>
                        <td>${user.secondName}</td>
                        <td>${user.country}</td>
                        <td>${user.city}</td>
                        <td>${user.street}</td>
                        <td>${user.phone}</td>
                        <td>
                            <form method = "POST" action = "mainServlet">
                                <input type = "hidden" name = "id" value = "${user.id}"/>
                                <input type = "hidden" name = "command" value = "delete_user"/>
                                <button type = "submit">DELETE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            form method = "POST" action = "mainServlet">
                                           <input type = "hidden" name = "command" value = "find_all"/>
                                            <button type = "submit">BACK</button>
                                        </form>
            </div>
            </body>
            </html>