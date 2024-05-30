<%-- 
    Document   : header
    Created on : May 30, 2024, 9:56:42 AM
    Author     : AERO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
