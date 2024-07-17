<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="./css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Quản lý sản phẩm</title>
</head>
<body>
	<a href="views/main.jsp"><button class="backbtn" type="button">trở về</button></a>
	<h2 style="color: white;">Quản lý sản phẩm</h2>
	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'SP')">Hàng</button>
		<button class="tablinks" onclick="openTab(event, 'LH')">Loại Hàng</button>
		<button class="tablinks" onclick="openTab(event, 'NCC')">Nhà Cung Cấp</button>
	</div>

	<jsp:include page="manageoption/productpage.jsp"></jsp:include>
	<jsp:include page="manageoption/categorypage.jsp"></jsp:include>
	<jsp:include page="manageoption/supplierpage.jsp"></jsp:include>

	<script src="./js/script.js">
		
	</script>
</body>
</html>