<%-- 
    Document   : register
    Created on : Sep 16, 2023, 5:23:05 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
<c:url value="/register" var="action"/>
<form:form modelAttribute="user" method="post" action="${action}" enctype="multipart/form-data">

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="username" placeholder="Tên đăng nhập" name="username" path="username"/>
        <label for="username">Tên đăng nhập</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password" path="password"/>
        <label for="password">Mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" id="confirm-password" placeholder="Xác nhận mật khẩu" name="confirm-password" path="confirmPassword"/>
        <label for="confirm-password">Xác nhận mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ho" placeholder="Họ" name="ho" path="ho"/>
        <label for="ho">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ten" placeholder="Tên" name="ten" path="ten"/>
        <label for="ten">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" placeholder="Hình đại diện" path="file"/>
        <label for="file">Hình đại diện</label>
    </div>
    <c:if test="${msg != null}">
        <div class="alert alert-danger">
            ${msg}
        </div>
    </c:if>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">Đăng ký</button>
    </div>
</form:form>

