<%-- 
    Document   : header
    Created on : Aug 31, 2023, 4:30:50 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${action}">VÉ PHIM</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}">TRANG CHỦ</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">ĐĂNG NHẬP</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/register" />">ĐĂNG KÝ</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <c:url value="/showtimes" var="movieAction"/>
            <form class="d-flex" action="${movieAction}">
                <input class="form-control me-2" type="text" name="phimID" placeholder="Tìm kiếm">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>