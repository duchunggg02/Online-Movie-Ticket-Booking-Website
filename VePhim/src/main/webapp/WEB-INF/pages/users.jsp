<%-- 
    Document   : users
    Created on : Aug 21, 2023, 8:34:17 PM
    Author     : Duc Hung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center mt-5">NGƯỜI DÙNG</h1>
    <div>
        <a href="<c:url value="/users/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Mã</th>
                <th>Tên đăng nhập</th>
                <th>Mật khẩu</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Vai trò</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>
                        <img src="${u.hinhDaiDien}" alt="${u.ten}" width="120"/>
                    </td>
                    <td>${u.nguoiDungID}</td>
                    <td>${u.username}</td>
                    <td>${u.password}</td>
                    <td>${u.ho}</td>
                    <td>${u.ten}</td>
                    <td>${u.vaiTroID.tenVaiTro}</td>
                    <td>
                        <c:url value="/users/edit/${u.nguoiDungID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>