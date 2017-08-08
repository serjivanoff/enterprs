<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<jsp:useBean id="user" class="model.User"/>
<table>
    <th>Phone</th>
    <th>Email</th>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.phone}</td>
            <td>${contact.email}</td>
        </tr>
    </c:forEach>
</table>
<h2> <a href="/users">Back to Users List</ahref></h2>
</body>
</html>
