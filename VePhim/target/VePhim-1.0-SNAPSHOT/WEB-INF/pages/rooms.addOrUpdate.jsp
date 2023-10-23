<%-- 
    Document   : rooms.addOrUpdate
    Created on : Sep 4, 2023, 2:20:24 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ PHÒNG CHIẾU</h1>
<c:url value="/rooms" var="action"/>
<form:form modelAttribute="room" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="phongChieuID" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tenPhongChieu" placeholder="Tên phòng chiếu" name="tenPhongChieu" path="tenPhongChieu"/>
        <label for="tenPhongChieu">Tên phòng chiếu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" id="soLuongGhe" placeholder="Số lượng ghế" name="soLuongGhe" path="soLuongGhe"/>
        <label for="soLuongGhe">Số lượng ghế</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="rapPhimID" name="rapPhimID" path="rapPhimID">
            <c:forEach items="${theaters}" var = "t">
                <c:choose>
                    <c:when test="${t.rapPhimID == room.rapPhimID.rapPhimID}">
                        <option value="${t.rapPhimID}" selected>${t.tenRapPhim}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.rapPhimID}">${t.tenRapPhim}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="rapPhimID" class="form-label">Tên rạp</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${room.phongChieuID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>