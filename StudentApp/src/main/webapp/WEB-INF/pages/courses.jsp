<%-- 
    Document   : courses
    Created on : May 31, 2024, 2:28:29 PM
    Author     : AERO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">Quản trị khóa học</h1>

<c:url value="/course" var="action"/>
<c:if test="${errMsg != null}">
    <div class="alert aalert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="course" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="courseCode" id="name" placeholder="Mã khóa học" name="courseCode" />
        <label for="name">Mã khóa học</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="courseName" id="name" placeholder="Tên khóa học" name="courseName" />
        <label for="name">Tên khóa học</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" accept=".pnj,.jpg" class="form-control" path="file" id="file" name="image" />
        <label for="file">Ảnh khóa học</label>
        <c:if test="${course.image != null}">
            <img src="${course.image}" width="200"/>
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">Thêm khóa học<button/>
            <form:hidden path="id" />
    </div>
</form:form>

