<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="UserDetail">ユーザー情報</a>　　　<a href="Cart">カート</a></h2>
<br><br><p>購入詳細</p>

<br>
<h3>購入詳細</h3>
<table><tr><th>購入日時</th><th>配送方法</th><th>合計金額</th>
</tr>
<tr><th>${bdbResult.formatDate}</th><th>${bdbResult.deliveryMethodName}</th><th>${bdbResult.totalPrice}円</th></tr></table>
<br><br>
<table><tr><th>商品名</th><th>単価</th></tr>
<c:forEach var="buyIDB" items="${itemList}" >
<tr><th>${buyIDB.name}</th><th>${buyIDB.price}円</th></tr>
</c:forEach>
<tr><th>${bdbResult.deliveryMethodName}</th><th>${bdbResult.deliveryMethodPrice}円</th></tr></table>
</body>
</html>