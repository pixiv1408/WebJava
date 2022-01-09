<%-- 
    Document   : Editfood
    Created on : May 11, 2021, 12:37:33 AM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>


        <div class="modal-dialog">
            <div class="modal-content">
                <form action = "Foodedit" method="post">
                     <p class="text-danger">${Mess}</p>
                    <div class="modal-header">						
                        <h4 class="modal-title">Chỉnh sửa</h4>
                        <button type="button" class="close" data-dismiss="modal" onclick="window.location.href = 'Manager'" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">	
                        <div class="form-group">
                            <label>Mã</label>
                            <input name ="FID" type="number" class="form-control" required value="${Efood.getFoodID()}" readonly="true">
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <input name ="efname" type="text" class="form-control" required value="${Efood.getFoodName()}">
                        </div>
                        <div class="form-group">
                            <label>Giá</label>
                            <input name ="efprice" type="number" class="form-control" required value="${Efood.getFoodPrice()}">
                        </div>
                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea name ="efdescribe" class="form-control" required value="${Efood.getFoodDescribe()}">${Efood.getFoodDescribe()}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Đường dẫn hình ảnh</label>
                            <input name = "efimg" type="text" class="form-control" required value="${Efood.getFoodIMG()}">
                        </div>	
                        <div class="form-group">
                            <label>Loại món</label>
                            <select name="fcate" class="form-select" >
                                
                                <c:forEach items="${FlistCate}" var="ct">
                                    <option ${Efood.getFoodCateID() == ct.getCateID()? "selected":"" } value="${ct.getCateID()}" >${ct.getCateName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="window.location.href = 'Manager'">Thoat  </button>
                        <button type="submit" class="btn btn-info">Lưu </button>
                    </div>
                </form>
            </div>
        </div>



    </body>
</html>
