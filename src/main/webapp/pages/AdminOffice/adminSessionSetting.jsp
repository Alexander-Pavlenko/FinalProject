<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 19.12.2016
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<style>
    <%@include file='styleWindow.css' %>
    <%@include file='../../WEB-INF/pages/style.css' %>
</style>
<script type="text/javascript">
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('wrap').style.display = state;
    }
    function AddFilm() {
    }
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<div id="container">
    <c:import url="/pages/AdminOffice/partJsp.jsp"></c:import>
    <div id="content">
        <div class="button">
            <input type="button" value="Add session" onclick="show('block')">
        </div>
        <div class="button">
            <form action="/AdminSession" method="post">
                <button type="submit" name="viewSessions">View Sessions</button>
            </form>
        </div>
        <c:if test="${requestScope.listSession!=null}">
            <blockquote>
                <table class="scrolling-table">
                    <thead>
                    <tr>
                        <th>
                            idSession
                        </th>
                        <th>
                            idHall
                        </th>
                        <th>
                            idFilm
                        </th>
                        <th>
                            Date start
                        </th>
                        <th>
                            Edit
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="sessions" value="${requestScope.listSession}" scope="page"/>
                    <c:forEach var="i" begin="0" end="${requestScope.listSession.size() - 1}">
                        <tr>
                            <td>
                                    ${sessions[i].id}
                            </td>
                            <td>
                                    ${sessions[i].filmDto.id}
                            </td>
                            <td>
                                    ${sessions[i].hallDto.id}
                            </td>
                            <td>
                                    ${sessions[i].date}
                            </td>
                            <td>
                                <form action="/AdminSession" method="post">
                                    <button name="edit" value="${sessions[i].id}">edit</button>
                                    <button name="delete" value="${sessions[i].id}" >delete</button>
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
    <form action="/AdminSession" method="post">
        <p>Id Film: <input type="text" name="idFilm"></p>
        <p>Id Hall: <input type="text" name="idHall"></p>
        <p>Date realease: <input type="text" name="dateStart" value="format: dd.mm.yyyy"></p>
        <p><label name="result"></label></p>
        <input type="submit" name="AddSession" value="Add">
    </form>
</div>


<c:set value="${requestScope.session}" var="sessionEdit"/>
<div id="window" style="display: ${requestScope.display}">
    <img class="close" onclick="showClose('none')" src="/images/close.png">
    <form action="/AdminSession" method="post">
        <p>FilmId: <input type="text" name="idFilm" value="${sessionEdit.filmDto.id}"></p>
        <p>HallId: <input type="text" name="idHall" value="${sessionEdit.hallDto.id}"></p>
        <%--<p>Date Release: <input type="text" name="release" value=<%=((FilmDto)request.getAttribute("item")).getDescription().getRelease()%>></p>--%>
        <input type="hidden" name="id" value="${sessionEdit.id}">
        <input type="submit" value="Update" name="UpdateSession">
    </form>
</div>
</body>
</html>
