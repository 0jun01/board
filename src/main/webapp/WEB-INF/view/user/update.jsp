<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- header.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="write--box">
	<h1>게시글 수정</h1>


	<form action="/board/revise" method="post">
		<input type="hidden" name="id" value="${board.id}">
		<div>
			<label for="title">제목:</label> <input type="text" id="title" name="title" value="${board.title}" required>
		</div>
		<div>
			<label for="content">내용:</label>
			<textarea id="content" name="content" rows="10" cols="30" maxlength="20" required>${board.content}</textarea>
		</div>
		<div>
			<label for="author">작성자:</label> <input type="text" id="author" name="author" value="${board.author}" required>
		</div>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>


</div>


</div>
</body>
</html>