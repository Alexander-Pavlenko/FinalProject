<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 23.12.2016
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/bootstrap.css' %>
    <%@include file='css/style.css' %>
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
<body>
<div class="container">
    <div class="container_wrap">
        <c:import url="/pages/updated_pages/utils/header.jsp"></c:import>
        <div class="content">
            <div class="register">
                <form action="/Register" method="post">
                    <div class="register-top-grid">
                        <h3>Personal Information</h3>
                        <div>
                            <span>First Name<label>*</label></span>
                            <input type="text" name="firstName">
                        </div>
                        <div>
                            <span>Last Name<label>*</label></span>
                            <input type="text" name="lastName">
                        </div>
                        <div>
                            <span>Email Address<label>*</label></span>
                            <input type="text" name="e_mail">
                        </div>
                        <div class="clearfix"> </div>
                        <a class="news-letter" href="#">
                            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
                        </a>
                    </div>
                    <div class="register-bottom-grid">
                        <h3>Login Information</h3>
                        <div>
                            <span>Login<label>*</label></span>
                            <input type="text" name="login">
                        </div>
                        <div>
                            <span>Password<label>*</label></span>
                            <input type="text" name="password">
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                <div class="clearfix"> </div>
                <div class="register-but">

                    <button type="submit" value="submit">Register</button>
                        <div class="clearfix"> </div>

                </div>
                </form>
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