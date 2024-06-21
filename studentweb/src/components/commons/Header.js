import { useContext, useState } from "react";
import { Button, Col, Container, Form, Nav, Navbar, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyUserContext } from "../../configs/contexts";

const Header = () => {
    const [q, setQ] = useState("");
    const nav = useNavigate();
    const user = useContext(MyUserContext);

    const search = (e) => {
        e.preventDafault();
        // nav(`/`)
    }

    const submit = (e) => {
        e.preventDafault();
        nav(`/?kw=${q}`);
    }

    return (
        <> 
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="#home">StudentWeb</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        {/* <Nav.Link href="#home">Trang chủ</Nav.Link> */}
                        <Link className="nav-link" to="/">Trang chủ</Link>
                        <Nav.Link href="/login" className="text-danger">Đăng nhập</Nav.Link>   
                        <Nav.Link href="/register" className="text-info">Đăng ký</Nav.Link>
                    </Nav>
                    </Navbar.Collapse>
                
                    <Form inline onSubmit={submit}>
                        <Row>
                            <Col xs="auto">
                                <Form.Control type="text" value={q} onChange={e => {setQ(e.target.value)}}placeholder="Tìm khóa học..."className=" mr-sm-2"/>
                            </Col>
                            <Col sx="auto">
                                <Button type="submit">Tìm kiếm</Button>
                            </Col>
                        </Row>
                    </Form>
                </Container>
            </Navbar> 
        </>
    );
}


export default Header;