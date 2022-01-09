<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
        <div class="shopping-cart">
            <div class="px-4 px-lg-0">

                <div class="pb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                <!-- Shopping cart table -->
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Số Lượng</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Xóa</div>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listcart}" var="c">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${c.getFoodIMG()}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${c.getFoodName()}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${fm.format(c.getFoodPrice())}</strong></td>
                                                    <td class="align-middle" >
                                                        <a href=" SubAmount?SFID=${c.getFoodID()}" ><button class="btnSub">-</button></a> 
                                                        <strong>${c.getAmount()}</strong>
                                                        <a href=" PlusAmount?PFID=${c.getFoodID()}" ><button class="btnAdd">+</button></a>
                                                    </td>
                                                    <td class="align-middle"><a href="DelAmount?DFID=${c.getFoodID()}" class="text-dark">
                                                            <button type="button" class="btn btn-danger">Delete</button>
                                                        </a>
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                                        <div class="input-group-append border-0">
                                            <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${fm.format(total)} VND</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>${fm.format(vat)} VND</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">${fm.format(total+vat)}VND</h5>
                                        </li>
                                        <c:if test="${listcart.size()!=0}">  </ul><a href="#" class="btn btn-dark rounded-pill py-2 btn-block" data-toggle="modal" data-target="#form" >Mua hàng</a></c:if>
                                </div>
                            </div>
                        </div>

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

                            <h3>Cảm ơn</h3> <i class="fa fa-bell"></i>
                            <br/>
                            <div>
                                <img src="https://image.flaticon.com/icons/png/128/1029/1029132.png" width="70" height="70"/>
                            </div>
                            <p class="r3 px-md-5 px-sm-1">${MESS}</p>

                            <div class="text-center mb-3"> <a href="Paycart?total=${total}" class="btn btn-primary">Xong</a></button> </div> 
                        </div>
                    </div>
                </center>
            </div>
 
    </body>

</html>
</html>
