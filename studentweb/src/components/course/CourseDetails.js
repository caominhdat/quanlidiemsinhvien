import { useEffect, useState } from "react";
import Myspinner from "../commons/Myspinner";
import { Col, Container, Image, Row } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import { useParams } from "react-router-dom";

const CourseDetails = () => {
    const [course, setCourse] = useState(null);
    const {courseId} = useParams();

    const loadCourse = async () => {
        try {
            let res = await APIs.get(endpoints['details'](courseId));
            setCourse(res.data)
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadCourse();
    }, [courseId]);

    return (
        <Container>
            <h1 className="text-center text-info mt-1">Chi tiết khóa học</h1>
            {course===null?<Myspinner/>:<>
                <Row>
                    <Col md={5} xs={6}>
                        <Image src={course.image} rounded fluid />
                    </Col>
                    <Col md={7} xs={6}>
                        <h2>Tên khóa học: {course.courseName}</h2>
                        <h4 className="text-danger">Mã khóa học: {course.courseCode}</h4>
                    </Col>
                </Row>
            </>}
        </ Container>
    );
}

export default CourseDetails;