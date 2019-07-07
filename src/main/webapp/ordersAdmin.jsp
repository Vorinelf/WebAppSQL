<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <title>
            Headphones shop
        </title>
        <link href="stylesOrdersAdmin.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    </head>
    <body>
        <div id="wrapper">
            <header>
                LIST OF ORDERS
            </header>
            <table>
                <tr>
                    <th>DATE</th>
                    <th>FIRST NAME</th>
                    <th>SECOND NAME</th>
                    <th>BRAND</th>
                    <th>MODEL</th>
                    <th>PRICE</th>
                    <th>COUNTRY</th>
                    <th>CITY</th>
                    <th>STREET,HOUSE</th>
                    <th>POST INDEX</th>
                    <th>PHONE</th>
                </tr>
                <c:forEach var="order" items="${ordersArray}">
                    <tr>
                        <td>${order.dateOrder}</td>
                        <td>${order.firstName}</td>
                        <td>${order.secondName}</td>
                        <td>${order.brand}</td>
                        <td>${order.model}</td>
                        <td>${order.price}$</td>
                        <td>${order.country}</td>
                        <td>${order.city}</td>
                        <td>${order.street}</td>
                        <td>${order.postIndex}</td>
                        <td>${order.phone}</td>
                        <td>
                            <form method = "POST" action = "mainServlet">
                                <input type="hidden" name="id" value="${order.id}">
                                <input type = "hidden" name = "command" value = "delete_order"/>
                                <button type = "submit">DELETE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                    <form method = "POST" action = "mainServlet">
                        <input type = "hidden" name = "command" value = "delete_all_orders"/>
                        <button type = "submit">DELETE ALL</button>
                    </form>
            </table>
            <form method = "POST" action = "mainServlet">
                <input type = "hidden" name = "command" value = "find_all"/>
                <button type = "submit">BACK</button>
            </form>
        </div>
    </body>
</html>