<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header_top">
    <div class="col-sm-3 logo"><a href="/HomePage"><img src="images/logo.png" alt=""/></a></div>
    <div class="col-sm-3 header_right" style="float: right;">
        <c:if test="${!empty sessionScope.user}">
            <c:set var="action" value="/LogOut"></c:set>
        </c:if><%--IF !SIGNED IN--%>
        <c:if test="${empty sessionScope.user}">
            <c:set var="action" value="/Login"></c:set>
        </c:if>
            <ul class="header_right_box">
                <a href="/PersonalOffice">
                    <li><p>${param.name}</p></li>
                </a>
                <a href="${action}">
                    <li class="last"><i class="edit"></i></li>
                </a>
                <div class="clearfix"> </div>
            </ul>

    </div>
    <div class="clearfix"> </div>
</div>
