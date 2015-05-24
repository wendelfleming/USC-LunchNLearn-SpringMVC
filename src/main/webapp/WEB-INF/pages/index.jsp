<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="usc" uri="/WEB-INF/usc-middleware-functions.tld" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="jsPath" value="${contextPath}/js/jbreadcrumb/"/>
    <c:set var="cssPath" value="${contextPath}/css/jbreadcrumb/"/>
    ${usc:breadcrumbhead(jsPath,cssPath)}

</head>

<body>

<h1>${message}</h1>

${usc:breadcrumbbody(x, bCrumbs)}


<h3>Search</h3>

<%--<form action="<c:url value="/spring/search"/>" method="post">--%>
<form action="<%=request.getContextPath()%>/spring/search?x=${x}" method="post">
    Search: <input type="text" name="searchTerm"/><br />
    <input type="submit" value="Search"/>
</form>



<h3>Database Administration</h3>

<%--<a href="<c:url value="/spring/db/genre/"/>">Genre</a><br />--%>
<%--<a href="<c:url value="/spring/db/platform/"/>">Platform</a><br />--%>
<%--<a href="<c:url value="/spring/db/studio/"/>">Studio</a><br />--%>
<%--<a href="<c:url value="/spring/db/game/"/>">Game</a><br />--%>

<a href="<%=request.getContextPath()%>/spring/db/genre/?x=${x}">Genre</a><br />
<a href="<%=request.getContextPath()%>/spring/db/platform/?x=${x}">Platform</a><br />
<a href="<%=request.getContextPath()%>/spring/db/studio/?x=${x}">Studio</a><br />
<a href="<%=request.getContextPath()%>/spring/db/game/?x=${x}">Game</a><br />



</body>

</html>