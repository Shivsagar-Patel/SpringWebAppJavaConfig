<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<html>
<body>
	<h3>Error-Page</h3>
	<hr>
	<h3>Data Binding Failed</h3>
	<fr:errors path="product.pcode"/><br>
	<fr:errors path="product.pname"/><br>
	<fr:errors path="product.price"/><br>
	<hr>
	<a href="newproduct">Try-Again</a><br>
	<a href="index.jsp">Home</a>
</body>
</html>