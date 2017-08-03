<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Кириллица отображается? </h2>
<jsp:useBean id="user" class="model.User"/>
<form method="post" action = "adduser">
    <input type="hidden" name="id" value=${"user.id"}>
    <dl>
        <dt>First Name</dt>
        <dd><input type="text" name="firstName"></dd>
        <dt>Middle Name</dt>
        <dd><input type="text" name="middleName"></dd>
        <dt>Last Name</dt>
        <dd><input type="text" name="lastName"></dd>
        <dt>Age</dt>
        <dd><input type="text" name="age"></dd>
        <dt>Experience</dt>
        <dd><input type="text" name="experience"></dd>
    </dl>
    <button type="submit">Add</button>
</form>
</body>
</html>
