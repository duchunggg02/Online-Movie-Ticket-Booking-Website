<%-- 
    Document   : tickets.addOrUpdate
    Created on : Sep 8, 2023, 12:26:44 AM
    Author     : Duc Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>QUẢN TRỊ VÉ</h1>

<c:url value="/tickets" var="action"/>
<form:form modelAttribute="ticket" method="post" action="${action}" enctype="multipart/form-data">
    <form:hidden path="veID" />
    <div class="form-floating">
        <form:select class="form-select" id="nguoiDungID" name="nguoiDungID" path="nguoiDungID">
            <c:forEach items="${users}" var = "u">
                <c:choose>
                    <c:when test="${u.nguoiDungID == ticket.nguoiDungID.nguoiDungID}">
                        <option value="${u.nguoiDungID}" selected>${u.ten}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${u.nguoiDungID}">${u.ten}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="nguoiDungID" class="form-label">Người đặt</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="suatChieuID" name="suatChieuID" path="suatChieuID">
            <option value="${showtime.suatChieuID}" selected>${showtime.phimID.tenPhim}</option>
        </form:select>
        <label for="suatChieuID" class="form-label">Suất chiếu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ngayDat" placeholder="Ngày đặt" name="ngayDat" path="ngayDat"/>
        <label for="ngayDat">Ngày đặt</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="phuongThucThanhToan" placeholder="Phương thức thanh toán" name="phuongThucThanhToan" path="phuongThucThanhToan"/>
        <label for="phuongThucThanhToan">Phương thức thanh toán</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tinhTrang" placeholder="Tình trạng" name="tinhTrang" path="tinhTrang"/>
        <label for="tinhTrang">Tình trạng</label>
    </div>
    <div class="form-floating">
        <div class="seat-container">
            <c:forEach items="${seats}" var="seat">
                <label class="seat">
                    <c:choose>
                        <c:when test="${seat.trangThai == true}">
                            <input type="checkbox" id="choNgoiID_${seat.choNgoiSuatChieuID}" name="choNgoiSuatChieuID" value="${seat.choNgoiSuatChieuID}" disabled />
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" id="choNgoiID_${seat.choNgoiSuatChieuID}" name="choNgoiSuatChieuID" value="${seat.choNgoiSuatChieuID}" />
                        </c:otherwise>
                    </c:choose>
                    <span>${seat.choNgoiID.hang}</span>
                </label>
            </c:forEach>
        </div>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${ticket.veID != null}">
                    Sửa
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
<style>
    /* CSS để tạo giao diện ghế */
    .seat {
        display: inline-block;
        width: 30px;
        height: 30px;
        border: 1px solid #ccc;
        margin: 5px;
        text-align: center;
        line-height: 30px;
        cursor: pointer;
        background-color: #eee;
    }

    .selected {
        background-color: #ffcc00; /* Màu của ghế đã chọn */
    }

</style>
<script>
    const seats = document.querySelectorAll('.seat');
    const choNgoiIDField = document.getElementById('choNgoiSuatChieuID');

    seats.forEach(seat => {
        seat.addEventListener('click', () => {
            seat.classList.toggle('selected');
            updateSelectedSeats();
        });
    });

    function updateSelectedSeats() {
        const selectedSeats = document.querySelectorAll('.seat.selected');
        const selectedSeatIds = Array.from(selectedSeats).map(seat => seat.getAttribute('data-seat-id'));
        choNgoiIDField.value = selectedSeatIds.join(','); // Gắn danh sách các ghế đã chọn vào trường choNgoiID
    }
</script>


