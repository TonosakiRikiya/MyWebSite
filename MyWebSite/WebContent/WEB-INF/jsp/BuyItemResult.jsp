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
<title>購入商品結果</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="Cart">カート</a></h2>
<br><br>
<h2>購入詳細</h2>

<br><br>
<table><tr><th>商品名</th><th>単価</th><th>小計</th></tr>
<c:forEach var="cartInItem" items="${cart}" >
<tr><th>${cartInItem.name}</th><th>${cartInItem.price}円</th><th>${cartInItem.price}円</th></tr>
</c:forEach>
<tr><th>${bdb.deliveryMethodName}</th><th></th><th>${bdb.deliveryMethodPrice}円</th></tr>
<tr><th></th><th>合計</th><th>${bdb.totalPrice}円</th></tr></table>
</body>
</html>