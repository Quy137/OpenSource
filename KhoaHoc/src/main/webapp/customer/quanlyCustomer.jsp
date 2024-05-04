<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh sách khách hàng</title>
</head>
<style>
	.viewport {
	  padding-left: 250px;
	  -webkit-transition: all 0.5s ease;
	  -moz-transition: all 0.5s ease;
	  -o-transition: all 0.5s ease;
	  transition: all 0.5s ease;
	}
	.sidebar {
	  z-index: 1000;
	  position: fixed;
	  left: 250px;
	  width: 250px;
	  height: 100%;
	  margin-left: -250px;
	  overflow-y: auto;
	  background: #37474F;
	  color: white;
	}
	.main{
		color: black;
	}

	.aList{
		text-decoration: none;
		color: white;
	}
</style>
<body>
<!-- MAIN CONTENT -->
	<div class="viewport">
		<!-- SIDEBAR -->
				
		<!-- END SIDEBAR -->	
	
		<!-- MAIN -->
		<div class="container-fluid">
			<div>
				<%@include file="../customer/customerList.jsp" %>
			</div>
		</div>
		<!-- END MAIN -->

	</div>
<!-- MAIN CONTENT -->	
</body>
</html>