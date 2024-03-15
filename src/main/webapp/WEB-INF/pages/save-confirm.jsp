<%@page isELIgnored="false" %>

<html>
<head>
<body>
<h3>Product Deatils Stored Successfully</h3>
<h4>Following Details Saved :</h4>
<hr>
<pre>
			Pcode     ${product.pcode}
			Pname     ${product.pname}
			Price     ${product.price}
<hr>
</pre>
<a href="newproduct">Add-More</a><br>
<a href="index.jsp">Home</a>
</body>
</html>