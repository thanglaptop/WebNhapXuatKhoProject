<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="SP" class="tabcontent">
	<!-- nút mở form thêm -->
	<button class="addbtn" type="button"
		onclick="document.getElementById('addProduct').style.display='block'">+
		Thêm hàng</button>

	<!-- form thêm -->
	<div id="addProduct" class="modal">
		<form class="modal-content animate" action="AddProduct" method="post"
			enctype="multipart/form-data">
			<div class="containerManage">
				<h2>Thêm Hàng Mới</h2>
				<div>
					Tên hàng: <input type="text" name="product_name"
						placeholder="nhập tên hàng.." required>
				</div>
				<div>
					Loại hàng: <select name="category">
						<c:forEach items="${listc }" var="c">
							<option value="${c.cate_id }">${c.name }</option>
						</c:forEach>
					</select>
				</div>
				<div>
					Nhà cung cấp: <select name="supplier">
						<c:forEach items="${listncc }" var="ncc">
							<option value="${ncc.sup_id }">${ncc.sup_name }</option>
						</c:forEach>
					</select>
				</div>
				<div>Kích thước</div>

				<!-- nút mở form thêm size -->
				<button type="button" class="addSizebtn"
					onclick="document.getElementById('addSize').style.display='block'">+
					thêm size</button>

				<!-- mảng size -->
				<input type="text" name="arraySize" id="mangSize">

				<!-- hiển thị size -->
				<div id="mySize" class="sizedisplay"></div>
				<div>
					Hình hàng: <input type="file" name="image" accept="image/*"
						class="fileinput">
				</div>

				<!-- các nút của form thêm hàng -->
				<div class="action">
					<button type="reset" onclick="closeformThem('addProduct')"
						class="cancelbtn" type="button">đóng</button>
					<button class="updbtn" type="submit">thêm</button>
				</div>
			</div>
		</form>
	</div>
	<!-- form thêm size -->
	<div id="addSize" class="modal">
		<form class="modal-content-Size animate">
			<div class="containerManage">
				<input id="mySizeInput" type="text" placeholder="nhập kích thước...">
				<div class="action">
					<button onclick="closeSize('addSize', 'mySizeInput')"
						class="cancelbtn" type="button">đóng</button>
					<button type="button"
						onclick="addSize('addSize', 'mySize', 'mySizeInput', 'mangSize')"
						class="updbtn">Thêm</button>
				</div>
			</div>
		</form>
	</div>

	<c:forEach items="${listc }" var="cate">
		<hr>
		<h2>${cate.name }</h2>
		<div class="containersp scroll-1">
			<c:forEach items="${cate.listp }" var="x">
				<div class="card">
					<div class="card__image">
						<img src="DisplayImage?id=${x.pro_id }" alt="image not available">
					</div>
					<div class="card__content">
						<span class="card__title"
							onclick="document.getElementById('p${x.pro_id }').style.display='block'">
							${x.pname }</span>
							 <span class="card__describe">nhà cung cấp: ${x.supplier.sup_name }</span>
						<div class="size">
							<span class="card__describe">kích thước:</span>
							<ul class="list-size scroll-1">
								<c:forEach items="${x.listsize }" var="s">
									<li class="item-list"><button class="item-list-button">${s.sizename }</button></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div id="p${x.pro_id }" class="modal">
					<form class="modal-content animate" action="EditProduct"
						method="post" enctype="multipart/form-data">
						<div class="containerManage">
							<h2>Sửa Hàng MH${x.pro_id }</h2>
							<div>
								<input type="text" name="edit_proid" value="${x.pro_id }"
									style="display: none"> Tên hàng: <input type="text"
									placeholder="nhập tên hàng.." name="edit_proname"
									value="${x.pname }">
							</div>
							<div>
								Loại hàng: <select name="edit_category">
									<c:forEach items="${listc }" var="c">
										<c:if test="${x.category.cate_id == c.cate_id }">
											<option value="${c.cate_id }" selected>${c.name }</option>
										</c:if>
										<c:if test="${x.category.cate_id != c.cate_id }">
											<option value="${c.cate_id }">${c.name }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div>
								Nhà cung cấp: <select name="edit_supplier">
									<c:forEach items="${listncc }" var="ncc">
										<c:if test="${x.supplier.sup_id == ncc.sup_id }">
											<option value="${ncc.sup_id }" selected>${ncc.sup_name }</option>
										</c:if>
										<c:if test="${x.category.cate_id != c.cate_id }">
											<option value="${ncc.sup_id }">${ncc.sup_name }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div>Kích thước</div>

							<!-- nút mở form thêm size -->
							<button type="button" class="addSizebtn"
								onclick="document.getElementById('psize${x.pro_id }').style.display='block'">+
								thêm size</button>

							<!-- mảng size -->
							<input type="text" name="edit_arraySize"
								id="mangSizeEdit${x.pro_id }">

							<!-- hiển thị size -->
							<div id="mySizeEdit${x.pro_id }" class="sizedisplay">
								<c:forEach items="${x.listsize }" var="si">
									<button class="btnsize" type="button" id="orinuttam">${si.sizename }</button>
								</c:forEach>
							</div>
							<div>
								Chụp hình mới: <input type="file" accept="image/*"
									name="edit_image" class="fileinput">
							</div>

							<!-- các nút của form thêm hàng -->
							<div class="action">
								<button type="reset" onclick="closeformThem('p${x.pro_id }')"
									class="cancelbtn">đóng</button>
								<button class="updbtn" type="submit">cập nhật</button>
							</div>
						</div>
					</form>
				</div>
				<!-- form thêm size -->
				<div id="psize${x.pro_id }" class="modal">
					<form class="modal-content-Size animate">
						<div class="containerManage">
							<input id="mySizeEditInput${x.pro_id }" type="text"
								placeholder="nhập kích thước...">
							<div class="action">
								<button
									onclick="closeSize('psize${x.pro_id }', 'mySizeEditInput${x.pro_id }')"
									class="cancelbtn" type="button">đóng</button>
								<button type="button"
									onclick="addSize('psize${x.pro_id }','mySizeEdit${x.pro_id }', 'mySizeEditInput${x.pro_id }', 'mangSizeEdit${x.pro_id }')"
									class="updbtn">Thêm</button>
							</div>
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</div>