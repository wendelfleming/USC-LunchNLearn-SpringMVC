<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>

</head>
<body>

<c:if test="${!empty game}">

  <h3>Game: ${game.name}</h3>

  <table>
    <tr>
      <td>Name:</td>
      <td>${game.name}</td>
    </tr>
    <tr>
      <td>Studio:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/studio?searchTerm=${game.studio.name}">${game.studio.name}</a></td>
    </tr>
    <tr>
      <td>Genre:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/genre?searchTerm=${game.genre.name}">${game.genre.name}</a></td>
    </tr>
    <tr>
      <td>Platform:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/platform?searchTerm=${game.platform.name}">${game.platform.name}</a></td>
    </tr>
  </table>

</c:if>
<c:if test="${empty game}">
  Game not found.
</c:if>

</body>
</html>
