<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link  rel="stylesheet" href="/resources/style.css" type="text/css" >
</head>
<body>
<h2>Here could be your advertisment</h2>
<jsp:useBean id="user" class="model.User"/>
<table class="user-table">
    <tr class="table-header">
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Experience</th>
    <th>Registered</th>
    <th>Role</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName} ${user.middleName == null?"":user.middleName} ${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.experience}</td>
            <td>${user.registered}</td>
            <td></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>