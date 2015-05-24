<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

</head>

<body>

<h1>${message}</h1>

<h3>Search</h3>

<form action="<c:url value="/spring/search"/>" method="post">
    Search: <input type="text" name="searchTerm"/><br />
    <input type="submit" value="Search"/>
</form>



<h3>Database Administration</h3>

<a href="<c:url value="/spring/db/genre/"/>">Genre</a><br />
<a href="<c:url value="/spring/db/platform/"/>">Platform</a><br />
<a href="<c:url value="/spring/db/studio/"/>">Studio</a><br />
<%--<a href="<c:url value="/spring/db/game/"/>">Game</a><br />--%>
<a href="<%=request.getContextPath()%>/spring/db/game/">Game</a><br />



</body>

</html>