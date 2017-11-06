<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
<body>
	<h1>등록 페이지</h1>
	<!-- ?표 쓴 이유 : 현재 url과 동일하다 -->
	<form action="?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>공지사항 수정정보 필드</legend>
			<table border="1">
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"" /></td>
					</tr>					
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" rows="20" cols="60"></textarea>

						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
				<input type="submit" value="등록" />
				<a href="info">취소</a>				
			</div>
		</fieldset>
	</form>
</body>
</main>