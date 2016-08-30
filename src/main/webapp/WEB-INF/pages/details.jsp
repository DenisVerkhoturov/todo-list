<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:url value="/static/css/normalize.css" var="normalizeCss"/>
<c:url value="/static/css/style.css" var="mainCss"/>

<html>
<head>
    <link href="${normalizeCss}" rel="stylesheet">
    <link href="${mainCss}" rel="stylesheet">
    <title>${task.name}</title>
</head>
<body>
<header></header>

<main>
    <article>
        <h1 class="task-name">Задание: ${task.name}</h1>

        <p class="description">
            ${task.description}
        </p>
    </article>
</main>

<footer></footer>
</body>
</html>