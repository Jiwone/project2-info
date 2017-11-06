<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="f" items="${list}">
				<tr>
					<td>${f.id}</td>
					<td><a href="info/${f.id}">${f.title}</a></td>
					<%-- <td>${n.writerId}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${f.date}" />
					</td> --%>
					<td>${f.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
				<a href="info/reg">등록하기</a>
			</div>
</body>
</main>