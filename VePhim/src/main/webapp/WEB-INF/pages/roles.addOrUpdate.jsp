<%-- 
    Document   : roles.addOrUpdate
    Created on : Sep 1, 2023, 1:41:30 PM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ VAI TRÒ</h1>
<c:url value="/roles" var="action"/>
<form:form modelAttribute="role" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="vaiTroID" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tenVaiTro" placeholder="Tên vai trò" name="tenVaiTro" path="tenVaiTro"/>
        <label for="tenVaiTro">Tên vai trò</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${role.vaiTroID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>