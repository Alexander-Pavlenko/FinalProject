<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 23.12.2016
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/bootstrap.css' %>
    <%@include file='css/style.css' %>
</style>

<html>
<head>
    <title>Movie_store A Entertainment Category Flat Bootstarp Resposive Website Template | Login :: w3layouts</title>
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
<body>
<div class="container">
    <div class="container_wrap">
        <c:import url="/pages/updated_pages/utils/header.jsp">

        </c:import>
        <div class="content">
            <div class="register">
                <div class="col-md-6 login-left">
                    <h3>New Customers</h3>
                    <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                    <a class="acount-btn" href="/Register">Create an Account</a>
                </div>
                <div class="col-md-6 login-right">
                    <h3>Registered Customers</h3>
                    <c:if test="${sessionScope.get('message') != null}">
                        <p>If you want byu ticket, ${sessionScope.get('message')}.</p>
                    </c:if>
                    <c:if test="${sessionScope.get('message') == null}">
                    <p>If you have an account with us, please log in.</p>
                    </c:if>

                    <form action="/Login" method="post">
                        <div>
                            <span>Email Address<label>*</label></span>
                            <input type="text" name="login">
                        </div>
                        <div>
                            <span>Password<label>*</label></span>
                            <input type="password" name="password">
                        </div>
                        <input type="submit" value="Login">
                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <footer id="footer">
        <div id="footer-3d">
            <div class="gp-container">
                <span class="first-widget-bend"> </span>
            </div>
        </div>
    </footer>
</div>
</body>
</html>