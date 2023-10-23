<%-- 
    Document   : ghe
    Created on : Sep 6, 2023, 1:53:52 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Danh sách ghế</h1>
<table>
    <thead>
        <tr>
            <th>STT</th>
            <th>Hàng</th>
            <th>Ghế</th>
            <th>Phòng chiếu</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="chongoi" items="${chongoiList}">
            <tr>
                <td>${chongoi.choNgoiID}</td>
                <td>${chongoi.hang}</td>
                <td>${chongoi.ghe}</td>
                <td>${chongoi.phongChieuID.tenPhongChieu}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
