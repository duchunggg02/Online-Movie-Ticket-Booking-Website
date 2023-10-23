<%-- 
    Document   : feedbacks
    Created on : Sep 15, 2023, 10:57:23 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1>PHẢN HỒI</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Phản hồi</th>
                <th>Vé</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${feedbacks}" var="f">
                <tr>
                    <td>${f.phanHoiID}</td>
                    <td>${f.noiDung}</td>
                    <td>${f.veID.veID}</td>
                    <td>
                        <c:url value="/feedbacks/edit/${f.phanHoiID}" var="api"/>
                        <a href="${api}" class="btn btn-success">Sửa</a>
                        <button class="btn btn-danger" onclick="deleteApi('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>