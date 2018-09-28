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
<title>エラー</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="section"></div>
			<div class="col s8 offset-s2">
				<div class="card grey lighten-5">
					<div class="card-content">
						<div class="row center">
							<h4 class="red-text">システムエラーが発生しました</h4>
							<h5 class="red-text">${errorMessage}</h5>
						</div>
						<div class="row">
							<div class="col s12">
								<p class="center-align">
									<a href="TopPage" class="btn btn-large waves-effect waves-light  col s8 offset-s2">TOPページへ</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>