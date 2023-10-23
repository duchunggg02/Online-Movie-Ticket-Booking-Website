import { useContext, useEffect, useState } from "react";
import { Card, Col, Row } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const Showtime = () => {
    const [user, ] = useContext(MyUserContext)
    const {phimID} = useParams();
    const [showtime, setShowtime] = useState(null);

    useEffect(() => {
        const loadShowtime = async () => {
            try {
                let {data} =  await Apis.get(endpoint['showtimes'](phimID));               
                setShowtime(data);
            } catch (ex) {
                console.error(ex);
            }
        }

        loadShowtime();
    }, [])


    if (showtime === null) {
        return <MySpinner />
    }
    
    let urlLogin = `/login?next=/showtime/${phimID}`;
    return (
        <>
         <Row className="mt-5">
         {showtime.map(s => {
                let url = `/booking/${s.suatChieuID}`;
                return (
                 <Col xs={12} md={4} className="mt-2 d-flex justify-content-center" key={s.suatChieuID}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Body>
                            <Card.Title>{s.phimID.tenPhim}</Card.Title>
                            <Card.Subtitle className="mb-2 text-muted">{s.phongChieuID.rapPhimID.tenRapPhim}</Card.Subtitle>
                            <Card.Text>{s.phongChieuID.tenPhongChieu}</Card.Text>
                            <Card.Text><Moment format="DD/MM/YYYY" unix>{s.ngayChieu / 1000}</Moment></Card.Text>
                            <Card.Text>{s.gioChieu}</Card.Text>
                            <Card.Text>{s.giaTien} VNĐ</Card.Text>
                            {user === null ? (
                                <p>Vui lòng <Link to={urlLogin}>đăng nhập</Link> để đặt vé</p>
                            ) : (
                                <Link to={url} className="dropdown-item" key={s.suatChieuID}>MUA VÉ</Link>
                            )}
                        </Card.Body>
                    </Card>
                    </Col>
                )
            })}
                        </Row>
         
        </>
    )
}

export default Showtime;