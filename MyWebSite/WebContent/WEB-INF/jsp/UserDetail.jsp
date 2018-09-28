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
<title>ユーザー詳細</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="Cart">カート</a><c:if test="${udb.loginId=='admin'}"><a href="MasterItemList">商品管理一覧</a></c:if>
<a href="UserLogout">ログアウト</a></h2>
<br><br><br>
<h2 class="center">ユーザー情報</h2>
<br><br><div class="center">

<form action="UserUpdate" method="post"><table class="center">
<tr><th>名前</th><th><input type="text" name="user_name" value="${udb.name}"></th></tr>
<tr><th>ログインID</th><th><input type="text" name=login_id value="${udb.loginId}" readonly></th></tr>

<tr><th>住所</th><th><input type="text" name="user_address" value="${udb.address}"></th></tr></table>
<button type="submit" class="btn btn-outline-warning">更新</button></form>

<br><br><br>
<table class="center"><tr><th></th><th>購入日時</th><th>配送方法</th><th>購入金額</th></tr>
<c:forEach var="udb" items="${BuyDataList}">
<tr><th><a href="UserDetailHistory?buyId=${udb.id}">#</a></th><th>${udb.formatDate}</th><th>${udb.deliveryMethodName}</th><th>${udb.totalPrice}円</th></tr>
</c:forEach></table></div>
</body>
</html>