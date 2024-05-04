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
		<div class="container-fluid">
		  <section class="container">
		    <header>Cập nhật thông tin về chi tiết</header>
		    <form class="row g-3" action="${pageContext.request.contextPath}/editDetailsServlet"  method="post">
		      <div class="col-md-12">
			      <label for="id" class="form-label">Mã ID:</label>
				  <input type="text" class="form-control" value="${updateDetails.getId()}" name="id" readonly>
		      </div>
		      <div class="col-md-12">
		        <label for="image" class="form-label">Hình Ảnh:</label>
		        <input type="file" class="form-control" value="${updateDetails.getImage()}" name="image" accept="image/*" required>
		      </div>
		       <div class="col-md-12">
		        <label for="rating" class="form-label">Đánh Giá:</label>
		        
		        </label> <label><input type="radio" name="rating" value="${updateDetails.getRating()}"
								readonly class="form-control" id="rating"> 1 sao</label> <label><input
								type="radio" name="rating" value="${updateDetails.getRating()}" readonly
								class="form-control" id="rating"> 2 sao</label> <label><input
								type="radio" name="rating" value="${updateDetails.getRating()}" readonly
								class="form-control" id="rating"> 3 sao</label> <label><input
								type="radio" name="rating" value="${updateDetails.getRating()}" readonly
								class="form-control" id="rating"> 4 sao</label> <label><input
								type="radio" name="rating" value="${updateDetails.getRating()}" readonly
								class="form-control" id="rating"> 5 sao</label>
		      </div>
		      <div class="col-md-12">
		      	  <label for="customerFK" class="form-label">Tên Khách Hàng:</label>
			      <select class="form-select" aria-label="Default select example" id="customerFK" name="customerFK" >
					    <!-- Populate this dropdown with available khoaModel instances -->
					    <c:forEach var="customer" items="${customerList}">
					        <option value="${customer.getCustomerID()}" ${updateDetails.getCustomerFK().getCustomerID() == customer.getCustomerID() ? 'selected="selected"' : ''}>${customer.getUserName()}</option>
					    </c:forEach>
				  </select>
			  </div><br>
		      <div class="col-md-12">
		      	  <label for="packagesFK" class="form-label">Tên Khóa Học:</label>
			      <select class="form-select" aria-label="Default select example" id="packagesFK" name="packagesFK" >
					    <!-- Populate this dropdown with available khoaModel instances -->
					    <c:forEach var="packages" items="${packagesList}">
					        <option value="${packages.getPackagesID()}" ${updateDetails.getPackagesFK().getPackagesID() == packages.getPackagesID() ? 'selected="selected"' : ''}>${packages.getNamePackages()}</option>
					    </c:forEach>
				  </select>
			  </div><br>
		      <div class="col-12">
		        <button class="btn btn-primary" type="submit">Cập nhật</button>
		        <button class="btn btn-info" type="reset">Đặt lại</button>	|
		        <a href="${pageContext.request.contextPath}/detailsServlet" class="btn btn-secondary">Quay lại</a>
		      </div>
		    </form>
		  </section>
		</div>

		<!-- END MAIN -->
	</div>
</body>
</html>