<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>${user.firstName}</title>
</head>
<body>
<h2> Кириллица отображается? </h2>
<form:form method="post" action = "/users/adduser" modelAttribute="userForm">
    <form:input path="id" hidden="true"/>
    <dl>
        <dt>First Name</dt>
        <dd><form:input path="firstName"/></dd>
        <dt>Middle Name</dt>
        <dd><form:input path="middleName" /></dd>
        <dt>Last Name</dt>
        <dd><form:input path="lastName" /></dd>
        <dt>Age</dt>
        <dd><form:input path="age" /></dd>
        <dt>Experience</dt>
        <dd><form:input path="experience"/></dd>
        <dt>Registered</dt>
        <dd><form:input path="registered" /></dd>
    </dl>
    <button type="submit">Create or Update</button>
</form:form>
</body>
</html>