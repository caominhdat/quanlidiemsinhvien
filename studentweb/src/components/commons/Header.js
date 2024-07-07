import { useContext, useState } from "react";
import { Button, ButtonGroup, Col, Container, Dropdown, Form, Nav, Navbar, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyDispatchContext, MyUserContext } from "../../configs/contexts";

const Header = () => {
    const [q, setQ] = useState("");
    const nav = useNavigate();
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);

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
                            {user !== null ? <>
                                <Nav.Link href="#/" className="text-info">Xin chào</Nav.Link> 
                                <Nav.Link onClick={() => dispatch({"type": "logout"})} className="text-danger">Đăng xuất</Nav.Link>
                                <Dropdown as={ButtonGroup}>
                                <Button variant="success">Tính năng</Button>

                                <Dropdown.Toggle split variant="success" id="dropdown-split-basic" />

                                <Dropdown.Menu>
                                    <Dropdown.Item href="#/abc">Xem điểm</Dropdown.Item>
                                    <Dropdown.Item href="/input">Nhập điểm</Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                            </>:<>
                                <Nav.Link href="/login" className="text-danger">Đăng nhập</Nav.Link>   
                                <Nav.Link href="/register" className="text-info">Đăng ký</Nav.Link>
                            </>}
                            
                            
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