<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Product Update Form</h3>
	<hr>
		<sf:form action="savechanges" modelAttribute="product">
		<pre>
		Pcode      <sf:input path="pcode"/>
		Pname      <sf:select path="pname" items="${pnames}"/>
		Price      <sf:input path="price"/>
		           <input type="submit" value="Save"/> 
		           </pre>
		</sf:form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>