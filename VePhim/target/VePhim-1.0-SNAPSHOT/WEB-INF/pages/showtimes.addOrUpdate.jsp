<%-- 
    Document   : showtimes.addOrUpdate
    Created on : Sep 5, 2023, 6:40:15 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ SUẤT CHIẾU</h1>
<c:url value="/showtimes" var="action"/>
<form:form modelAttribute="showtime" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="suatChieuID" />
    <div class="form-floating">
        <form:select class="form-select" id="phimID" name="phimID" path="phimID">
            <c:forEach items="${movies}" var = "m">
                <c:choose>
                    <c:when test="${m.phimID == showtime.phimID.phimID}">
                        <option value="${m.phimID}" selected>${m.tenPhim}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${m.phimID}">${m.tenPhim}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="phimID" class="form-label">Tên phim</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="phongChieuID" name="phongChieuID" path="phongChieuID">
            <c:forEach items="${rooms}" var = "r">
                <c:choose>
                    <c:when test="${r.phongChieuID == showtime.phongChieuID.phongChieuID}">
                        <option value="${r.phongChieuID}" selected>${r.tenPhongChieu} - ${r.rapPhimID.tenRapPhim}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${r.phongChieuID}">${r.tenPhongChieu} - ${r.rapPhimID.tenRapPhim}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="phongChieuID" class="form-label">Tên phòng chiếu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ngayChieu" placeholder="Ngày chiếu" name="ngayChieu" path="ngayChieu"/>
        <label for="ngayChieu">Ngày chiếu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="gioChieu" placeholder="Giờ chiếu" name="gioChieu" path="gioChieu"/>
        <label for="gioChieu">Giờ chiếu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="giaTien" placeholder="Giá tiền" name="giaTien" path="giaTien"/>
        <label for="giaTien">Giá tiền</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${showtime.suatChieuID != null}">
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
        $("#ngayChieu").datepicker({
            dateFormat: "yy-mm-dd" // Định dạng ngày: yyyy-mm-dd
        });
    });
</script>
