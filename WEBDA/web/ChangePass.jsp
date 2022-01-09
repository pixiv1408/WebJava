
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login2.css" rel='stylesheet' type='text/css' />
        <title>Thay đổi mật khẩu</title>

        <link href="css/updateuser.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--/start-login-two-->
        <div class="login-02">
            <div class="two-login  hvr-float-shadow">
                <div class="two-login-head">
                    <img src="https://image.flaticon.com/icons/png/512/3427/3427189.png" width="70" height="70" alt="" />
                    <br/>
                    <h2>Cập nhật thông tin</h2>
                    <lable></lable>
                </div>
                <form action="ChangePass" method="post">

                    Tên đăng nhập
                    <li>
                        <input type="text" class="text"value="${info.getAccUsername()}"readonly="true" name="username">
                        <a  href="#" class=" icon2 user2"></a>
                    </li>
                    Mật khẩu
                    <li>
                        <input type="password" name="oldpass" ><a href="#" class=" icon2 lock2"></a>
                    </li>
                    Mật khẩu mới
                    <li>
                        <input type="password" name="newpass" ><a href="#" class=" icon2 lock2"></a>
                    </li>
                    Nhập lại mật khẩu mới
                    <li><input type="password" name="repass" ><a href="#" class=" icon2 lock2"></a></li>
                    <div> 
                        <b>

                            <p class="text-danger" >${Mess}</p>
                            <p class="text-light" >${Mess1}</p>
                        </b>

                    </div>


                    <div class="submit two">
                        <input type="submit" class="btn btn-success" value="Thay đổi mật khẩu">
                        <%-- <input type="submit" class="btn btn-success" value="Add"> --%>                      
                    </div>
                    <h5>
                        <a href="Customerinfo">Trở về</a>
                    </h5>
                </form>
            </div>
        </div>
    </body>
</html>