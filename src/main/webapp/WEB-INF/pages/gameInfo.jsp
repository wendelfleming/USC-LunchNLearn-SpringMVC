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

  <c:if test="${!empty game}">

  <h3>Game: ${game.name}</h3>

  ${usc:breadcrumbbody(x, bCrumbs)}

    <div id="content_section">

    <br /><br />

  <table>
    <tr>
      <td>Name:</td>
      <td>${game.name}</td>
    </tr>
    <tr>
      <td>Studio:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/studio?searchTerm=${usc:encodeUrl(game.studio.name)}&x=${x}">${game.studio.name}</a></td>
    </tr>
    <tr>
      <td>Genre:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/genre?searchTerm=${usc:encodeUrl(game.genre.name)}&x=${x}">${game.genre.name}</a></td>
    </tr>
    <tr>
      <td>Platform:</td>
      <td><a href="<%=request.getContextPath()%>/spring/search/platform?searchTerm=${usc:encodeUrl(game.platform.name)}&x=${x}">${game.platform.name}</a></td>
    </tr>
  </table>
    </div>

</c:if>
<c:if test="${empty game}">
  Game not found.
</c:if>
</div>

</body>
</html>
