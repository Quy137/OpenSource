<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h3>Quản lý danh sách chi tiết</h3>
	</center>

	<div class="card-add">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
			fill="currentColor" class="bi bi-plus-square-dotted"
			viewBox="0 0 16 16">
		  <path
				d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0zm2.292 0h-.917v1h.917zm1.833 0h-.917v1h.917zm1.833 0h-.916v1h.916zm1.834 0h-.917v1h.917zm1.833 0h-.917v1h.917zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0m2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917zm16 .917v-.917h-1v.917zM0 5.708v.917h1v-.917zm16 .917v-.917h-1v.917zM0 7.542v.916h1v-.916zm15 .916h1v-.916h-1zM0 9.375v.917h1v-.917zm16 .917v-.917h-1v.917zm-16 .916v.917h1v-.917zm16 .917v-.917h-1v.917zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487M.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1zm-9.625 0h.917v-1h-.917zm1.833 0h.917v-1h-.917zm1.834-1v1h.916v-1zm1.833 1h.917v-1h-.917zm1.833 0h.917v-1h-.917zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
		</svg>
		<a href="${pageContext.request.contextPath}/newDetailsServlet">
			&nbsp&nbsp Thêm Chi Tiết</a>
	</div>
	<br>


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
	    List detailsList = (List) request.getAttribute("detailsList");
	    int count = 0;
	    if(detailsList != null){
	        count = detailsList.size();
	    }
	%>
		<div class="count">
		 <b>Có <%= count %> chi tiết trong danh sách</b>	
		</div>
	

	<!-- CARD LIST -->
	<div id="cardListContent" style="display: none;">
		<p style="color: red;">${errorString}</p>
		<div class="container text-center center-div">
			<div class="row row-cols-3">
				<c:forEach items="${detailsList}" var="details">
					<div class="col bottom">
						<div class="card" style="width: 400px;">
							<div class="card-body card-color">
								<h5 class="card-title">Mã ID: ${details.id}</h5>
								<h6 class="card-subtitle mb-2 text-muted">Hình Ảnh:
									${details.image}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Đánh Gía:
									${details.rating}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Trực Thuộc Khách Hàng:
									${details.customerFK.customerID} - ${details.customerFK.userName}</h6>
								<h6 class="card-subtitle mb-2 text-muted">Trực Thuộc Khóa Học:
									${details.packagesFK.packagesID} - ${details.packagesFK.namePackages}</h6>
								<hr>
								<a href="editDetailsServlet?code=${details.id}" class="btn btn-info">Cập
									nhật</a> <a
									href="./details/deleteDetails.jsp?code=${details.id}&hinhanh=${details.image}
									&danhgia=${details.rating}"
									class="btn btn-danger">Xóa</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- END CARD LIST -->	

	

	<!-- TABLE LIST-->
	<p style="color: red;">${errorString}</p>
	<div id="tableContent" class="container text-center center-div"
		style="display: none;">
		<table class="table table-hover">
			<thead class="table-light">
				<tr style="text-align: center;">
					<th>Mã ID</th>
					<th>Hình Ảnh</th>
					<th>Đánh Gía</th>
					<th>Trực Thuộc Khách Hàng</th>
					<th>Trực Thuộc Khóa Học</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${detailsList}" var="details">
					<tr style="text-align: center;">
						<td>${details.id}</td>
						<td>${details.image}</td>
						<td>${details.rating}</td>
						<td>${details.customerFK.customerID} - ${details.customerFK.userName}</td>
						<td>${details.packagesFK.packagesID} - ${details.packagesFK.namePackages}</td>
						<td><a href="editDetailsServlet?code=${details.id}"
							class="btn btn-info">Cập nhật</a> <a
							href="./details/deleteDetails.jsp?code=${details.id}&hinhanh=${details.image}
							&danhgia=${details.rating}"
							class="btn btn-danger">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- END TABLE LIST-->

	
	<!-- SCRIPT CARD LIST -->
	<script>
		// Set the initial display property to 'block'
		document.getElementById('cardListContent').style.display = 'block';

		// Add a click event listener to the toggle button
		document
				.getElementById('iconListToggle')
				.addEventListener(
						'click',
						function() {
							// Toggle the display property of the content container
							var cardListContent = document
									.getElementById('cardListContent');
							cardListContent.style.display = (cardListContent.style.display === 'none' || cardListContent.style.display === '') ? 'block'
									: 'none';

							// Disable the table list toggle button
							var tableListToggle = document
									.getElementById('tableListToggle');
							tableListToggle.disabled = true;
						});
	</script>
	<!-- END SCRIPT CARD LIST -->
	
	

	<!-- SCRIPT TABLE LIST -->
	<script>
		var isTableVisible = true; // Sử dụng biến để theo dõi trạng thái

		document.getElementById('tableListToggle').addEventListener(
				'click',
				function() {
					var tableContent = document.getElementById('tableContent');

					// Đảo ngược trạng thái và hiển thị/ẩn dữ liệu tùy thuộc vào trạng thái mới
					isTableVisible = !isTableVisible;
					tableContent.style.display = isTableVisible ? 'block'
							: 'none';

					// Ẩn script dạng card nếu hiển thị script dạng table và kích hoạt lại nút toggle của nó
					if (isTableVisible) {
						var cardListContent = document
								.getElementById('cardListContent');
						cardListContent.style.display = 'none';

						var iconListToggle = document
								.getElementById('iconListToggle');
						iconListToggle.disabled = false;
					}
				});

		// Thêm sự kiện 'click' cho script dạng card để chuyển đổi sang script dạng table
		document.getElementById('cardListToggle').addEventListener(
				'click',
				function() {
					var cardListContent = document
							.getElementById('cardListContent');
					cardListContent.style.display = 'none';

					var tableContent = document.getElementById('tableContent');
					tableContent.style.display = 'block';

					// Vô hiệu hóa nút toggle của script dạng card khi hiển thị script dạng table
					var iconListToggle = document
							.getElementById('iconListToggle');
					iconListToggle.disabled = true;

					// Đảm bảo rằng biến isTableVisible được cập nhật đúng
					isTableVisible = true;
				});
	</script>
	<!-- END SCRIPT TABLE LIST -->
</body>
</html>