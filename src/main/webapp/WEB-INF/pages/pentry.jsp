<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<html>
<body>
	<h3>Product Entry Form</h3>
	<hr>
	<form action="saveproduct">
		<pre>
		PCode	    <input type="text" name="pcode" />
		            <fr:errors path="product.pcode"/><br>
		PName       <input type="text" name="pname" />
		            <fr:errors path="product.pname"/><br>
		Price       <input type="text" name="price" />
		            <fr:errors path="product.price"/><br>
		            <input type="submit" value="Save" />
	 </pre>
	</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>