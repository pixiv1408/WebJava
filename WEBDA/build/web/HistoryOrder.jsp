<%-- 
    Document   : Odetail
    Created on : May 24, 2021, 1:26:57 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/HistoryOrder.css">

        <title>Lịch sử mua </title>
    </head>
    <body>
        <div class="container py-5">
            <div class="row text-center text-white mb-5">
                <div class="col-lg-7 mx-auto">
                    <h1 class="display-4">LỊCH SỬ MUA HÀNG</h1>
                </div >

            </div>


            <div class="row">

                <div class=" col-lg-8 mx-auto">
                    <a type="button" href="Home" class=" float-left btn btn-block btn-info text-center" >Trang chủ </a>
                </div>

                <div class="col-lg-8 mx-auto">

                    <!-- List group-->



                    <div
                        <c:forEach items="${HOrder}" var="o">

                            <ul class="list-group shadow">
                            <!-- list group item-->
                            <li class="list-group-item">
                                <!-- Custom content-->
                                <div class="media align-items-lg-center flex-column flex-lg-row p-3">
                                    <div class="media-body order-2 order-lg-1">
                                        <h5 class="mt-0 font-weight-bold mb-2" style="color: black">Mã đơn hàng: ${o.getOrderID()}</h5>
                                        <p class="font-italic text-muted mb-0 small ">${o.getOrderDate()} |  Đã thanh toán </p>
                                        <div class="d-flex align-items-center justify-content-between mt-1">
                                            <h6 class="font-weight-bold my-2" style="color: black">${fm.format(o.getOrderTotal())} VND</h6>


                                        </div>
                                        <a href="OrderDetail?OID=${o.getOrderID()}" style="text-decoration: none" >  <i> Xem chi tiết > </i></a>
                                    </div><img src="https://t3.ftcdn.net/jpg/02/26/35/22/240_F_226352250_XoFeQ0kxNX0PmnrRA1x8J0ieHzA7HuDe.jpg" alt="Generic placeholder image" width="200" height="200" class="ml-lg-5 order-1 order-lg-2">
                                </div> <!-- End -->
                            </li> <!-- End -->

                            </ul> <!-- End -->

                        </c:forEach>
                    </div>
                    <div>
                        <a type="button" href="#" class=" float-left btn btn-block btn-danger text-center" >Đầu trang </a>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
