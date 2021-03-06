<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <title>
            Headphones shop
        </title>
        <link href="stylesCart.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    </head>
    <body>
        <div id="wrapper">
            <header>
                YOUR ORDER
            </header>
            <div class="list">
                <table>
                    <tr>
                        <th>
                            BRAND
                        </th>
                        <th>
                            MODEL
                        </th>
                        <th>
                            PRICE
                        </th>
                        <th>
                            CONSTRUCTION
                        </th>
                        <th>
                            HI-RES
                        </th>
                        <th>
                            BLUETOOTH
                        </th>
                        <th>
                            RELEASE
                        </th>
                        <th>
                            IN STOCK
                        </th>
                    </tr>
                    <c:forEach var="hp" items="${cart}">
                        <tr>
                            <td>
                                ${hp.name}
                            </td>
                            <td>
                                ${hp.model}
                            </td>
                            <td>
                                ${hp.price}$
                            </td>
                            <td>
                                ${hp.construction}
                            </td>
                            <td>
                                ${hp.hiRes}
                            </td>
                            <td>
                                ${hp.bluetooth}
                            </td>
                            <td>
                                ${hp.release}
                            </td>
                            <td>
                                ${hp.stock}
                            </td>
                        </tr>
                    </c:forEach>
                </table
            </div>
            <p>________________________________________</p>
            <h3>
                COMPLETE THE FORM OF DELIVERY
            </h3>
            <form method="POST" action = "mainServlet">
                <label>
                    FIRST NAME
                </label><br>
                <input name="firstName" required value ="${userOrder.firstName}" pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]" maxlength = "30"/><br><br>
                <label>
                    SECOND
                </label><br>
                <input name="secondName" required value ="${userOrder.secondName}" pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
                <label>
                    COUNTRY
                </label><br>
                <input name="country" required value ="${userOrder.country}" pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
                <label>
                    CITY
                </label><br>
                <input name="city" required value ="${userOrder.city}" pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
                <label>
                    STREET, HOUSE NUMBER
                </label><br>
                <input name="street" required value ="${userOrder.street}"  pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,]+" maxlength = "30"/><br><br>
                <label>
                    POST INDEX
                </label><br>
                <input name="postIndex" required value ="${userOrder.postIndex}" pattern="[A-Za-zА-Яа-яЁё0-9\-\_\s\.\,\:\;]+" maxlength = "30"/><br><br>
                <label>
                    PHONE
                </label><br>
                <input name="phone" required value ="${userOrder.phone}" pattern="[0-9\+\-]+" maxlength = "20"/><br><br>
                <input type = "hidden" name = "command" value = "buy"/>
                <h3 align="left">TOTAL ORDER: ${orderCount} headphones</h3>
                <h3 align="left">TOTAL SUM: ${totalSum}$</h3>
                <button type = "submit">BUY</button>
            </form>
            <form method = "POST" action = "mainServlet">
                <input type = "hidden" name = "command" value = "find_all"/>
                <button type = "submit">CONTINUE SHOPPING</button>
            </form>
        </div>
    </body>
</html>
