<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenin
  Date: 08.09.2020
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty someData.surName}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty someData.surName}">
        <title>Edit</title>
    </c:if>
</head>
<body>

<div align="center">
<c:if test="${empty someData.surName}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty someData.surName}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty someData.surName}">
        <input type="hidden" name="id" value="${someData.id}">
    </c:if>

    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${someData.name}">

    <label for="surName">Surname</label>
    <input type="text" name="surName" id="surName" value="${someData.surName}">

    <label for="birthDate">Birthdate</label>
    <input type="text" name="birthDate" id="birthDate" value="${someData.birthDate}">

    <label for="gender">Gender</label>
    <input type="text" name="gender" id="gender" value="${someData.gender}">

    <label for="someboolean">Some boolean</label>
    <input type="checkbox" name="someboolean" id="someboolean" value="${someData.someBoolean}">

    <c:if test="${empty someData.surName}">
        <label for="submitb"><p>

        </p></label>
        <input type="submit" name="submitb" id="submitb" value="Add some data">
    </c:if>
    <c:if test="${!empty someData.surName}">
        <label for="submitb"><p>

        </p></label>
        <input type="submit" name="submitb" id="submitb" value="Edit some data">
    </c:if>

</div>
</form>
</body>
</html>
