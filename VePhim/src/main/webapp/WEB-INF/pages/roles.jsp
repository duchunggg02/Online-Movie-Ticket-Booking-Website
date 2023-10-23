<%-- 
    Document   : roles
    Created on : Sep 1, 2023, 1:28:15 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section class="container">
    <h1>VAI TRÒ</h1>
    <div>
        <a href="<c:url value="/roles/add"/>" class="btn btn-info mt-1">Thêm</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên vai trò</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${roles}" var="r">
                <tr>
                    <td>${r.vaiTroID}</td>
                    <td>${r.tenVaiTro}</td>
                    <td>
                        <c:url value="/roles/edit/${r.vaiTroID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>