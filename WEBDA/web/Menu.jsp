<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">

        <a class="navbar-brand" href="Home"> <img src="https://popeyes.vn/skin/frontend/rwd/popeyes/images/Popeyes-New-Logo.png" class ="small"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Tài khoản</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ManagerProduct.jsp">Sản phẩm(Admin)</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">hello</a>
                </li>

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

            <form action="searchfood" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="foodname" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number" value = "searchfood">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">CHUỖI CỦA HÀNG GÀ RÁN SỐ 1 VIỆT NAM AEVVT</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 ngày xây dựng chuỗi cơ sở :))</p>
    </div>
    <c:if test="${checklogin==true}" >
        <div>
            <p>Xin chào:  <b>${customer.getCusName()}</b></p>
        </div>
    </c:if>
</section>
<!--end of menu-->
