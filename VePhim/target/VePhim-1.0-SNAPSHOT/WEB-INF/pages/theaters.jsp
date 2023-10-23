<%-- 
    Document   : theaters
    Created on : Sep 1, 2023, 4:43:15 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container">
    <h1>RẠP PHIM</h1>
    <div>
        <a href="<c:url value="/theaters/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Mã</th>
                <th>Tên rạp</th>
                <th>Địa chỉ</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${theaters}" var="t">
                <tr>
                    <td>
                        <img src="${t.anhRap}" alt="${t.tenRapPhim}" width="120"/>
                    </td>
                    <td>${t.rapPhimID}</td>
                    <td>${t.tenRapPhim}</td>
                    <td>${t.diaChi}</td>
                    <td>
                        <c:url value="/theaters/edit/${t.rapPhimID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>