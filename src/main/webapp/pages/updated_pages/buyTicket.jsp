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
<style>
    table {
        border-spacing: 7px 5px; /* Расстояние между границ */
    }
    td {
        padding: 5px; /* Поля в ячейках */
    }

</style>
<body>
<div class="container">

    <div class="container_wrap">
        <c:import url="/pages/updated_pages/utils/header.jsp"></c:import>
        <div class="content">
            <div class="register">
                    <table style="margin: auto"; border-spacing: 10px 0px; >
                        <tr>
                            <td>
                                <div>
                                    <div class="screen">екран</div>
                                </div>
                    <div id="content" style="text-align: center">
                        <c:set var="hallTest" value="test"/>

                        <c:set var="hall" value="${requestScope.hall}"/>
                                    <c:forEach var="i" begin="0" end="${requestScope.column-1}">
                                        ${i+1}
                                            <c:forEach var="j" begin="0" end="${requestScope.row-1}">

                                                <c:if test="${hall[i][j].state eq 'FREE'}">
                                                    <c:set var="stateButt" value=''></c:set>
                                                    <c:set var="image" value="/images/bullet_black.png"></c:set>
                                                </c:if>
                                                <c:if test="${hall[i][j].state eq 'BUSY'}">
                                                    <c:set var="stateButt" value='disabled'></c:set>
                                                    <c:set var="image" value="/images/seat-occupied.png"></c:set>
                                                </c:if>
                                                <button id="Submit${i}${j}" name="place" onclick="addElement(${i},${j})" value="${j + 1}" ${stateButt}><img src="${image}" title="Column: ${i}, Row: ${j} "></button>
                                            </c:forEach>
                                        <p></p>
                                    </c:forEach>

                    </div>
                                <c:if test="${requestScope.message != null}">
                                    <c:set var="stateButt1" value='disabled'></c:set>
                                </c:if>
                        <form action="/buyServlet" method="post" style="text-align: center; margin: 10px">
                            <input type="hidden" name="tickets-list" value="qwerr">
                            <input type="submit" value="Buy" ${stateButt1} onclick="BuyTicket()">
                            <div class="clearfix"> </div>
                        </form>
                                <div>
                                    <span>${requestScope.message}</span>
                                </div>
                                </td>
                        <td>
                            <div id="list">

                            </div>
                        </td>
                    </tr>
                </table>
                <div class="clearfix"> </div>
                <span>${sessionScope.get("message")}</span>
                <div class="clearfix"> </div>
                <div class="register-but">

                </div>
            </div>
        </div>
    </div>
    <script>
        var array = [];
        function addElement(i,j) {
            if(document.getElementsByName("Ticket").length < ${requestScope.column + 3}) {
                $(document.getElementById('list')).after('<div name ="Ticket" id=' + i + "|" + j + '><button name="close" onclick="deleteElement(' + "" + i + "," + j + ')"><img src="/images/favicon.ico"></button>  <span>Column' + (i + 1) + ', Row' + (j + 1) + '</span></div>');
                $(document.getElementById('Submit' + i + "" + j))[0].disabled = true;
            }
            else {
                alert("This is max count ticket, what can you buy");
            }
        }
        function deleteElement(i,j) {
            var elem1 = $(document.getElementById(i+"|"+j));
            elem1[0].parentNode.removeChild(elem1[0]);
            $(document.getElementById('Submit'+i+""+j))[0].disabled=false;
        }
        function BuyTicket() {
            var list = $(document.getElementsByName("Ticket"));
            list = [].slice.call(list);

            list.forEach(function(v,i,a) {
                array.push(v.id);
            });
            document.getElementsByName('tickets-list')[0].value = array;
            alert(array);
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