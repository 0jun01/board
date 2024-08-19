<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- header.jsp -->
	<%@ include file="/WEB-INF/view/layout/header.jsp"%>
	
	<div class="board--box">
		<table borer="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
				<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.author}</td>
				<td>
				<form action="/board/delete" method="POST">
				 <input type="hidden" name="id" value="${board.id}">
					<button type ="submit">
						삭제
					</button>
				</form>
				<form action="/board/revise" method="GET">
				 <input type="hidden" name="id" value="${board.id}">
					<button type ="submit">
						수정
					</button>
				</form>
				</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<!-- Pagination -->
		<div class="d-felx justify-content-center">
			<ul class="pagination">
				<!-- Previous Page Link -->
				<li class="page-item <c:if test='${currentPage == 1}'>disabled</c:if>">
					<a class="page-link" href="?type=${type}&page=${currentPage - 1}&size=${size}">Previous</a>
				</li>
				
				<!-- Page Numbers -->
				<!-- [Previous] 1 2 3 4 [Next] -->
				<c:forEach begin="1" end="${totalPages}" var="page">				
				<li class="page-item <c:if test='${page == currentPage}'>active</c:if>">
					<a class="page-link" href="?type=${type}&page=${page}&size=${size}">${page}</a>
				</li>
				</c:forEach>
				<!-- Next Page Link -->
				<li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>">
					<a class="page-link" href="?type=${type}&page=${currentPage + 1}&size=${size}">Next</a>
				</li>
			</ul>
		</div>
	</div>
	

	</div>
</body>
</html>