
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 19.12.2016
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>



</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/bootstrap.css' %>
    <%@include file='css/style.css' %>
    <%@include file='../AdminOffice/styleWindow.css' %>
</style>
<html>
<head>

    <title>Movie_store A Entertainment Category Flat Bootstarp Resposive Website Template | Register :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- start plugins -->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<style>
    table {
        border-spacing: 7px 5px; /* Расстояние между границ */
    }
    th{
        width: auto;
    }
    td {
        width: auto;
        border: 1px solid #333; /* Граница вокруг ячеек */
        padding: 5px; /* Поля в ячейках */
    }
</style>
<body>
<div class="container">

    <div class="container_wrap">
        <c:import url="/pages/updated_pages/utils/header.jsp"></c:import>
        <div class="content">
            <div class="register">
                <table  border-spacing: 10px 0px; >
                   <tr>
                       <td style="width: 300px">
                           <p>Name: ${sessionScope.user.firstName}</p>
                           <p>Last Name ${sessionScope.user.lastName}</p>
                           <p>Login: ${sessionScope.user.login}</p>
                           <p>E-mail: ${sessionScope.user.e_mail}</p>
                           <p>Money: ${sessionScope.user.money}</p>
                           <p>Discount: ${sessionScope.user.discount}</p>
                       </td>
                       <td>
                           <form action="PersonalOffice" method="post">
                               <input type="text" name="moneyAdd">
                               <button type="submit" name="Add">Add</button>
                           </form>

                           <form action="/PersonalOffice" method="post">
                               <button type="submit" value="${sessionScope.user.id}" name="viewHistory">Tickets</button>
                           </form>

                           <form action="/PersonalOffice" method="post">
                               <button type="submit" value="${sessionScope.user.id}" name="edit">Edit</button>
                           </form>
                           <c:if test="${!sessionScope.user.isClient}">
                               <form action="/AdminSetting" method="get" >
                                   <button name="adminOffice">Admin Office</button>
                               </form>
                           </c:if>
                       </td>
                       <td>
                           <c:if test="${requestScope.ticketDtoList!=null}">
                               <blockquote>
                                   <table class="scrolling-table">
                                       <thead>
                                       <tr>
                                           <th STYLE="width: auto">
                                               Film
                                           </th>
                                           <th STYLE="width: auto">
                                               Date
                                           </th>
                                           <th STYLE="width: auto">
                                               Column
                                           </th>
                                           <th STYLE="width: auto">
                                               Row
                                           </th>
                                           <th STYLE="width: auto">
                                               Price
                                           </th>
                                           <th STYLE="width: auto">
                                               Show
                                           </th>
                                       </tr>
                                       </thead>
                                       <tbody>
                                       <c:set var="tickets" value="${requestScope.ticketDtoList}" scope="page"/>
                                       <c:forEach var="i" begin="0" end="${requestScope.ticketDtoList.size() - 1}">
                                           <tr>
                                               <td STYLE="width: auto">
                                                       ${tickets[i].sessionDto.filmDto.name}
                                               </td>
                                               <td STYLE="width: auto">
                                                       ${tickets[i].sessionDto.date}
                                               </td>
                                               <td STYLE="width: auto">
                                                       ${tickets[i].place.column}
                                               </td>
                                               <td STYLE="width: auto">
                                                       ${tickets[i].place.row}
                                               </td>
                                               <td STYLE="width: auto">
                                                       ${tickets[i].price}
                                               </td>
                                               <td>
                                                   <form action="/PersonalOffice" method="post">
                                                       <button name="show" value="${tickets[i].id}">Open</button>
                                                   </form>

                                               </td>
                                           </tr>
                                       </c:forEach>

                                       </tbody>
                                   </table>
                               </blockquote>
                           </c:if>
                       </td>
                   </tr>
                </table>
                <div class="clearfix"> </div>
                <div class="register-but">

                </div>
            </div>
        </div>
    </div>
    <div id="window" style="display: ${requestScope.display}">
        <c:set var="userEdit" value="${sessionScope.user}"></c:set>
        <img class="close" onclick="showClose('none')" src="/images/close.png">
        <form action="/PersonalOffice" method="post">

            <p>First Name: <input type="text" name="firstName" value="${userEdit.firstName}"></p>

            <p>Last Name: <input type="text" name="lastName" value="${userEdit.lastName}"></p>
            <p>Login: <input type="text" name="login" value="${userEdit.login}"></p>
            <p>Password: <input type="text" name="password" value="${userEdit.password}"></p>
            <p>E-mail: <input type="text" name="e_mail" value="${userEdit.e_mail}"></p>
            <input type="hidden" name="id" value="${userEdit.id}">
            <input type="hidden" name="isClient" value="${userEdit.isClient}">
            <input type="hidden" name="URL" value="/pages/updated_pages/personalOffice.jsp">
            <input type="submit" value="Update" name="UpdateUser">
        </form>
    </div>
    <script type="text/javascript">
        function showClose(state) {
            document.getElementById('window').style.display = state;
        }
    </script>
    <div class="container">
        <footer id="footer">
            <div id="footer-3d">
                <div class="gp-container">
                    <span class="first-widget-bend"> </span>
                </div>
            </div>
        </footer>
    </div>
</div>
</body>

</html>