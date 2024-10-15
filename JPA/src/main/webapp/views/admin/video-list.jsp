<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath }/admin/video/add">Add
	Video</a>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Poster</th>
		<th>VideoID</th>
		<th>Title</th>
		<th>Description</th>
		<th>Active</th>
		<th>View</th>
	</tr>
	<c:forEach items="${listvideo}" var="video" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<td><c:choose>
					<c:when
						test="${video.poster != null && video.poster.length() >= 5}">
						<c:if test="${video.poster.substring(0, 5) != 'https'}">
							<c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${video.poster.substring(0, 5) == 'https'}">
							<c:url value="${video.poster}" var="imgUrl"></c:url>
						</c:if>
						<img height="150" width="200" src="${imgUrl}" />
					</c:when>
					<c:otherwise>
						<img height="150" width="200"
							src="${pageContext.request.contextPath}/images/default.png"
							alt="No Image" />
					</c:otherwise>
				</c:choose></td>
			<td>${video.videoId }</td>
			<td>${video.title }</td>
			<td>${video.description }</td>

			<td><c:if test="${video.active == 1 }">
					<span>Active</span>
				</c:if> <c:if test="${video.active!=1 }">
					<span>Lock</span>
				</c:if></td>
			<td>${video.views }</td>
			<td><a
				href="<c:url value='/admin/video/edit?id=${video.videoId }'/>">Edit</a>
				| <a
				href="<c:url value='/admin/video/delete?id=${video.videoId }'/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>