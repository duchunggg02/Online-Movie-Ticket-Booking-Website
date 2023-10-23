import { useContext, useState } from "react";
import { Button, Container, Form, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyUserContext } from "../App";

const Header = () => {
    const [user, dispatch] = useContext(MyUserContext);

    const [kw, setKw] = useState("");
    const nav = useNavigate();

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const logout = () => {
      dispatch({
        "type": "logout"
      })
    }

    let url
    if(user !== null) {
       url = `/user/${user.nguoiDungID}`
    }
     
    return (<>
         <Navbar expand="lg" className="bg-body-tertiary">
      <Container fluid>
        <Navbar.Brand>Đức Hưng</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: '100px' }}
            navbarScroll
          >
            <Link className="nav-link" to="/">TRANG CHỦ</Link>
          
            {user === null ? <>
              <Link className="nav-link" to="/register">Đăng ký</Link>
              <Link className="nav-link" to="/login">Đăng nhập</Link>
            </>: <>
            <NavDropdown title={user.ten} id="basic-nav-dropdown">
                                    <NavDropdown.Item as={Link} to={url}>Tài khoản</NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    <NavDropdown.Item onClick={logout}>Đăng xuất</NavDropdown.Item>
                                </NavDropdown>
            </>}
          </Nav>
          <Form className="d-flex" onSubmit={search}>
            <Form.Control
              type="search"
              placeholder="Tìm kiếm phim..."
              className="me-2"
              aria-label="Search"
              value={kw}
              onChange={e => setKw(e.target.value)}
              name="kw"
            />
            <Button variant="primary" type="submit">Tìm</Button>
       
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </>)
}

export default Header;