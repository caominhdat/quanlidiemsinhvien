import React, {  useState } from "react";
import Myspinner from "../commons/Myspinner";
import { Button, Col, Container, Form, Image, Row } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import { useNavigate } from "react-router-dom";

const InputGrade = () => {
    const fields = [{
        "label": "Điểm thành phần 1:",
        "type": "text",
        "field": "additional1"
    }, {
        "label": "Điểm thành phần 2:",
        "type": "text",
        "field": "additional2"
    }, {
        "label": "Điểm thành phần 3:",
        "type": "text",
        "field": "additional3"
    }, {
        "label": "Điểm quá trình:",
        "type": "text",
        "field": "midterm"
    }, {
        "label": "Điểm kết thúc:",
        "type": "text",
        "field": "final1"
    }];

    const [course, setCourse] = useState(null);
    const [grade, setGrade] = useState({});
    const [courseId, setCourseId] = useState("");
    const nav = useNavigate();

    const loadCourse = async (id) => {
        try {
            let res = await APIs.get(endpoints['details'](id));
            setCourse(res.data);
        } catch (ex) {
            console.error(ex);
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (courseId) {
            loadCourse(courseId);
        }
    };

    const change = (event, field) => {
        setGrade(current =>{
            return {...current, [field]: event.target.value}
        })
    }

    const input = async (e) => {
        e.preventDefault();

        // Tạo đối tượng lưu trữ dữ liệu từ form
        let formData = {
            additional1: grade.additional1,
            additional2: grade.additional2,
            additional3: grade.additional3,
            midterm: grade.midterm,
            final1: grade.final1
        };

        // Chuyển đổi đối tượng thành chuỗi x-www-form-urlencoded
        let urlEncodedData = new URLSearchParams(formData).toString();

        try {
            let res = await APIs.post(endpoints['input'], urlEncodedData, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            });
            if (res.status === 201) {
                nav("/");
            }
        } catch (ex) {
            console.error(ex);
        }
    }

    return (
        <Container>
            <h1 className="text-center text-info mt-1">Nhập điểm sinh viên</h1>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formCourseId">
                    <Form.Label>Nhập Course ID</Form.Label>
                    <Form.Control
                        type="text"
                        value={courseId}
                        onChange={(e) => setCourseId(e.target.value)}
                        placeholder="Enter Course ID"
                    />
                </Form.Group>
                <Form.Group controlId="formStudentId">
                    <Form.Label>Nhập Student ID</Form.Label>
                    <Form.Control
                        type="text"
                        value={courseId}
                        onChange={(e) => setCourseId(e.target.value)}
                        placeholder="Enter Student ID"
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="mt-2">
                    Load Course
                </Button>
            </Form>
            {course === null ? (<Myspinner />) : (
                <>
                    <Row className="mt-4">
                        <Col md={5} xs={12}>
                            <Image src={course.image} rounded fluid />
                        </Col>
                        <Col md={7} xs={12}>
                            <h2>Tên khóa học: {course.courseName}</h2>
                            <h4 className="text-danger">Mã khóa học: {course.courseCode}</h4>
                        </Col>
                    </Row>
                    <Form className="mt-2" onSubmit={input}>
                    {fields.map(f => <React.Fragment key={f.field}>
                        <Form.Group className="mb-3" controlId={f.field}>
                            <Form.Control onChange={e => change(e, f.field)} value={grade[f.field]} type={f.type} placeholder={f.label} />
                        </Form.Group>
                        </React.Fragment>)}
                    <Button variant="info" type="submit"  className="mb-1 mt-1">Apply</Button>
                    </Form>
                </>
            )}
        </Container>
    );
};

export default InputGrade;