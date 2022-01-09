<%-- 
    Document   : notification
    Created on : May 13, 2021, 3:27:17 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Chỉnh sửa món ăn</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/notifi.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       
             <form>
        <div class="" id="form" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="py-md-5 px-md-4 p-sm-3 p-4">
                    <h2 style="color: orangered">Thông tin đơn hàng</h2> <i class="fa fa-bell"></i>
                    <p class="r3 px-md-5 px-sm-1">Mã đơn hàng của bạn là : ${info.get(info.size()-1).getOrderID()} </p>
                       <p class="r3 px-md-5 px-sm-1">Đã mua vào lúc: ${info.get(info.size()-1).getOrderDate()} </p>
                       <p class="r3 px-md-5 px-sm-1 text-danger">Giá: ${fm.format(info.get(info.size()-1).getOrderTotal())} </p>
                       <div class="text-center mb-3"> <a href="Home" class="btn btn-primary w-50 rounded-pill b1">Trang chủ</a> </div> 
                </div>
            </div>
        </div>
        </form>
    </body>
</html>
