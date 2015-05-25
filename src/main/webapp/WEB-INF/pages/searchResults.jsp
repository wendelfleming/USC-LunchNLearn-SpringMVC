<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="usc" uri="/WEB-INF/usc-lunchnlearn-functions.tld" %>

<html>
<head>
    <title>Spring MVC LunchNLearn - Search</title>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery/swfobject.js"></script>

    <c:set var="jsPath" value="${contextPath}/js/jbreadcrumb/"/>
    <c:set var="cssPath" value="${contextPath}/css/jbreadcrumb/"/>
    ${usc:breadcrumbhead(jsPath,cssPath)}

    <style type='text/css' media='screen'>@import "${contextPath}/css/lunchnlearn.css";</style>

</head>
<body>

<div id="main_section">

    <h3>Search Results</h3>


    ${usc:breadcrumbbody(x, bCrumbs)}

    <div id="content_section">

        Results for ${searchterm}: <br/>


        <c:if test="${!empty searchresult}">
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Studio</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${searchresult}" var="game">
                    <tr>
                        <td><a href="${contextPath}/spring/gameinfo/${game.id}/?x=${x}">${game.name}</a></td>
                        <td>
                            <a href="${contextPath}/spring/search/studio?searchTerm=${usc:encodeUrl(game.studio.name)}&x=${x}">${game.studio.name}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty searchresult}">
            No results found.
        </c:if>


    </div>
</div>


</body>
</html>
