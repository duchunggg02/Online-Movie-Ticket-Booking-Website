<%-- 
    Document   : movies.addOrUpdate
    Created on : Sep 2, 2023, 1:43:07 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>QUẢN TRỊ PHIM</h1>
<c:url value="/movies" var="action"/>
<form:form modelAttribute="movie" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="phimID" />
    <form:hidden path="anhPhim" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tenPhim" placeholder="Tên phim" name="tenPhim" path="tenPhim"/>
        <label for="tenPhim">Tên phim</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="moTa" placeholder="Mô tả" name="moTa" path="moTa"/>
        <label for="moTa">Mô tả</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ngayPhatHanh" placeholder="Ngày phát hành" name="ngayPhatHanh" path="ngayPhatHanh"/>
        <label for="ngayPhatHanh">Ngày phát hành</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="thoiLuong" placeholder="Thời lượng" name="thoiLuong" path="thoiLuong"/>
        <label for="thoiLuong">Thời lượng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" placeholder="Ảnh phim" path="file"/>
        <label for="file">Ảnh phim</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${movie.phimID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

<script>
    $(document).ready(function () {
        $("#ngayPhatHanh").datepicker({
            dateFormat: "yy-mm-dd" // Định dạng ngày: yyyy-mm-dd
        });
    });
</script>
