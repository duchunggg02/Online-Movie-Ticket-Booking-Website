import { useEffect, useState } from "react";
import { Card, Col, Row } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";




const Home = () => {

    const [movies, setMovies] = useState(null);
   
    const [q] = useSearchParams();

    useEffect(() => {
        const loadMovies = async () => {
            try {
                let e = endpoint['movies'];

                let kw = q.get("kw");
                if(kw !== null) {
                    e = `${e}?kw=${kw}`;
                }

                let res = await Apis.get(e);
                setMovies(res.data);
            } catch (ex) {
                console.error(ex);
            }
          
        }

        loadMovies();
    }, [q])

    
  

    if (movies === null) {
        return <MySpinner />
    }


    return (
        <>
        <Row className="mt-5">
            {movies.map(m => { 
                   let urlShowtime = `/showtime/${m.phimID}`;
                   let urlMovie = `/movie/${m.phimID}`;
                 return <Col xs={12} md={3} className="mt-2 d-flex justify-content-center" key={m.phimID}>
                            <Card style={{ width: '18rem' }} className="text-center">
                                <Card.Img variant="top" src={m.anhPhim} height="140px"/>
                                <Card.Body>
                                <Card.Title>{m.tenPhim}</Card.Title>
                                <Card.Text>{m.moTa}</Card.Text>
                                <div className="d-flex justify-content-between">
                                    <Link to={urlMovie} className="dropdown-item" key={m.phimID}>XEM CHI TIẾT</Link>
                                    <Link to={urlShowtime} className="dropdown-item" key={m.phimID}>ĐẶT VÉ</Link>
                                </div>
                                </Card.Body>
                            </Card>
                        </Col>
            })}
        </Row>
        </>
    )

}

export default Home;