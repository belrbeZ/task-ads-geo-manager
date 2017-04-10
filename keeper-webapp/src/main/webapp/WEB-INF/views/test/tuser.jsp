<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%--
  By User: @GoodforGod
  On Date: 10.04.2017
  On Time: 09:02
--%>
<html>
<head>
    <meta charset="UTF-8">

    <title>User Test</title>
</head>
<body>
    <%@include file="/resources/html/nav-bar.html"%>
    <div id="users" align="center">
        <%-- user table naming --%>
        <table id="users" class="user-table">
            <tr>
                <th class="shadow" style="font-weight: bold"> Name </th>
                <th class="shadow" style="font-weight: bold"> Email </th>
                <th class="shadow" style="font-weight: bold"> Phone </th>
            </tr>

            <%-- users --%>
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td class="shadow" style="width:7%"> ${user.name} </td>
                        <td class="shadow" style="width:32%"> ${user.email} </td>
                        <td class="shadow" style="width:24%"> ${user.phone} </td>
                        <td class="shadow" style="width:7%; text-align: center">
                           <c:url value="/secure/api/profile?id=${user.id}" var="Update"/>
                        </td>
                        <td class="shadow" style="width:7%; text-align: center">
<%--                            <a href=<c:url value="/secure/api/profile?id=${user.id}"/> "> Delete </a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            <%-- User post/update --%>
            <form:form method="post" action="/secure/api/profile" modelAttribute="User">
                <tr>
                    <td class="shadow" > <input type="text" name="name" title="name" placeholder="name"/> </td>
                    <td class="shadow" > <input type="text" name="email" title="email" placeholder="email"/></td>
                    <td class="shadow" > <input type="text" name="phone" title="phone" placeholder="phone"/> </td>
                    <td class="shadow" > <input type="text" name="password" title="password" placeholder="password"/> </td>
                    <td style="text-align: center" align="center">
                        <input type="submit" class="custom_button" align="center" value="Add Users">
                    </td>
                </tr>
            </form:form>
        </table>
    </div>
</body>
</html>
