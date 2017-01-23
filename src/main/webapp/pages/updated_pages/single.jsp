<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 23.12.2016
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='css/bootstrap.css' %>
    <%@include file='css/style.css' %>
</style>

<html>
<head>
    <title>Movie_store A Entertainment Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- start plugins -->
    <script type="text/javascript" src="../../../js/jquery-1.11.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <c:import url="/pages/updated_pages/utils/header.jsp">
            <c:param name="name" value="${sessionScope.user.login}"></c:param>
        </c:import>
        <div class="content">
            <div class="movie_top">
                <div class="col-md-9 movie_box">
                    <div class="grid images_3_of_2">
                        <div class="movie_image">
                            <span class="movie_rating">5.0</span>
                            <img src="../../../images/${requestScope.movie.description.picture}" class="img-responsive" alt=""/>
                        </div>

                    </div>
                    <div class="desc1 span_3_of_2">
                        <p class="movie_option"><strong>Title: </strong><a href="#">${requestScope.movie.name}</a>, <a href="#">USA</a></p>
                        <p class="movie_option"><strong>Format film: </strong><a href="#">${requestScope.movie.description.formatFilm} </a></p>
                        <p class="movie_option"><strong>Duration: </strong>${requestScope.movie.description.duration}</p>

                    </div>

                    <div class="clearfix"> </div>
                    <div class="desc1 span_3_of_2" style="margin-top: 15px;">
                        <p class="movie_option"><strong>Sesions: </strong>
                            <c:forEach var="session" items="${requestScope.sessions}">
                                <p class="movie_option"><a href="/sessionServlet?id=${session.hallDto.id}&idSession=${session.id}">${session.date}</a>...........${session.hallDto.name}</p>
                            </c:forEach>
                    </div>
                    <div class="clearfix"> </div>

                    <p class="m_4">${requestScope.movie.description.miniDescription}</p>
                    <div class="single">
                        <h1>10 Comments</h1>
                        <ul class="single_list">
                            <li>
                                <div class="preview"><a href="#"><img src="../../../images/2.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data">
                                    <div class="title">Movie  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                            <li>
                                <div class="preview"><a href="#"><img src="../../../images/3.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data">
                                    <div class="title">Wernay  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent </p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                            <li>
                                <div class="preview"><a href="#"><img src="../../../images/4.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data">
                                    <div class="title">mr.dev  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram,</p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                            <li class="middle">
                                <div class="preview"><a href="#"><img src="../../../images/5.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data-middle">
                                    <div class="title">Wernay  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                            <li class="last-comment">
                                <div class="preview"><a href="#"><img src="../../../images/6.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data-last">
                                    <div class="title">mr.dev  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit </p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                            <li>
                                <div class="preview"><a href="#"><img src="../../../images/7.jpg" class="img-responsive" alt=""></a></div>
                                <div class="data">
                                    <div class="title">denpro  /  2 hours ago  /  <a href="#">reply</a></div>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                                </div>
                                <div class="clearfix"></div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="movie_img"><div class="grid_2">
                        <img src="../../../images/pic6.jpg" class="img-responsive" alt="">
                        <div class="caption1">
                            <ul class="list_5 list_7">
                                <li><i class="icon5"> </i><p>3,548</p></li>
                            </ul>
                            <i class="icon4 icon6 icon7"> </i>
                            <p class="m_3">Guardians of the Galaxy</p>
                        </div>
                    </div>
                    </div>
                    <div class="grid_2 col_1">
                        <img src="../../../images/pic2.jpg" class="img-responsive" alt="">
                        <div class="caption1">
                            <ul class="list_3 list_7">
                                <li><i class="icon5"> </i><p>3,548</p></li>
                            </ul>
                            <i class="icon4 icon7"> </i>
                            <p class="m_3">Guardians of the Galaxy</p>
                        </div>
                    </div>
                    <div class="grid_2 col_1">
                        <img src="../../../images/pic9.jpg" class="img-responsive" alt="">
                        <div class="caption1">
                            <ul class="list_3 list_7">
                                <li><i class="icon5"> </i><p>3,548</p></li>
                            </ul>
                            <i class="icon4 icon7"> </i>
                            <p class="m_3">Guardians of the Galaxy</p>
                        </div>
                    </div>
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