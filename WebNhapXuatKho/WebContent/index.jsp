<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="css/styles.css">

<title>Login</title>
</head>
<body>
	<section class="form-dangnhap">
		<div class="form-container">
			<p class="title">Đăng Nhập</p>
			<form action="LoginServlet" method="post">
				<div class="input-group">
					<label for="username">Tên đăng nhập</label> <input type="text"
						name="username">
				</div>
				<div class="input-group">
					<label for="password">Mật khẩu</label> <input type="password"
						name="password">
				</div>
				<div class="btn">
					<button class="sign" type="submit">Đăng Nhập</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>