import React, { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import { MyDispatchContext, MyUserContext } from "../../configs/contexts";
import { Navigate, useNavigate } from "react-router-dom";

const Login = () => {
    const fields = [{
        "label": "Username",
        "type": "text",
        "field": "username"
    }, {
        "label": "Password",
        "type": "password",
        "field": "password"
    }];

    const [user, setUser] = useState({});
    const dispatch = useContext(MyDispatchContext);
    const currentUser = useContext(MyUserContext);
    const nav = useNavigate();

    const login = async (e) => {
        e.preventDefault();
        try {
            let res = await APIs.post(endpoints['login'], {...user});
            dispatch ({
                "type": "login",
                "payload": {

                }
            });
            nav("/");
        } catch (ex) {
            console.error(ex);
        }
    }

    const change = (event, field) => {
        setUser(current =>{
            return {...current, [field]: event.target.value}
        })
    }

    if (currentUser !== null)
        return <Navigate to="/" />

    return (
        <Container>
            <h1 className="text-center text-info">Đăng nhập người dùng</h1>
            <Form onSubmit={login}>
                {fields.map(f => <React.Fragment key={f.field}>
                    <Form.Group className="mb-3" controlId={f.field}>
                        <Form.Control onChange={e => change(e, f.field)} value={user[f.field]} type={f.type} placeholder={f.label} />
                    </Form.Group>
                </React.Fragment>)}
                <Button variant="info" type="submit"  className="mb-1 mt-1">Đăng nhập</Button>
            </Form>
        </Container>
    );
}

export default Login;