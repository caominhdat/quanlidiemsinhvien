import React, { useRef, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import { useNavigate } from "react-router-dom";

const Register = () =>{
    const fields = [{
        "label": "Email",
        "type": "text",
        "field": "email"
    }, {
        "label": "Username",
        "type": "text",
        "field": "username"
    }, {
        "label": "Password",
        "type": "password",
        "field": "password"
    }, {
        "label": "Confirm Password",
        "type": "password",
        "field": "confirm"
    }];

    const [user, setUser] = useState({});
    const avatar = useRef();
    const nav = useNavigate();

    const change = (event, field) => {
        setUser(current =>{
            return {...current, [field]: event.target.value}
        })
    }

    const register = async (e) => {
        e.preventDefault();

        let form = new FormData();
        for (let k in user)
            if (k !== 'confirm')
                form.append(k, user[k]);

        form.append('file', avatar.current.files[0]);
        try{
            let res = await APIs.post(endpoints['register'], form, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
            if (res.status === 201)
                nav("/login");
        } catch (ex) {
            console.error(ex);
        }
    }

    return (
        <Container>
            <h1 className="text-center text-info">Đăng kí người dùng</h1>
            <Form onSubmit={register}>
                {fields.map(f => <React.Fragment key={f.field}>
                    <Form.Group className="mb-3" controlId={f.field}>
                        <Form.Control onChange={e => change(e, f.field)} value={user[f.field]} type={f.type} placeholder={f.label} />
                    </Form.Group>
                </React.Fragment>)}
                <Form.Control type="file" ref={avatar} accept=".png,.jpg" placeholder="avatar" />
                <Button variant="info" type="submit"  className="mb-1 mt-1">Đăng kí</Button>
            </Form>
        </Container>
    );
}

export default Register;