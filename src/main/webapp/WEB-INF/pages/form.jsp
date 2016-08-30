<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:url value="/static/css/normalize.css" var="normalizeCss"/>
<c:url value="/static/css/style.css" var="mainCss"/>
<c:url var="addAction" value="/add"/>

<html>
<head>
    <link href="${normalizeCss}" rel="stylesheet">
    <link href="${mainCss}" rel="stylesheet">
    <title>Редактирование</title>
</head>
<body>
<header></header>

<main>
    <h1>Задача: ${task.name}</h1>
    <form:form cssClass="task" action="${addAction}" commandName="task">
        <form:input path="name" cssClass="task-name" placeholder="Название"/>
        <form:textarea path="description" cssClass="task-description" placeholder="Описние"/>

        <form:label path="done">
            <spring:message text="Выполнено"/>
        </form:label>
        <form:checkbox path="done"/>

        <form:hidden path="id"/>
        <input type="submit" value="<spring:message text="Сохранить"/>"/>
    </form:form>
</main>

<footer></footer>
</body>
</html>