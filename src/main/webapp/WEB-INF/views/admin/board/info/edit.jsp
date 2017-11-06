<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
<form action="?${_csrf.parameterName}=${_csrf.token}" method="post">
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<td colspan="3"> <input name="title" value ="${up.title}"></td>
			</tr>
			<tr>	
				<th>조회수</th>
				<td>${up.hit}</td>
			</tr>
			<tr>
				<td colspan="4">
				<textarea name = "content">${up.content }</textarea></td>
			</tr>
		</thead>
		
	</table>
	<div>
		<input type="hidden" name="id" value="${up.id}"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
		<input type="submit">저장 </a>
		<a href="info-detail?id=">취소</a>
	</div>
	
	</form>

</body>
</main>