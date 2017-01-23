<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 18.12.2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru" lang="ru">
<style>

    <%@include file='css/styleTicket.css' %>
</style>
<head>
    <title>Результат - Сайт</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>

</head>
<body>
<div id="middle">
    <div>
        <div>
            <div id="headerSetting">
                <form action="/HomePage">
                    <button type="submit">Main Page</button>
                </form>
            </div>
            <div id="content">
                <div class="cheque">
                    <c:forEach var="ticket" items="${requestScope.list}">
                    <div class="text">
                        <h3>
                            Кинобилет                   </h3>
                    </div>
                    <div class="blank electronic" data-doctype="travel">

                        <table>
                            <tr class="sizing">
                                <td style="width: 102px"></td>
                                <td style="width: 43px"></td>
                                <td style="width: 79px"></td>
                                <td style="width: 135px"></td>
                                <td style="width: 245px"></td>
                                <td style="width: 142px"></td>
                                <td style="width: 171px"></td>
                            </tr>
                            <tr>
                                <td colspan="3">Прізвище, Ім’я</td>
                                <td colspan="2">${ticket.userDto.firstName} ${ticket.userDto.lastName} </td>
                                <td>Залл</td>
                                <td class="align-right ticket_info w-right">
                                   ${ticket.sessionDto.hallDto.name}
                                </td>
                            </tr>
                            <tr>
                                <td class="nowrap w1" colspan="3">Кинотеатр</td>
                                <td class="upper ticket_info" colspan="2">MovieStory</td>
                                <td>Ряд</td>
                                <td class="align-right ticket_info">${ticket.place.column + 1}</td>
                            </tr>
                            <tr>
                                <td class="nowrap" colspan="3">Названия фильма</td>
                                <td class="upper ticket_info" colspan="2">${ticket.sessionDto.filmDto.name}</td>
                                <td>Місце</td>
                                <td class="align-right ticket_info">${ticket.place.row + 1  }</td>
                            </tr>
                            <tr>
                                <td colspan="3">Дата/час начала</td>
                                <td class="ticket_info" colspan="2">${ticket.sessionDto.date}</td>
                                <td>Цена</td>
                                <td class="align-right">${ticket.price}</td>
                            </tr>
                            <tr>
                                <td colspan="7" class="info arial">
                                    <p>Этот кинобилет является основанием для просмотра фильма без обращения в кассу. Билет является расчетным документом.</p>
                                    <p>Возвращение данного билета возможно до начала фильма.</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="clear page-break"></div>
                    </c:forEach>
                    <div class="clear"></div>

                    <div class="clear"></div>
                </div>

                <div class="clear"></div>
                <br/>
            </div>
        </div>
    </div>
</div>
</body>
</html>

