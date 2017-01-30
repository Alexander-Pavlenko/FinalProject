<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 19.12.2016
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<style>
    <%@include file='../updated_pages/css/style1.css' %>
</style>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="container">

    <c:import url="/pages/AdminOffice/partJsp.jsp"></c:import>

    <div id="content">
        <p>${sessionScope.user.login}</p>
    </div>

    <c:import url="/pages/AdminOffice/part1Jsp.jsp"></c:import>



</div>

</body>
</html>
