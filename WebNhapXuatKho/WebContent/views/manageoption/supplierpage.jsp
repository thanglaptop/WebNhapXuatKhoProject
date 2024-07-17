<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="NCC" class="tabcontent">
	<button class="addbtn" type="button"
		onclick="document.getElementById('addSupplier').style.display='block'">+
		Thêm nhà cung cấp</button>
	<div id="addSupplier" class="modal">
		<form class="modal-content animate" action="AddSupplier">
			<div class="containerManage">
				<h2>Thêm Nhà Cung Cấp Mới</h2>
				<div>
					Tên nhà cung cấp: <input type="text" name="sname"
						placeholder="nhập tên nhà cung cấp..">
				</div>
				<div>
					Địa chỉ: <input type="text" name="address"
						placeholder="nhập địa chỉ..">
				</div>
				<div>
					Số điện thoại: <input type="text" name="phone"
						placeholder="nhập số điện thoại..">
				</div>
				<div class="action">
					<button
						onclick="document.getElementById('addSupplier').style.display='none'"
						class="cancelbtn" type="reset">đóng</button>
					<button class="updbtn" type="submit">thêm</button>
				</div>
			</div>
		</form>
	</div>
	<h3>Nhà Cung Cấp</h3>
	<table class="bang">
		<tr>
			<th>Mã</th>
			<th>Tên NCC</th>
			<th>Địa Chỉ</th>
			<th>SĐT</th>
		</tr>
		<c:forEach items="${listncc }" var="x">
			<tr>
				<td>NCC${x.sup_id }</td>
				<td>${x.sup_name}</td>
				<td>${x.address }</td>
				<td>${x.phone }</td>
				<td><button class="suabtn"
						onclick="document.getElementById('s${x.sup_id}').style.display='block'">sửa</button>
					<div id="s${x.sup_id}" class="modal">
						<form class="modal-content animate" action="EditSupplier">
							<div class="containerManage">
								<label><b>Tên Nhà Cung Cấp</b></label> <input type="text"
									name="sid" value="${x.sup_id }" style="display: none">
								<input type="text" name="sname" value="${x.sup_name }">
								<label><b>Địa chỉ</b></label> <input type="text" name="address"
									value="${x.address }"> <label><b>Số Điện
										Thoại</b></label> <input type="text" name="phone" value="${x.phone }">
								<div class="action">
									<button type="button"
										onclick="document.getElementById('s${x.sup_id}').style.display='none'"
										class="cancelbtn">đóng</button>
									<button class="updbtn" type="submit">cập nhật</button>
								</div>
							</div>
						</form>
					</div></td>
				<td><a href=""><button class="xoabtn">xóa</button></a></td>
			</tr>
		</c:forEach>
	</table>
</div>