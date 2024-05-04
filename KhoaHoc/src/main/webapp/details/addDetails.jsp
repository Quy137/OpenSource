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
	padding: 11px;
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
		<form class="row g-6"
			action="${pageContext.request.contextPath}/newDetailsServlet"
			method="post">
			<div class="container text-center">
			<header>Thêm thông tin về chi tiết</header>
				<div class="row">
					<div class="col-7">
						<div class="col-md-12">
							<label for="id" class="form-label"> <b> Mã ID ngành </b></label>
							<input type="text" class="form-control" id="id" name="id"
								required>
						</div>

						<div class="col-md-12">
							<label for="image" class="form-label"><b> Hình Ảnh
									ngành </b></label> <input type="file" name="profilePicture"
								accept="image/*" class="form-control" id="image" name="image"
								required>
						</div>

						<div class="col-md-12">
							<label for="checkbox" class="form-label"><b> Đánh Giá
							</b></label> <label><input type="radio" name="rating" value="1"
								required class="form-control" id="rating"> 1 sao</label> <label><input
								type="radio" name="rating" value="2" required
								class="form-control" id="rating"> 2 sao</label> <label><input
								type="radio" name="rating" value="3" required
								class="form-control" id="rating"> 3 sao</label> <label><input
								type="radio" name="rating" value="4" required
								class="form-control" id="rating"> 4 sao</label> <label><input
								type="radio" name="rating" value="5" required
								class="form-control" id="rating"> 5 sao</label>

						</div>


					</div>
					<div class="col-5">
						<div class="col-md-12">
							<label for="customerFK" class="form-label"><b> Chọn Khách Hàng
							</b></label> <select class="form-select" aria-label="Default select example"
								id="customerFK" name="customerFK">
								<c:forEach var="customer" items="${customerList}">
									<option value="${customer.getCustomerID()}">${customer.getUserName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-12">
							<label for="packagesFK" class="form-label"><b> Chọn Khóa Học
							</b></label> <select class="form-select" aria-label="Default select example"
								id="packagesFK" name="packagesFK">
								<c:forEach var="packages" items="${packagesList}">
									<option value="${packages.getPackagesID()}">${packages.getNamePackages()}</option>
								</c:forEach>
							</select>
						</div>
						<br>

						<div class="col-12">
							<button class="btn btn-primary" type="submit">Thêm vào
								danh sách</button>
							<button class="btn btn-info" type="reset">Đặt lại</button>
							<a href="${pageContext.request.contextPath}/detailsServlet"
								class="btn btn-secondary" style="width: 250px; margin-top: 10px">Quay
								lại</a>
						</div>
					</div>
				</div>
			</div>
		</form>


		<!-- END MAIN -->
	</div>
</body>
</html>