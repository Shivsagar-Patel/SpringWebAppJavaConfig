<%@page import="java.util.List,com.ssi.models.Product"%>
<%
	List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html>
<body>
	<h3>Product-List-Without-JSTL</h3>
	<hr>
	<table border="2">
		<%
		 if (products != null) {
			for (Product product : products) {
		%>
		<tr>
			<td><%=product.getPcode()%></td>
			<td><%=product.getPname()%></td>
			<td><%=product.getPrice()%></td>
		</tr>
		<%
			}
		 }else
		 {
			 System.out.println("NUll..........");
		 }
		%>
	</table>
	
    <hr>
	<a href="index.jsp">Home</a>
</body>
</html>