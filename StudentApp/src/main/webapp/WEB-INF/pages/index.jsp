<%-- 
    Document   : index
    Created on : May 29, 2024, 7:14:34 AM
    Author     : AERO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">My Student App</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng kí</a>
                        </li>
                    </ul>
                    <form action="<c:url value="/" />" class="d-flex">
                            <input class="form-control me-2" name="kw" type="text" placeholder="Bạn muốn tìm?">
                            <button class="btn btn-primary" type="submit">Tìm</button>
                        </form>
                    </div>
                </div>
            </nav>

            <section>
                <div class="row" class="container">
                    <c:forEach items="${course}" var="c">
                        <div class="col-md-3 col-12" style="padding: 1rem;">
                            <div class="card">
                                <img class="card-img-top" src="${c.image}" alt="${c.courseName}">
                                <div class="card-body">
                                    <h4 class="card-title">${c.courseName} (${c.courseCode})</h4>
                                    <a href="#" class="btn btn-primary">Xem chi tiết</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
            </section>

        </body>
    </html>
