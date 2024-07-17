<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="../css/styles.css">

<title>main</title>
</head>
<body>
	<h1 style="margin-top: 2rem;">
		Xin Chào
		<%=request.getSession().getAttribute("fullname")%>!
	</h1>
	<section>
		<div class="main">
			<div class="container">
				<button class="button">Bán Hàng</button>
			</div>
			<div class="container">
				<button class="button">Nhập Hàng</button>
			</div>
		</div>
		<div class="main">
			<div class="container">
				<button class="button">Xem Doanh Thu</button>
			</div>
			<a href="/WebNhapXuatKho/ManageServlet">
				<div class="container">
					<button class="button">Quản Lý Mặt Hàng</button>
				</div>
			</a>

		</div>
	</section>
</body>
</html>