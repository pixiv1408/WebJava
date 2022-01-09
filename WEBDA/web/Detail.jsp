<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: 500px;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 326px !important;
                height: 500px !important;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">

                <a class="navbar-brand" href="Home"> <img src="https://popeyes.vn/skin/frontend/rwd/popeyes/images/Popeyes-New-Logo.png" class ="small"/></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <div>
                        <ul class="navbar-nav m-auto">
                            <c:if test="${account!=null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="Customerinfo">Tài khoản</a>
                                </li>

                                <c:if test="${account.getAccID()==1}">

                                    <li class="nav-item">

                                        <a class="nav-link" href="Manager">Sản phẩm(Admin)</a>

                                    </li>
                                </c:if>

                                <li class="nav-item">
                                    <a class="nav-link" href="HistoryOderinfo">Lịch sử mua hàng</a>
                                </li>
                            </c:if>
                            <c:if test="${account!=null}"> 
                                <li class="nav-item">
                                    <a class="nav-link" href="checklogout">Đăng xuất</a>
                                </li>
                            </c:if>
                            <c:if test="${account==null}"> 
                                <li class="nav-item">
                                    <a class="nav-link" href="Login.jsp">Đăng nhập</a> 
                                </li>

                            </c:if>    

                        </ul>
                    </div>

                    <form action="searchfood" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="foodname" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number" value = "searchfood">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="Cuscart">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${listcart.size()}</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div class="container">
                            <form action="addcartintodetailfood"  method="post">
                                <div class="card">
                                    <div class="row">
                                        <aside class="col-sm-5 border-right">
                                            <article class="gallery-wrap"> 
                                                <div class="img-big-wrap">
                                                    <div > <a href="#"><img src="${Fdetail.getFoodIMG()} " ></a></div>
                                            </div> <!-- slider-product.// -->
                                            <div class="img-small-wrap">
                                            </div> <!-- slider-nav.// -->
                                        </article> <!-- gallery-wrap .end// -->
                                    </aside>
                                    <aside class="col-sm-7">
                                        <article class="card-body p-5">
                                            <input name="fid" value="${Fdetail.getFoodID()}" class="table title " style="border: none; font-size: 30px;visibility: hidden  " readonly="true" >
                                            <h3  class="title mb-3">${Fdetail.getFoodName()}</h3>


                                            <p class="price-detail-wrap"> 
                                                <span class="price h3 text-warning"> 
                                                    <span class="num">${Fdetail.getFoodPrice()}vnd</span>
                                                </span> 
                                            </p> <!-- price-detail-wrap .// -->
                                            <dl class="item-property">
                                                <dt>Mô tả</dt>
                                                <dd><p>
                                                        ${Fdetail.getFoodDescribe()}

                                                    </p></dd>
                                            </dl>

                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-5">
                                                    <dl class="param param-inline">
                                                        <dt>Số lượng: </dt>
                                                        <dd>

                                                            <select name="amount" class="form-control form-control-sm" aria-label="Default select example" style="width:70px;">
                                                                <option value="1"> 1 </option>
                                                                <option value="2"> 2 </option>
                                                                <option value="3"> 3 </option>
                                                                <option value="4"> 4 </option>
                                                                <option value="5"> 5 </option>
                                                            </select>
                                                        </dd>
                                                    </dl>  <!-- item-property .// -->
                                                </div> <!-- col.// -->

                                            </div> <!-- row.// -->
                                            <hr> 

                                            <button  type="submit" data-toggle="modal" data-target="#form" formaction="Buynowintodetailfood" class="btn btn-danger btn-lg text-uppercase"> <i class="fas fa-shopping-cart"></i>Mua ngay</button>
                                            <button type="submit" class="btn btn-primary btn-lg text-uppercase"> <i class="fas fa-shopping-cart"></i> Giỏ hàng</button>

                                        </article> <!-- card-body.// -->
                                    </aside> <!-- col.// -->
                                </div> <!-- row.// -->
                            </div> <!-- card.// -->
                        </form>


                    </div>
                </div>
            </div>
        </div>
                                                        
        <jsp:include page="Footer.jsp"></jsp:include>
       
    </body>
</html>
