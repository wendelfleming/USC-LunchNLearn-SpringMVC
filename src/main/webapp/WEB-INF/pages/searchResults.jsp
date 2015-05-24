<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Spring MVC LunchNLearn - Search</title>

</head>
<body>

Search Results for ${searchterm}: <br />

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
      <td><a href="<%=request.getContextPath()%>/spring/gameinfo/${game.id}/">${game.name}</a></td>
      <td><a href="<%=request.getContextPath()%>/spring/search/studio?searchTerm=${game.studio.name}">${game.studio.name}</a></td>
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
