<%-- 
    Document   : feedbacks.addOrUpdate
    Created on : Sep 16, 2023, 12:10:42 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ PHẢN HỒI</h1>
<c:url value="/feedbacks" var="action"/>
<form:form modelAttribute="feedback" method="post" action="${action}" enctype="multipart/form-data">

    <form:hidden path="phanHoiID" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="noiDung" placeholder="Nội dung phản hồi" name="noiDung" path="noiDung"/>
        <label for="noiDung">Nội dung phản hồi</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select
            class="form-select"
            id="veID"
            name="veID"
            path="veID"
            >
            <option value="${feedback.veID.veID}" selected>
                ${feedback.veID.veID}
            </option>
        </form:select>
        <label for="veID">Vé</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${feedback.phanHoiID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>