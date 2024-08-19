<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.header--box {
	width: 1300px;
	border: 1px solid black;
	background-color: black;
	background-position: center;
	border-radius: 2px;
	display: flex;
	align-items: left;
	justify-content: left;
}

.header--box h3 {
	margin: 0;
	padding: 20px;
	color: white;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
}

.header--box a {
	margin: 0;
	padding: 20px;
	color: white;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
}

table {
	width: 70%;
	border-collapse: collapse;
	margin: 20px auto;
	border: 1px solid black;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

h1 {
	text-align: center;
}

.short-width {
	width: 30%;
}
</style>
</head>
<body>
	<div class="all--of--container">
		<!-- header -->
		<header>
			<div class="header--box">
				<h3>Metacoding</h3>
				<a href="/write">글쓰기</a>
			</div>
		</header>
</body>
</html>