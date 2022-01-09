

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh mục</div>
        <ul class="list-group category_block">
            <c:forEach items = "${listCategory}" var="c">
                 <li class="list-group-item text-white ${choose == c.getCateID()? "active":""}"><a href="loadbycate?cateID=${c.getCateID()}"><b> <center> ${c.getCateName()}</center></b></a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Món mới</div>
        <div class="card-body">
            
            <img class="img-fluid" src="${topfood.getFIMG()}" />
            <h5 class="card-title">${topfood.getFName()}</h5>
            <p class="card-text">${topfood.getFDescribe()}</p>
            <p class="bloc_left_price">${fm.format(topfood.getFPrice())} vnd</p>
        </div>
    </div>
</div>