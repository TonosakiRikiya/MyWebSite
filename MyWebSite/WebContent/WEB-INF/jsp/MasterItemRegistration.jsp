<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>マスタ商品登録</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage.html">GIANTS</a>　　　<a href="MasterItemList.html">商品一覧</a></h2>
<div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>商品登録</h2>

      </div>

      <div class="row">

        <div class="col-md-8 order-md-1">
          <form class="needs-validation" action="MasterItemRegistration.html" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">名前</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="username">詳細</label>
              <div class="input-group">

                <input type="text" class="form-control" id="username"required="">
                <div class="invalid-feedback" style="width: 100%;">
                  Your username is required.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="address">金額</label>
              <input type="text" class="form-control" id="address"  required="">
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

             <div class="mb-3">
              <label for="password">画像</label>
              <input type="text" class="form-control" id="password">
            </div>


            <button class="btn btn-warning btn-lg btn-block" type="submit">登録</button>
          </form>
        </div>
      </div>
    </div>
</body>
</html>