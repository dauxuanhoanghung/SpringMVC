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
        <style>
            * {
                padding: 0;
                margin: 0;
            }
            .rating {
                --mdb-rating-icon-padding: 0.25rem;
                display: flex;
                margin: 0;
                padding: 0;
            }
            ul li {
                list-style: none;
            }
        </style>
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
                                <c:url value="/" var="url">
                                    <c:param name="categoryId" value="${c.id}"/>
                                </c:url>
                                <li class="nav-item active">
                                    <a class="nav-link text-purple-500 " href="${url}">${c.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div>
                        <form class="input-group rounded">
                            <input name="kw" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                            <span class="input-group-text border-0" id="search-addon">
                                <button type="submit"><i class="fas fa-search"></i></button>
                            </span>
                        </form>
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
                                <img src="${p.image}" class="img-fluid px-3 py-1"/>
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>
                            <div class="card-body bg-light">
                                <h5 class="card-title">${p.name}</h5>
                                <p class="card-text">${p.price}</p>
                                <div>
                                    <ul class="rating" data-mdb-toggle="rating" tabindex="0">
                                        <li>
                                            <i class="fa-star fa-sm text-primary far" data-mdb-toggle="tooltip" aria-label="Bad" data-mdb-original-title="Bad"></i>
                                        </li>
                                        <li>
                                            <i class="fa-star fa-sm text-primary far" data-mdb-toggle="tooltip" aria-label="Poor" data-mdb-original-title="Poor"></i>
                                        </li>
                                        <li>
                                            <i class="fa-star fa-sm text-primary far" data-mdb-toggle="tooltip" aria-label="OK" data-mdb-original-title="OK"></i>
                                        </li>
                                        <li>
                                            <i class="fa-star fa-sm text-primary far" data-mdb-toggle="tooltip" aria-label="Good" data-mdb-original-title="Good"></i>
                                        </li>
                                        <li>
                                            <i class="fa-star fa-sm text-primary far" data-mdb-toggle="tooltip" aria-label="Excellent" data-mdb-original-title="Excellent"></i>
                                        </li>
                                    </ul>
                                </div>
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
