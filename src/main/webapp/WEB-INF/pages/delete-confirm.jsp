<%@page isELIgnored="false" %>

<html>
<head>
<body>
<h3>Product Deatils Deleted Successfully</h3>
<h4>Following Details Deleted :</h4>
<hr>
<pre>
			Pcode     ${product.pcode}
			Pname     ${product.pname}
			Price     ${product.price}
<hr>
</pre>
<a href="deleteproduct">Delete-more</a><br>
<a href="viewproducts">Back-To-List</a><br>
<a href="index.jsp">Home</a>
</body>
</html>