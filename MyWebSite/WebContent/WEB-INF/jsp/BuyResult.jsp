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
<title>購入結果</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="UserLogin">ログイン</a>　　　<a href="Cart">カート</a></h2>
<br><br><p>購入が完了しました</p>
<a href="TopPage"><button type="button" class="btn btn-outline-warning">引き続き買い物する</button></a>
<a href="UserDetail"><button type="button" class="btn btn-outline-warning">ユーザー情報へ</button></a>
<br>
<h3>購入詳細</h3>
<table><tr><th>購入日時</th><th>配送方法</th><th>合計金額</th>
</tr>
<tr><th>${resultBDB.formatDate}</th><th>${resultBDB.deliveryMethodName}</th><th>${resultBDB.totalPrice}円</th></tr></table>
<br><br>
<table><tr><th>商品名</th><th>単価</th></tr>
<c:forEach var="buyIDB" items="${buyIDBList}" >
<tr><th>${buyIDB.name}</th><th>${buyIDB.price}円</th></tr>
<tr><th>${resultBDB.deliveryMethodName}</th><th>${resultBDB.deliveryMethodPrice}円</th></tr></c:forEach></table>
</body>
</html>