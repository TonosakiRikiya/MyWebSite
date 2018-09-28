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
<title>内容確認</title>
</head>
<body>
<div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>入力内容確認</h2>

      </div>

      <div class="row">

        <div class="col-md-8 order-md-1">
          <form class="needs-validation" action="UserUpdateResult" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">名前</label>
                <input type="text" class="form-control" name="user_name_update" value="${udb.name}" readonly>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="username">ユーザーID</label>
              <div class="input-group">

                <input type="text" class="form-control" name="login_id_update" value="${udb.loginId}" readonly>
                <div class="invalid-feedback" style="width: 100%;">
                  Your username is required.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="address">住所</label>
              <input type="text" class="form-control" name="user_address_update" value="${udb.address}" readonly>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <input type="hidden" name="userId" value="${udb.id}">
<div>上記の内容で更新してもよろしいですか</div>

            <button class="btn btn-warning btn-lg btn-block" type="submit">更新</button>
          </form>
           <a href="UserDetail"><button class="btn btn-warning btn-lg btn-block" type="submit">戻る</button></a>
        </div>
      </div>
    </div>

</body>
</html>