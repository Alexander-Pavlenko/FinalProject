<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 19.12.2016
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='styleWindow.css' %>
    <%@include file='../../WEB-INF/pages/style.css' %>
</style>
<script type="text/javascript">
    function showClose(state) {
        document.getElementById('window').style.display = state;
    }
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="container">


    <c:import url="/pages/AdminOffice/partJsp.jsp"></c:import>



    <div id="content" style="margin-right: 0px">
        <div class="ReadAllUser">
            <form action="/AdminUsers"  method="post">
                <input type="submit" name="viewUser" value="View Users">
            </form>
        </div>
<c:if test="${requestScope.userList!=null}">
        <blockquote>
            <table class="scrolling-table">
                <thead>
                <tr>
                    <th>
                        idUser
                    </th>
                    <th>
                        login
                    </th>
                    <th>
                        password
                    </th>
                    <th>
                        lastName
                    </th>
                    <th>
                        firstName
                    </th>
                    <th>
                        e-mail
                    </th>
                    <th>
                        isClient
                    </th>
                    <th>
                        Edit
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:set var="users" value="${requestScope.userList}" scope="page"/>
                <c:forEach var="i" begin="0" end="${requestScope.userList.size() - 1}">
                    <tr>
                        <td>
                                ${users[i].id}
                        </td>
                        <td>
                                ${users[i].login}
                        </td>
                        <td>
                                ${users[i].password}
                        </td>
                        <td>
                                ${users[i].firstName}
                        </td>
                        <td>
                                ${users[i].lastName}
                        </td>
                        <td>
                                ${users[i].e_mail}
                        </td>
                        <td>
                                ${users[i].isClient}
                        </td>
                        <td>
                            <form action="/AdminUsers" method="post">
                                <button name="edit" value="${users[i].id}">edit</button>
                                <button name="delete" value="${users[i].id}" >delete</button>
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
<c:set value="${requestScope.user}" var="userEdit"/>
<div id="window" style="display: ${requestScope.display}">
    <img class="close" onclick="showClose('none')" src="/images/close.png">
    <form action="/AdminUsers" method="post">

        <p>First Name: <input type="text" name="firstName" value="${userEdit.firstName}"></p>

        <p>Last Name: <input type="text" name="lastName" value="${userEdit.lastName}"></p>
        <p>Login: <input type="text" name="login" value="${userEdit.login}"></p>
        <p>Password: <input type="text" name="password" value="${userEdit.password}"></p>
        <p>E-mail: <input type="text" name="e_mail" value="${userEdit.e_mail}"></p>
        <p>IsAdmin: <input type="text" name="isClient" id="picture" value="${userEdit.isClient}"></p>
        <input type="hidden" name="id" value="${userEdit.id}">
        <input type="submit" value="Update" name="UpdateUser">
    </form>
</div>

</body>
</html>
