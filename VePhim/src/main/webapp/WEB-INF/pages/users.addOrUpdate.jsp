<%-- 
    Document   : users.addOrUpdate
    Created on : Aug 31, 2023, 7:33:02 PM
    Author     : Duc Hung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center mt-5">QUẢN TRỊ NGƯỜI DÙNG</h1>
<c:url value="/users" var="action"/>
<form:form modelAttribute="user" method="post" action="${action}" enctype="multipart/form-data">
    
    <form:hidden path="nguoiDungID"/>
    <form:hidden path="hinhDaiDien"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="username" placeholder="Tên đăng nhập" name="username" path="username"/>
        <label for="username">Tên đăng nhập</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password" path="password"/>
        <label for="password">Mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ho" placeholder="Họ" name="ho" path="ho"/>
        <label for="ho">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ten" placeholder="Tên" name="ten" path="ten"/>
        <label for="ten">Tên</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="vaiTroID" name="vaiTroID" path="vaiTroID">
            <c:forEach items="${roles}" var = "r">
                <c:choose>
                    <c:when test="${r.vaiTroID == user.vaiTroID.vaiTroID}">
                        <option value="${r.vaiTroID}" selected>${r.tenVaiTro}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${r.vaiTroID}">${r.tenVaiTro}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="vaiTroID" class="form-label">Vai trò</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" placeholder="Hình đại diện" path="file"/>
        <label for="file">Hình đại diện</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${user.nguoiDungID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

