<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<body>
	<h3>Product-List-With-JSTL</h3>
	<hr>
	<table border="2">
	<tr>
		<th>Code</th><th>Name</th><th>Price</th>
	</tr>
		<jstl:forEach  var="product" items="${products}">
		<tr>
		<td>${product.pcode}</td>
		<td>${product.pname}</td>
		<td>${product.price}</td>
		<td><a href="dodelete?pcode=${product.pcode}">delete</a></td>
		</tr>
		</jstl:forEach>
	</table>
	
    <hr>
	<a href="index.jsp">Home</a>
</body>
</html>