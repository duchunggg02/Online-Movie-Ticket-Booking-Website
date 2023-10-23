import { useContext, useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useNavigate, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const UserDetail = () => {

    const [user, ] = useContext(MyUserContext)
    const nav = useNavigate()
    const {nguoiDungID} = useParams()
    const [ticket, setTicket] = useState(null)
  
    useEffect(() => {

        const loadTicket = async () => {
            try {
                let {data} =  await Apis.get(endpoint['ticket'](nguoiDungID));               
                setTicket(data);
            } catch (ex) {
                console.error(ex);
            }
        }

        loadTicket();

        if (user === null) {
            nav("/")
        }
    }, [user, nav])

   
    if (ticket === null) {
        return <MySpinner />
    }

    return (
        <>
            <h1>ĐÂY LÀ TRANG USER DETAIL</h1>

            <h2>Vé</h2>
            {/* <ul>
                {ticket.map(t => {
                      let url = `/ticket/${t.veID}`;
                return (
                <li key={t.veID}>
                    {t.ngayDat}
                    {t.phuongThucThanhToan}
                    {t.suatChieuID.phimID.tenPhim}
                    <Link to={url} className="dropdown-item" key={t.veID}>CHI TIẾT VÉ</Link>
                </li>)
                })}
            </ul> */}
             <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Ngày đặt</th>
                        <th>Phương thức thanh toán</th>
                        <th>Phim</th>
                        <th>Suất chiếu</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {ticket.map((t) => {
                        let url = `/ticket/${t.veID}`;
                        return (
                            <tr key={t.veID}>
                                <td><Moment format="DD/MM/YYYY" unix>
                                    {t.ngayDat / 1000} 
                                </Moment></td>
                                <td>{t.phuongThucThanhToan}</td>
                                <td>{t.suatChieuID.phimID.tenPhim}</td>
                                <td>{t.suatChieuID.phongChieuID.tenPhongChieu}, {t.suatChieuID.phongChieuID.rapPhimID.tenRapPhim}</td>
                                <td>
                                    <Link to={url} className="btn btn-primary">
                                        CHI TIẾT VÉ
                                    </Link>
                                </td>
                            </tr>
                        );
                    })}
                </tbody>
            </Table>
        </>
    )
}

export default UserDetail;