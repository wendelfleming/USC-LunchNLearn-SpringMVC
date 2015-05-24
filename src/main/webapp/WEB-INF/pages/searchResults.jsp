<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="usc" uri="/WEB-INF/usc-middleware-functions.tld" %>

<html>
<head>
  <title>Spring MVC LunchNLearn - Search</title>

  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <c:set var="jsPath" value="${contextPath}/js/jbreadcrumb/"/>
  <c:set var="cssPath" value="${contextPath}/css/jbreadcrumb/"/>
  ${usc:breadcrumbhead(jsPath,cssPath)}

</head>
<body>

Search Results for ${searchterm}: <br />

${usc:breadcrumbbody(x, bCrumbs)}


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
      <td><a href="<%=request.getContextPath()%>/spring/gameinfo/${game.id}/?x=${x}">${game.name}</a></td>
      <td><a href="<%=request.getContextPath()%>/spring/search/studio?searchTerm=${usc:encodeUrl(game.studio.name)}&x=${x}">${game.studio.name}</a></td>
    </tr>
  </c:forEach>
    </tbody>
  </table>

</c:if>
<c:if test="${empty searchresult}">
  No results found.
</c:if>


</body>
</html>
