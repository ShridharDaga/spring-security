<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

<html>

<head>
	<title>Zemoso Company Home Page</title>
</head>

<body>
	<h2>Zemoso Company Home Page</h2>
	<hr>

	Welcome to the Zemoso company home page!

	<!-- Add a logout button -->
    	<form:form action="${pageContext.request.contextPath}/logout"
    			   method="POST">

    		<input type="submit" value="Logout" />

    	</form:form>

</body>

</html>