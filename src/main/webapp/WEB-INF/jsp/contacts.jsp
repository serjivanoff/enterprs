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
    <c:forEach var="contact" items="user.contacts">
        <tr>${contact.phone}</tr>
        <tr>${contact.email}</tr>
    </c:forEach>

</table>
</body>
</html>
