<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>

<html>
	<head><title>HelloWorld</title></head>
	<% String str = (String)request.getAttribute("helloWorld"); %>
	<body>
		<h2><c:out value="${helloWorld}"/></h2>
	</body>
</html>
