<%--
* Copyright 2015 wendel fleming
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="usc" uri="/WEB-INF/usc-lunchnlearn-functions.tld" %>

<html>
<head>
    <title></title>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/LunchnLearn.js"></script>

    <c:set var="jsPath" value="${contextPath}/js/jbreadcrumb/"/>
    <c:set var="cssPath" value="${contextPath}/css/jbreadcrumb/"/>
    ${usc:breadcrumbhead(jsPath,cssPath)}

    <style type='text/css' media='screen'>@import "${contextPath}/css/lunchnlearn.css";</style>

    <script type="text/javascript">
        <!--
        var page_ajaxmapping = "${contextPath}/spring/db/${pathName}/admin";
        //-->
    </script>

</head>
<body>

<div id="main_section">


    <h1>${pageName}</h1>


    ${usc:breadcrumbbody(x, bCrumbs)}

    <div id="content_section">

        <br/><br/>

        <div id="dynamicForms">
            <form class="addForm">
                Name:
                <input type="text" name="dataname"/>
                <input type="submit" value="Add ${pageName}"/>
            </form>

            <h3>${pageName}s</h3>

            <div><span id="ajaxMessage"></span><span id="ajaxError"></span></div>


            <table id="results">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${!empty dataset}">
                    <c:forEach items="${dataset}" var="data">
                        <tr>
                            <td>${data.name}</td>
                            <td>
                                <form class="deleteForm"><input type="hidden" name="dataid" value="${data.id}"/><input
                                        type="hidden" name="dataname" value="${data.name}"/><input type="submit"
                                                                                                   value="Delete"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>


