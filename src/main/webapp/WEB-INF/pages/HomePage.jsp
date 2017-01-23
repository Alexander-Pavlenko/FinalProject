<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='style.css' %>
</style>
<html>
<head>
    <meta charset="utf-8">

    <title>Route Schedule</title>
</head>
<body>


<div id="container">

    <div id="header">

        <div id = "enter">
            <form action="/pages/Register.jsp">
                <input type="submit" value="Register">
            </form>
            <form action="/pages/login.jsp">
                <input type="submit" value="LogIn">
            </form>
        </div>
        <div id = "userTable">
           <a href="/PersonalOffice"><p>${sessionScope.user.login}</p></a>
        </div>

    </div>

    <div id="top_menu"></div>

    <div id="left"></div>

    <div id="right"></div>

    <div id="content">
        <c:forEach var="movie" items="${requestScope.movieList}">
            <div class="item">
                <div class="picture" ><img src=${movie.description.picture} width="80"height="100"></div>
                <div class="text">

                    <div class="name"><h3><a href='/movie?id=${movie.id}'>${movie.name}</a></h3></div>

                    <div class="formatFilm">Формат фильма: ${movie.name}</div>
                    <div class="dateRelease">Дата выхода: ${movie.description.miniDescription}</div>
                    <div class="description">Описания: ${movie.description.formatFilm}</div>
                    <div class="duration">Длительность: ${movie.description.mark}</div>



                </div>
            </div>
        </c:forEach>
    </div>

    <div id="clear"></div>

    <div id="footer"></div>

</div>


</body>
</html>