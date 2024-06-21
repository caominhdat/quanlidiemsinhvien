import { useEffect, useState } from "react";
import { Button, Card, Col, Row } from "react-bootstrap";
import Myspinner from "../commons/Myspinner"
import APIs, { endpoints } from "../../configs/APIs";
import { useNavigate, useSearchParams } from "react-router-dom";

const Home = () => {
    const [course, setCourse] = useState([]);
    const [loading, setLoading] = useState(false);
    const [q, ] = useSearchParams();
    const [page, setPage] = useState(1);
    const nav = useNavigate();


    const loadCourse = async () => {
        setLoading(true)
        try {
            let url = `${endpoints['course']}?page=${page}`;
            
            let kw = q.get("kw");
            if (kw)
                url = `${url}&kw=${kw}`;
            
            const res = await APIs.get(url);

            if (page === 1)
                setCourse(res.data);
            else if  (page > 1)
                setCourse(current => {
                    return [...current, ...res.data];
                });
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        loadCourse();
    }, [q, page]);

    const loadMore = () => {
        if (!loading)
        setPage(page+1);
    }

    return (
        <>
            
            <div>
                {loading && <Myspinner />}
                <h1 className="text-center textt-info mt-1">Danh Mục Khóa Học</h1> 
                <Row className="p-5">
                    {course.map(c => <>
                    <Col md={3} xs={12} className="p-2">
                        <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src={c.image} />
                        <Card.Body>
                            <Card.Title>{c.courseName}</Card.Title>
                            <Card.Text>{c.courseCode}</Card.Text>
                            <Button variant="primary" className="m-1" onClick={() => nav(`/course/${c.id}`)}>Xem chi tiết</Button>
                        </Card.Body>
                        </Card>
                    </Col> 
                    </>)}   
                </Row>
                <div className="text-center">
                        <Button variant="info" onClick={loadMore} disabled={loading}>Xem thêm</Button>
                </div>    
            </div>     
        </>
    );
};

export default Home;