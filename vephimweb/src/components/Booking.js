import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import Moment from "react-moment";
import { useNavigate, useParams } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Apis, { authApi, endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import './booking.css';


const Booking = () => {

    const nav = useNavigate();
    const {suatChieuID} = useParams();
    const [seat, setSeat] = useState(null);
    const [showtime, setShowtime] = useState(null);
    const [selectedSeats, setSelectedSeats] = useState([]);
    const seatsPerRow = 10; // Số ghế mỗi hàng
    const [selectedSeatCount, setSelectedSeatCount] = useState(0);
    const [totalPrice, setTotalPrice] = useState(0);







    useEffect(() => {
        const loadSeat = async () => {
            try {
                let {data} =  await Apis.get(endpoint['seats'](suatChieuID));               
                setSeat(data);
            } catch (ex) {
                console.error(ex);
            }
        }

        const loadShowtime = async () => {
            try {
            let {data} = await Apis.get(endpoint['showtimes_id'](suatChieuID));
            setShowtime(data); 
        } catch (ex) {
            console.error(ex);
        }
        }
        loadSeat();
        loadShowtime();
     
    }, [])

    if (seat === null) {
        return <MySpinner />
    }

    
    const addTicket = () => {
        if (selectedSeats.length === 0) {
            // Hiển thị thông báo lỗi nếu không có ghế nào được chọn
            toast.error("Vui lòng chọn ít nhất một ghế trước khi đặt vé.");
            return;
        }
        const process = async () => {
            try {
                const requestData = {
                    suatChieuID: showtime.suatChieuID, // Chỉ truyền suatChieuID
                    selectedSeatIds: selectedSeats
                };
    
                let res = await authApi().post(endpoint['booking-ticket'], requestData);
                if(res.status === 201) {
                    toast.success('Đặt vé thành công!');
                    setTimeout(() => {
                        nav('/');
                      }, 3000);
                }
            } catch (ex) {
                console.error(ex);
            }
        };
    
        process();
    };

    const handleSeatSelection = (seatId) => {
        // Kiểm tra xem ghế đã được chọn hay chưa
        const isSeatSelected = selectedSeats.includes(seatId);
    
        let updatedSelectedSeats;
        if (isSeatSelected) {
            // Nếu ghế đã được chọn, hủy chọn nó bằng cách loại bỏ seatId khỏi danh sách
            updatedSelectedSeats = selectedSeats.filter((id) => id !== seatId);
            setSelectedSeats(updatedSelectedSeats);
            
        } else {
            // Nếu ghế chưa được chọn, thêm nó vào danh sách
            updatedSelectedSeats = [...selectedSeats, seatId];
            setSelectedSeats([...selectedSeats, seatId]);
        }
        const giaTien = showtime.giaTien; // Giá tiền của một ghế
        const tongGiaTien = giaTien * updatedSelectedSeats.length; 
        
        setSelectedSeatCount(updatedSelectedSeats.length);
        setTotalPrice(tongGiaTien); // Cập nhật tổng tiền
    };
    
    const rows = Math.ceil(seat.length / seatsPerRow); // Số hàng cần hiển thị

    const seatRows = [];
    
    for (let i = 0; i < rows; i++) {
      const rowSeats = seat.slice(i * seatsPerRow, (i + 1) * seatsPerRow);
      seatRows.push(rowSeats);
    }
    
    return (
        <>
     
     <div className="booking-header">
                <h3>BOOKING ONLINE</h3>
            </div>
         <div>
    <p style={{ fontWeight: 'bold' }}>{showtime.phongChieuID.rapPhimID.tenRapPhim} | {showtime.phongChieuID.tenPhongChieu} | Số ghế: {showtime.phongChieuID.soLuongGhe}</p>
    <p style={{ fontWeight: 'bold' }}>{showtime.phimID.tenPhim} | <Moment format="DD/MM/YYYY" unix>{showtime.ngayChieu / 1000}</Moment> {showtime.gioChieu}</p>
</div>
    
        <hr />

       <div className="screen-container">
        
                <p className="screen-text">SCREEN</p>
            </div>
            {seatRows.map((rowSeats, rowIndex) => (
  <div key={rowIndex} className="seat-row">
    {rowSeats.map((seat) => (
      <li
        key={seat.choNgoiSuatChieuID}
        className={`seat-item ${seat.trangThai ? 'disabled' : ''} ${selectedSeats.includes(seat.choNgoiSuatChieuID) ? 'selected' : ''}`}
      >
        <label>
          <input
            type="checkbox"
            value={seat.choNgoiSuatChieuID}
            checked={selectedSeats.includes(seat.choNgoiSuatChieuID)}
            onChange={() => handleSeatSelection(seat.choNgoiSuatChieuID)}
            disabled={seat.trangThai}
          />
          {seat.choNgoiID.soGhe}
        </label>
      </li>
    ))}
  </div>
))}




            <div className="text-center">
                <p>Số ghế đã chọn: {selectedSeatCount}</p>
                <p>Tổng: {totalPrice} VNĐ</p>
                <Button  onClick={addTicket} variant="primary" type="submit">ĐẶT VÉ</Button>
            </div>
            <ToastContainer />

                

        </>
    )
}

export default Booking;