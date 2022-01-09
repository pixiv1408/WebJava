<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Update Profile</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/signup.css">
        <meta charset="utf-8">
    </head>
    <body>
        <div class="registration-form">
            <form action="UpdateProfile" method="post">
                <p class="text-danger">${Mess}</p>
                <div class="form-icon">
                    <span><i class="icon icon-user"></i></span>

                </div>
                <div class="form-group">
                    <input name ="name" type="text" class="form-control item" id="hoten" value="${info.getName()}" readonly="true">                  
                </div>
                <div class="form-group">
                    <input name ="user" type="text" class="form-control item" id="username" value="${info.getUser()}" readonly="true">
                </div>
                <div class="form-group">
                    <input name ="email" type="text" class="form-control item" id="email" value="${info.getEmail()}">
                </div>
                <div class="form-group">
                    <input name ="phone" type="text" class="form-control item" id="phone-number" value="${info.getPhone()}">
                </div>
                <div class="form-group">
                    <input name ="address" type="text" class="form-control item" id="address" value="${info.getAddress()}">
                </div>
                <div class="form-group">
                    <center> <label> Xác nhận mật khẩu </label></center>
                    <input name ="pass" type="password" class="form-control item" id="password" placeholder="Mật khẩu">
                </div>
                <br/>
                <div class="form-group" >

                    <button type="submit" class="btn btn-block btn-primary">Cập nhật tài khoản</button>
                    <br/>
                    <a href="upaccount" style="text-decoration: none"> <button type="button" class="btn btn-block btn-info ">Thay đổi mật khẩu</button></a>
                    <br/>
                    <a href="Home" style="text-decoration: none"> <button type="button" class="btn btn-block btn-danger">Trở về trang chủ</button></a>

                </div>
            </form>

        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>
