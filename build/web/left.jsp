

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listCategory}" var="Category">
                <li class="list-group-item text-black"><a href="MainController?btnAction=select&Cateid=${Category.id}">${Category.nameCate}</a></li>

            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Hot Phone</div>
        <div class="card-body">
             <img class="img-fluid" src="${HotPhone.img}" />
             <h5 class="card-title">${HotPhone.name}</h5>
             <p class="bloc_left_price">${HotPhone.price}đ</p>
        </div>
    </div>
</div>