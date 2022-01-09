<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>The Easiest Way to Add Input Masks to Your Forms</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/signup.css">
    </head>
    <body>
        <div class="registration-form">
            <form action="signup" method="post">
                 <p class="text-danger">${Mess}</p>
                <div class="form-icon">
                    <span><i class="icon icon-user"></i></span>
                   
                </div>
                <div class="form-group">
                    <input name ="name" type="text" class="form-control item" id="hoten" placeholder="Họ Và Tên">                  
                </div>
                <div class="form-group">
                    <input name ="user" type="text" class="form-control item" id="username" placeholder="Tên Đăng Nhập">
                </div>
                <div class="form-group">
                    <input name ="password" type="password" class="form-control item" id="password" placeholder="Mật Khẩu">
                </div>
                <div class="form-group">
                    <input name ="email" type="text" class="form-control item" id="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <input name ="phone" type="text" class="form-control item" id="phone-number" placeholder="SDT">
                </div>
                <div class="form-group">
                    <input name ="address" type="text" class="form-control item" id="address" placeholder="Địa Chỉ">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-block create-account">Đăng Kí</button>


                </div>
                <br>
                <a href="Login.jsp" id="cancel_signup"><i class="fas fa-angle-left"></i>< Trở Về</a>
                </br>
            </form>

        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>
