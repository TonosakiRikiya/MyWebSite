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
<title>カート</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="UserLogin">ログイン</a><a>${udb.name}さん</a></h2>
<br>
<br>
<h1>買い物かご</h1>
<br>
<div class="section">

				<div class="row">
					<div class="col s12">
					<form action="ItemDelete" method="post">
						<div class="col s6 center-align">
							<button type="submit" class="btn btn-outline-warning">
								削除
							</button>
						</div></form>
						<div class="col s6 center-align">
							<a href="Buy"><button type="submit" class="btn btn-outline-warning">レジに進む</button></a>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach var="item" items="${cart}" varStatus="status">
					<div class="col s12 m3">
						<div class="card">
							<div class="card-image">
								<a href="Item?item_id=${item.id}"><img src="img/${item.fileName}"> </a>
							</div>
							<div class="card-content">
								<span class="card-title">${item.name}</span>
								<p>${item.price}円
								</p>
								<p>
									<input type="checkbox" id="${status.index}" name="delete_item_id_list" value="${item.id}" /> <label for="${status.index}">削除</label>
								</p>
							</div>
						</div>
					</div>
					</c:forEach>
					<c:if test="${(status.index+1) % 4 == 0 }">
					</c:if>



		</div>
</body>
</html>