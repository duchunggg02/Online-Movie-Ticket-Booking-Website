<%-- 
    Document   : movies
    Created on : Sep 1, 2023, 8:07:02 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1>PHIM</h1>
    <div>
        <a href="<c:url value="/movies/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Mã</th>
                <th>Tên phim</th>
                <th>Mô tả</th>
                <th>Ngày phát hành</th>
                <th>Thời lượng</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movies}" var="m">
                <tr>
                    <td>
                        <img src="${m.anhPhim}" alt="${m.tenPhim}" width="120"/>
                    </td>
                    <td>${m.phimID}</td>
                    <td>${m.tenPhim}</td>
                    <td>${m.moTa}</td>
                    <td>${m.ngayPhatHanh}</td>
                    <td>${m.thoiLuong}</td>
                    <td>
                        <c:url value="/movies/edit/${m.phimID}" var="api" />
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>