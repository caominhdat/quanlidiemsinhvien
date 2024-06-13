<%-- 
    Document   : index
    Created on : May 29, 2024, 7:14:34 AM
    Author     : AERO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">Danh mục khóa học</h1>
<a href="<c:url value="/courses" />" class="btn btn-success mb-1">Thêm khóa học</a>
<table class="table table-striped">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Mã khóa học</th>
        <th>Tên khóa học</th>
        <th>Ngày bắt đầu</th>
        <th>Chức năng khác</th>
    </tr>
    <c:forEach items="${course}" var="c">
        <tr>
            <td><img class="rounded img-fluid" src="${c.image}" width="200" alt="${c.courseName}"></td>
            <td>${c.id}</td>
            <td>${c.courseCode}</td>
            <td>${c.courseName}</td>
            <td>${c.createdAt}</td>

            <td>
                <c:url value="/api/course/${c.id}" var="url" />
                <button onclick="deleteCourse('${url}',${c.id})" class="btn btn-danger">Xóa</button>
                <a href="${url}" class="btn btn-success">Cập nhật</a>
            </td>
        </tr>
    </c:forEach>
</table>

<script src="<c:url value="/js/script.js" />"></script>
