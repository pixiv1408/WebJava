<%-- 
    Document   : HistoryOder
    Created on : May 24, 2021, 12:37:31 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/DetailOrder.css">

        <title>Chi tiết hóa đơn</title>
    </head>        


    <body>
        
        <div class="row d-flex justify-content-center mt-100 mb-100">



            <div class="col-lg-6">
                <div>
                    <a type="button" href="HistoryOderinfo" class="btn btn-block btn-info text-center " width="60" > Trở về</a>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h4 class="card-title m-b-0">Chi tiết đơn hàng</h4>
                    </div>
                    <c:forEach items="${HDetail}" var="d">
                        <ul class="list-style-none">

                            <li class="d-flex no-block card-body border-top border-bottom"><image src="${d.getFimg()}" width="70" height="70" style="padding-right: 0.5"  /> <i class=" w-30px m-t-5"></i>
                                <div style="padding-top: 50" class="m-b-0 font-medium p-0"  data-abc="true"> <br/> <span style="font-size: 20 " class="text-muted ">${d.getFname()}</span> </div>

   
                                <div class="ml-auto">


                                    <div class="tetx-right">
                                        <br/>
                                        <h5 style="color: black" class=" m-b-0">Số lượng: ${d.getAmount()}</h5> <span style="font-size: 20" class="text text-danger font-italic font-16">Giá: ${fm.format(d.getTotal())}</span>
                                    </div>
                                   

                                </div>

                            </li>


                        </ul>
                    </c:forEach>
                </div>
                <div>
                    <a type="button" href="#" class=" float-left btn btn-block btn-danger text-center" >Đầu trang </a>
                </div>
            </div>

        </div>
    </body>
</html>