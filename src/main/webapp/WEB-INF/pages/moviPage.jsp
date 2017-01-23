<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='styleMovie.css' %>
</style>
<html>
<head>
    <meta charset="utf-8">

    <title>${requestScope.movie.name}</title>
</head>
<body>


<div id="container">

    <div id="header"></div>

    <div id="top_menu"></div>

    <div id="left"></div>

    <div id="right"></div>

    <div id="content">

        <div class="picture" ><img src=${requestScope.movie.description.picture} width="100"height="300"></div>
        <div class="text">

                    <div class="name"><h1><${movie.name}</h1></div>

                    <div class="formatFilm">Формат фильма: ${movie.description.formatFilm}</div>

                    <div class="description">Описания: ${movie.description.miniDescription}</div>
                    <div class="duration">Длительность: ${movie.description.duration}</div>



        </div>
        <div class="sessionMonie">
            <c:forEach var="session" items="${requestScope.sessionList}">
                <div class="item">
                    <div class="text">
                        <div class="name"><h3><a href='/sessionServlet?id=${session.id}'>${session.date}</a></h3></div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="clear"></div>

    <div id="footer"></div>

</div>


</body>
</html>