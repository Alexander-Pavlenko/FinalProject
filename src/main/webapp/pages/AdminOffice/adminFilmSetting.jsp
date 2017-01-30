<%@ page import="dto.FilmDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 19.12.2016
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='styleWindow.css' %>
    <%@include file='../updated_pages/css/style1.css' %>
</style>
<script type="text/javascript">
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('wrap').style.display = state;
    }
    function AddFilm() {
    }
</script>
<style type="text/css">
    TABLE {
        table-layout: fixed; /* Ячейки фиксированной ширины */
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="container">

    <c:import url="/pages/AdminOffice/partJsp.jsp"></c:import>


    <div id="content">
        <div class="button">
            <input type="button" value="Add film" onclick="show('block')">
        </div>
        <div class="button">
            <form action="/AdminFilmSetting" method="post">
                <button type="submit" name="viewFilms">View Films</button>
            </form>
        </div>
        <c:if test="${requestScope.listFilm!=null}">
            <blockquote>
                <table class="scrolling-table">
                    <thead>
                    <tr>
                        <th>
                            idFilm
                        </th>
                        <th>
                            Title
                        </th>
                        <th>
                            Duration
                        </th>
                        <th>
                            Description
                        </th>
                        <th>
                            Release Date
                        </th>
                        <th>
                            Picture
                        </th>
                        <th>
                            Mark
                        </th>
                        <th>
                            Edit
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="films" value="${requestScope.listFilm}" scope="page"/>
                    <c:forEach var="i" begin="0" end="${requestScope.listFilm.size() - 1}">
                        <c:set var="item" value="${films[i]}" scope="request"></c:set>
                        <tr>
                            <td>
                                    ${films[i].id}
                            </td>
                            <td>
                                    ${films[i].name}
                            </td>
                            <td>
                                    ${films[i].description.duration}
                            </td>
                            <td>
                                    ${films[i].description.miniDescription}
                            </td>
                            <td>
                                    <%=((FilmDto)request.getAttribute("item")).getDescription().getRelease()%>
                            </td>
                            <td>
                                    ${films[i].description.picture}
                            </td>
                            <td>
                                    ${films[i].description.mark}
                            </td>
                            <td>
                                <form action="/AdminFilmSetting" method="post">
                                    <button name="edit" value="${films[i].id}">edit</button>
                                    <button name="delete" value="${films[i].id}" >delete</button>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </blockquote>
        </c:if>

    </div>


    <c:import url="/pages/AdminOffice/part1Jsp.jsp"></c:import>

</div>





<div id="window">
    <img class="close" onclick="show('none')" src="/images/close.png">
    <form action="/AdminFilmSetting" method="post" name="filmSetting">
        <p>Name: <input type="text" name="title"></p>
        <p>Duration: <input type="text" name="duration"></p>
        <p>Description: <input type="text" name="description"></p>
        <p>Date realease: <input type="text" name="dateRealease" value="format: dd.mm.yyyy"></p>
        <p>Format Film: <input type="text" name="formatFilm"></p>
        <p>Picture: <input type="text" name="picture" id="picture"></p>
        <button onclick="">load image</button>
        <p><label name="result"></label></p>
        <input type="submit" name="AddFilm" value="Add">
    </form>
</div>


<c:set value="${requestScope.film}" var="filmEdit"/>
<div id="window" style="display: ${requestScope.display}">
    <img class="close" onclick="showClose('none')" src="/images/close.png">
    <form action="/AdminFilmSetting" method="post">
        <p>Title: <input type="text" name="title" value="${filmEdit.name}"></p>
        <p>Duration: <input type="text" name="duration" value="${filmEdit.description.duration}"></p>
        <p>miniDescription: <input type="text" name="description" value="${filmEdit.description.miniDescription}"></p>
        <%--<p>Date Release: <input type="text" name="release" value=<%=((FilmDto)request.getAttribute("item")).getDescription().getRelease()%>></p>--%>
        <p>Format Film: <input type="text" name="formatFilm" value="${filmEdit.description.formatFilm}"></p>
        <p>Picture: <input type="text" name="picture" value="${filmEdit.description.picture}"></p>
        <input type="hidden" name="id" value="${filmEdit.id}">
        <input type="hidden" name="idDes" value="${filmEdit.description.id}">
        <input type="submit" value="Update" name="UpdateUser">
    </form>
</div>


</body>
</html>
