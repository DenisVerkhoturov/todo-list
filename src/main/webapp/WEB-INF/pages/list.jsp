<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<c:url value="/static/css/normalize.css" var="normalizeCss"/>
<c:url value="/static/css/style.css" var="mainCss"/>
<c:url value="/add" var="addAction"/>
<c:url value="/test" var="test"/>
<html>
<head>
    <link href="${normalizeCss}" rel="stylesheet">
    <link href="${mainCss}" rel="stylesheet">
    <title>Задания</title>
</head>
<body>
<header></header>

<main>
    <section class="tasklist">
        <h1>Задания</h1>

        <form:form action="${addAction}" cssClass="task" commandName="task">
            <form:input path="name" cssClass="form-field task-name" placeholder="Название"/>
            <form:textarea path="description" cssClass="form-field task-description" placeholder="Описние"/>
            <form:checkbox path="done" cssClass="form-field task-done"/>
            <div class="task-operations">
                <button class="button" type="submit"><spring:message text="Добавить задание"/></button>
            </div>
        </form:form>

        <c:choose>
            <c:when test="${!empty tasks}">
                <c:forEach items="${tasks}" var="task">
                    <article class="task">
                        <a class="task-name" href="/task/${task.id}"><h2>${task.name}</h2></a>
                        <p class="task-description">${task.description}</p>
                        <div class="task-operations">
                            <a class="button" href="<c:url value='/edit/${task.id}'/>">Редактировать</a>
                            <a class="button" href="<c:url value='/remove/${task.id}'/>">Удалить</a>
                            <c:choose>
                                <c:when test="${task.done}">
                                    <a class="button" href="<c:url value='/task/${task.id}'/>">Пометить как невыполненное</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="button" href="<c:url value='/remove/${task.id}'/>">Пометить как выполненное</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </article>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Нет ни одного задания, к которому можно было бы приступить... <a href="${test}">Выдумать задачи</a>
                </p>
            </c:otherwise>
        </c:choose>
    </section>
</main>

<footer></footer>
</body>
</html>
