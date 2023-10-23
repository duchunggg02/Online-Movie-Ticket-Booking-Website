<%-- 
    Document   : theaters.addOrUpdate
    Created on : Sep 1, 2023, 5:56:31 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ RẠP PHIM</h1>

<c:url value="/theaters" var="action"/>
<form:form modelAttribute="theater" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="rapPhimID"/>
    <form:hidden path="anhRap"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tenRapPhim" placeholder="Tên rạp phim" name="tenRapPhim" path="tenRapPhim"/>
        <label for="tenRapPhim">Tên rạp phim</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="diaChi" placeholder="Địa chỉ" name="diaChi" path="diaChi"/>
        <label for="diaChi">Địa chỉ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" placeholder="Ảnh rạp" path="file"/>
        <label for="file">Ảnh rạp</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${theater.rapPhimID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>