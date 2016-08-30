<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:url value="/static/css/normalize.css" var="normalizeCss" />
<c:url value="/static/css/style.css" var="mainCss" />
<c:url var="addAction" value="/add"/>

<html>
<head>
    <link href="${normalizeCss}" rel="stylesheet">
    <link href="${mainCss}" rel="stylesheet">
    <title>Редактирование</title>
</head>
<body>

<form:form action="${addAction}" commandName="task">

    <div class="form-field">
        <form:label path="name">
            <spring:message text="name"/>
        </form:label>
        <form:input path="name"/>
    </div>
    <div class="form-field">
        <form:label path="description">
            <spring:message text="description"/>
        </form:label>
        <form:input path="description"/>
    </div>
    <div class="form-field">
        <form:label path="done">
            <spring:message text="Выполнено"/>
        </form:label>
        <form:input path="done"/>
    </div>

    <form:hidden path="id"/>
    <input type="submit" value="<spring:message text="Сохранить"/>"/>
</form:form>
</body>
</html>