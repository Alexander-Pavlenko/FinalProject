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
                    <input type="button" value="Add hall" onclick="show('block')">
                </div>
                <div class="button">
                    <form action="/AdminHall" method="post">
                        <button type="submit" name="viewHalls">View Halls</button>
                    </form>
                </div>
                <c:if test="${requestScope.listHalls!=null}">
                    <blockquote>
                        <table class="scrolling-table">
                            <thead>
                            <tr>
                                <th>
                                    idHall
                                </th>
                                <th>
                                    Title
                                </th>
                                <th>
                                    Columns
                                </th>
                                <th>
                                    Rows
                                </th>
                                <th>
                                    Edit
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="halls" value="${requestScope.listHalls}" scope="page"/>
                            <c:forEach var="i" begin="0" end="${requestScope.listHalls.size() - 1}">
                                <c:set var="item" value="${halls[i]}" scope="request"></c:set>
                                <tr>
                                    <td>
                                            ${halls[i].id}
                                    </td>
                                    <td>
                                            ${halls[i].name}
                                    </td>
                                    <td>
                                            ${halls[i].countColumn}
                                    </td>
                                    <td>
                                            ${halls[i].countRow}
                                    </td>
                                    <td>
                                        <form action="/AdminHall" method="post">
                                            <button name="delete" value="${halls[i].id}" >delete</button>
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
        <form action="/AdminHall" method="post">
            <p>Title: <input type="text" name="title"></p>
            <p>Columns: <input type="text" name="columns"></p>
            <p>Rows: <input type="text" name="rows"></p>
            <p>Price: <input type="text" name="price"></p>
            <p><label name="result"></label></p>
            <input type="submit" name="AddHall" value="Add">
        </form>
    </div>

</body>
</html>
