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
<title>ユーザーログイン</title>
</head>
<body>
	<h2 class="backOrange">
		<a href="TopPage">GIANTS</a>
	</h2>

	<div class="sign-in">
	<form action="UserLogin" method="post">
		<div class="form-group row">
			<label for="loginId" class="col-sm-2 col-form-label">ログインID</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="loginId"
					placeholder="ログインID">
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password"
					placeholder="Password">
			</div>
		</div>
		<c:if test="${errMsg != null}" >
	    <a class="re">
		  ${errMsg}
		</a>
	</c:if>
<button type="submit" class="btn btn-warning btn-lg btn-block">ログイン</button>
		</form>
		<a href="UserRegistration">新規登録</a>
	</div>

</body>
</html>