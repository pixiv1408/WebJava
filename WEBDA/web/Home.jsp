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
        <!------ Include the above in your HEAD tag ---------->

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>



        <nav class="navbar navbar-expand-md navbar-dark bg-dark" >
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
        <section class="jumbotron text-center" style=" background-color: threedlightshadow">
            <div class="container">
                <h1 class="jumbotron-heading"">CHUỖI CỬA HÀNG GÀ RÁN SỐ 1 VIỆT NAM AEVVT</h1>
                <h3 class="lead mb-0" style="font-size: 25px" >Uy tín tạo nên thương hiệu với hơn 10 ngày xây dựng chuỗi cơ sở </h3>
            </div>
            <c:if test="${checklogin==true}" >
                <div style="padding-top: 10px">

                    <p class="lead mb-0" style="color:blue;font-size: 25px ">Xin chào:  <b class="text-danger">${customer.getCusName().toUpperCase()}</b></p>
                </div>
            </c:if>

        </section>

        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Home">Trang chủ</a></li>
                            <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Món ăn</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">

            <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row">

                        <c:forEach items="${listFoods}" var="f">
                            <br/>

                            <div style="padding-top: 20px" class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${f.getFoodIMG()}" alt="Card image cap">
                                    <div class="card-body">
                                        <center><b> <h4 class="card-title show_txt"><a href="Fdetail?FID=${f.getFoodID()}" title="View Product">${f.getFoodName()}</a></h4></b></center>

                                        </p>
                                        <div class="row">
                                            <div class="col">
                                                <c:choose>
                                                    <c:when test = "${checklogin == true}">
                                                        <a  href="Buy?BFID=${f.getFoodID()}" class="btn btn-danger btn-block">${fm.format(f.getFoodPrice())}</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="Login.jsp" style="text-decoration: none"> <p class="btn btn-danger btn-block">${fm.format(f.getFoodPrice())}</p></a>

                                                    </c:otherwise>
                                                </c:choose>

                                            </div>
                                            <div class="col">
                                                <a  class="btn btn-success btn-block"  href="Addcart?AFID=${f.getFoodID()}" >Giỏ hàng  </a>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <div class="modal fade" id="form" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <center> 
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content py-md-5 px-md-4 p-sm-3 p-4">

                        <h3>Thông báo</h3> <i class="fa fa-bell"></i>
                        <br/>
                        <div>
                            <img src="https://image.flaticon.com/icons/png/128/1029/1029132.png" width="70" height="70"/>
                        </div>
                        <p class="r3 px-md-5 px-sm-1">${MESS}</p>

                        <div class="text-center mb-3"> <a href="Cuscart" class="btn btn-primary">Xem giỏ hàng</a></button> </div> <a href="Home">Tiếp tục</a>
                    </div>
                </div>
            </center>
        </div>



        <jsp:include page="Footer.jsp"></jsp:include>




    </body>
</html>

