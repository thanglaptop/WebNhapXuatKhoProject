<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="LH" class="tabcontent">
	<button class="addbtn" type="button"
		onclick="document.getElementById('addCategory').style.display='block'">+
		Thêm loại hàng</button>
	<div id="addCategory" class="modal">
		<form class="modal-content animate" action="AddCategory">
			<div class="containerManage">
				<h2>Thêm Loại Hàng Mới</h2>
				<div>
					Tên loại hàng: <input type="text" name="cname"
						placeholder="nhập tên loại hàng.." required>
				</div>
				<div class="action">
					<button
						onclick="document.getElementById('addCategory').style.display='none'"
						class="cancelbtn" type="reset">đóng</button>
					<button class="updbtn" type="submit">thêm</button>
				</div>
			</div>
		</form>
	</div>
	<h3>Loại Hàng</h3>
	<table class="bang">
		<tr>
			<th>Mã Loại</th>
			<th>Tên Loại Sản Phẩm</th>
		</tr>
		<c:forEach items="${listc }" var="x">
			<tr>
				<td>LH${x.cate_id }</td>
				<td>${x.name }</td>
				<td>
					<button class="suabtn"
						onclick="document.getElementById('c${x.cate_id}').style.display='block'">sửa</button>
					<div id="c${x.cate_id }" class="modal">
						<form class="modal-content animate" action="EditCategory">
							<div class="containerManage">
								<label><b>Tên Loại</b></label> <input type="text"
									style="display: none" name="cid" value="${x.cate_id }">
								<input type="text" name="cname" value="${x.name }">
								<div class="action">
									<button type="button"
										onclick="document.getElementById('c${x.cate_id}').style.display='none'"
										class="cancelbtn" type="reset">đóng</button>
									<button class="updbtn" type="submit">cập nhật</button>
								</div>
							</div>
						</form>
					</div>
				</td>
				<td><a href="#"><button class="xoabtn">xóa</button></a></td>
			</tr>
		</c:forEach>
	</table>
</div>