<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Headphones shop</title>
<link href="styles1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<div id="wrapper">
		<header>
		<form name="login" action="mainServlet" method="POST">
		<input type="text" name="login" required placeholder="Login"/>
		<input type="text" name="password" required placeholder="Password"/>
		<input type = "hidden" name = "command" value = "login"/>
        <button type = "submit">LOGIN</button>
        </form>
	   </header>
	   <header2>
       		<ul class ="header-menu">
       			            <li><a href="cart.jsp"><h3>MY CART${sizeOfCart}</h3></a></li>
                       		<li><a href="registrationUser.jsp"><h3>REGISTRATION</h3></a></li>
                       		<li><a href="/customers/"><h3>SESSION</h3></a></li>
                       		</ul></header2>
		<header1>
		<h1>HEADPHONES SHOP</h1>
		</header1>
		<nav>
		<ul class="top-menu">
        		<li><a href="index.jsp">SORT BY PRICE (from high to low)</a></li>
        		<li><a href="/partners/">SORT BY PRICE (from low to high)</a></li>
        		<li><a href="/customers/">SORT BY NAME</a></li>
        		<li><a href="/projects/">SORT BY DATE OF RELEASE</a></li>

        	</ul></nav>
		<div id="heading"></div>
		<aside>
		<navy>
        	<ul class="aside-menu">
        		<li class="active">BRAND</li>
        		<li><a href="/donec/">PRICE (FROM - TO)</a></li>
        		<li><a href="/vestibulum/">CONSTRUCTION</a></li>
        		<li><a href="/etiam/"></a>HI-RES</li>
        		<li><a href="/phasellus/">BLUETOOTH</a></li>
        		<li><a href="/cras/"></a>IN STOCK</li>
        	</ul>
        </navy>
		</aside>
		<section>
		<blockquote>
        	<p>
        	The place for the list of headphones
        	</p>

        	</blockquote>
		</section>
	</div>
	<footer></footer>
</body>
</html>