<%-- 
    Document   : showtimes
    Created on : Sep 4, 2023, 5:58:16 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1>SUẤT CHIẾU</h1>
    <div>
        <a href="<c:url value="/showtimes/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên phim</th>
                <th>Tên phòng chiếu</th>
                <th>Tên rạp</th>
                <th>Ngày chiếu</th>
                <th>Giờ chiếu</th>
                <th>Giá tiền</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${showtimes}" var="s">
                <tr>
                    <td>${s.suatChieuID}</td>
                    <td>${s.phimID.tenPhim}</td>
                    <td>${s.phongChieuID.tenPhongChieu}</td>
                    <td>${s.phongChieuID.rapPhimID.tenRapPhim}</td>
                    <td>${s.ngayChieu}</td>
                    <td>${s.gioChieu}</td>
                    <td>${s.giaTien}</td>
                    <td>
                        <c:url value="/showtimes/edit/${s.suatChieuID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                        <a href="<c:url value="/tickets/booking/${s.suatChieuID}"/>" class="btn btn-primary">Đặt vé</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>