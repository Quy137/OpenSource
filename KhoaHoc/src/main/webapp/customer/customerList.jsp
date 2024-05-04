<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Khách Hàng</title>
</head>
<style>
.center-div {
	display: flex;
	justify-content: center;
	align-items: flex-start;
	height: 800px;
}

.card-color {
	background-color: #EEEEEE;
}

.bottom {
	margin-bottom: 20px;
}

.card-add {
	width: 130px;
	height: 40px;
	background-color: #99CCFF;
	border-radius: 5px;
	display: flex; /* Use flexbox */
	align-items: center;
	justify-content: center; /* Center content horizontally */
	margin-top: 20px;
}

.card-add a {
	text-decoration: none; /* Remove underline from the link */
	color: #000000; /* Set text color */
}
.count{
	text-align: right;
	margin-right: 10px;
}
</style>
<body>
<br>
	<center>
		<h3>Quản lý danh sách Khách Hàng</h3>
	</center>
	<!-- ADD -->
	<div class="card-add">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
			fill="currentColor" class="bi bi-plus-square-dotted"
			viewBox="0 0 16 16">
		  <path
				d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0zm2.292 0h-.917v1h.917zm1.833 0h-.917v1h.917zm1.833 0h-.916v1h.916zm1.834 0h-.917v1h.917zm1.833 0h-.917v1h.917zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0m2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917zm16 .917v-.917h-1v.917zM0 5.708v.917h1v-.917zm16 .917v-.917h-1v.917zM0 7.542v.916h1v-.916zm15 .916h1v-.916h-1zM0 9.375v.917h1v-.917zm16 .917v-.917h-1v.917zm-16 .916v.917h1v-.917zm16 .917v-.917h-1v.917zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487M.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1zm-9.625 0h.917v-1h-.917zm1.833 0h.917v-1h-.917zm1.834-1v1h.916v-1zm1.833 1h.917v-1h-.917zm1.833 0h.917v-1h-.917zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
		</svg>
		<a href="${pageContext.request.contextPath}/newCustomerServlet">
			&nbsp&nbsp Thêm khoa</a>
	</div>
	<br>
	<!-- END ADD -->

	<!-- ICON CARD LIST -->
	<div id="iconListToggle" class="btn btn-secondary">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
			fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
	        <path fill-rule="evenodd"
				d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5m-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2m0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2m0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2" />
	    </svg>
		Danh sách dạng thẻ
	</div>
	<!-- END ICON CARD LIST -->
	
	<!-- ICON TABLE LIST -->
	<div class="btn btn-secondary" id="tableListToggle">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
			fill="currentColor" class="bi bi-card-checklist" viewBox="0 0 16 16">
	        <path
				d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2z" />
	        <path
				d="M7 5.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0M7 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0" />
	    </svg>
		Danh sách dạng bảng
	</div>
	<!-- END ICON TABLE LIST -->

	<%
	    List customerList = (List) request.getAttribute("customerList");
	    int count = 0;
	    if(customerList != null){
	        count = customerList.size();
	    }
	%>
		<div class="count">
		 <b>Có <%= count %> Khách hàng trong danh sách </b>	
		</div>

	<!-- CARD LIST -->
	<div id="cardListContent" style="display: none;">
		<p style="color: red;">${errorString}</p>
		<div class="container text-center center-div">
			<div class="row row-cols-3">
				<c:forEach items="${customerList}" var="customer">
					<div class="col bottom">
						<div class="card" style="width: 400px;">
							<div class="card-body card-color">
								<h5 class="card-title">Mã khách hàng: ${customer.customerID}</h5>
								<h6 class="card-subtitle mb-2 text-muted">Tên user:
									${customer.userName}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Mật Khẩu:
									${customer.password}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Đặt lại Mật Khẩu:
									${customer.resetPassword}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Tên :
									${customer.name}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Địa Chỉ:
									${customer.address}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Số Điện Thoại:
									${customer.phoneNumber}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Email:
									${customer.email}</h6>
								<h6 class="card-subtitle mb-2 text-muted">DOB:
									${customer.dob}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Giới Tính:
									${customer.gender}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Ngày Đăng Nhập:
									${customer.joinDate}</h6>
								<hr>
								<a
									href="editCustomerServlet?code=${customer.customerID}&userName=${customer.userName}
									&password=${customer.password}&resetPassword=${customer.resetPassword}&name=${customer.name}
									&address=${customer.address}&phoneNumber=${customer.phoneNumber}&email=${customer.email}
									&dob=${customer.dob}&gender=${customer.gender}&joinDate=${customer.joinDate}"
									class="btn btn-info">Cập nhật</a> <a
									href="./customer/deleteCustomer.jsp?code=${customer.customerID}&userName=${customer.userName}
									&password=${customer.password}&resetPassword=${customer.resetPassword}&name=${customer.name}
									&address=${customer.address}&phoneNumber=${customer.phoneNumber}&email=${customer.email}
									&dob=${customer.dob}&gender=${customer.gender}&joinDate=${customer.joinDate}"
									class="btn btn-danger">Xóa</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- END CARD LIST -->

	
	
	<!-- TABLE CONTENT -->
	<div id="tableContent" style="display: none; margin-top: 20px;">
		<table class="table table-hover">
			<thead class="table-light">
				<tr style="text-align: center;">
					<th>Mã Khách Hàng</th>
					<th>Tên user</th>
					<th>Mật Khẩu</th>
					<th>Đặt Lại Mật Khẩu</th>
					<th>Tên</th>
					<th>Địa Chỉ</th>
					<th>Số Điện Thoại</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Giới Tính</th>
					<th>Ngày Bắt Đầ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerList}" var="customer">
					<tr style="text-align: center;">
						<td>${customer.customerID}</td>
						<td>${customer.userName}</td>
						<td>${customer.password}</td>
						<td>${customer.resetPassword}</td>
						<td>${customer.name}</td>
						<td>${customer.address}</td>
						<td>${customer.phoneNumber}</td>
						<td>${customer.email}</td>
						<td>${customer.dob}</td>
						<td>${customer.gender}</td>
						<td>${customer.joinDate}</td>
						<td><a
							href="editCustomerServlet?code=${customer.customerID}&userName=${customer.userName}
									&password=${customer.password}&resetPassword=${customer.resetPassword}&name=${customer.name}
									&address=${customer.address}&phoneNumber=${customer.phoneNumber}&email=${customer.email}
									&dob=${customer.dob}&gender=${customer.gender}&joinDate=${customer.joinDate}"
							class="btn btn-info">Cập nhật</a> <a
							href="./customer/deleteCustomer.jsp?code=${customer.customerID}&userName=${customer.userName}
									&password=${customer.password}&resetPassword=${customer.resetPassword}&name=${customer.name}
									&address=${customer.address}&phoneNumber=${customer.phoneNumber}&email=${customer.email}
									&dob=${customer.dob}&gender=${customer.gender}&joinDate=${customer.joinDate}"
							class="btn btn-danger">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>