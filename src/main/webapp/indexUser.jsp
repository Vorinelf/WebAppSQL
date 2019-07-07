<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>
        Headphones shop
    </title>
    <link href="styles.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css"/>
</head>
<body>
    <div id="wrapper">
		<header3>
		    <h4>${role}: ${user.firstName} ${user.secondName}</h4>
		    <form name="login" action="mainServlet" method="POST">
           	    <input type = "hidden" name = "command" value = "logout"/>
           		<button type = "submit">LOGOUT</button>
            </form>
	   </header3>
	   <header2>
       		<ul class ="header-menu">
       		    <li>
       		        <form method = "POST" action = "mainServlet">
       		            <input type = "hidden" name = "command" value = "check_cart"/>
                        <button type = "submit">MY CART ${sizeOfCart}</button>
                    </form>
                </li>
             </ul>
       </header2>
       <header1>HEADPHONES SHOP</header1>
       <nav>
		    <ul class="top-menu">
        		<li>
        		    <form name ="topMenu" action="mainServlet" method "POST">
        		        <input type="hidden" name="column" value="price"/>
        		        <input type="hidden" name="highOrLow" value="DESC"/>
                        <input type="hidden" name="command" value="sort_by_price"/>
                        <button type = "submit">SORT BY PRICE (from high to low)</button>
                    </form>
                </li>
                <li>
                    <form name ="topMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="column" value="price"/>
                        <input type="hidden" name="highOrLow" value="ASC"/>
                        <input type="hidden" name="command" value="sort_by_price"/>
                        <button type = "submit">SORT BY PRICE (from low to high)</button>
                    </form>
                </li>
                <li>
                    <form name ="topMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="column" value="name"/>
                        <input type="hidden" name="command" value="sort_by"/>
                        <button type = "submit">SORT BY NAME </button>
                    </form></li>
                <li>
                    <form name ="topMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="column" value= "releas"/>
                        <input type="hidden" name="command" value="sort_by"/>
                        <button type = "submit">SORT BY DATE OF RELEASE </button>
                    </form>
                </li>
        	    <li>
        	        <form name ="topMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET FILTERS</button>
                    </form>
                </li>
            </ul>
        </nav>
	<aside>
	    <navy>
        	<ul class="aside-menu">
                <li>BRAND</li>
        		    <form name ="selectMenu" action="mainServlet" method "POST">
                        <li>
                            <a>
                                <input type = "radio" name ="param" value ="'SONY'"/>SONY
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'JBL'"/>JBL
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'AUDIO-TECHNICA'"/>AUDIO-TECHNICA
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'SENNHEISER'"/>SENNHEISER
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio"name="param" value="'BOSE'"/>BOSE
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio"name="param" value="'APPLE'"/>APPLE
                            </a>
                        </li>
                        <input type="hidden" name="column" value="name"/>
                        <input type="hidden" name="command" value="find_by"/>
                        <button type = "submit">SELECT</button>
                    </form>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
        		<li>PRICE</li>
        		    <form name="price" action="mainServlet" method="POST">
                		<input type="text" name="priceFrom" required placeholder="from $"/>
                		<input type="text" name="priceTo" required placeholder="to $"/>
                		<input type = "hidden" name = "command" value = "find_by_price"/>
                        <button type = "submit">SELECT</button>
                    </form>
                </li>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
                </li>
        		<li>CONSTRUCTION</li>
        		    <form name = "selectMenu" action="mainServlet" method "POST">
                        <li>
                            <a>
                                <input type="radio" name="param" value="'insert'">INSERT
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'intra-channel'" >INTRA-CHANNEL
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'monitor'" >MONITOR
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'overhead'">OVERHEAD
                            </a>
                        </li>
                            <input type="hidden" name="column" value="construction"/>
                            <input type="hidden" name="command" value="find_by"/>
                            <button type = "submit">SELECT</button>
                    </form>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
        		<li>HI-RES</li>
        		    <form name = "selectMenu" action="mainServlet" method "POST">
                        <li>
                            <a>
                                <input type="radio" name="param" value="'YES'">YES
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'NO'">NO
                            </a>
                        </li>
                        <input type="hidden" name="column" value="hiRes"/>
                        <input type="hidden" name="command" value="find_by"/>
                        <button type = "submit">SELECT</button>
                    </form>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
        		<li>BLUETOOTH</li>
        		    <form name = "selectMenu" action="mainServlet" method "POST">
                        <li>
                            <a>
                                <input type="radio" name="param" value="'YES'">YES
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'NO'">NO
                            </a>
                        </li>
                        <input type="hidden" name="column" value="bluetooth"/>
                        <input type="hidden" name="command" value="find_by"/>
                        <button type = "submit">SELECT</button>
                    </form>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
        		<li>IN STOCK</li>
        		    <form name = "selectMenu" action="mainServlet" method "POST">
                        <li>
                            <a>
                                <input type="radio" name="param" value="'YES'">YES
                            </a>
                        </li>
                        <li>
                            <a>
                                <input type="radio" name="param" value="'NO'"> NO
                            </a>
                        </li>
                        <input type="hidden" name="column" value="stock"/>
                        <input type="hidden" name="command" value="find_by"/>
                        <button type = "submit">SELECT</button>
                    </form>
                    <form name ="selectMenu" action="mainServlet" method "POST">
                        <input type="hidden" name="command" value="find_all"/>
                        <button type = "submit">RESET</button>
                    </form>
        	</ul>
        </navy>
	</aside>
	    <section>
	        <table>
                <tr>
                    <th>BRAND</th>
                    <th>MODEL</th>
                    <th>PRICE</th>
                    <th>CONSTRUCTION</th>
                    <th>HI-RES</th>
                    <th>BLUETOOTH</th>
                    <th>RELEASE</th>
                    <th>IN STOCK</th>
                </tr>
                <c:forEach var="hp" items="${headphonesArray}">
                    <tr>
                        <td>${hp.name}</td>
                        <td>${hp.model}</td>
                        <td>${hp.price}$</td>
                        <td>${hp.construction}</td>
                        <td>${hp.hiRes}</td>
                        <td>${hp.bluetooth}</td>
                        <td>${hp.release}</td>
                        <td>${hp.stock}</td>
                        <td>
                            <form method = "POST" action = "mainServlet">
                                <input type = "hidden" name = "id" value = "${hp.id}"/>
                                <input type = "hidden" name = "command" value = "in_cart"/>
                                <button type = "submit">ADD IN CART</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
    <footer></footer>
</body>
</html>