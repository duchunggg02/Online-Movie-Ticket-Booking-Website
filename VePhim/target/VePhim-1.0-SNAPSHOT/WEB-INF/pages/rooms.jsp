<%-- 
    Document   : rooms
    Created on : Sep 4, 2023, 1:36:47 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1>PHÒNG CHIẾU</h1>
    <div>
        <a href="<c:url value="/rooms/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên phòng chiếu</th>
                <th>Số lượng ghế</th>
                <th>Rạp</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rooms}" var="r">
                <tr>
                    <td>${r.phongChieuID}</td>
                    <td>${r.tenPhongChieu}</td>
                    <td>${r.soLuongGhe}</td>
                    <td>${r.rapPhimID.tenRapPhim}</td>
                    <td>
                        <c:url value="/rooms/edit/${r.phongChieuID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>