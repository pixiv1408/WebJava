<%-- 
    Document   : editcate
    Created on : Jun 1, 2021, 8:18:53 PM
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
        <title>Chỉnh sửa danh mục</title>
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
                <form action = "editcate" method="post">
                     <p class="text-danger">${Mess}</p>
                    <div class="modal-header">						
                        <b><h4 class="modal-title text-center text-warning" >Chỉnh sửa</h4></b>
                        
                    </div>
                    <div class="modal-body">	
                        <div class="form-group">
                            <label>Mã Danh Mục</label>
                            <input name ="cid" type="number" class="form-control" required value="${ifc.getCateID()}" readonly="true">
                        </div>
                        <div class="form-group">
                            <label>Tên Danh Mục</label>
                            <input name ="edcname" type="text" class="form-control" required value="${ifc.getCateName()}">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a type="button" class="btn btn-danger" href="Home" >Thoát  </a>
                        <button type="submit" class="btn btn-info">Lưu </button>
                    </div>
                </form>
            </div>
        </div>



        
        
        

    </body>
</html>
