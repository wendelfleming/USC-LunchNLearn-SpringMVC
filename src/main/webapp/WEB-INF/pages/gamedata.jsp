<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>

  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.11.0.min.js"></script>--%>
  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/LunchnLearn.js"></script>--%>

  <%--<script type="text/javascript">--%>
    <%--<!----%>
    <%--var page_ajaxmapping = "<%=request.getContextPath()%>/spring/game/admin";--%>
    <%--//-->--%>
  <%--</script>--%>


</head>
<body>

<h1>Game</h1>

  <form:form commandName="newGame" method="POST">
    Name: <form:input path="name"/><br />
    Genre: <form:select path="genre"><form:options items="${genres}" itemValue="id" itemLabel="name"></form:options></form:select><br />
    Platform: <form:select path="platform"><form:options items="${platforms}" itemValue="id" itemLabel="name"></form:options></form:select><br />
    Studio: <form:select path="studio"><form:options items="${studios}" itemValue="id" itemLabel="name"></form:options></form:select><br />
    <input type="submit" value="Add Game" />
  </form:form>

  <h3>Games</h3>

  <table id="results">
    <thead>
    <tr>
      <th>Name</th>
      <th>Genre</th>
      <th>Platform</th>
      <th>Studio</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty games}">
      <c:forEach items="${games}" var="game">
        <tr>
          <td>${game.name}</td>
          <td>${game.genre}</td>
          <td>${game.platform}</td>
          <td>${game.studio}</td>
          <td>
            <form method="post" action="<%=request.getContextPath()%>/spring/db/game/delete"><input type="hidden" name="gameId" value="${game.id}"/><input type="submit" value="Delete"/></form>
          </td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>

</body>
</html>


