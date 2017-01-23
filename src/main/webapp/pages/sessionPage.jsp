<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file='../WEB-INF/pages/styleMovie.css' %>
</style>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 11.12.2016
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Заказ билета!</h1>
</head>
<body>
<div class="container">
    <div id="header"></div>

    <div id="top_menu"></div>

    <div id="left"></div>

    <div id="right"></div>

    <div id="content">
        <c:set var="hall" value="${requestScope.hall}"/>
        <c:forEach var="i" begin="0" end="${requestScope.column}">
            ${i}
            <c:forEach var="j" begin="0" end="${requestScope.row}">
                 <input type="button" onclick="addPlace(${[j]})" value="${[j]}">${hall[i][j]}</input>
            </c:forEach>

        </c:forEach>
        <form action="/buyServlet" method="post">
            <input type="hidden" name="tickets-list">
            <button>Купить</button>
        </form>

    </div>
</div>

<script>
    var array = [];
    function addPlace(item) {
        array.push(item);
        document.getElementsByName('tickets-list')[0].value = array.join(',');
    }
</script>
</body>
</html>
