<%-- 
    Document   : index
    Created on : Aug 21, 2023, 10:09:32 AM
    Author     : Duc Hung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<style>
    a {
        text-decoration: none;
    }
</style>


<h1 class="text-center mt-5">
    QUẢN TRỊ ADMIN
</h1>

<a href="<c:url value="/users"/>">QUẢN LÝ NGƯỜI DÙNG</a>
<br>
<a href="<c:url value="/roles"/>">QUẢN LÝ VAI TRÒ</a>
<br>
<a href="<c:url value="/theaters"/>">QUẢN LÝ RẠP PHIM</a>
<br>
<a href="<c:url value="/rooms"/>">QUẢN LÝ PHÒNG CHIẾU</a>
<br>
<a href="<c:url value="/movies"/>">QUẢN LÝ PHIM</a>
<br>
<a href="<c:url value="/showtimes"/>">QUẢN LÝ SUẤT CHIẾU</a>
<br>
<a href="<c:url value="/tickets"/>">QUẢN LÝ VÉ</a>
<br>
<a href="<c:url value="/feedbacks"/>">QUẢN LÝ PHẢN HỒI</a>
    
