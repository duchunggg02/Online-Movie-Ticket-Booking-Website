<%-- 
    Document   : tickets
    Created on : Sep 6, 2023, 6:33:39 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1>VÉ</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Suất chiếu</th>
                <th>Ngày đặt</th>
                <th>Phương thức thanh toán</th>
                <th>Người đặt</th>
                <th>Tình trạng</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tickets}" var="t">
                <tr>
                    <td>${t.veID}</td>
                    <td>${t.suatChieuID.phimID.tenPhim}</td>
                    <td>${t.ngayDat}</td>
                    <td>${t.phuongThucThanhToan}</td>
                    <td>${t.nguoiDungID.ten}</td>
                    <td>${t.tinhTrang}</td>
                    <td>
                        <c:url value="/tickets/edit/${t.veID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                        <a href="<c:url value="/feedbacks/add?ticketId=${t.veID}"/>" class="btn btn-primary">Phản hồi</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>