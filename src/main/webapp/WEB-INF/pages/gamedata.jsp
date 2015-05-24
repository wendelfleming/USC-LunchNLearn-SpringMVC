<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="usc" uri="/WEB-INF/usc-middleware-functions.tld" %>

<html>
<head>
  <title></title>

  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <c:set var="jsPath" value="${contextPath}/js/jbreadcrumb/"/>
  <c:set var="cssPath" value="${contextPath}/css/jbreadcrumb/"/>
  ${usc:breadcrumbhead(jsPath,cssPath)}

  <style type='text/css' media='screen'>@import "${contextPath}/css/lunchnlearn.css";</style>


</head>
<body>

<div id="main_section">


<h1>Game</h1>

${usc:breadcrumbbody(x, bCrumbs)}

  <div id="content_section">

  <br /><br />

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
            <form method="post" action="<%=request.getContextPath()%>/spring/db/game/delete?x=${x}"><input type="hidden" name="gameId" value="${game.id}"/><input type="submit" value="Delete"/></form>
          </td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>
</div>
  </div>
</body>
</html>


