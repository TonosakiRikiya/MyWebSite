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
<title>TOPページ</title>
</head>
<body>
<h2 class="backOrange"><a href="TopPage">GIANTS</a>　　　<a href="UserLogin">ログイン</a>　　　<a href="Cart">カート</a></h2>
<br>
<br>
<h1 class="center">ONLINE　SHOP</h1>
<br>
<br>
<div class="sign">
<nav class="navbar navbar-light bg-light">
  <form class="form-inline" action="ItemResearchResult" method="get">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</nav></div>
<br>
<div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
          <c:forEach var="item" items="${itemList}">
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
              <a href="ItemDetail?item_id=${item.id}">
                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22347%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20347%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_165fa9d5940%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_165fa9d5940%22%3E%3Crect%20width%3D%22347%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.2109375%22%20y%3D%22120.0984375%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                </a>
                <div class="card-body">
                  <p class="card-text">${item.name}</p>
                  <p class="card-text">${item.price}円</p>
                  <div class="d-flex justify-content-between align-items-center">
                  </div>
                </div>
              </div>
            </div>
            </c:forEach>
           </div>
           </div>
           </div>


<table class="table table-borderless">
  <thead>
    <tr>
      <th scope="col">カテゴリー</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">ユニホーム</th>
    </tr>
    <tr>
      <th scope="row">キーホルダー</th>
    </tr>
    <tr>
      <th scope="row">ボール</th>
    </tr>
  </tbody>
</table>
</body>
</html>