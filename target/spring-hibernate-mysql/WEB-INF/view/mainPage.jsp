<%--
  Created by IntelliJ IDEA.
  User: lenin
  Date: 08.09.2020
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Some data</title>
</head>
<body>

<h2 align="center">Some data</h2>
<table class="blueTable">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>birthdate</th>
        <th>gender</th>
        <th>someboolean</th>
    </tr>
    <c:forEach var="someData" items="${someDataList}">
        <tr>
            <td>${someData.id}</td>
            <td>${someData.name}</td>
            <td>${someData.surName}</td>
            <td>${someData.birthDate}</td>
            <td>${someData.gender}</td>
            <td align="center">
                <c:choose>
                    <c:when test="${someData.someBoolean == true}">
                        <label for="checkbox"></label>
                        <input id="checkbox" type="checkbox" name="checkbox" checked/>
                    </c:when>
                    <c:otherwise>
                        <label for="checkbox"></label>
                        <input id="checkbox" type="checkbox" name="checkbox"/>
                    </c:otherwise>
                </c:choose></td>
            <td>
                <a href="/edit/${someData.id}"> <img src="${pageContext.request.contextPath}/res/noun_edit_2977470.png" style="width:30px; height:30px">edit</a>
                <a href="/delete/${someData.id}"> <img src="${pageContext.request.contextPath}/res/noun_Delete_45886.png" style="width:30px; height:30px">delete</a>
            </td>
        </tr>
    </c:forEach>


</table>

<h2>Add
    <c:url value="/add" var="add"/>
    <a href="${add}"> <img src="/res/noun_add_937093.png" style="width:40px; height:40px"></a>
</h2>

</body>
</html>
