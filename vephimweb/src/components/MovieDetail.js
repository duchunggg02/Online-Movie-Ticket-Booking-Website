    import { useEffect, useState } from "react";
import { Alert, Col, Image, ListGroup, Pagination, Row } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useParams } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

    const MovieDetail = () => {

        const {phimID} = useParams();
        const [movie, setMovie] = useState(null);
        const [feedback, setFeedback] = useState([]);
        const [currentPage, setCurrentPage] = useState(1);
        const itemsPerPage = 4;

        useEffect(() => {
            const loadMovie = async () => {
                try {
                    let {data} = await Apis.get(endpoint['movies_detail'](phimID));
                    setMovie(data);
                } catch (ex) {
                    console.error(ex);
                }
            }

            const loadFeedback = async () => {
                try {
                    let {data} = await Apis.get(endpoint['feedbacks'](phimID));
                    setFeedback(data);
                } catch (ex) {
                    console.error(ex);
                }
            }

            loadMovie();
            loadFeedback();
        }, []);

        const indexOfLastFeedback = currentPage * itemsPerPage;
        const indexOfFirstFeedback = indexOfLastFeedback - itemsPerPage;
        const currentFeedback = feedback.slice(indexOfFirstFeedback, indexOfLastFeedback);

        const paginate = (pageNumber) => {
            setCurrentPage(pageNumber);
        }

        if(movie === null) {
            return <MySpinner />
        }

        if(feedback === null) {
            return <MySpinner />
        }

        let urlShowtime = `/showtime/${movie.phimID}`;

        return (
            <>
                <h2 className="mt-2 text-primary">Nội Dung Phim</h2>
                <hr style={{ height: '2px', backgroundColor: '#000000', border: 'none' }} />

                <Row>
                    <Col md={5} xs={6}>
                        <Image src={movie.anhPhim} rounded fluid />
                    </Col>
                    <Col md={5} xs={6}>
                        <h2 style={{ textTransform: 'uppercase' }} className="text-primary">{movie.tenPhim}</h2>
                        <hr/>
                        <p><strong>Mô tả:</strong> {movie.moTa}</p>
                        <p><strong>Thời lượng:</strong> {movie.thoiLuong}</p>
                        <p><strong>Khởi chiếu:</strong> <Moment format="DD/MM/YYYY" unix>{movie.ngayPhatHanh / 1000}</Moment></p>
                        <Link to={urlShowtime} className="dropdown-item" key={movie.phimID}>ĐẶT VÉ</Link>
                    </Col>
                </Row>

            
        
                <h4 className="mt-5">Các đánh giá về phim {movie.tenPhim}</h4>
    
            
                <Pagination className="mt-2">
                    <Pagination.Prev onClick={() => paginate(currentPage - 1)} disabled={currentPage === 1} />
                    {Array.from({ length: Math.ceil(feedback.length / itemsPerPage) }, (_, i) => (
                        <Pagination.Item key={i} active={i + 1 === currentPage} onClick={() => paginate(i + 1)}>
                            {i + 1}
                        </Pagination.Item>
                    ))}
                    <Pagination.Next onClick={() => paginate(currentPage + 1)} disabled={currentPage === Math.ceil(feedback.length / itemsPerPage)} />
                </Pagination>
                {feedback.length === 0 ? (<Alert>Hiện chưa có đánh giá về bộ phim này</Alert>): (
                        <ListGroup as="ol">
                        {currentFeedback.map(f => 
                            <ListGroup.Item id={f.phanHoiID}
                                as="li"
                                className="d-flex justify-content-between align-items-start"
                            >
                                <div className="d-flex align-items-center">
                                <div>
            <Image src={f.veID.nguoiDungID.hinhDaiDien} alt="Avatar" roundedCircle width={40} height={40} />
        </div>
                                <div className="ms-2">
                                    <div className="fw-bold">{f.veID.nguoiDungID.ho} {f.veID.nguoiDungID.ten}</div>
                                {f.noiDung} - <Moment locale="vi" fromNow>{f.ngayTao}</Moment>
                                </div>
                                </div>
                                
                            </ListGroup.Item>
                        )}
                    </ListGroup>
                )}
        
                
            
            </>
        )
    }

    export default MovieDetail;