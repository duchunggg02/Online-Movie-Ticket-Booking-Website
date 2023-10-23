<%-- 
    Document   : login
    Created on : Sep 15, 2023, 4:23:45 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Enter email" name="username">
        <label for="username">Username</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        <label for="password">Password</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Đăng nhập" class="btn btn-danger" />
    </div>
</form>
