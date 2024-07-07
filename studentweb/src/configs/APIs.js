import axios from "axios";

const BASE_URL = 'http://localhost:8080/StudentApp/';

export const endpoints = {
    'course': '/api/course/',
    'details': (courseId) => `/api/course/${courseId}/`,
    'register': '/api/user/',
    'login': '/api/login/',
    'input': '/api/grade/',
}

export default axios.create({
    baseURL: BASE_URL
});