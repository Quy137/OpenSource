<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa</title>

</head>
<style>
body {
	background: #EEEEEE;
}

.form .input-box {
	width: 100%;
	margin-top: 10px;
}

.container {
	background-color: white;
	max-width: 800px;
	text-align: center;
	padding: 25px;
	border-radius: 8px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

.col-md-12 {
	padding: 8px;
}

.container header {
	font-size: 1.8rem;
	color: #000;
	font-weight: 600;
	text-align: center;
}

.container .form {
	margin-top: 15px;
}

.form .input-box {
	width: 100%;
	margin-top: 10px;
}

.form .label {
	width: 100%;
	margin-top: 10px;
	font-size: 1.6rem;
}

.input-box label {
	color: #000;
}
</style>
<body>
<div class="viewport">
		<!-- SIDEBAR -->
			
		<!-- END SIDEBAR -->
		<br>
		<!-- MAIN -->
		<div class="container-fluid">
		  <section class="container">
		    <header>Bạn có chắc chắc muốn xóa?</header>
		    <form class="row g-3" action="${pageContext.request.contextPath}/deleteCustomerServlet" method="get">
		      <div class="col-md-12">
		        <label for="customerID" class="form-label">Mã Khách Hàng</label>
		        <input type="text" class="form-control" value="${param.code}" name="customerID" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="userName" class="form-label">Tên UserName</label>
		        <input type="text" value="${param.userName}" class="form-control" name="userName" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="password" class="form-label">Mật Khẩu</label>
		        <input type="password" value="${param.password}" class="form-control" name="password" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="resetPassword" class="form-label">Đặt Lại Mật Khẩu</label>
		        <input type="password" value="${param.resetPassword}" class="form-control" name="resetPassword" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="name" class="form-label">Tên</label>
		        <input type="text" value="${param.name}" class="form-control" name="name" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="address" class="form-label">Địa Chỉ</label>
		        <input type="text" value="${param.address}" class="form-control" name="address" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="phoneNumber" class="form-label">Số Điện Thoại</label>
		        <input type="text" value="${param.phoneNumber}" class="form-control" name="phoneNumber" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="email" class="form-label">Email</label>
		        <input type="email" value="${param.email}" class="form-control" name="email" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="dob" class="form-label">DOB</label>
		        <input type="date" value="${param.dob}" class="form-control" name="dob" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="gender" class="form-label">Giới Tính</label>
		        <input type="radio" name="gender" value="${param.gender}" checked class="form-control" id="gender"
							readonly checked> Nam
							<input type="radio" name="gender" value="${param.gender}"> Nữ
							<input type="radio" name="gender" value="${param.gender}"> Khác
		      </div>
		      <div class="col-md-12">
		        <label for="joinDate" class="form-label">Ngày Đăng Nhập</label>
		        <input type="date" value="${param.joinDate}" class="form-control" name="joinDate" readonly>
		      </div>
		      <div class="col-12">
		        <button class="btn btn-danger" type="submit">Delete</button>
		        <a href="${pageContext.request.contextPath}/customerServlet" class="btn btn-secondary">Quay lại</a>
		      </div>
		    </form>
		  </section>
		</div>
</body>
</html>