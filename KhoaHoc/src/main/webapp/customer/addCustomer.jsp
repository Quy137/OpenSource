	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<!-- MAIN CONTENT -->

	<div class="viewport">
		<!-- SIDEBAR -->
		<!-- END SIDEBAR -->
		<br>
		<!-- MAIN -->
		<div class="container-fluid">
			<section class="container">
				<header>Thêm thông tin về khách hàng</header>
				<form class="row g-3"
					action="${pageContext.request.contextPath}/newCustomerServlet"
					method="post">
					<div class="col-md-12">
						<label for="customerID" class="form-label">Mã khách hàng</label> <input
							type="text" class="form-control" id="customerID" name="customerID" 
							required>
					</div>
					<div class="col-md-12">
						<label for="userName" class="form-label">User Name</label> <input
							type="password" class="form-control" id="userName" name="userName"
							required>
					</div>
					<div class="col-md-12">
						<label for="password" class="form-label">PassWord</label> <input
							type="text" class="form-control" id="password" name="password" 
							required>
					</div>
					<div class="col-md-12">
						<label for="resetPassword" class="form-label">Reset Password</label> <input
							type="password" class="form-control" id="resetPassword" name="resetPassword"
							required>
					</div>
					<div class="col-md-12">
						<label for="name" class="form-label">Tên khách hàng</label> <input
							type="text" class="form-control" id="name" name="name" 
							required>
					</div>
					<div class="col-md-12">
						<label for="address" class="form-label">Địa Chỉ</label> <input
							type="text" class="form-control" id="address" name="address"
							required>
					</div>
					<div class="col-md-12">
						<label for="phoneNumber" class="form-label">Số Điện Thoại</label> <input
							type="text" class="form-control" id="phoneNumber" name="phoneNumber" 
							required>
					</div>
					<div class="col-md-12">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							required>
					</div>
					<div class="col-md-12">
						<label for="dob" class="form-label">DOB</label> <input
							type="date" class="form-control" id="dob" name="dob" 
							required>
					</div>
					<div class="col-md-12">
						<label for="gender" class="form-label">Giới tính</label> 
							<input type="radio" name="gender" value="male" checked class="form-control" id="gender"
							required checked> Nam
							<input type="radio" name="gender" value="female"> Nữ
							<input type="radio" name="gender" value="other"> Khác
					</div>
					<div class="col-md-12">	
						<label for="joinDate" class="form-label">Ngày Tham Gia</label> <input
							type="date" class="form-control" id="joinDate" name="joinDate" 
							required>
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Thêm vào
							danh sách</button>
						<button class="btn btn-info" type="reset">Đặt lại</button> |
						<a href="${pageContext.request.contextPath}/customerServlet" class="btn btn-secondary">Quay lại</a>
					</div>
				</form>
			</section>
</body>
</html>