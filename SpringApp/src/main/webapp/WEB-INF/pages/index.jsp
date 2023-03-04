<%-- 
    Document   : index
    Created on : Mar 4, 2023, 1:25:46 PM
    Author     : admin
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light shadow" style="background-color: #81C784 !important;">
                <div class="container">
                    <a class="navbar-brand" href="#">BÁN HÀNG</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav me-auto text-purple-500">
                            <c:forEach items="${categories}" var="c">
                                <li class="nav-item active">
                                    <a class="nav-link text-purple-500 " href="#">${c.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div>
                        <div class="input-group rounded">
                            <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                            <span class="input-group-text border-0" id="search-addon">
                                <a type="button"><i class="fas fa-search"></i></a>
                            </span>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="p">
                    <div class="col-md-3 col-sm-6 col-xs-12 px-2 py-1">
                        <div class="card">
                            <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                                <img src="${p.image}" class="img-fluid"/>
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>
                            <div class="card-body bg-light">
                                <h5 class="card-title">${p.name}</h5>
                                <p class="card-text">${p.price}</p>
                                <a href="#!" class="btn btn-primary">Xem chi tiết</a>
                                <a href="#!" class="btn btn-warning ms-auto">Đặt hàng</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <footer>
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                &copy; 2023 Copyright: Hùng
                <a class="text-dark" href="https://mdbootstrap.com/">2059052059</a>
            </div>
            <!-- Copyright -->
        </footer>
    </footer>
</body>
</html>
