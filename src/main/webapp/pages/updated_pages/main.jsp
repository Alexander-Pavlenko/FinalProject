<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 21.12.2016
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@include file='/pages/updated_pages/styles.css' %>
</style>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#myPage">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#myPage">HOME</a></li>
                <li><a href="#tour">FILMS</a></li>
                <%--IF SIGNED IN--%>
                <c:if test="${!empty sessionScope.user}">
                    <li><a href="/PersonalOffice">${sessionScope.user.login}</a></li>
                    <li><a href="/LogOut">LOGOUT</a></li>
                </c:if><%--IF !SIGNED IN--%>
                <c:if test="${empty sessionScope.user}">
                    <li><a href="/Login">LOGIN</a></li>
                    <li><a href="/Register">REGISTER</a></li>
                </c:if>
                <%--END IF--%>
            </ul>
        </div>
    </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <c:forEach var="i" begin="1" end="${requestScope.listBest.size() - 1}">
            <li data-target="#myCarousel" data-slide-to="${i}"></li>
        </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <c:set var="listBest" value="${requestScope.listBest}"></c:set>
        <div class="item active">
            <a href="/movie?id=${listBest[0].id}">
                <img src="/images/B${listBest[0].description.picture}" alt="${listBest[0].name}" width="1200" height="700">
            </a>
            <div class="carousel-caption">
                <a href="/movie?id=${listBest[0].id}">
                    <h3>${listBest[0].name}</h3>
                </a>
            </div>
        </div>
        <c:forEach var="i" end="${requestScope.listBest.size() - 1}" begin="1">
        <div class="item">
            <a href="/movie?id=${listBest[i].id}">
                <img src="/images/B${listBest[i].description.picture}" alt="${listBest[i].name}" width="1200" height="700">
            </a>
            <div class="carousel-caption">
                <a href="/movie?id=${listBest[i].id}">
                    <h3>${listBest[i].name}</h3>
                </a>
            </div>
        </div>
        </c:forEach>
    </div>

    <!-- Left and right controls -->

    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
    <div class="container">
        <h3 class="text-center">FILMS</h3>


        <div class="row text-center">

            <c:set var="movie" value="${requestScope.movieList}"></c:set>

            <c:forEach var="i" begin="0" end="2">
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="/images/${movie[i].description.picture}" width="400" height="300">
                    <p><strong>${movie[i].name}</strong></p>
                    <p>${movie[i].description.formatFilm}</p>
                    <form action='/movie' method="get">
                        <input type="hidden" name="id" value="${movie[i].id}">
                        <button class="btn">Read more</button>
                    </form>
                </div>
            </div>
            </c:forEach>
            <c:choose>
                <c:when test="${sessionScope.index == 0}">
                    <style>
                        .prev {
                            display: none;
                        }
                        .next{
                            display: block;
                        }
                    </style>
                </c:when>
                <c:when test="${sessionScope.index + 3 == sessionScope.maxSize}">
                    <style>
                        .prev {
                            display: block;
                        }
                        .next{
                            display: none;
                        }
                    </style>
                </c:when>
                <c:otherwise>
                    <style>
                        .prev {
                            display: block;
                        }
                        .next{
                            display: block;
                        }
                    </style>
                </c:otherwise>
            </c:choose>
            <form action="/HomePage">
                <p><button value="prev" class="prev" name="prev" style="background-color: #777; margin: auto">Prev</button>
                <button value="next" class="next" name="next" style="background-color: #777; margin: auto">Next</button>
                </p>
            </form>
        </div>

    </div>

</div>
<!-- Footer -->
<footer class="text-center">
    <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
        <span class="glyphicon glyphicon-chevron-up"></span>
    </a><br><br>
    <p>Film Portal by Sasha ©<a href="#" data-toggle="tooltip"></a></p>
</footer>

<script>
    $(document).ready(function(){
        // Initialize Tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Add smooth scrolling to all links in navbar + footer link
        $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

            // Make sure this.hash has a value before overriding default behavior
            if (this.hash !== "") {

                // Prevent default anchor click behavior
                event.preventDefault();

                // Store hash
                var hash = this.hash;

                // Using jQuery's animate() method to add smooth page scroll
                // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 900, function(){

                    // Add hash (#) to URL when done scrolling (default click behavior)
                    window.location.hash = hash;
                });
            } // End if
        });
    })
</script>

</body>
</html>
